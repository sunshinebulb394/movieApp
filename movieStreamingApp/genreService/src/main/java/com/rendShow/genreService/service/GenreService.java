package com.rendShow.genreService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rendShow.genreService.dto.GenreRequest;
import com.rendShow.genreService.dto.GenreResponse;
import com.rendShow.genreService.pojo.Genre;
import com.rendShow.genreService.respository.GenreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public void createGenre(GenreRequest genreRequest) {
		Genre genre = Genre.builder()
				.category(genreRequest.getCategory())
				.build();
		
		genreRepository.save(genre);
		log.info("Genre {} is added", genre.getId());
		
	}

	public List<GenreResponse> getAllGenre() {
		List<Genre> genres = genreRepository.findAll();
		
		return genres.stream().map(this::mapToGenreResponse).toList();	
		
	}
	
	private GenreResponse mapToGenreResponse(Genre genre) {
		return GenreResponse.builder()
				.id(genre.getId())
				.category(genre.getCategory())
				.build();
	}

}
