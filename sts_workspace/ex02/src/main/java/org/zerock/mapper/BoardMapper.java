package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno >0")
	public List<BoardVO> getList();
	
	//게시글 등록
	public void insert(BoardVO board);
	
	//게시글 번호를 우리가 확인해서 게시글등록(등록된 글번호 확인)
	public void insertSelectKey(BoardVO board);
	
	//게시글 읽기 - 글번호를 통해
	public BoardVO read(Long bno);
	
	//게시글 지우기 - 글번호를 통해
	public int delete(Long bno);

	//게시글 수정
	public int update(BoardVO board);
	
	//퀴즈> 게시글 삭제 개수
	public int deleteCount();
	
	//퀴지> 특정유저 글 개수
	public int userPostCount(String user);
}



