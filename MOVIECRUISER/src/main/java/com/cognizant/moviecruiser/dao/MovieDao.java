package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {
	
	List<Movie> getMovieListAdmin();
	
	List<Movie> getMovieListCustomer();
	
	void modifyMovie(Movie movie);
	
	Movie getMovie(long movieId)throws SQLException;

}
