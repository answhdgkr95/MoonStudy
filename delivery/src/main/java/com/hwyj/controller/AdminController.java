package com.hwyj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwyj.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
@AllArgsConstructor
public class AdminController {
	
	private MemberService memberService;
	
	
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')") //관리자만 들어올 수 있는 페이지 (주석처리 나중에 없애기)
	@GetMapping("/memberList") //멤버 리스트 보는 페이지
	public void MemberList(String auth, Model model) {
		//#memberList 열때 기본을 멤버로 열고 매장,관리자는 나중에 따로 선택해서 여는걸로 만들기
		model.addAttribute("memberList", memberService.getMemberList(auth));
		model.addAttribute("auth", auth);
	}

}
