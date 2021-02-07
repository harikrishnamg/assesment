package com.cardio.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardio.ws.model.Category;
import com.cardio.ws.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
    
	@Autowired
	private CategoryRepo catRepo;
	
	public Category findByName(String name) {
		
		return catRepo.findByCategoryName(name);
	}

	
}
