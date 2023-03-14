package com.myspring.pro27;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale; //A Locale object represents a specific geographical, political,or cultural region.
//SLF4J(simple logging Facade java)는 단순한 퍼사드 패턴을 수단으로 하는 자바 로깅  API 제공
//facade 패턴 : 소프트웨어 공학 디자인 패턴, 클래스 라이브러리 같은 어떤 소프트웨어의 다른 커다란 코드 부분에 대한 간략화된 인터페이스 제공 객체
import org.slf4j.Logger; //The org.slf4j.Logger interface is the main user entry point of SLF4J API
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
