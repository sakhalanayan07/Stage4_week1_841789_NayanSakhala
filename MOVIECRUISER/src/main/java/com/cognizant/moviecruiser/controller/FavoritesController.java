package com.cognizant.moviecruiser.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoritesService;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;
@RestController
@RequestMapping("/favorites")
public class FavoritesController {

	@Autowired
	FavoritesService favoritesService;
	
	@GetMapping("/{userId}")
    List<Movie> getAllFavoritesMovies(@PathVariable String userId) throws FavoritesEmptyException {
		return favoritesService.getAllFavoritesMovies(userId);
	}
	
	@PostMapping("/{userId}/{movieId}")
	void addFavoritesMovie(@PathVariable String userId,@PathVariable long movieId) throws ParseException {
		favoritesService.addFavoritesMovie(userId, movieId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	void removeCartItem(@PathVariable String userId,@PathVariable long movieId) {
		favoritesService.removeFavoritesMovie(userId, movieId);
	}
}
