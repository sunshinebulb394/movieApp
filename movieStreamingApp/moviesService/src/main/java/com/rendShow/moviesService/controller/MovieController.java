package com.rendShow.moviesService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rendShow.moviesService.pojo.Movies;
import com.rendShow.moviesService.repository.MovieRepository;
import com.rendShow.moviesService.service.MovieServiceImp;


@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MovieServiceImp service;
	
//	@Autowired
//	private MovieRepository movieRepository;
	
//	@PostMapping("/upload")
//	public ResponseEntity<?> uploadMovie(@RequestBody Movies movies){
//		boolean movie = service.addMovie(movies);
//		if(!movie ) {
//			movieRepository.save(movies);
//			return ResponseEntity.status(HttpStatus.OK).body("Movie successfully uploaded");
//			
//		}
//		
//		return new ResponseEntity<String>("movie already in the system ", HttpStatus.OK);
//	}
	
	 @PostMapping("/upload")
	    public ResponseEntity<Movies> uploadMovie(@RequestParam("file") MultipartFile file, @ModelAttribute Movies movie) {
	        Movies savedMovie = service.saveMovie(file, movie);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
	    }

}
