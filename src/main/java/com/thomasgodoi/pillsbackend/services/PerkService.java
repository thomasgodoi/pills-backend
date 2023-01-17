package com.thomasgodoi.pillsbackend.services;

import java.util.ArrayList;
import java.util.List;

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
		final List<Perk> response = perkRepository.findAll();
		return response;
	}
	
	public Perk findPerkById(Long idPerk) throws Exception {
		try {
			Perk response = perkRepository.findById(idPerk).get();
			return response;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public Page<Perk> findRandomPositivePerks(Integer pageNo, Integer pageSize) {
		final Pageable paging = PageRequest.of(pageNo, pageSize);		
		final Page<Perk> response = perkRepository.findRandomPositivePerks(paging);
		return response;
	}
	
	public Page<Perk> findRandomNegativePerks(Integer pageNo, Integer pageSize) {
		final Pageable paging = PageRequest.of(pageNo, pageSize);
		final Page<Perk> response = perkRepository.findRandomNegativePerks(paging);
		return response;
	}
	
	public void addPerksScore(List<Long> perksIdList, Boolean isWinner) {
		final List<Perk> perksUpdated = new ArrayList<>();

		for (Long perkId : perksIdList) {
			try {
				Perk perk = findPerkById(perkId);
				if(isWinner) {
					perk.setTimesWon(perk.getTimesWon() + 1);
					updatePerkPerformance(perk, isWinner);
					
					perksUpdated.add(perk);	
				} else {
					perk.setTimesLost(perk.getTimesLost() + 1);
					updatePerkPerformance(perk, isWinner);
					
					perksUpdated.add(perk);
				} 
			} catch(Exception e) {
				System.out.println("--- Error trying to get perk to add win ---");
				e.printStackTrace();
			} 
		}
		updatePerksTier(perksUpdated);
	}

	public void updatePerkPerformance(Perk perk, Boolean isWinner) {
		Long performance = perk.getRecentPerformance();
		
		if(isWinner && performance <= 24) {
			perk.setRecentPerformance(performance + 1);	
		}
		
		if(!isWinner && performance >= -24) {
			perk.setRecentPerformance(performance -1);
		}	
		return;
	}
	
	public void updatePerksTier(List<Perk> perks) {
		List<Perk> perksToSave = new ArrayList<>();
		
		for(Perk perk : perks) {
			Long perkPerformance = perk.getRecentPerformance();
			if(perkPerformance <= 25 && perkPerformance >= 20) {
				perk.setTier("S+");
				perksToSave.add(perk);
			}
			
			if(perkPerformance <= 19 && perkPerformance >= 12) {
				perk.setTier("S");
				perksToSave.add(perk);
			}
			
			if(perkPerformance <= 11 && perkPerformance >= 5) {
				perk.setTier("A");
				perksToSave.add(perk);
			}

			if(perkPerformance <= 3 && perkPerformance >= -3) {
				perk.setTier("B");
				perksToSave.add(perk);
			}
			
			if(perkPerformance <= -4 && perkPerformance >= -11) {
				perk.setTier("C");
				perksToSave.add(perk);
			}
			
			if(perkPerformance <= -12 && perkPerformance >= -19) {
				perk.setTier("D");
				perksToSave.add(perk);
			}
			
			if(perkPerformance <= -20 && perkPerformance >= -25) {
				perk.setTier("E");
				perksToSave.add(perk);
			}
		}
		
		perkRepository.saveAll(perksToSave);
	}
	
}
