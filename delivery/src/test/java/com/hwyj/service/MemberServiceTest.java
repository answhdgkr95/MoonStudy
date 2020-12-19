package com.hwyj.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService service;
	
	@Test //서비스객체 테스트
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test //권한별로 멤버 목록보기 테스트
	public void getList() {
		List<MemberVO> memberList=service.getMemberList("ROLE_ADMIN");
		log.info("목록보기-----------------");
		for(MemberVO temp : memberList) {
			log.info(temp);
		}
	}

}
