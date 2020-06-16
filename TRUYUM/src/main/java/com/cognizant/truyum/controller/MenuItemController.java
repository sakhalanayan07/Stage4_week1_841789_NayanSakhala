package com.cognizant.truyum.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("menu-items")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) throws SQLException {
		return menuItemService.getMenuItem(id);
	}
	
	@GetMapping("/all")
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemService.getMenuItemListCustomer();
	}
	
	@PutMapping("/edit")
	public void modifyMenuItem(@RequestBody MenuItem menuItem) { 
		LOGGER.info("START");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("ENDs");
		return;
	}
}
