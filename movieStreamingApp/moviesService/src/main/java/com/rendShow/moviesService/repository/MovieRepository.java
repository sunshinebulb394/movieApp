package com.rendShow.moviesService.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rendShow.moviesService.pojo.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
	
//	Movies saveMovie(Movies movie);
	
//	Movies findByTitle(String title);
//
//    boolean existsByTitle(String title);

    //@Query(nativeQuery = true, value="SELECT title FROM movies")
//    List<String> getAllEntryTitles();

}
