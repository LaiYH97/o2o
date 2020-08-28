package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建工具类，判断验证码是否符合预期
 * @author Administrator
 *
 */
public class CodeUtil {

	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
		if(verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
