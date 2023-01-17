package com.thomasgodoi.pillsbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thomasgodoi.pillsbackend.entities.Perk;
import com.thomasgodoi.pillsbackend.repositories.PerkRepository;

@Service
public class PerkService {

	@Autowired
	private PerkRepository perkRepository;
	
	public List<Perk> getAllPerks() {
		List<Perk> response = perkRepository.findAll();
		return response;
	}
	
	public Optional<Perk> findPerkById(Long idPerk) throws Exception {
		try {
			Optional<Perk> response = perkRepository.findById(idPerk);
			return response;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public Page<Perk> findRandomPositivePerks(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);		
		Page<Perk> response = perkRepository.findRandomPositivePerks(paging);
		return response;
	}
	
	public Page<Perk> findRandomNegativePerks(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Perk> response = perkRepository.findRandomNegativePerks(paging);
		return response;
	}
	
	public void addPerkWin(List<Long> perksIdList) {
		for (Long perkId : perksIdList) {
			try {
				Optional<Perk> perkObj = findPerkById(perkId);
				perkObj.get().setTimesWon(perkObj.get().getTimesWon() + 1);
				perkRepository.save(perkObj);
			} catch (Exception e) {
				System.out.println("--- Error trying to get perk to add win ---");
				e.printStackTrace();
			}
		}
	}
	
}
