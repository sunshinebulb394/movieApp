package com.rendShow.moviesService.service;

import java.nio.file.Path;
import java.util.stream.Stream;

//import java.nio.file.Path;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
//import org.springframework.core.io.Resource;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.rendShow.moviesService.dto.MovieRequest;
//import com.rendShow.moviesService.dto.MovieResponse;
import com.rendShow.moviesService.pojo.Movies;
import com.rendShow.moviesService.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
    private FileStorageService fileStorageService;

	@Override
    public Movies saveMovie(MultipartFile file, Movies movie) {
        String fileName = fileStorageService.storeFile(file);
        movie.setFilePath(fileName);
        return movieRepository.save(movie);
    }
	

	

	@Override
	public Movies getMovieById(Long id) {
		return movieRepository.findById(id)
				.stream()
				.filter(movie -> movie.getId() == id)
				.findAny()
				.orElseThrow();
	}

	

	@Override
	public Movies updateMovie(Movies movie, Long id) {
		return movieRepository.findById(id)
				.map(movies ->{
					movies.setTitle(movie.getTitle());
					movies.setMovie(movie.getMovie());
					movies.setReleaseDate(movie.getReleaseDate());
					movies.setRating(movie.getRating());
					return movieRepository.save(movies);
				}).orElseGet(()->{
					movie.setId(id);
					return movieRepository.save(movie);
				});
				
	}




	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
