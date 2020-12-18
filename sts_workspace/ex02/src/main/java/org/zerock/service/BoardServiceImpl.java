package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO boardVO) {
		log.info("���� ����մϴ�."+ boardVO);
		mapper.insertSelectKey(boardVO);

	}

	@Override
	public BoardVO get(Long bno) {
		log.info("�� �󼼺���");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		log.info("�� ���� ����"+ boardVO);
		return mapper.update(boardVO)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info(bno+"�� ����");
		//int status = mapper.delete(bno);
		//if(status==1) 
		//	return true;
		//else return false;
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("�۸�� ��������");
		return mapper.getList();
	}

	@Override
	public int deleteCount() {
		return mapper.deleteCount();
	}

	@Override
	public int userPostCount(String user) {
		return mapper.userPostCount(user);
	}

}
