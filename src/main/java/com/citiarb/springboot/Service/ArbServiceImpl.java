package com.citiarb.springboot.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiarb.springboot.entity.Arbitrage;
import com.citiarb.springboot.entity.CalculatedArbitrage;

@Service
public class ArbServiceImpl {

	@Autowired
    public CalculatedArbitrage calculatedArbitrage;

	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double fwd_arb_invest_amount_Curr1;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private double rev_arb_invest_amount_Curr2;

	public CalculatedArbitrage sixMonthAmountFwd(Arbitrage arb) {

		fwd_arb_amount = arb.getFwd_arb_quantity()
				+ (arb.getFwd_arb_quantity()) * ((arb.getInterest_rate_curr2_ask() * arb.getTime_months() * 0.01) / 12)
				+ arb.getTransaction_cost();
		fwd_arb_invest_amount_Curr1 = (arb.getFwd_arb_quantity() / arb.getSpot_ask())
				* ((arb.getInterest_rate_curr1_bid() * arb.getTime_months() * 0.01) / 12)
				+ (arb.getFwd_arb_quantity() / arb.getSpot_ask());
		fwd_arb_invest_amount = fwd_arb_invest_amount_Curr1 * arb.getForward_bid();
		
		
		
		rev_arb_amount = arb.getRev_arb_quantity()
				* (1 + arb.getTime_months() * 0.01 * arb.getInterest_rate_curr1_ask() / 12)
				+ arb.getTransaction_cost();
		
		
		rev_arb_invest_amount_Curr2 = (arb.getRev_arb_quantity() * arb.getSpot_bid())
				* (1 + ((arb.getTime_months() * 0.01 * arb.getInterest_rate_curr2_bid()) / 12));// Amount after

		rev_arb_invest_amount = rev_arb_invest_amount_Curr2 / arb.getForward_ask();
		
		
		
		

		
		calculatedArbitrage.setFwd_arb_amount(fwd_arb_amount);
		calculatedArbitrage.setFwd_arb_invest_amount_Curr1(fwd_arb_invest_amount_Curr1);
		calculatedArbitrage.setFwd_arb_invest_amount(fwd_arb_invest_amount);
		calculatedArbitrage.setRev_arb_amount(rev_arb_amount);
		calculatedArbitrage.setRev_arb_invest_amount_Curr2(rev_arb_invest_amount_Curr2);
		calculatedArbitrage.setRev_arb_invest_amount(rev_arb_invest_amount);
		profit_loss_fwd = calculatedArbitrage.getFwd_arb_invest_amount() - calculatedArbitrage.getFwd_arb_amount();
		profit_loss_rev = calculatedArbitrage.getRev_arb_invest_amount() - calculatedArbitrage.getRev_arb_amount();
		calculatedArbitrage.setProfit_loss_fwd(profit_loss_fwd);
		calculatedArbitrage.setProfit_loss_rev(profit_loss_rev);
		
		if(profit_loss_fwd > 0) {
			calculatedArbitrage.setFwdArbitrage(true);
		}else
			calculatedArbitrage.setFwdArbitrage(false);
		
		if(profit_loss_rev > 0) {
			calculatedArbitrage.setRevArbitrage(true);
		}else 
			calculatedArbitrage.setRevArbitrage(false);
		
		
		return calculatedArbitrage;
		}
	
	   

	/*public void investAmountFwd(Arbitrage arb) {
		fwd_arb_invest_amount_Curr1 = (arb.getFwd_arb_quantity() / arb.getSpot_ask())
				* ((arb.getInterest_rate_curr1_bid() * arb.getTime_months() * 0.01) / 12)
				+ (arb.getFwd_arb_quantity() / arb.getSpot_ask());
		fwd_arb_invest_amount = fwd_arb_invest_amount_Curr1 * arb.getForward_bid();
		calculatedArbitrage.setFwd_arb_invest_amount_Curr1(fwd_arb_invest_amount_Curr1);
		calculatedArbitrage.setFwd_arb_invest_amount(fwd_arb_invest_amount);

	}

	public void profitLoss() {
		profit_loss_fwd = calculatedArbitrage.getFwd_arb_invest_amount() - calculatedArbitrage.getFwd_arb_amount();
		calculatedArbitrage.setProfit_loss_fwd(profit_loss_fwd);
		if(profit_loss_fwd > 0) {
			calculatedArbitrage.setFwdArbitrage(true);
		}else
			calculatedArbitrage.setFwdArbitrage(false);
	}
	
	
	public CalculatedArbitrage isArb(Arbitrage arb) {
		ArbServiceImpl arbService = new ArbServiceImpl();
		arbService.sixMonthAmountFwd(arb);
		arbService.investAmountFwd(arb);
		arbService.profitLoss();
		return calculatedArbitrage;
	}

	public void sixMonthAmountRev(Arbitrage arb_rev) {
		rev_arb_amount = arb_rev.getRev_arb_quantity()
				* (1 + arb_rev.getTime_months() * 0.01 * arb_rev.getInterest_rate_curr1_ask() / 12)
				+ arb_rev.getTransaction_cost();
		calculatedArbitrage.setRev_arb_amount(rev_arb_amount);
	}

	public void investAmountRev(Arbitrage arb_rev) {
		rev_arb_invest_amount_Curr2 = (arb_rev.getRev_arb_quantity() * arb_rev.getSpot_bid())
				* (1 + ((arb_rev.getTime_months() * 0.01 * arb_rev.getInterest_rate_curr2_bid()) / 12));// Amount after

		rev_arb_invest_amount = rev_arb_invest_amount_Curr2 / arb_rev.getForward_ask();
		calculatedArbitrage.setRev_arb_invest_amount_Curr2(rev_arb_invest_amount_Curr2);
		calculatedArbitrage.setRev_arb_invest_amount(rev_arb_invest_amount);

	}

	public void profitLossRev() {
		profit_loss_rev = calculatedArbitrage.getRev_arb_invest_amount() - calculatedArbitrage.getRev_arb_amount();
		calculatedArbitrage.setProfit_loss_rev(profit_loss_rev);
		if(calculatedArbitrage.isFwdArbitrage() == false ) {
			if(profit_loss_rev > 0) {
				calculatedArbitrage.setRevArbitrage(true);
			}else {
				calculatedArbitrage.setRevArbitrage(false);
			}
		}
	}
*/
	

}
