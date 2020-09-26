package com.citi.ArbApplication.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FxConstant {

	private static final double spot_bid_range = 0.5;
	private static final double spot_bid_min = 105.0;
	private static final double forward_bid_range = 0.5;
	private static final double forward_bid_min = 105.5;
	private static final double interest_rate_usd_bid_range = 0.5;
	private static final double interest_rate_usd_bid_min = 4.9;
	private static final double interest_rate_jpy_bid_range = 0.1;
	private static final double interest_rate_jpy_bid_min = 0.3;
	private static final double range = 0.15;
	private static final double minVal = 0.01;
	private static final double transactionCostPercent = 0.025;
	
	static List<Double> fwd_arb_quantity_list = new ArrayList<Double>();
	public static List<Double> getfwdArbQuantityList(){
		
		fwd_arb_quantity_list.add(500.0);
		fwd_arb_quantity_list.add(1000.0);
		fwd_arb_quantity_list.add(5000.0);
		return fwd_arb_quantity_list;
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
