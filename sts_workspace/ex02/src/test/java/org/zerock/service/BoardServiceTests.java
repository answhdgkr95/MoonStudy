package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExitst() {
		assertNotNull(service);
	}
	
	@Test
	public void testregister() {
		BoardVO board = new BoardVO();
		board.setTitle("s���� �ۼ��ϴ� ��");
		board.setContent("s���� �ۼ��ϴ� ����");
		board.setWriter("snewbie");
		service.register(board);
	}
	
	@Test
	public void testDeleteCount() {
		log.info("�ۻ��� ����:"+service.deleteCount());
	}
	
	@Test
	public void testUserPostCount() {
		log.info("����Ȯ��:"+service.userPostCount("user00"));
	}
	
	@Test
	public void testGetList() {
		List<BoardVO>  boardList=service.getList();
		
		for(BoardVO board : boardList) {
			log.info(board);
		}
		
	}
	
	@Test
	public void testGet() {
		BoardVO board=service.get(7L);
		log.info("�ۻ󼼺���"+board);
	}
	
	@Test
	public void testRemove() {
		log.info("��������?:"+service.remove(12L));
	}
	
	@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("��bie");
		board.setBno(5);
		log.info("��������?:"+service.modify(board));
	}

	
	
	
	
}











