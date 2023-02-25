package com.rendShow.moviesService.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
	
	private Long id;
	private String title;
	private Date releaseDate;
	private String rating;
	private String filePath;
	private byte[] movie;

}
