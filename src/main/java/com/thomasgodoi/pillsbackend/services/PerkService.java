package com.thomasgodoi.pillsbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomasgodoi.pillsbackend.entities.Perk;
import com.thomasgodoi.pillsbackend.repositories.PerkRepository;

@Service
public class PerkService {

	@Autowired
	private PerkRepository perkRepository;
	
	public List<Perk> getAllPerks() {
		return perkRepository.findAllTeste();
	}
	
//	public Long getPerkTotalRecords() {
//		return perkRepository.getPerkTotalRecords();
//	}
//	
//	public List<Perk> getRandomPerks() {
//		return perkRepository.getRandomPerks();
//	}
}
