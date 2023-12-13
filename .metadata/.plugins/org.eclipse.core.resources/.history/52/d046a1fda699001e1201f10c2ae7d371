package com.praneeth.traindetailsservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trains")
public class Train {
	
	@Id
	private String trianId;
	private Integer trainNumber;
	private String trainName;
	private String source;
	private String destination;
	private String classes;
	private String quota;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String date;
	private String departure;
	private String arrival;
	private Integer price; 
	

}
