package com.hwyj.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testConnectionMySQL() {
		
		try (Connection con =
			 DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/testdb?useSSL=false&serverTimezone=Asia/Seoul",
					 "java","java")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}		
	}
	


}
