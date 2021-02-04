package com.cardio.ws.repo;

import com.cardio.ws.model.Category;

public interface CategoryRepo {

	Category findByName(String name);

}
