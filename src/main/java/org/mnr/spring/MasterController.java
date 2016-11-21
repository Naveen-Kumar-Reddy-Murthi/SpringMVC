package org.mnr.spring;

import javax.validation.Valid;

import org.mnr.dao.StudentDao;
import org.mnr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MasterController {
	
	@Autowired
	StudentDao sDao;

	@RequestMapping(value="/register")
	public ModelAndView register(@ModelAttribute("student1") Student student1){
		
		return new ModelAndView("studentForm");
	}
	/*
	 * Since we have used <context:component-scan base-package="org.mnr.spring,org.mnr.model"/>
	 * in dispatcher-servlet, container automatically creates beans with default reference variables.
	 * But spring container will lower case the first letter of reference variables
	 * Ex: If Class name is "Student" reference variable will "student"
	 * To override this we need to use the modelAttribute annotation wherever that reference is used
	 * 
	 */
	
	@RequestMapping(value="/save")
	public ModelAndView save(@Valid @ModelAttribute("student1")Student student1,BindingResult bind){
		
		
		if(bind.hasErrors())
			return new ModelAndView("studentForm");
		sDao.save(student1);
		return new ModelAndView("success1","student1",student1);
	}
}
