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
import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Component.FXCalculatedArbitrage;
import com.citi.ArbApplication.Service.ArbService;
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
	@PostMapping(value = "/userCashArbitrage", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CashandCarryCalculatedArbitrage> calculateArbitrage(@RequestBody CashAndCarryArbitrage arbitrage){
		calculatedArbitrage = cashAndCarryService.checkArbitrage(arbitrage, "Post");
		return new ResponseEntity<>(calculatedArbitrage, HttpStatus.OK);
		}
	
	@GetMapping(value = "/randomCashArbitrage", produces = MediaType.APPLICATION_JSON_VALUE)
	public CashandCarryCalculatedArbitrage randomCalculatedArbitrage() {
		try {
			calculatedArbitrage = cashAndCarryService.checkArbitrage(randomArbService.randomCashGeneration(), "Get");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return calculatedArbitrage;
	}
}
