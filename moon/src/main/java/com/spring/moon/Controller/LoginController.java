package com.spring.moon.Controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.moon.dto.CustomerDTO;
import com.spring.moon.service.LoginService;


@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login/login")
	public String login(Model model) throws Exception {

		return "login/login";
	}
	@RequestMapping(value = "/login/signup")
	public String signupForm(Model model) throws Exception {
		model.addAttribute("CustomerDTO", new CustomerDTO());
		return "login/signup";
	}
	@ResponseBody
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
	public int insertCustomer(Locale locale, CustomerDTO customerDTO) throws Exception {
		logger.info("a"+customerDTO.toString());

		return loginService.insertCustomer(customerDTO);
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public int login(CustomerDTO customerDTO, HttpSession Hsession) {
		return loginService.Login(customerDTO, Hsession); 
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    //�޼ҵ� �̸��� LOGOUT �Ű� ������ SESSION
    public String logout(HttpSession session) {
        //m���� ����� ������ ������Ų��.
        session.removeAttribute("c");
        // /�������� �����̷�Ʈ ��Ų��.
        return "redirect:/";
    }


}