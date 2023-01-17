package com.thomasgodoi.pillsbackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.thomasgodoi.pillsbackend.entities.Perk;
import com.thomasgodoi.pillsbackend.services.PerkService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class PerkController {

	@Autowired
	private  PerkService perkService;
		
	@GetMapping("/find-all")
	public List<Perk> getAllPerks() {
		try {
			List<Perk> response = perkService.getAllPerks();
			return response;
		} catch(Error error) {
			System.out.println("Error=> " + error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "It just wasn't possible to retrieve perks :(");
		}
	}

	@GetMapping("positive-perks")
	public Page<Perk> getRandomPositivePerks(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "6") Integer pageSize) {
		
		try {
			Page<Perk> response = perkService.findRandomPositivePerks(pageNo, pageSize);
			return response;	
		} catch (Error error) {
			System.out.println("Error=> " + error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "It just wasn't possible to retrieve positive perks :(");
		}
	}
	
	@GetMapping("negative-perks")
	public Page<Perk> getRandomNegativePerks(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "2") Integer pageSize) {
		
		try {
			Page<Perk> response = perkService.findRandomNegativePerks(pageNo, pageSize);
			return response;	
		} catch (Error error) {
			System.out.println("Error=> " + error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "It just wasn't possible to retrieve negative perks :(");
		}
	}
	
	@GetMapping("{id}")
	public Optional<Perk> findPerkById(@PathVariable Long id) {
		try {
			Optional<Perk> response;
			response = perkService.findPerkById(id);
			return response;
		} catch (Exception error) {
			System.out.println("Error=> " + error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "It just wasn't possible to retrieve this perk :(");
		}
	}
	
	@PutMapping("add-win/{perkIdList}")
	public void findPerkById(@PathVariable List<Long> perkIdList) {
		try {
			perkService.addPerkWin(perkIdList);
		} catch (Exception error) {
			System.out.println("Error=> " + error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "It just wasn't possible to retrieve this perk :(");
		}
	}
	
}
