package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	/*
	 *  name of the method does not matter 
	 *  annonate the method will special annotation
	 *  This method will handle the request of "/hello"
	 *  @RequestMapping annotaion is applied on methods in controller classes to
	 *  match to URLS
	 */
	@RequestMapping("/hello")
	public ModelAndView handleHelloWorld(@RequestParam("name")String name) { 
		/*
		 * No arguments when no need request parameter Put HttpServlet as argument to
		 * get request parameter String name as parameter and annotate parameter
		 * with @RequestParam
		 */
		
		String result = "Hello" + name;
		//result rendered using helloview.jsp
		String viewName = "helloview";
		//Model and view can take MAP as argument for constructor
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("result",result);
		// any no of attributes can be put which can be accessed in the JSP
		
		return new ModelAndView(viewName, attributes); // (viewName, modelName)  model is nothing but data map (attributes)
		
		// No type for viewName is given.. to promote flexibility of types
		// This is just a logical view name
		
	}
	
}
