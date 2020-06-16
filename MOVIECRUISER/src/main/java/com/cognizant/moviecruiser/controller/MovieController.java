package com.cognizant.moviecruiser.controller;

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

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@GetMapping("/{movieid}")
	public Movie getMenuItem(@PathVariable long movieid)throws SQLException {
		return movieService.getMovie(movieid);
	}
	
	@GetMapping()
	public List<Movie> getMovieListCustomer(){
		return movieService.getMovieListCustomer();
	}
	
	@PutMapping("/modify")
	public void modifyMenuItem(@RequestBody Movie movie) { 
		LOGGER.info("START modify");
		movieService.modifyMovie(movie);
		LOGGER.info("END modify");
		return;
	}
}
