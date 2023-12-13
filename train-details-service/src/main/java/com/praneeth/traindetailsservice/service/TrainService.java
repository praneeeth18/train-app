package com.praneeth.traindetailsservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.praneeth.traindetailsservice.model.Train;
import com.praneeth.traindetailsservice.model.TrainSearchRequest;
import com.praneeth.traindetailsservice.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	TrainRepository trainRepository;
	
	public ResponseEntity<String> addTrain(Train train) {
		try {
			trainRepository.insert(train);
			return new ResponseEntity<>("Train added successfully!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Unsuccessfull!", HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Train>> getAllTrains() {
		try {
			return new ResponseEntity<>(trainRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Train>> searchTrain(@RequestBody TrainSearchRequest request) {
		try {
			Optional<List<Train>> trains = trainRepository.findTrainsByCriteria(
					request.getSource(),
					request.getDestination(),
					request.getClasses(),
					request.getQuota(),
					request.getDate()
					);
			if(trains.isPresent()) {
				return new ResponseEntity<>(trains.get(), HttpStatus.OK);
			} else {
                // Handle the case when no trains are found (Optional is empty)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
