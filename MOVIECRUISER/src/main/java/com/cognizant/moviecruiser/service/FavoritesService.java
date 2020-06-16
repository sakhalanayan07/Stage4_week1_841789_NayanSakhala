package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDao favoritesDao;
	
	public void addFavoritesMovie(String userId, long movieId){
		favoritesDao.addFavoritesMovie(userId, movieId);
	}

	public List<Movie> getAllFavoritesMovies(String userIds) throws FavoritesEmptyException{
		return favoritesDao.getAllFavoritesMovies(userIds);
	}
	
	public void removeFavoritesMovie(String userId, long movieId) {
		favoritesDao.removeFavoritesMovie(userId, movieId);
	}
}
