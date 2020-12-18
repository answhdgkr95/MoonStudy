package edu.mit.iot4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // root실행
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/ex05")
	public void ex01() { // 리턴 타입에 따라 paramiter.jsp가 자동으로 열리도록 설정, 메소드 이름 상관 ㄴㄴ

	}

	@RequestMapping("/test2")
	public String ex02() { // 리턴 문자열.jsp 페이지가 호출됨

		// return "result";
		return "redirect:/result"; // redirect > 새로운 result 요청

	}

	@RequestMapping("/result") // 새로운 result요청을 받음
	public void ex03() {

	}

	@RequestMapping("/test3")
	public String ex04(Model model) {

		model.addAttribute("abc", "1234"); // 모델 아이디, 값

		return "productDetail";

	}

	@RequestMapping("/test1")
	public void ex05(Model model) {
		int sum = 0;
		int i = 0;
		for (i = 0; i < 101; i++) {
			sum += i;
		}
		model.addAttribute("aaa", sum);
	}

	@RequestMapping("/send")
	public void send() {
		
	}
	@RequestMapping("/ex01")
	public void ex01_para(SampleDTO dto) {
		
		System.out.println("이름"+dto.getName() +"\n나이"+ dto.getAge());
	}
	
	
	@RequestMapping("/test11")
	public String test11() {
		return "test12";
	}
	
	@RequestMapping("/test13")
	public void test13(int a, int b,Model model) {
		int i = 0;
		int sum=0;
		for (i=a; i<=b; i++) {
			sum += i;
	}
		System.out.println("다 더한 값은" + sum);
		model.addAttribute("aaaa", sum);
	}

	@RequestMapping("/ex22")
	public void ex22() {
	}
	
	@RequestMapping("/ex02")
	public void ex002(SampleDTO dto, int page) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(page);
	}
	
	@RequestMapping("/test4")
	public @ResponseBody SampleDTO test4 () {
		SampleDTO aaa = new SampleDTO();
		aaa.setName("hong");
		aaa.setAge(99);
		return aaa;
	}

	
	
}