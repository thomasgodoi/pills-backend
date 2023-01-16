package com.thomasgodoi.pillsbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perk")
public class Perk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;

	@Column(name = "is_positive")
	private Boolean isPositive;

	@Column(name = "additional_info")
	private String additionalInfo;
	
	@Column(name = "tier")
	private String tier;
	
	@Column(name = "times_won")
	private Long timesWon;
	
	@Column(name = "times_lost")
	private Long timesLost;
	
//	public Perk(Long id, String description, Boolean isPositive, String additionalInfo, 
//			String tier, Long timesWon, Long timesLost) {
//		this.id = id;
//		this.description = description;
//		this.isPositive = isPositive;
//		this.additionalInfo = additionalInfo;
//		this.tier = tier;
//		this.timesWon = timesWon;
//		this.timesLost = timesLost;
//	}
//	
	public Perk(Long id) {
		this.id = id;
	}
	
}
