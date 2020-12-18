package org.zerock.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class TestController2 {
	@GetMapping("/join")
	public void join() {

	}

	@GetMapping("/join2")
	public void join2(String d, Model model) {
		
		
		try {
			
			//현재 날짜 알기
			Date date1 = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = formatter.parse(d);
			long diff = date1.getTime() - beginDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			log.info("날짜차이 : " + diffDays);
			model.addAttribute("days",diffDays);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/join3")
	public void join3(String a, String b, String c, String d, Model model) {
		
		
		try {
			
			Date date2 = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date toDate = format.parse(d);
			//Date fromDate = format.parse(d);
			
			long baseDay = 24 * 60 * 60 * 1000; 	// 일
			long baseMonth = baseDay * 30;		// 월
			long baseYear = baseMonth * 12;		// 년
			
			// from 일자와 to 일자의 시간 차이를 계산한다.
			long calDate = date2.getTime() - toDate.getTime();
			
			long diffYear = calDate / baseYear;
			

			
			model.addAttribute("year",diffYear);
			model.addAttribute("d",d.length());
			model.addAttribute("b",b.length());
			model.addAttribute("a",a.length());
			model.addAttribute("c",c.length());
			
			model.addAttribute("id",a);
			model.addAttribute("name",b);
			model.addAttribute("pass",c);
			model.addAttribute("brt",d);
			
			


			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
