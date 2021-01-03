package com.hwyj.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CustomerVO;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;
import com.sun.javafx.collections.MappingChange.Map;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberJoinTest {
	
	@Autowired
	private Custmapper custmapper;
	
	@Test
	public void test() {
		log.info(custmapper);
		assertNotNull(custmapper);
	}
	
	@Test //join
	public void testInsertCustomer (Map<MemberJoinTest, CustomerVO> cvo) {
		//CustomerVO cvo = Integer.parseInt(custmapper.toString(cvo.getId()));
		
		
		/*
		 * cvo.map(this).getId().toString(); cvo.map(this).getEmail().toString();
		 * cvo.map(this).getPw().toString(); cvo.map(this).getM_name().toString(); int a
		 * = Integer.parseInt(cvo.toString()); System.out.println(a);
		 */
		
		/*Parseint해
		 * custmapper.insertCustomer(cvo); log.info(cvo); int a = Integer.parseInt(cvo);
		 * cvo.getId(a);
		 */
		
	}
}
