package com.visa.training;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@RequestMapping ("calculate")
	public ModelAndView getResult(@RequestParam("num1")int n1,@RequestParam("num2")int n2, @RequestParam("op")String op ) {
		
		int result = 0;
		if(op.equals("+"))
			result = n1 + n2;
		if(op.equals("-"))
			result = n1 - n2;
		if(op.equals("*"))
				result = n1 * n2;
		if(op.equals("/"))
				result = n1 / n2;
		
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("result",result);
		/*
		 * attributes.put("num1", n1); attributes.put("num2",n2);
		 * attributes.put("op",op);
		 */
		String viewName = "calculatorview";
		return new ModelAndView(viewName, attributes);
	}
	
	
}
