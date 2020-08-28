package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.WechatAuthExecution;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;
import com.imooc.o2o.enums.WechatAuthStateEnum;

public class WechatAuthServiceTest extends BaseTest {

	@Autowired
	private WechatAuthService wechatAuthService;
	
	@Test
	public void testRegister() {
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		String openId = "openIDlyh";
		
		personInfo.setCreateTime(new Date());
		personInfo.setName("laiyanhong");
		personInfo.setUserType(1);
		
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		
		WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
		
		wechatAuth  = wechatAuthService.getWechatAuthByOpenId(openId);
		System.out.println(wechatAuth.getPersonInfo().getName());
		
	}
}
