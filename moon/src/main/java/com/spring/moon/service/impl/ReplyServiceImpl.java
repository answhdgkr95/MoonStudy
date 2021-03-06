package com.spring.moon.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.spring.moon.dao.ReplyDAO;
import com.spring.moon.dto.ReplyVO;
import com.spring.moon.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	ReplyDAO replyDao;

	// 1. ?κΈ? ?? ₯
	@Override
	public void create(ReplyVO vo) {
		replyDao.create(vo);
	}
	// 2. ?κΈ? λͺ©λ‘
	@Override
	public List<ReplyVO> list(Integer bno, int start, int end, HttpSession session) {
		List<ReplyVO> items = replyDao.list(bno, start, end);
		// ?Έ??? ??¬ ?¬?©? idκ°? ???₯
		String userId = (String) session.getAttribute("userId");
		for(ReplyVO vo : items){
			// ?κΈ? λͺ©λ‘μ€μ μ€μ λΉλ? ?κΈ??΄ ?? κ²½μ°
			if(vo.getSecretReply().equals("y")){
				if(userId== null){ // λΉλ‘κ·ΈμΈ ??λ©? λΉλ? ?κΈ?λ‘? μ²λ¦¬
					vo.setReplytext("λΉλ? ?κΈ????€.");
				} else { // λ‘κ·Έ?Έ ???Ό κ²½μ°
					String writer = vo.getWriter(); // κ²μλ¬? ??±? ???₯
					String replyer = vo.getReplyer(); // ?κΈ? ??±? ???₯
					// λ‘κ·Έ?Έ? ?¬?©?κ°? κ²μλ¬Όμ ??±?X ?κΈ? ??±?? X λΉλ??κΈ?λ‘? μ²λ¦¬
					if(!userId.equals(writer) && !userId.equals(replyer)) {
						vo.setReplytext("λΉλ? ?κΈ????€.");
					}
				}
			}
		}
		return items; 
	}
	// 3. ?κΈ? ??Έλ³΄κΈ°
	@Override
	public ReplyVO detail(Integer rno) {
		return replyDao.detail(rno);
	}
	// 4. ?κΈ? ?? 
	@Override
	public void update(ReplyVO vo) {
		replyDao.update(vo);
	}
	// 5. ?κΈ? ?­? 
	@Override
	public void delete(Integer rno) {
		replyDao.delete(rno);
	}
	// 6. ?κΈ? κ°??
	@Override
	public int count(Integer bno) {
		return replyDao.count(bno);
	}
	@Override
	public int reply_delete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyDao.reply_delete(vo);
	}
}
