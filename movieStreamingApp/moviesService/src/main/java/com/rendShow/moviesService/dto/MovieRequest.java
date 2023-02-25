package com.rendShow.moviesService.dto;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequest {
	
	private String title;
	private Date releaseDate;
	private String rating;
	private String filePath;
	private byte[] movie;

}
