package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoCollectionImpl implements MovieDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoCollectionImpl.class);

	public static List<Movie> movieList;
	@Override
	public List<Movie> getMovieListCustomer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
     	List<Movie> movieListCustomer = context.getBean("movieList", ArrayList.class);
		return movieListCustomer;
	}

	

	@Override
	public List<Movie> getMovieListAdmin() {
		return movieList;
	}
	@Override
	public void modifyMovie(Movie movie) {
		
		for(int i=0;i<movieList.size();i++)
		{
			if(movie.getId()==movieList.get(i).getId())
			{
				movieList.set(i,movie);
			}
		}
		
	}

	@Override
	public Movie getMovie(long movieId) {
		Movie tempItem=null;
		for(int i=0;i<movieList.size();i++)
		{
			if(movieId==movieList.get(i).getId())
			{
				tempItem=movieList.get(i);				
			}
		}
		return tempItem;
	}
	
	

}
