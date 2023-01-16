package com.thomasgodoi.pillsbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thomasgodoi.pillsbackend.entities.Perk;

public interface PerkRepository extends JpaRepository<Perk, Long>{
	
	@Query("SELECT new com.thomasgodoi.pillsbackend.entities.Perk(p.id)FROM Perk p")
	public List<Perk> findAllTeste();

//	@Query("SELECT p.id FROM Perk p")
//	public List<Perk> getAllPerks();
	
//	@Query("SELECT COUNT(p.id) FROM Perk p")
//	public Long getPerkTotalRecords();
//	
//	@Query("SELECT p.id, p.description, p.isPositive, p.additionalInfo, p.tier FROM Perk p")
//	public List<Perk> getRandomPerks();
}
