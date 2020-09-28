package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.CashAndCarryConstant;
import com.citi.ArbApplication.Component.FxConstant;

@Service
public class RandomGenerationServiceImpl {

	public ArrayList<Object> randomFxGeneration() {
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
		
		double time_months = FxConstant.getTimeMonths().get((rand.nextInt(FxConstant.getTimeMonths().size())));
		arr.add(time_months);

	
		return arr;
	}
	
	public ArrayList<Object> randomCashGeneration(){
		ArrayList<Object> arr = new ArrayList<Object>();
		
		arr.add((Math.random() * CashAndCarryConstant.getSpotBidRange()) + CashAndCarryConstant.getSpotBidMin());
		arr.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arr.get(0) + CashAndCarryConstant.getMinval());
		arr.add((Math.random() * CashAndCarryConstant.getFutureBidRange()) + CashAndCarryConstant.getFutureBidMin());
		arr.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arr.get(2) + CashAndCarryConstant.getMinval());
		arr.add((Math.random() * CashAndCarryConstant.getInterestRateBidRange()) + CashAndCarryConstant.getInterestRateBidMin());
		arr.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arr.get(4) + CashAndCarryConstant.getMinval());
		
		Random rand = new Random();
		double future_arb_quantity = CashAndCarryConstant.getFutureArbQuantityList().get((rand.nextInt(CashAndCarryConstant.getFutureArbQuantityList().size())));
		
		arr.add(future_arb_quantity);
		arr.add((CashAndCarryConstant.getTransactioncostpercent()));
		
		double time_months = CashAndCarryConstant.getTimeMonths().get((rand.nextInt(CashAndCarryConstant.getTimeMonths().size())));
		arr.add(time_months);
		return arr;
	}
	
	

}
