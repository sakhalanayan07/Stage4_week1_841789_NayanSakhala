package com.cognizant.truyum.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.*;
@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	
	List<MenuItem> menuItemList=null;
    SimpleDateFormat smp=new SimpleDateFormat("dd/MM/yyyy");
	ApplicationContext context=new ClassPathXmlApplicationContext("truyum.xml");
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		
		Date now=new Date();
		Date temp=menuItemList.get(0).getDateOfLaunch();
		boolean status=menuItemList.get(0).isActive();
		if(temp.after(now) || !status )
		{
			menuItemList.remove(0);
		}
		return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		for(int i=0;i<menuItemList.size();i++)
		{
			if(menuItem.getId()==menuItemList.get(i).getId())
			{
				menuItemList.set(i,menuItem);
			}
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem tempItem=null;
		for(int i=0;i<menuItemList.size();i++)
		{
			if(menuItemId==menuItemList.get(i).getId())
			{
				tempItem=menuItemList.get(i);				
			}
		}
		return tempItem;
	}
	
	

}
