
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

import com.citi.ArbApplication.Component.FRAArbitrage;
import com.citi.ArbApplication.Component.FRACalculatedArbitrage;
import com.citi.ArbApplication.Service.FRAService;
import com.citi.ArbApplication.Service.RandomArbService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FRAController {
	@Autowired
	public FRAService fraService;
	
	@Autowired
	public FRACalculatedArbitrage calculatedArbitrage;
	
	@Autowired
	public RandomArbService randomArbService;
	
	@PostMapping(value = "/user/fra", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FRACalculatedArbitrage> calculateArbitrage(@RequestBody FRAArbitrage arbitrage){
		calculatedArbitrage = fraService.checkArbitrage(arbitrage);
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
		}
	
	@GetMapping(value = "/random/fra", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FRACalculatedArbitrage> randomCalculatedArbitrage() {
		try {
			calculatedArbitrage = fraService.checkArbitrage(randomArbService.randomFRAGeneration());
		} catch (InterruptedException e) {
		 return new ResponseEntity<>(calculatedArbitrage, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
	}
}


