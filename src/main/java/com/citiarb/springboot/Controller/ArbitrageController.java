package com.citiarb.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiarb.springboot.Service.ArbServiceImpl;
import com.citiarb.springboot.entity.Arbitrage;
import com.citiarb.springboot.entity.CalculatedArbitrage;

@RestController  
public class ArbitrageController {
	
	@Autowired
	public ArbServiceImpl ServiceImpl;
	
	@PostMapping("/response")
		public CalculatedArbitrage calculateArbitrage(@RequestBody Arbitrage arbitrage){
		Arbitrage _arbitrage = new Arbitrage(arbitrage.getSpot_bid(), arbitrage.getSpot_ask(), arbitrage.getForward_bid(), arbitrage.getForward_ask(), arbitrage.getInterest_rate_curr1_bid(), arbitrage.getInterest_rate_curr1_ask(), arbitrage.getInterest_rate_curr2_bid(), arbitrage.getInterest_rate_curr2_ask(), arbitrage.getTransaction_cost(), arbitrage.getFwd_arb_quantity(), arbitrage.getRev_arb_quantity(), arbitrage.getTime_months());
		return ServiceImpl.sixMonthAmountFwd(_arbitrage);
		}
}

	
	


