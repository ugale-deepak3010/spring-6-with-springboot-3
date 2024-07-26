package com.DeepHotel.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	@ResponseBody
	public String getWelcome(@RequestParam(value = "name", required = false, defaultValue = "Deepak") String name) {

		return "<h1>"+name+" Welcome!! </h1>";
	}
}
