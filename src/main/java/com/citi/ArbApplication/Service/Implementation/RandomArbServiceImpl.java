package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Service.RandomArbService;

@Service
public class RandomArbServiceImpl implements RandomArbService {

	@Autowired
	public RandomGenerationServiceImpl random;

	@Autowired
	public FXArbitrage arbitrage;

	public FXArbitrage randomGeneration() throws InterruptedException {

		ArrayList<Object> RandomgeneratedArray = new ArrayList<Object>();
		RandomgeneratedArray = random.randomGeneration();

		arbitrage.setSpot_bid((double) RandomgeneratedArray.get(0));
		arbitrage.setSpot_ask((double) RandomgeneratedArray.get(1));
		arbitrage.setForward_bid((double) RandomgeneratedArray.get(2));
		arbitrage.setForward_ask((double) RandomgeneratedArray.get(3));
		arbitrage.setInterest_rate_curr1_bid((double) RandomgeneratedArray.get(4));
		arbitrage.setInterest_rate_curr1_ask((double) RandomgeneratedArray.get(5));
		arbitrage.setInterest_rate_curr2_bid((double) RandomgeneratedArray.get(6));
		arbitrage.setInterest_rate_curr2_ask((double) RandomgeneratedArray.get(7));
		arbitrage.setFwd_arb_quantity((double) RandomgeneratedArray.get(8));
		arbitrage.setTransaction_cost((double) RandomgeneratedArray.get(9));

		return arbitrage;

	}
}
