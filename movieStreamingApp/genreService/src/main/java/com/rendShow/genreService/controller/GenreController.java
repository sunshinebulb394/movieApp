package com.rendShow.genreService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rendShow.genreService.dto.GenreRequest;
import com.rendShow.genreService.dto.GenreResponse;
import com.rendShow.genreService.service.GenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@PostMapping("/")
	public void createGenre(@RequestBody GenreRequest genreRequest) {
		genreService.createGenre(genreRequest);
		
	}
	
	@GetMapping("")
	public List<GenreResponse> getAllGenre(){
		return genreService.getAllGenre();
		
	}

}
