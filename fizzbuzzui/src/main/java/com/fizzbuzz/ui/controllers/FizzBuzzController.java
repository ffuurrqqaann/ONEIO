package com.fizzbuzz.ui.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fizzbuzz.ui.ApiResponse;
import com.fizzbuzz.ui.model.Parameter;
import com.google.gson.Gson;

@Controller
public class FizzBuzzController {

	@Value("${fizzbuzz.api.server.url.local}")
	String appUrlLocal;

	@Value("${fizzbuzz.api.server.url.production}")
	String appUrlProd;
	
	@Value("${app.run.local}")
	boolean isAppRunningOnLocal;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("parameter", new Parameter()); 
		return "home";
	}

	@PostMapping("/fizzbuzz")
	public String fizzbuzzPage(@ModelAttribute Parameter parameter, Model model) {

		String uri = "";
		
		if(isAppRunningOnLocal) {
			uri = appUrlLocal+"api/fizzbuzz/"+parameter.getNumber()+"/"+parameter.getDivisible1()+"/"+parameter.getDivisible2();
		} else {
			uri = appUrlProd+"api/fizzbuzz/"+parameter.getNumber()+"/"+parameter.getDivisible1()+"/"+parameter.getDivisible2();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		Gson gson = new Gson();
		ApiResponse response = gson.fromJson(result, ApiResponse.class);
		
		model.addAttribute("fizzbuzzList", response.getData());
		model.addAttribute("message", response.getMessage());
		
		return "fizzbuzz";
	}

}