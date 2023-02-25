package com.rendShow.moviesService.service;

import java.nio.file.Path;
//import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.rendShow.moviesService.pojo.Movies;

public interface MovieService {
	
	Movies saveMovie(MultipartFile file, Movies movie);
	
	Movies updateMovie(Movies movie, Long id);
	
	Movies getMovieById(Long id);	
	
	
//	Movies getMovie(String title);
//	
//	
//
//	boolean addMovie(Movies movie);
//	
//	List<String> getAllMovieNames();
//	
//
//	void deleteMovieById(Long id);
//	
//	List<Movies> getAllMovies();
//	
//	 public void init();
//
//	
//
	  public Resource load(String filename);

//	  public void deleteAll();
//
	  public Stream<Path> loadAll();

	

}







