package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repository.Emploee;
import com.example.demo.service.MainService;

@Controller
public class MainController {

	private final static Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	private final MainService service;
	

	@Autowired
	public MainController(MainService service)
	{
		this.service = service;
	}
	
	@GetMapping("/demos")
	@ResponseBody
	public List<Emploee> allEmployees()
	{
		return service.getAllUsers();
	}
	
}
