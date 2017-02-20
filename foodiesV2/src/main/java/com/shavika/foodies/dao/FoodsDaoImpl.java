package com.shavika.foodies.dao;

import org.springframework.stereotype.Repository;

import com.shavika.foodies.api.dao.BaseDaoImpl;
import com.shavika.foodies.api.dto.Customer;
import com.shavika.foodies.api.dto.FoodItem;

@Repository("foodsDao")
public class FoodsDaoImpl extends BaseDaoImpl<FoodItem> implements FoodsDao {
	

}