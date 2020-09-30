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

import com.citi.ArbApplication.Component.CashAndCarryArbitrage;
import com.citi.ArbApplication.Component.CashandCarryCalculatedArbitrage;
import com.citi.ArbApplication.Service.CashAndCarryService;
import com.citi.ArbApplication.Service.RandomArbService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CashAndCarryController {
	@Autowired
	public CashAndCarryService cashAndCarryService;
	
	@Autowired
	public CashandCarryCalculatedArbitrage calculatedArbitrage;
	
	@Autowired
	public RandomArbService randomArbService;
	@PostMapping(value = "/user/cash&carry", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CashandCarryCalculatedArbitrage> calculateArbitrage(@RequestBody CashAndCarryArbitrage arbitrage){
		calculatedArbitrage = cashAndCarryService.checkArbitrage(arbitrage);
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
		}
	
	@GetMapping(value = "/random/cash&carry", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CashandCarryCalculatedArbitrage> randomCalculatedArbitrage() {
		try {
			calculatedArbitrage = cashAndCarryService.checkArbitrage(randomArbService.randomCashGeneration());
		} catch (InterruptedException e) {
			new ResponseEntity<>(calculatedArbitrage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
	}
}
