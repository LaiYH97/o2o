package com.imooc.o2o.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.LocalAuthExecution;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;

public class LocalAuthServiceTest extends BaseTest {

	@Autowired
	private LocalAuthService localAuthService;
	
	@Ignore
	@Test
	public void testbindLocalAuth() {
		LocalAuth localAuthCondition = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuthCondition.setUsername("lyh");
		localAuthCondition.setPassword("123456");
		localAuthCondition.setPersonInfo(personInfo);
		LocalAuthExecution localAuthExecution = localAuthService.bindLocalAuth(localAuthCondition);
		System.out.println(localAuthExecution.getLocalAuth().getUsername());
		System.out.println(localAuthExecution.getLocalAuth().getPassword());
	}
	
	@Test
	public void testmodifyLocalAuth() {
		LocalAuthExecution localAuthExecution = localAuthService.modifyLocalAuth(1L, "lyh", "123456", "12345678");
		System.out.println(localAuthExecution.getState());
		System.out.println(localAuthExecution.getStateInfo());
		LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd("lyh", "12345678");
		System.out.println(localAuth.getPersonInfo().getName());
	}
}
