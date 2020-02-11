package com.fund.transfer.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fund.transfer.dto.LoginRequestDto;
import com.fund.transfer.dto.LoginResponseDto;
import com.fund.transfer.entity.User;
import com.fund.transfer.exception.NotFoundException;
import com.fund.transfer.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Before
	public void before() {

	}
	@Test
	public void authenticateCustomer() throws NotFoundException {
		LoginRequestDto req = new LoginRequestDto();
		LoginRequestDto req1 = new LoginRequestDto();
		LoginResponseDto res = null;
		Optional<User> user = null;
		User user1 = new User();
		user1.setUserId(1L);
		user1.setPassword("vinod");
		user1.setUserId(2L);
		user1.setPassword("vinod123");
		req.setPassword("vinod");
		req.setUserId(1L);
		req1.setUserId(2L);
		req1.setPassword("vinod123");
		Mockito.when(userRepository.findByUserIdAndPassword(req.getUserId(), req.getPassword())).thenReturn(user);
		
	
		

		
	}

}
