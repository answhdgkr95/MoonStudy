package com.hwyj.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;


@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Controller
@Log4j
public class CommonController {
	
	//로그인 테스트용 나중에 지우기
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')") //auth가 ROLE_ADMIN이랑 ROLE_MEMBER일때만 페이지 열 수 있음
	@GetMapping("/test/securityTest") //이 주소 요청하면 아래 /login 페이지 열림
	public void securityTest() {
		
	}
	
	@GetMapping("/login") //로그인 페이지
	public void login() {
		
	}
	
	@GetMapping("/min/test") //로그인 페이지
	public void test() {
		
	}
	
	
	@GetMapping("/join") //가입
	public void join() {
		
	}
	
	@GetMapping("/index") //main
	public void index() {
		
	}
	
	@GetMapping("/logout") //로그아웃 페이지
	public void logout() {
		
	}
	
	@GetMapping("/maptest") //현재위치 테스트중
	public void maptest() {
		
	}
	
	@GetMapping("/foodmaptest") //음식점 마커
	public void foodmaptest() {
		
	}
	
	@GetMapping("/accessError") //403페이지 (접근제한) //accessError.jsp 수정 해야됨//
	public void accessDenied(Authentication auth) {
		
		//log .info(auth);
	}
	
	@Autowired
	private MemberMapper memberMapper;
	@GetMapping("/insertCustomer")  //ㅎㅗㅣㅇㅜㅓㄴㄱㅏㅇㅣㅂ
	@ResponseBody
	public String insertCustomer(Locale locale, CustomerVO csVO,Model model) {

		int a= 0;
	/*	if(memberMapper.selectCustomer(csVO.getId())!=0) {
			return "2";
			
		}
		else {*/
		 a = memberMapper.insertCustomer(csVO);
		 System.out.println(a);
		
		return a+"";
	}


	}

	
	

