package com.spring.moon.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.moon.dao.ReplyDAO;
import com.spring.moon.dto.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	SqlSession sqlSession;
	
	// 1. ?κΈ? ?? ₯
		@Override
		public void create(ReplyVO vo) {
			sqlSession.insert("reply.insertReply", vo);
		}
	// 2. ?κΈ? λͺ©λ‘
	@Override
	public List<ReplyVO> list(Integer bno,  int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("reply.listReply", map);
	}
	// 3. ?κΈ? ??Έλ³΄κΈ°
	@Override
	public ReplyVO detail(Integer rno) {
		return sqlSession.selectOne("reply.detailReply", rno);
	}
	// 4. ?κΈ? ?? 
	@Override
	public void update(ReplyVO vo) {
		sqlSession.update("reply.updateReply", vo);
	}
	// 5. ?κΈ? ?­? 
	@Override
	public void delete(Integer rno) {
		sqlSession.delete("reply.deleteReply", rno);
	}
	@Override
	public int reply_delete(ReplyVO vo) {
		return sqlSession.delete("reply.reply_deleteReply", vo);
	}
	// 6. ?κΈ? κ°??
	@Override
	public int count(Integer bno) {
		return sqlSession.selectOne("reply.countReply", bno);
	}

}
