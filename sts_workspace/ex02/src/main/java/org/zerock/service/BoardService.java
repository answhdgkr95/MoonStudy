package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	//글 등록
	public void register(BoardVO boardVO);
	
	//글 상세보기
	public BoardVO get(Long bno);
	
	//글 수정
	public boolean modify(BoardVO boardVO);
	
	//글 삭제
	public boolean remove(Long bno);
	
	//목록 보기
	public List<BoardVO> getList();
	
	//퀴즈 글삭제 개수
	public int deleteCount();
	
	//퀴즈 작성자 글 개수 
	public int userPostCount(String user);
}



