package com.abebe.babybames.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abebe.babybames.models.BabyName;
import com.abebe.babybames.models.User;
import com.abebe.babybames.repositories.BabyNameRepository;



@Service
public class BabyNameService {
	@Autowired
	private BabyNameRepository babyNameRepo;

	public BabyName getOne(Long id) {
		Optional<BabyName> babyName = babyNameRepo.findById(id);
		return babyName.isPresent() ? babyName.get() : null;
	}
	
	public BabyName getBabyName(String name) {
		Optional<BabyName> potentialName = babyNameRepo.findByName(name);
		return potentialName.isPresent() ? potentialName.get(): null;
	}

	public List<BabyName> getAll() {
		return (List<BabyName>) babyNameRepo.findAll();
	}

	public BabyName create(BabyName babyName) {
		return babyNameRepo.save(babyName);
	}

	public BabyName update(BabyName babyName) {
		return babyNameRepo.save(babyName);
	}

	public void delete(Long id) {
		babyNameRepo.deleteById(id);
	}
}
