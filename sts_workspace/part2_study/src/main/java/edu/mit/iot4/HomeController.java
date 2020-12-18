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
	@RequestMapping(value = "/", method = RequestMethod.GET) // root����
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/ex05")
	public void ex01() { // ���� Ÿ�Կ� ���� paramiter.jsp�� �ڵ����� �������� ����, �޼ҵ� �̸� ��� ����

	}

	@RequestMapping("/test2")
	public String ex02() { // ���� ���ڿ�.jsp �������� ȣ���

		// return "result";
		return "redirect:/result"; // redirect > ���ο� result ��û

	}

	@RequestMapping("/result") // ���ο� result��û�� ����
	public void ex03() {

	}

	@RequestMapping("/test3")
	public String ex04(Model model) {

		model.addAttribute("abc", "1234"); // �� ���̵�, ��

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
		
		System.out.println("�̸�"+dto.getName() +"\n����"+ dto.getAge());
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
		System.out.println("�� ���� ����" + sum);
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