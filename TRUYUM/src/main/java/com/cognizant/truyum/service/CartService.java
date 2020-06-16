package com.cognizant.truyum.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.exception.CartEmptyException;

@Service
public class CartService {
	
	@Autowired
	CartDao cartDao;
	
	public void addCartItem(String userId, long menuItemId) throws ParseException {
		cartDao.addCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userIds) throws CartEmptyException{
		return cartDao.getAllCartItems(userIds);
	}
	
	public void removeCartItem(String userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
