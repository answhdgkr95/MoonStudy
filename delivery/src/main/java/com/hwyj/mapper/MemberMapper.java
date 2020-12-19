package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.MemberVO;

public interface MemberMapper {
	
	//멤버정보 읽기 (로그인 등)
	public MemberVO read(String id);
	
	//권한별로 멤버 목록 보기 (관리자 페이지에서)
	public List<MemberVO> getMemberList(String auth);
	
	//멤버 삭제 (member 테이블, auth 테이블 둘 다 삭제됨)
	public int deleteMember(String id);
	
	//


}
