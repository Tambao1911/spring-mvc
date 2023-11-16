package com.tambao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tambao.constant.SystemConstant;
import com.tambao.dto.MyUser;
import com.tambao.entity.RoleEntity;
import com.tambao.entity.UserEntity;
import com.tambao.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		//Khi thông tin bị lỗi hay kh có người dùng 
		if(userEntity == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		// Lấy ra các role và put vào authorities(quyền của user)
		for(RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		//put thông  tin vào security duy trì thông tin khi user login vào hệ thống
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
				true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
