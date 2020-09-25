package com.citi.ArbApplication.Service.Implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.Arbitrage;
import com.citi.ArbApplication.Service.RandomArbService;

@Service
public class RandomArbServiceImpl implements RandomArbService {

	@Autowired
	public RandomGenerationServiceImpl random;

	@Autowired
	public Arbitrage arbitrage;

	/*double spot_bid;
	double spot_ask;
	double forward_bid;
	double forward_ask;
	double interest_rate_curr1_bid;
	double interest_rate_curr1_ask;
	double interest_rate_curr2_bid;
	double interest_rate_curr2_ask;
	double fwd_arb_quantity;
	double rev_arb_quantity;
	double transaction_cost;
  */
	public Arbitrage randomGeneration() throws InterruptedException {
		while (true) {

			ArrayList<Object> arr = new ArrayList<Object>();
			arr = random.randomGeneration();
			/*spot_bid = (double) arr.get(0);
			spot_ask = (double) arr.get(1);
			forward_bid = (double) arr.get(2);
			forward_ask = (double) arr.get(3);
			interest_rate_curr1_bid = (double) arr.get(4);
			interest_rate_curr1_ask = (double) arr.get(5);
			interest_rate_curr2_bid = (double) arr.get(6);
			interest_rate_curr2_ask = (double) arr.get(7);
			fwd_arb_quantity = (double) arr.get(8);
			rev_arb_quantity = (double) arr.get(9);
			transaction_cost = (double) arr.get(10);
			*/
			arbitrage.setSpot_bid((double) arr.get(0));
			arbitrage.setSpot_ask((double) arr.get(1));
			arbitrage.setForward_bid((double) arr.get(2));
			arbitrage.setForward_ask((double) arr.get(3));
			arbitrage.setInterest_rate_curr1_bid((double) arr.get(4));
			arbitrage.setInterest_rate_curr1_ask((double) arr.get(5));
			arbitrage.setInterest_rate_curr2_bid((double) arr.get(6));
			arbitrage.setInterest_rate_curr2_ask((double) arr.get(7));
			arbitrage.setFwd_arb_quantity((double) arr.get(8));
			arbitrage.setRev_arb_quantity((double) arr.get(9));
			arbitrage.setTransaction_cost((double) arr.get(10));

			/*System.out.println("spot_bid " + spot_bid + " spot_ask " + spot_ask + " forward_bid " + forward_bid
					+ " forward_ask " + forward_ask + " interest_rate_usd_bid " + interest_rate_curr1_bid
					+ " interest_rate_usd_ask " + interest_rate_curr1_ask + " interest_rate_jpy_bid "
					+ interest_rate_curr2_bid + " interest_rate_jpy_ask " + interest_rate_curr2_ask
					+ " fwd_arb_quantity " + fwd_arb_quantity + "transaction_cost" + transaction_cost);
				*/
			
			
			return arbitrage;

		}
	}
}
