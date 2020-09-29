package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.CashAndCarryConstant;
import com.citi.ArbApplication.Component.FRAConstant;
import com.citi.ArbApplication.Component.FxConstant;
import com.citi.ArbApplication.Service.RandomGenerationService;

@Service
public class RandomGenerationServiceImpl implements RandomGenerationService {

	@Override
	public ArrayList<Object> randomFxGeneration() {
		ArrayList<Object> arrFX = new ArrayList<Object>();
		arrFX.add((Math.random() * FxConstant.getSpotBidRange()) + FxConstant.getSpotBidMin()); // spot_bid(1)
		arrFX.add((Math.random() * FxConstant.getRange()) + (double) arrFX.get(0) + FxConstant.getMinval());// spot_ask(2)
		arrFX.add((Math.random() * FxConstant.getForwardBidRange()) + FxConstant.getForwardBidMin());// forward_bid(3)
		arrFX.add((Math.random() * FxConstant.getRange()) + (double) arrFX.get(2) + FxConstant.getMinval());// forward_ask(4)
		arrFX.add((Math.random() * FxConstant.getInterestRateUsdBidRange()) + FxConstant.getInterestRateUsdBidMin());// interest_rate_usd_bid(5)
		arrFX.add((Math.random() * FxConstant.getRange()) + (double) arrFX.get(4) + FxConstant.getMinval());// interest_rate_usd_ask(6)
		arrFX.add((Math.random() * FxConstant.getInterestRateJpyBidRange()) + FxConstant.getInterestRateJpyBidMin());// interest_rate_jpy_bid(7)
		arrFX.add((Math.random() * FxConstant.getRange()) + (double) arrFX.get(6) + FxConstant.getMinval());// interest_rate_jpy_ask(8)


		Random rand = new Random();
		double fwd_arb_quantity = FxConstant.getfwdArbQuantityList().get((rand.nextInt(FxConstant.getfwdArbQuantityList().size())));
		
		arrFX.add(fwd_arb_quantity);// 9
		
		arrFX.add(((double) arrFX.get(8)) * (FxConstant.getTransactioncostpercent()));// transaction_cost(11)
		
		double time_months = FxConstant.getTimeMonths().get((rand.nextInt(FxConstant.getTimeMonths().size())));
		arrFX.add(time_months);

	
		return arrFX;
	}
	
	@Override
	public ArrayList<Object> randomCashGeneration(){
		ArrayList<Object> arrCash = new ArrayList<Object>();
		
		arrCash.add((Math.random() * CashAndCarryConstant.getSpotBidRange()) + CashAndCarryConstant.getSpotBidMin());
		arrCash.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arrCash.get(0) + CashAndCarryConstant.getMinval());
		arrCash.add((Math.random() * CashAndCarryConstant.getFutureBidRange()) + CashAndCarryConstant.getFutureBidMin());
		arrCash.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arrCash.get(2) + CashAndCarryConstant.getMinval());
		arrCash.add((Math.random() * CashAndCarryConstant.getInterestRateBidRange()) + CashAndCarryConstant.getInterestRateBidMin());
		arrCash.add((Math.random() * CashAndCarryConstant.getRange()) + (double) arrCash.get(4) + CashAndCarryConstant.getMinval());
		
		Random rand = new Random();
		double future_arb_quantity = CashAndCarryConstant.getFutureArbQuantityList().get((rand.nextInt(CashAndCarryConstant.getFutureArbQuantityList().size())));
		
		arrCash.add(future_arb_quantity);
		arrCash.add(CashAndCarryConstant.getTransactioncostpercent());
		
		double time_months = CashAndCarryConstant.getTimeMonths().get((rand.nextInt(CashAndCarryConstant.getTimeMonths().size())));
		arrCash.add(time_months);
		return arrCash;
	}
	
	@Override
	public ArrayList<Object> randomFRAGeneration(){
		ArrayList<Object> arrFRA = new ArrayList<Object>();
		
		arrFRA.add((Math.random() * FRAConstant.getInterest_rate1_bid_range()) + FRAConstant.getInterest_rate1_bid_min());
		arrFRA.add((Math.random() * FRAConstant.getRange()) + (double) arrFRA.get(0) + FRAConstant.getMinVal());
		arrFRA.add((Math.random() * FRAConstant.getInterest_rate2_bid_range()) + FRAConstant.getInterest_rate2_bid_min());
		arrFRA.add((Math.random() * FRAConstant.getRange()) + (double) arrFRA.get(2) + FRAConstant.getMinVal());
		arrFRA.add((Math.random() * FRAConstant.getFra_rate_bid_range()) + FRAConstant.getFra_rate_bid_min());
		arrFRA.add((Math.random() * FRAConstant.getRange()) + (double) arrFRA.get(4) + FRAConstant.getMinVal());
		
		Random rand = new Random();
		double notional_amount= FRAConstant.getNotionalAmountList().get((rand.nextInt(FRAConstant.getNotionalAmountList().size())));
		
		arrFRA.add(notional_amount);
		arrFRA.add(((double) arrFRA.get(6)) * (FRAConstant.getTransaction_cost_percent()));
		
	    return arrFRA;
	}
	
	

}
