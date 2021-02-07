package com.cardio.ws.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardio.ws.model.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{

	Category findByCategoryName(String name);

}
