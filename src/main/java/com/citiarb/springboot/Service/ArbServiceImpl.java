package com.citiarb.springboot.Service;


import org.springframework.stereotype.Service;

import com.citiarb.springboot.entity.Arbitrage;

@Service
public class ArbServiceImpl implements ArbService {
	

	
	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double fwd_arb_invest_amount_USD;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private double rev_arb_invest_amount_JPY;

	
	public double sixMonthAmountFwd(Arbitrage arb) {
		
		fwd_arb_amount = arb.getFwd_arb_quantity() + (arb.getFwd_arb_quantity()) * ((arb.getInterest_rate_curr2_ask()* arb.getTime_months() * 0.01) / 12)
				+ arb.getTransaction_cost();
		return fwd_arb_amount;
	}

	public double investAmountFwd(Arbitrage arb) {
		fwd_arb_invest_amount_USD = (arb.getFwd_arb_quantity()/ arb.getSpot_ask()) * ((arb.getInterest_rate_curr1_bid() * arb.getTime_months() * 0.01) / 12)
				+ (arb.getFwd_arb_quantity() / arb.getSpot_ask());
		fwd_arb_invest_amount = fwd_arb_invest_amount_USD * arb.getForward_bid();
		return fwd_arb_invest_amount;

	}
	
	public double profitLoss(double fwd_arb_invest_amount, double fwd_arb_amount) {
		profit_loss_fwd = fwd_arb_invest_amount - fwd_arb_amount;
		return profit_loss_fwd;
	}
	public boolean isArbitrage(double fwd_arb_invest_amount, double fwd_arb_amount) {
		profit_loss_fwd = fwd_arb_invest_amount - fwd_arb_amount;
		return profit_loss_fwd > 0 ? true : false;
	}


}
