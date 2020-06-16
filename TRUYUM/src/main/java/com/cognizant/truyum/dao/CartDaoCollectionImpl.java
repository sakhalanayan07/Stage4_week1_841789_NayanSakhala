package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;
import com.cognizant.truyum.service.exception.CartEmptyException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository
public class CartDaoCollectionImpl implements CartDao{

	HashMap<String,Cart> userCarts=null;
	ApplicationContext context=new ClassPathXmlApplicationContext("truyum.xml");

	public CartDaoCollectionImpl() {
		super();
		if(userCarts==null)
		{
			//userCarts=new HashMap<String,Cart>();
			userCarts=context.getBean("cartMap",HashMap.class);
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) throws ParseException {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
        MenuItem menuItem;
		try {
			menuItem = menuItemDao.getMenuItem(menuItemId);
		
        List<MenuItem> list=null;
        
	    if(userCarts.containsKey(userId))
	    {
	    	list=userCarts.get(userId).getMenuItemList();
	    	list.add(menuItem);	 
	    
	    }
	    else
	    {
	    	List<MenuItem> newList=new ArrayList<>();
	    	newList.add(menuItem);
	    	Cart cart=new Cart(newList,50);
	    	userCarts.put(userId,cart);
	    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Override
	public List<MenuItem> getAllCartItems(String userIds) throws CartEmptyException{
    	Cart cart=userCarts.get(userIds);
    	List<MenuItem> list=cart.getMenuItemList();
    	if(list.isEmpty())
    	{
    		throw new CartEmptyException();
    	}
    	long sum=0;
    	for(int i=0;i<list.size();i++)
    	{
    		sum+=list.get(i).getPrice();
    		cart.setTotal(sum);
    	}
    	
    	
		return list;
	}
	
	@Override
	public void removeCartItem(String userId, long menuItemId) {
                   
		List<MenuItem> list=userCarts.get(userId).getMenuItemList();
	    for(int i=0;i<list.size();i++)
	    {
	    	if(list.get(i).getId()==menuItemId)
	    	{
	    		list.remove(i);
	    	}
	    }
	}

	
}
