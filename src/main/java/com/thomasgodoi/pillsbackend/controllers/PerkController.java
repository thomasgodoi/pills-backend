package com.thomasgodoi.pillsbackend.controllers;

import java.util.List;

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
@RequestMapping("/perks")
public class PerkController {

	@Autowired
	private  PerkService perkService;
		
	@GetMapping("/find-all")
	public List<Perk> getAllPerks() {
		try {
			List<Perk> response = perkService.getAllPerks();
			return response;
		} catch(Error error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/positives")
	public Page<Perk> getRandomPositivePerks(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "3") Integer pageSize) {
		
		try {
			Page<Perk> response = perkService.findRandomPositivePerks(pageNo, pageSize);
			return response;	
		} catch (Error error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/negatives")
	public Page<Perk> getRandomNegativePerks(
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "1") Integer pageSize) {
		
		try {
			Page<Perk> response = perkService.findRandomNegativePerks(pageNo, pageSize);
			return response;	
		} catch (Error error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/by-id/{id}")
	public Perk findPerkById(@PathVariable Long id) {
		try {
			Perk response;
			response = perkService.findPerkById(id);
			return response;
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/add-score/{perkIdList}/{isWinner}")
	public void scorePerks(@PathVariable("perkIdList") List<Long> perkIdList, @PathVariable("isWinner") Boolean isWinner) {
		try {
			perkService.addPerksScore(perkIdList, isWinner);
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-perks")
	public List<Perk> findPerks() {	
		try {
			List<Perk> response = perkService.findPerks();
			return response;
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-most-wins")
	public Perk findPerkWithMostWins() {	
		try {
			Perk response = perkService.findPerkWithMostWins();
			return response;
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-most-losses")
	public Perk findPerkWithMostLosses() {	
		try {
			Perk response = perkService.findPerkWithMostLosses();
			return response;
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-hot-streak")
	public Perk findPerkHotStreak() {	
		try {
			Perk response = perkService.findPerkWithHotStreak();
			return response;
		} catch (Exception error) {
			System.out.println(error);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
}
