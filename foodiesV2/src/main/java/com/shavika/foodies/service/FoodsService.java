package com.shavika.foodies.service;

import java.util.List;

import com.shavika.foodies.api.dto.FoodItem;
import com.shavika.foodies.api.exception.ShavikaAppException;

public abstract interface FoodsService {

	public abstract List<FoodItem> getAllFoodItems() throws ShavikaAppException;

}
