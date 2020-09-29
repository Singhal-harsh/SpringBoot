package com.citi.ArbApplication.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CashAndCarryConstant {

	private static final double spot_bid_range = 30; 
	private static final double spot_bid_min = 3070; 
	private static final double future_bid_range = 30;  
	private static final double future_bid_min = 3100;
	private static final double interest_rate_bid_range = 0.25;
	private static final double interest_rate_bid_min = 3.9;
	private static final double range = 0.15;
	private static final double minVal = 0.01;
	private static final double transactionCostPercent = 0.5;

	

	static List<Double> future_arb_quantity_list = new ArrayList<Double>();

	public static List<Double> getFutureArbQuantityList() {

		future_arb_quantity_list.add(100.0);
		future_arb_quantity_list.add(200.0);
		future_arb_quantity_list.add(300.0);
		return future_arb_quantity_list;
	}
	
	static List<Double> time_months = new ArrayList<Double>();
	public static List<Double> getTimeMonths(){
		
		time_months.add((double) 3);
		//time_months.add((double) 6);
		//time_months.add((double) 12);
		return time_months;
	}

	public static double getSpotBidRange() {
		return spot_bid_range;
	}

	public static double getSpotBidMin() {
		return spot_bid_min;
	}

	public static double getFutureBidRange() {
		return future_bid_range;
	}

	public static double getFutureBidMin() {
		return future_bid_min;
	}

	public static double getInterestRateBidRange() {
		return interest_rate_bid_range;
	}

	public static double getInterestRateBidMin() {
		return interest_rate_bid_min;
	}

	public static List<Double> getFuture_arb_quantity_list() {
		return future_arb_quantity_list;
	}

	public static double getRange() {
		return range;
	}

	public static double getMinval() {
		return minVal;
	}
	
	public static double getTransactioncostpercent() {
		return transactionCostPercent;
	}

}
