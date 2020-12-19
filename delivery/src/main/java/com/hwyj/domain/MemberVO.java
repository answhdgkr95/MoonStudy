package com.hwyj.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id; //아이디
	private String pw; //비밀번호
	private String m_name; //회원이름
	private boolean enabled;
	
	private String auth; //이렇게 해도 되나??????(memberList에서 멤버권한 보기위해서)
	
	private List<AuthVO> authList;//사용자권한 객체 리스트(관리자처럼 여러개의 사용자권한을 가진 계정을 위해서)

}
