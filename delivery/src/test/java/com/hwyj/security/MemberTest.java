package com.hwyj.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.Custmapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTest {
	
	
	@Setter(onMethod_= @Autowired)
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_= @Autowired)
	private DataSource ds;
	
	@Test //member테이블에 인코딩된 패스워드 가진 사용자 추가하는 테스트
	public void testInsertMember() {
		String sql = "insert into member(id, pw, m_name) values(?,?,?)";
		
		for(int i=0; i<100; ++i) {
			
			Connection con=null;
			PreparedStatement pstmt=null;			
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(2, pwencoder.encode("pw"+i));
				
				if(i<80) {
					pstmt.setNString(1, "user"+i);
					pstmt.setNString(3, "일반사용자"+i);
				}else if(i<90) {
					pstmt.setNString(1, "restaurant"+i);
					pstmt.setNString(3, "매장"+i);
				}else {
					pstmt.setNString(1, "admin"+i);
					pstmt.setNString(3, "관리자"+i);
				}
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
				if(con!=null) {try {con.close();} catch(Exception e) {}}
			}
		}
	}
	
	@Test //auth테이블에 사용자 권한 추가하는 테스트
	public void testInsertAuth() {
		String sql = "insert into auth(id, auth) values(?,?)";
		
		for(int i=0; i<100; ++i) {
			
			Connection con=null;
			PreparedStatement pstmt=null;			
			try {
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				
				if(i<80) {
					pstmt.setNString(1, "user"+i);
					pstmt.setNString(2, "ROLE_MEMBER");
				}else if(i<90) {
					pstmt.setNString(1, "restaurant"+i);
					pstmt.setNString(2, "ROLE_RES");
				}else {
					pstmt.setNString(1, "admin"+i);
					pstmt.setNString(2, "ROLE_ADMIN");
				}
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) {try {pstmt.close();} catch(Exception e) {}}
				if(con!=null) {try {con.close();} catch(Exception e) {}}
			}
		}
	}
	
	
	
		}
	
	


