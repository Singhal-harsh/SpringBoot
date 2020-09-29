package com.citi.ArbApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Component.FXCalculatedArbitrage;
import com.citi.ArbApplication.Service.ArbService;
import com.citi.ArbApplication.Service.RandomArbService;

@CrossOrigin(origins="http://localhost:4200")
@RestController  
public class FXController {
	
	@Autowired
	public ArbService arbService;
	
	@Autowired
	public FXCalculatedArbitrage calculatedArbitrage;
	
	@Autowired
	public RandomArbService randomArbService;
	
	@PostMapping(value = "/userFxArbitrage", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<FXCalculatedArbitrage> calculateArbitrage(@RequestBody FXArbitrage arbitrage){
		calculatedArbitrage = arbService.checkArbitrage(arbitrage);
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
		}
	
	@GetMapping(value = "/randomFxArbitrage", produces = MediaType.APPLICATION_JSON_VALUE)
	public FXCalculatedArbitrage randomCalculatedArbitrage() {
		try {
			calculatedArbitrage = arbService.checkArbitrage(randomArbService.randomGeneration());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return calculatedArbitrage;
	}
}

	
	


