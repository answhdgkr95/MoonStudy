package com.hwyj.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class AdminControllerTest {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc; //url, 파라미터등 테스트용도
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); //MockMvc 객체 생성
	}
	
	@Test //멤버 목록보는 페이지 테스트
	public void tesMembertList() throws Exception {
		log.info("글 상세보기: "+mockMvc.perform(MockMvcRequestBuilders.get("/admin/memberList").param("auth", "ROLE_RES"))
		.andReturn().getModelAndView().getModelMap());
	}

}
