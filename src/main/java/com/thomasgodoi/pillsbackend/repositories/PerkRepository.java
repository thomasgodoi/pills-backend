package com.thomasgodoi.pillsbackend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thomasgodoi.pillsbackend.entities.Perk;

public interface PerkRepository extends JpaRepository<Perk, Long>{
	
	@Query("SELECT new com.thomasgodoi.pillsbackend.entities.Perk(p.id)FROM Perk p")
	public List<Perk> findAllTeste();

	
	@Query("SELECT new com.thomasgodoi.pillsbackend.entities.Perk(p.id, p.description, p.isPositive, p.additionalInfo, p.tier) FROM Perk p"
			+ " WHERE p.isPositive = TRUE"
			+ " ORDER BY random()")
	public Page<Perk> findRandomPositivePerks(Pageable pageable); 	
	
	@Query("SELECT new com.thomasgodoi.pillsbackend.entities.Perk(p.id, p.description, p.isPositive, p.additionalInfo, p.tier) FROM Perk p"
			+ " WHERE p.isPositive = FALSE"
			+ " ORDER BY random()")
	public Page<Perk> findRandomNegativePerks(Pageable pageable);

	public void save(Optional<Perk> perk);	
}
