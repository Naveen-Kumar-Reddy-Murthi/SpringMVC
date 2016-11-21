package org.mnr.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebController {

	@RequestMapping("/Link1")
	public ModelAndView handlerOne()
	{
		return new ModelAndView("success");
	}
	
	@RequestMapping("/Link2")
	public ModelAndView handlerTwo(HttpServletRequest request){
		System.out.println("param from Link2="+request.getParameter("param"));
		
		return new ModelAndView("success");
	}
	
	@RequestMapping("/Link3")//passing  params to View
	public ModelAndView handlerTwo(){
								/*View*/  /*param name*/ /*param */			
		return new ModelAndView("success"  ,"message",   "hello");
	}
	
	@RequestMapping("/Link4")//passing multiple params to View
	public ModelAndView handlerThree(){
		
		ModelAndView modelAndView	=	new ModelAndView("success");
		
		modelAndView.addObject("param1","Hello");
		modelAndView.addObject("param2","Bye");
		
		return modelAndView;
	}
	
	@RequestMapping("/Link5")
	public ModelAndView handlerFour(@RequestParam(value="param",defaultValue="default",required=false)String param){
		
		System.out.println("param="+param);
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/Link6")
	public String handlerFive(ModelMap map){
		
		map.addAttribute("param", "testvalue");
		return "success";
	}
	
	@RequestMapping(value="/Link7",method=RequestMethod.GET)
	public String handlerSix(HttpServletRequest request){
		
		System.out.println("handlerSix");
		
		request.setAttribute("name", "Naveen");
		request.setAttribute("id", "13123");
		
		System.out.println("End of handlerSix");
//		return "redirect:error?name=naveen&id=13123";
		
		return "redirect:error";
	}
}
