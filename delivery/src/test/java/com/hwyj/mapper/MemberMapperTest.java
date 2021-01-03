package com.hwyj.mapper;

import java.sql.DriverManager;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.MemberVO;
import com.sun.corba.se.pept.transport.Connection;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testRead() { //멤버 정보 읽는 테스트
		
		MemberVO memberVO=mapper.read("admin90");
		log.info("read.... "+memberVO);
		memberVO.getAuthList().forEach(authVO -> log.info(authVO));
	}
	
	@Test //권한별 멤버 목록 보기 테스트
	public void testGetList() {
		List<MemberVO> memberList=mapper.getMemberList("ROLE_RES");
		for(MemberVO temp : memberList) {
			log.info(temp);
		}		
	}
	
	@Test //멤버 삭제 테스트
	public void testDeleteMember() {
		log.info("멤버 삭제 확인: "+mapper.deleteMember("user1"));
	}
	
	@Test //멤버 삭제 테스트
	public void testInsertCustomer() {
		CustomerVO csVO = new CustomerVO();
		csVO.setEmail("TEST");
		csVO.setM_name("TEST");
		csVO.setPw("8");
		csVO.setId("TTTT");
		
		log.info("@@@@@@@@@" +mapper.insertCustomer(csVO));
	}


}