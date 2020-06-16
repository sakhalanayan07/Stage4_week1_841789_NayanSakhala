package com.cognizant.moviecruiser.dao;
import java.util.List;

import com.cognizant.moviecruiser.model.*;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

public interface FavoritesDao {
 
    public void addFavoritesMovie(String userId, long movieId);
    
	public List<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException;
    
	public void removeFavoritesMovie(String userId, long movieId);
}
