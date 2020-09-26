package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.FxConstant;

@Service
public class RandomGenerationServiceImpl {

	public ArrayList<Object> randomGeneration() {
		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add((Math.random() * FxConstant.getSpotBidRange()) + FxConstant.getSpotBidMin()); // spot_bid(1)
		arr.add((Math.random() * FxConstant.getRange()) + (double) arr.get(0) + FxConstant.getMinval());// spot_ask(2)
		arr.add((Math.random() * FxConstant.getForwardBidRange()) + FxConstant.getForwardBidMin());// forward_bid(3)
		arr.add((Math.random() * FxConstant.getRange()) + (double) arr.get(2) + FxConstant.getMinval());// forward_ask(4)
		arr.add((Math.random() * FxConstant.getInterestRateUsdBidRange()) + FxConstant.getInterestRateUsdBidMin());// interest_rate_usd_bid(5)
		arr.add((Math.random() * FxConstant.getRange()) + (double) arr.get(4) + FxConstant.getMinval());// interest_rate_usd_ask(6)
		arr.add((Math.random() * FxConstant.getInterestRateJpyBidRange()) + FxConstant.getInterestRateJpyBidMin());// interest_rate_jpy_bid(7)
		arr.add((Math.random() * FxConstant.getRange()) + (double) arr.get(6) + FxConstant.getMinval());// interest_rate_jpy_ask(8)


		Random rand = new Random();
		double fwd_arb_quantity = FxConstant.getfwdArbQuantityList().get((rand.nextInt(FxConstant.getfwdArbQuantityList().size())));
		
		arr.add(fwd_arb_quantity);// 9
		

		arr.add(((double) arr.get(8)) * (FxConstant.getTransactioncostpercent()));// transaction_cost(11)

		//System.out.println("elements are : " + arr);
		return arr;
	}

}
