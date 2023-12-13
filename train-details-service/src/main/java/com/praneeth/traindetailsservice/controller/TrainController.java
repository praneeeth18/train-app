package com.praneeth.traindetailsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth.traindetailsservice.model.Train;
import com.praneeth.traindetailsservice.service.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {
	
	@Autowired
	TrainService trainService;
	
	@PostMapping("/addTrain")
	public ResponseEntity<String> addTrain(@RequestBody Train train) {
		return trainService.addTrain(train);
	}
	
	@GetMapping("/getAllTrains")
	public ResponseEntity<List<Train>> getAllTrains() {
		return trainService.getAllTrains();
	}
}
