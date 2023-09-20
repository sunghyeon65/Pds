package com.green.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.green.member.service.MemberService;
import com.green.member.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private KakaoLoginBO kakaoLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	@Autowired
	   private void setKakaoLoginBO(KakaoLoginBO kakaoLoginBO) {
	      this.kakaoLoginBO  =  kakaoLoginBO;
	   }
	
	
	
	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버 
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "login";
	}

	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

        /* 네이버 로그인 성공 페이지 View 호출 */
		return "naverSuccess";
	}
	// ------------------------------------------------------------------------
	@RequestMapping(value = "/kakaologin", method = { RequestMethod.GET, RequestMethod.POST })
	   public String kakaologin(Model model, HttpSession session) {
	      
	      /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
	      String kakaoAuthUrl = kakaoLoginBO.getAuthorizationUrl(session);
	      
	      //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
	      //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
	      System.out.println("카카오 :" + kakaoAuthUrl);
	      
	      //네이버 
	      model.addAttribute("kakaourl", kakaoAuthUrl);

	      /* 생성한 인증 URL을 View로 전달 */
	      return "login";
	   }

	   //네이버 로그인 성공시 callback호출 메소드
	      @RequestMapping(value = "/oauth/kakao", method = { RequestMethod.GET, RequestMethod.POST })
	      public String kakaocallback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
	            throws IOException {
	         System.out.println("여기는 callback");
	         OAuth2AccessToken oauthToken;
	           oauthToken = kakaoLoginBO.getAccessToken(session, code, state);
	           //로그인 사용자 정보를 읽어온다.
	          apiResult = kakaoLoginBO.getUserProfile(oauthToken);
	         model.addAttribute("result", apiResult);
	         
	         System.out.println(apiResult);
	           /* 네이버 로그인 성공 페이지 View 호출 */
	         return "naverSuccess";
	      }
	   
	     //회원가입 
	      @RequestMapping("/joinForm")
	      public ModelAndView joinForm() {
	    	  
	    	  ModelAndView  mv  =  new ModelAndView();
	    	  mv.setViewName("/join");
	    	  
	    	  return mv;	    	      	  
	      }
	      
	      @RequestMapping("/join")
	      public ModelAndView join(MemberVo vo) {
	    	  
	    	  int result = memberService.join(vo);
	    	  
	    	  
	    	  
	    	  return null;
	      }
}

