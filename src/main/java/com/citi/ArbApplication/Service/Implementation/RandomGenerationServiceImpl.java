package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Enum.FxEnum;

@Service
public class RandomGenerationServiceImpl {
	
	
	public FxEnum fxEnum;
	
	private double spot_bid_range = 0.5, spot_bid_min = 105.0;
	private double forward_bid_range = 0.5, forward_bid_min = 105.5;
	private double interest_rate_usd_bid_range = 0.5, interest_rate_usd_bid_min = 4.9;
	private double interest_rate_jpy_bid_range = 0.1, interest_rate_jpy_bid_min = 0.3;

	public ArrayList<Object> randomGeneration() {
		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add((Math.random() * spot_bid_range) + spot_bid_min); // spot_bid(1)
		arr.add((Math.random() * 0.15) + (double) arr.get(0) + 0.01);// spot_ask(2)
		arr.add((Math.random() * forward_bid_range) + forward_bid_min);// forward_bid(3)
		arr.add((Math.random() * 0.15) + (double) arr.get(2) + 0.01);// forward_ask(4)
		arr.add((Math.random() * interest_rate_usd_bid_range) + interest_rate_usd_bid_min);// interest_rate_usd_bid(5)
		arr.add((Math.random() * 0.15) + (double) arr.get(4) + 0.01);// interest_rate_usd_ask(6)
		arr.add((Math.random() * interest_rate_jpy_bid_range) + interest_rate_jpy_bid_min);// interest_rate_jpy_bid(7)
		arr.add((Math.random() * 0.15) + (double) arr.get(6) + 0.01);// interest_rate_jpy_ask(8)

		List<Double> fwd_arb_quantity_list = new ArrayList<Double>();
		fwd_arb_quantity_list.add(500.0);
		fwd_arb_quantity_list.add(1000.0);
		fwd_arb_quantity_list.add(5000.0);
		Random rand = new Random();
		double fwd_arb_quantity = fwd_arb_quantity_list.get(rand.nextInt(fwd_arb_quantity_list.size()));
		double rev_arb_quantity = fwd_arb_quantity;
		arr.add(fwd_arb_quantity);// 9
		arr.add(rev_arb_quantity);// 10

		arr.add(((double) arr.get(8)) * (0.025));// transaction_cost(11)

		System.out.println("elements are : " + arr);
		return arr;
	}

}

