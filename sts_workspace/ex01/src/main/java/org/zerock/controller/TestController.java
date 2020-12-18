package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ToDoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test/*")
@Log4j

public class TestController {

	@GetMapping("/test1")
	public String test1() {
		return "test2";
	}

	@GetMapping("/test2")
	public void test2() {

	}

	@GetMapping("/test3.do")
	public String test3(int a, Model model) {
		String str = null;
		if (a % 2 == 0) {
			str = "¦";
		} else {
			str = "Ȧ";

			model.addAttribute("a", a);
			model.addAttribute("value", str);
		}
		return "test4";
	}

	@PostMapping("/test5")
	public void test5() {

	}

	@RequestMapping(value = "test6", method = { RequestMethod.POST })
	public void test6(int a, int b, Model model) {
		Random ran = new Random();
		int rand = ran.nextInt((b - a) + 1); // (b-a+1)+a
		int com = (int) (Math.random() * b) + a;
		model.addAttribute("com", com);
		model.addAttribute("rand", rand);

	}

	@GetMapping("test7")

	public void test7() {

	}

	@RequestMapping(value = "/test7", method = RequestMethod.POST)
	public String test7_1(Model model, int a, int b, int c) {
		int sum = a + b + c;
		model.addAttribute("sum", sum);
		return "/test7";
	}

/*	@GetMapping("/join")

	public String join() {
		return "join";
	}

	@GetMapping("/join2")

	public void join2(ToDoDTO dto, Model model) {
		ToDoDTO aaa = new ToDoDTO();

		LocalDate today = LocalDate.now();
		LocalDate hiredDate = aaa.getDueDate();

		long days = ChronoUnit.DAYS.between(hiredDate, today);
		model.addAttribute("days", days);*/

		/*
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); String date1 =
		 * "2020-12-04"; Date date2 = null; aaa.setDueDate(date2); String date =
		 * date2.toLocaleString(); Date FirstDate = format.parse(date1); Date SecondDate
		 * = format.(date); long calDate = FirstDate.getTime() - SecondDate.getTime();
		 * 
		 * long calDateDays = calDate / ( 24*60*60*1000);
		 * 
		 * calDateDays = Math.abs(calDateDays);
		 */

	}


