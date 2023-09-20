package com.green.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Controller 어노테이션은 현재 클래스를 SpringWebMVC가 관리하는 컨트롤러로 등록할 때 사용 */
@Controller
public class LoginController2 {
	
	@RequestMapping("/loginform.it")
	public String loginform() {
		System.out.println("loginform 메소드 호출입니다.");
		return "login/loginform";// "/WEB-INF/views/loginform.jsp"
	}

	// 로그인실패 페이지 요청
	@RequestMapping(value = "/loginfail.it", method = RequestMethod.GET)
	public String loginfail() {

		/* View 정보를 반환하는 부분 */
		return "login/loginfail"; // "/WEB-INF/views/loginfail.jsp"
	}

	// 로그아웃폼 페이지 요청
	@RequestMapping(value = "/logoutform.it", method = RequestMethod.GET)
	public String logoutform() {

		/* View 정보를 반환하는 부분 */
		return "login/logoutform"; // "/WEB-INF/views/logoutform.jsp"
	}

	// 계정별 로그인
	@RequestMapping(value = "/loginsuccess.it", method = RequestMethod.GET)
	public String loginresult() {

		return "login/loginsuccess";// "/WEB-INF/views/loginsuccess.jsp"
	}
}



