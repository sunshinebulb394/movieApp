package com.rendShow.genreService.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rendShow.genreService.pojo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
