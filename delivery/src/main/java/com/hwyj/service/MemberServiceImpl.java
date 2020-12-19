package com.hwyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hwyj.domain.MemberVO;
import com.hwyj.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;

	@Override //멤버 목록 보기 서비스
	public List<MemberVO> getMemberList(String auth) {
		log.info("멤버 목록 보기: "+memberMapper.getMemberList(auth));
		return memberMapper.getMemberList(auth);
	}

}
