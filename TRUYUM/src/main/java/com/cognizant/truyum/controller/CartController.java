package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.exception.CartEmptyException;
@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/{userId}")
    List<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException {
		return cartService.getAllCartItems(userId);
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	void addCartItem(@PathVariable String userId,@PathVariable long menuItemId) throws ParseException {
		cartService.addCartItem(userId, menuItemId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	void removeCartItem(@PathVariable String userId,@PathVariable long menuItemId) {
		cartService.removeCartItem(userId, menuItemId);
	}
}
