package com.visa.training;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"selectedBooks","selectedCars","selectedBikes"})
public class StoreController {
	
	
	// Another method
	
	@RequestMapping("/addbook")
	public String addBooks(@RequestParam("books") String[] books, Map<String, Object> model) {
		model.put("selectedBooks",books);
		return "carview";
		
	}
	
	@RequestMapping("/addcar")
	public String addCars(@RequestParam("Cars") String[] cars, Map<String, Object> model) {
		model.put("selectedCars",cars);
		return "bikeview";
		
	}
	
	@RequestMapping("/addbike")
	public String addBikes(@RequestParam("bikes") String[] bikes, Map<String, Object> model) {
		model.put("selectedBikes",bikes);
		return "cartview";
		
	}

	/*
	 * @RequestMapping("/addbook") public ModelAndView bookCart(HttpSession
	 * session, @RequestParam("books") String[] books) { String viewName =
	 * "bikeview"; session.setAttribute("selectedBooks",books); return new
	 * ModelAndView(viewName);
	 * 
	 * }
	 * 
	 * @RequestMapping("/addbike") public ModelAndView bikeCart(HttpSession
	 * session, @RequestParam("bikes") String[] bikes) { String viewName =
	 * "carview"; session.setAttribute("selectedBikes",bikes); return new
	 * ModelAndView(viewName);
	 * 
	 * }
	 * 
	 * @RequestMapping("/addcar") public ModelAndView carCart(HttpSession
	 * session, @RequestParam("Cars") String[] cars) { String viewName = "cartview";
	 * session.setAttribute("selectedCars",cars);
	 * 
	 * return new ModelAndView(viewName);
	 * 
	 * }
	 */
	
}
