package com.citi.ArbApplication.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FxConstant {
	
	
	private static final double spot_bid_range = 0.05;
	private static final double spot_bid_min = 1.66;
	private static final double forward_bid_range = 0.05;
	private static final double forward_bid_min = 1.67;
	private static final double interest_rate_usd_bid_range = 0.3;
	private static final double interest_rate_usd_bid_min = 3.9;
	private static final double interest_rate_jpy_bid_range = 0.4;
	private static final double interest_rate_jpy_bid_min = 4.6;
	private static final double range = 0.01;
	private static final double minVal = 0.01;
	private static final double transactionCostPercent = 0.015;
	
	static List<Double> fwd_arb_quantity_list = new ArrayList<Double>();
	public static List<Double> getfwdArbQuantityList(){
		
		fwd_arb_quantity_list.add(500.0);
		fwd_arb_quantity_list.add(1000.0);
		fwd_arb_quantity_list.add(5000.0);
		return fwd_arb_quantity_list;
	}
	
	static List<Double> time_months = new ArrayList<Double>();
	public static List<Double> getTimeMonths(){
		
		time_months.add((double) 3);
		time_months.add((double) 6);
		time_months.add((double) 12);
		return time_months;
	}
	

	public static double getMinval() {
		return minVal;
	}

	public static double getSpotBidRange() {
		return spot_bid_range;
	}

	public static double getSpotBidMin() {
		return spot_bid_min;
	}

	public static double getForwardBidRange() {
		return forward_bid_range;
	}

	public static double getForwardBidMin() {
		return forward_bid_min;
	}

	public static double getInterestRateUsdBidRange() {
		return interest_rate_usd_bid_range;
	}

	public static double getInterestRateUsdBidMin() {
		return interest_rate_usd_bid_min;
	}

	public static double getInterestRateJpyBidRange() {
		return interest_rate_jpy_bid_range;
	}

	public static double getInterestRateJpyBidMin() {
		return interest_rate_jpy_bid_min;
	}

	public static double getRange() {
		return range;
	}


	public static double getTransactioncostpercent() {
		return transactionCostPercent;
	}
}
