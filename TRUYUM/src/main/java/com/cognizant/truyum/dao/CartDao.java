package com.cognizant.truyum.dao;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.*;
import com.cognizant.truyum.service.exception.CartEmptyException;
public interface CartDao {
 
	void addCartItem(String userId, long menuItemId) throws ParseException;
	
	List<MenuItem> getAllCartItems(String userId) throws CartEmptyException;
	
	void removeCartItem(String userId, long menuItemId);
}
