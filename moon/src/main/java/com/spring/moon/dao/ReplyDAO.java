package com.spring.moon.dao;

import java.util.List;

import com.spring.moon.dto.ReplyVO;

public interface ReplyDAO {
	// 1. ?κΈ? ?? ₯
	public void create(ReplyVO vo);
	// 2. ?κΈ? λͺ©λ‘
	public List<ReplyVO> list(Integer bno, int start, int end);
	// 3. ?κΈ? ??Έλ³΄κΈ°
	public ReplyVO detail(Integer rno);
	// 4. ?κΈ? ?? 
	public void update(ReplyVO vo);
	// 5. ?κΈ? ?­? 
	public void delete(Integer rno);
	
	public int reply_delete(ReplyVO vo);
	// 6. ?κΈ? κ°??
	public int count(Integer bno);
}
