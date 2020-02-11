package com.fund.transfer.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
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
			req.setUserName("vinod");
			req.setPassword("vinod123");
			List<User> list = new ArrayList<User>();
			User user = new User();
			user.setUserName("vinod");
			user.setPassword("vinod123");
			list.add(user);
			Mockito.when(userRepository.findByUserNameAndPassword(req.getUserName(), req.getPassword())).thenReturn(Optional.of(user));
			LoginResponseDto res = loginServiceImpl.authenticateCustomer(req);
			assertNotNull(list);
			
	}
		
	}

