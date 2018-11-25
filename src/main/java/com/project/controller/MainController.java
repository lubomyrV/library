package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@org.springframework.web.bind.annotation.RestController
public class MainController {
	
	@GetMapping("/")
    public String index(){
		return "Index page,\n'/books' - to Books page\n";
    }
    
}