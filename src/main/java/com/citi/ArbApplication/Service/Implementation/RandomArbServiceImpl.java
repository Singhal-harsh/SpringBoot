package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.CashAndCarryArbitrage;
import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Service.RandomArbService;

@Service
public class RandomArbServiceImpl implements RandomArbService {

	@Autowired
	public RandomGenerationServiceImpl random;

	@Autowired
	public FXArbitrage arbitrage;
	
	@Autowired
	public CashAndCarryArbitrage cashArbitrge;

	public FXArbitrage randomGeneration() throws InterruptedException {

		ArrayList<Object> RandomgeneratedArray = new ArrayList<Object>();
		RandomgeneratedArray = random.randomFxGeneration();

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
		arbitrage.setTime_months((double) RandomgeneratedArray.get(10));

		return arbitrage;

	}
	
	public CashAndCarryArbitrage randomCashGeneration() throws InterruptedException {
		
		ArrayList<Object> RandomCashgeneratedArray = new ArrayList<Object>();
		RandomCashgeneratedArray = random.randomCashGeneration();
		
		cashArbitrge.setSpot_bid((double) RandomCashgeneratedArray.get(0));
		cashArbitrge.setSpot_ask((double) RandomCashgeneratedArray.get(1));
		cashArbitrge.setFuture_bid((double) RandomCashgeneratedArray.get(2));
		cashArbitrge.setFuture_ask((double) RandomCashgeneratedArray.get(3));
		cashArbitrge.setInterest_rate_bid((double) RandomCashgeneratedArray.get(4));
		cashArbitrge.setInterest_rate_ask((double) RandomCashgeneratedArray.get(5));
		cashArbitrge.setQuantity((double) RandomCashgeneratedArray.get(6));
		cashArbitrge.setTransaction_cost((double) RandomCashgeneratedArray.get(7));
		cashArbitrge.setTime_months((double) RandomCashgeneratedArray.get(8));
		
		return cashArbitrge;
	}
}
