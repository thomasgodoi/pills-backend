package com.thomasgodoi.pillsbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomasgodoi.pillsbackend.entities.Perk;
import com.thomasgodoi.pillsbackend.services.PerkService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class PerkController {

	@Autowired
	private  PerkService perkService;
		
	@GetMapping("/findAllPerks")
	public List<Perk> getAllPerks() {
		List<Perk> response = perkService.getAllPerks();
		return response;
	}
	
	@GetMapping("/teste")
	public String teste() {
		return "Hello World!!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
