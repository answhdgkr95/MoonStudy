package com.spring.moon.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.moon.dto.ReplyPager;
import com.spring.moon.dto.ReplyVO;
import com.spring.moon.service.ReplyService;


// REST : Representational State Transfer
// ??? URIκ°? ??? κ³ μ ? λ¦¬μ?€λ₯? ?????λ‘? ?€κ³λ κ°λ

// http://localhost/spring02/list?bno=1 ==> url+??Όλ―Έν°
// http://localhost/spring02/list/1 ==> url
// RestController?? ?€?λ§? 4.0λΆ??° μ§??
// @Controller, @RestController μ°¨μ΄? ?? λ©μ?κ°? μ’λ£?λ©? ?λ©΄μ ?? ? λ¬?

@Controller

@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
	// 1_1. ?κΈ? ?? ₯(@Controllerλ°©μ?Όλ‘? ?κΈ? ?? ₯)
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session){
		// ?Έ?? ???₯? ????΄?λ₯? ?κΈ???±?? ?Έ?
		String userId = (String) session.getAttribute("c_id");
		vo.setReplyer(userId);
		// ?κΈ? ?? ₯ λ©μ? ?ΈμΆ?
		replyService.create(vo);
		
	}
	
	// 1_2. ?κΈ??? ₯ (@RestControllerλ°©μ?Όλ‘? json? ?¬??¬ ?κΈ??? ₯)
	// @ResponseEntity : ?°?΄?° + http status code
	// @ResponseBody : κ°μ²΄λ₯? json?Όλ‘? (json - String)
	// @RequestBody : json? κ°μ²΄λ‘?
	@RequestMapping(value="insertRest", method=RequestMethod.POST)
	public ResponseEntity<String> insertRest(@RequestBody ReplyVO vo, HttpSession session){
		ResponseEntity<String> entity = null;
		try {
			String userId = (String) session.getAttribute("c_id");
			vo.setReplyer(userId);
			replyService.create(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 2_1. ?κΈ? λͺ©λ‘(@Controllerλ°©μ : veiw(?λ©?)λ₯? λ¦¬ν΄)
	@RequestMapping("list")
	public ModelAndView list(@RequestParam int bno,	@RequestParam(defaultValue="1") int curPage, ModelAndView mav, HttpSession session){
		// ??΄μ§? μ²λ¦¬ 
		int count = replyService.count(bno); // ?κΈ? κ°??
		ReplyPager replyPager = new ReplyPager(count, curPage);
		// ??¬ ??΄μ§?? ??΄μ§? ?? λ²νΈ
		int start = replyPager.getPageBegin();
		// ??¬ ??΄μ§?? ??΄μ§?  ? λ²νΈ
		int end = replyPager.getPageEnd();
		List<ReplyVO> list = replyService.list(bno, start, end, session);
		// λ·°μ΄λ¦? μ§?? 
		mav.setViewName("board/replyList");
		// λ·°μ ? ?¬?  ?°?΄?° μ§?? 
		mav.addObject("list", list);
		mav.addObject("replyPager", replyPager);
		// replyList.jspλ‘? ?¬??©
		return mav;
	}
	
	// 2_2. ?κΈ? λͺ©λ‘(@RestControllerλ°©μ : Json?Όλ‘? ?°?΄?°λ₯? λ¦¬ν΄)
	@RequestMapping("listJson")
	@ResponseBody // λ¦¬ν΄?°?΄?°λ₯? json?Όλ‘? λ³??(RestController?¬?©? @ResponseBody??΅κ°??₯)
	public List<ReplyVO> listJson(@RequestParam int bno, @RequestParam(defaultValue="1") int curPage, HttpSession session){
		// ??΄μ§? μ²λ¦¬
		int count = replyService.count(bno); // ?κΈ? κ°??
		ReplyPager pager = new ReplyPager(count, curPage);
		// ??¬ ??΄μ§?? ??΄μ§? ?? λ²νΈ
		int start = pager.getPageBegin();
		// ??¬ ??΄μ§?? ??΄μ§?  ? λ²νΈ
		int end = pager.getPageEnd();
		List<ReplyVO> list = replyService.list(bno, start, end, session);
		// listλ₯? λ¦¬ν΄
		return list;
	}
	
	// ** Controller μΆκ? ?¬?­ - Restλ°©μ?Όλ‘? ?κΈ? λͺ©λ‘, ?? , ?­?  μ²λ¦¬
	
	// 2_3. ?κΈ? λͺ©λ‘(@RestControllerλ°©μ :  json?Όλ‘? ? ?¬??¬ λͺ©λ‘??±)
	// /reply/list/1 => 1λ²? κ²μλ¬Όμ ?κΈ? λͺ©λ‘ λ¦¬ν΄
	// /reply/list/2 => 2λ²? κ²μλ¬Όμ ?κΈ? λͺ©λ‘ λ¦¬ν΄
	// @PathVariable : url? ?? ₯?  λ³??κ°? μ§?? 
	@RequestMapping(value="/list/{bno}/{curPage}", method=RequestMethod.GET)
	public ModelAndView replyList(@PathVariable("bno") int bno, @PathVariable int curPage, ModelAndView mav, HttpSession session){
		// ??΄μ§? μ²λ¦¬
		int count = replyService.count(bno); // ?κΈ? κ°??
		ReplyPager replyPager = new ReplyPager(count, curPage);
		// ??¬ ??΄μ§?? ??΄μ§? ?? λ²νΈ
		int start = replyPager.getPageBegin();
		// ??¬ ??΄μ§?? ??΄μ§?  ? λ²νΈ
		int end = replyPager.getPageEnd();
		List<ReplyVO> list = replyService.list(bno, start, end, session);
		// λ·°μ΄λ¦? μ§?? 
		mav.setViewName("board/replyList");
		// λ·°μ ? ?¬?  ?°?΄?° μ§?? 
		mav.addObject("list", list);
		mav.addObject("replyPager", replyPager);
		// replyList.jspλ‘? ?¬??©
		return mav;
	}
	
	// 3. ?κΈ? ??Έ λ³΄κΈ°
	// /reply/detail/1 => 1λ²? ?κΈ?? ??Έ?λ©? λ¦¬ν΄
	// /reply/detail/2 => 2λ²? ?κΈ?? ??Έ?λ©? λ¦¬ν΄
	// @PathVariable : url? ?? ₯?  λ³??κ°? μ§?? 
	@RequestMapping(value="/detail/{rno}", method=RequestMethod.GET)
	public ModelAndView replyDetail(@PathVariable("rno") Integer rno, ModelAndView mav){
		ReplyVO vo = replyService.detail(rno);
		// λ·°μ΄λ¦? μ§?? 
		mav.setViewName("board/replyDetail");
		// λ·°μ ? ?¬?  ?°?΄?° μ§?? 
		mav.addObject("vo", vo);
		// replyDetail.jspλ‘? ?¬??©
		return mav;
	}
	
	// 4. ?κΈ? ??  μ²λ¦¬ - PUT:? μ²? ?? , PATCH:?ΌλΆ??? 
	// RequestMethodλ₯? ?¬?¬ λ°©μ?Όλ‘? ?€? ?  κ²½μ° {}?? ??±
	@RequestMapping(value="/update/{rno}", method={RequestMethod.POST})
	public ResponseEntity<String> replyUpdate(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setRno(rno);
			replyService.update(vo);
			// ?κΈ? ?? ?΄ ?±κ³΅νλ©? ?±κ³? ??λ©μμ§? ???₯
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// ?κΈ? ?? ?΄ ?€?¨?λ©? ?€?¨ ??λ©μμ§? ???₯
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// ??  μ²λ¦¬ HTTP ?? λ©μμ§? λ¦¬ν΄
		return entity;
	}
	
	// 5. ?κΈ? ?­? μ²λ¦¬
	@RequestMapping(value="/delete/{rno}")
	public ResponseEntity<String> replyDelete(@PathVariable("rno") Integer rno){
		ResponseEntity<String> entity = null;
		try {
			replyService.delete(rno);
			// ?κΈ? ?­? κ°? ?±κ³΅νλ©? ?±κ³? ??λ©μμ§? ???₯
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// ?κΈ? ?­? κ°? ?€?¨?λ©? ?€?¨ ??λ©μμ§? ???₯
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// ?­?  μ²λ¦¬ HTTP ?? λ©μμ§? λ¦¬ν΄
		return entity;
	}
}
