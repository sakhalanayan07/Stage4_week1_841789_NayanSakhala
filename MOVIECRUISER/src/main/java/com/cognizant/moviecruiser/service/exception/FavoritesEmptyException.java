package com.cognizant.moviecruiser.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Cart Empty")
public class FavoritesEmptyException extends Exception {

}
