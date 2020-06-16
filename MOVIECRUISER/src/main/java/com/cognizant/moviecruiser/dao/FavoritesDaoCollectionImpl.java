package com.cognizant.moviecruiser.dao;
import com.cognizant.moviecruiser.model.*;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository
public class FavoritesDaoCollectionImpl implements FavoritesDao{

	HashMap<String,Favorites> userCarts=null;
	ApplicationContext context=new ClassPathXmlApplicationContext("moviecruiser.xml");

	public FavoritesDaoCollectionImpl() {
		super();
		if(userCarts==null)
		{
			//userCarts=new HashMap<String,Cart>();
			userCarts=context.getBean("favMap",HashMap.class);
		}
	}

	@Override
	public void addFavoritesMovie(String userId, long movieId) {
		MovieDao menuItemDao=new MovieDaoCollectionImpl();
        Movie movie;
		try {
			movie = menuItemDao.getMovie(movieId);
		
        List<Movie> list=null;
        
	    if(userCarts.containsKey(userId))
	    {
	    	list=userCarts.get(userId).getMovieList();
	    	list.add(movie);	 
	    
	    }
	    else
	    {
	    	List<Movie> newList=new ArrayList<>();
	    	newList.add(movie);
	    	Favorites cart=new Favorites(newList,50);
	    	userCarts.put(userId,cart);
	    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Override
	public List<Movie> getAllFavoritesMovies(String userIds) throws FavoritesEmptyException{
    	Favorites cart=userCarts.get(userIds);
    	List<Movie> list=cart.getMovieList();
    	if(list.isEmpty())
    	{
    		throw new FavoritesEmptyException();
    	}
    	cart.setTotal(list.size());    	
		return list;
	}
	
	@Override
	public void removeFavoritesMovie(String userId, long movieId) {
                   
		List<Movie> list=userCarts.get(userId).getMovieList();
	    for(int i=0;i<list.size();i++)
	    {
	    	if(list.get(i).getId()==movieId)
	    	{
	    		list.remove(i);
	    	}
	    }
	}

	
}
