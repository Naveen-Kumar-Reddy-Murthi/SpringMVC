package org.mnr.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController1 {

	@RequestMapping("/error")
	public String errorRedirect(HttpServletRequest request){
		
		System.out.println("WebController1|| /error");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("id"));
		
		System.out.println("errorRedirect");
		return "error";
	}
	
}
