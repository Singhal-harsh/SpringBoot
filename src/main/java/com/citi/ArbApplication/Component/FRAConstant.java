package com.citi.ArbApplication.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FRAConstant {
 
	private static double interest_rate1_bid_range = 0.8; //5.34
	private static double interest_rate1_bid_min = 4.7; //5.41
	private static double interest_rate2_bid_range = 0.5; //5.19
	private static double interest_rate2_bid_min = 5.15; //5.24
	private static double fra_rate_bid_range = 0.2; /* 6/12 fra */ //6.21
	private static double fra_rate_bid_min = 5.5; /* 6/12 fra */ //6.38
	private static double range = 0.15;
	private static double minVal = 0.01;
	private static double transaction_cost_percent = 0.002;
	
	static List<Double> notional_amount_list = new ArrayList<Double>();
	public static List<Double> getNotionalAmountList(){
		
		notional_amount_list.add(50000.0);
		notional_amount_list.add(100000.0);
		notional_amount_list.add(150000.0);
		return notional_amount_list;
	}
	
	
	public static double getInterest_rate1_bid_range() {
		return interest_rate1_bid_range;
	}
	public static double getInterest_rate1_bid_min() {
		return interest_rate1_bid_min;
	}
	public static double getInterest_rate2_bid_range() {
		return interest_rate2_bid_range;
	}
	public static double getInterest_rate2_bid_min() {
		return interest_rate2_bid_min;
	}
	public static double getFra_rate_bid_range() {
		return fra_rate_bid_range;
	}
	public static double getFra_rate_bid_min() {
		return fra_rate_bid_min;
	}
	public static double getRange() {
		return range;
	}
	public static double getMinVal() {
		return minVal;
	}
	public static double getTransaction_cost_percent() {
		return transaction_cost_percent;
	}	
	
}

