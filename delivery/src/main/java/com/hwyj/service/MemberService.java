package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.MemberVO;

public interface MemberService {
	
	//권한별 멤버 목록 보기
	public List<MemberVO> getMemberList(String auth);

}
