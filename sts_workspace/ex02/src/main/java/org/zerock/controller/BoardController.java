package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,Model model, RedirectAttributes rttr) {
		service.register(board);
		
		//몇번글이 등록되었습니다.
		//model.addAttribute("result", board.getBno());
		rttr.addFlashAttribute("result", "register");
		rttr.addFlashAttribute("bno", board.getBno());
		//한번만 값이 전송된다.
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(Long bno,Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	@GetMapping("modify")
	public void modify(Long bno, Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board,Model model,RedirectAttributes rttr) {
		if(service.modify(board))
			//model.addAttribute("result", "success");
			rttr.addFlashAttribute("result", "modify"); //한번만 보내기
			rttr.addFlashAttribute("bno", board.getBno());
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno,Model model,RedirectAttributes rttr) {
		if(service.remove(bno))
			//model.addAttribute("result", "success");
			rttr.addFlashAttribute("result", "remove"); 
			rttr.addFlashAttribute("bno", bno);
		return "redirect:/board/list";
	}
}



