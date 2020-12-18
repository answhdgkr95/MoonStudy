package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	//�� ���
	public void register(BoardVO boardVO);
	
	//�� �󼼺���
	public BoardVO get(Long bno);
	
	//�� ����
	public boolean modify(BoardVO boardVO);
	
	//�� ����
	public boolean remove(Long bno);
	
	//��� ����
	public List<BoardVO> getList();
	
	//���� �ۻ��� ����
	public int deleteCount();
	
	//���� �ۼ��� �� ���� 
	public int userPostCount(String user);
}



