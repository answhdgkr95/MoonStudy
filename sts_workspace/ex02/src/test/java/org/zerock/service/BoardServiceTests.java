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
		board.setTitle("s새로 작성하는 글");
		board.setContent("s새로 작성하는 내용");
		board.setWriter("snewbie");
		service.register(board);
	}
	
	@Test
	public void testDeleteCount() {
		log.info("글삭제 개수:"+service.deleteCount());
	}
	
	@Test
	public void testUserPostCount() {
		log.info("개수확인:"+service.userPostCount("user00"));
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
		log.info("글상세보기"+board);
	}
	
	@Test
	public void testRemove() {
		log.info("삭제성공?:"+service.remove(12L));
	}
	
	@Test
	public void testModify() {
		BoardVO board = new BoardVO();
		board.setTitle("수정 작성하는 글");
		board.setContent("수정 작성하는 내용");
		board.setWriter("수bie");
		board.setBno(5);
		log.info("수정성공?:"+service.modify(board));
	}

	
	
	
	
}











