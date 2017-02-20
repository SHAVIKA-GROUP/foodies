package com.shavika.foodies.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shavika.foodies.api.dto.FoodItem;
import com.shavika.foodies.api.exception.ShavikaAppException;
import com.shavika.foodies.dao.FoodsDao;

@Service("foodsService")
public class FoodsServiceImpl implements FoodsService {

	private static final Logger LOGGER = Logger.getLogger(FoodsServiceImpl.class);

	@Autowired
	private FoodsDao foodsDao;

	@Override
	public List<FoodItem> getAllFoodItems() throws ShavikaAppException {
		return foodsDao.findAll(FoodItem.class);
	}
}
