package com.hwyj.mapper;

import java.sql.DriverManager;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CustomerVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Custmapper {
	@Autowired
	private SqlSession sqlSession;

	public int insertCustomer(CustomerVO csvo) {
		csvo = sqlSession.selectOne("customer.select", csvo);
		System.out.println(csvo.toString());
		return sqlSession.insert("customer.insertCustomer", csvo);
	}

	
}
