package com.dhanjyoti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	/*@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;

	}*/
	@RequestMapping(value="/", method=RequestMethod.GET)  
    public String home() {  
        return "home";  
    }  
	
	@RequestMapping(value="/homeaction", method=RequestMethod.GET)  
    public String home2() {  
        return "home";  
    }
	
}
