package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.ToDoDTO;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	
	@RequestMapping(value="abc", method= {RequestMethod.POST,RequestMethod.GET })
	public void basic() {
		
		log.info("basic....................");
	}
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		
	}
	
	
	@GetMapping("/ex01") //ex01?name=aaa&age=111
	public String ex01(SampleDTO dto) {
		log.info("dto 정보 "+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02") //ex02?name=bbb&age=111
	public void ex02(String name, int age) {
		log.info("name" + name);
		log.info("age" + age);
	}
	
	//ex02List?ids=111&ids=222&ids=333
	@GetMapping("/pre_ex02List")
	public String pre_ex02List()  {    
		return "/pre_ex02List";
	}
	
	
	@GetMapping("/ex02List")
	public String ex02(@RequestParam("ids")ArrayList<String> ids) {
			
		log.info("lds" + ids);
		
		return "ex02List";
	}
	//ex02Bean?list[0].name=aaa&list[2].name=bbb
	@GetMapping("/ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info("객체리스트 수집" +list);
		
	}
	//ex03?title=test&dueDate=2018-01-01
	@GetMapping("/ex03")
	public void ex03(ToDoDTO todo) {
		log.info("todo" + todo);
	}
	//ex04?name=aaa&age=111&page=9
	@GetMapping("/ex04")
	public void ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		
	}
	
	
	
	
}













































