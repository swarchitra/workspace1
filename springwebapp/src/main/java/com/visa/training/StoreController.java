package com.visa.training;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	@RequestMapping("/books")
	public ModelAndView shoppingCart(HttpSession session) {
		
		
		String viewName = "books";
		Map<String, Object> model = new HashMap<>();
		return new ModelAndView(viewName, model);
		
	}
	
}
