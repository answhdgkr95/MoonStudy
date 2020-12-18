package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno >0")
	public List<BoardVO> getList();
	
	//�Խñ� ���
	public void insert(BoardVO board);
	
	//�Խñ� ��ȣ�� �츮�� Ȯ���ؼ� �Խñ۵��(��ϵ� �۹�ȣ Ȯ��)
	public void insertSelectKey(BoardVO board);
	
	//�Խñ� �б� - �۹�ȣ�� ����
	public BoardVO read(Long bno);
	
	//�Խñ� ����� - �۹�ȣ�� ����
	public int delete(Long bno);

	//�Խñ� ����
	public int update(BoardVO board);
	
	//����> �Խñ� ���� ����
	public int deleteCount();
	
	//����> Ư������ �� ����
	public int userPostCount(String user);
}



