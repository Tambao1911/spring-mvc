package com.tambao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tambao.constant.SystemConstant;
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
		
		//put thông  tin vài security duy trì thông tin khi user login vào hệ thống
		
		return null;
	}

}
