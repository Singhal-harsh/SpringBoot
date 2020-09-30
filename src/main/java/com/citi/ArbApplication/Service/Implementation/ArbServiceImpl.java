package com.citi.ArbApplication.Service.Implementation;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Component.FXCalculatedArbitrage;
import com.citi.ArbApplication.Service.ArbService;

@Service
public class ArbServiceImpl implements ArbService {

	@Autowired
    public FXCalculatedArbitrage calculatedArbitrage;
	private static int id = 0;
	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double fwd_arb_invest_amount_Curr1;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private double rev_arb_invest_amount_Curr2;
	
	
	@Override
	public void normalArbitrageCalc(FXArbitrage arb) {
		fwd_arb_amount = arb.getFwd_arb_quantity()
				+ (arb.getFwd_arb_quantity()) * ((arb.getInterest_rate_curr2_ask() * arb.getTime_months() * 0.01) / 12)
				+ arb.getTransaction_cost();

		fwd_arb_invest_amount_Curr1 = (arb.getFwd_arb_quantity() / arb.getSpot_ask())
				* ((arb.getInterest_rate_curr1_bid() * arb.getTime_months() * 0.01) / 12)
				+ (arb.getFwd_arb_quantity() / arb.getSpot_ask());

		fwd_arb_invest_amount = fwd_arb_invest_amount_Curr1 * arb.getForward_bid();
	}
	
	@Override
	public void reverseArbitrageCalc(FXArbitrage arb) {
		rev_arb_amount = (arb.getFwd_arb_quantity()
				* (1 + arb.getTime_months() * 0.01 * arb.getInterest_rate_curr1_ask() / 12)
				+ arb.getTransaction_cost());

		rev_arb_invest_amount_Curr2 = (arb.getFwd_arb_quantity()*arb.getSpot_bid())
				* (1 + ((arb.getInterest_rate_curr2_bid() * arb.getTime_months() * 0.01) / 12));

		rev_arb_invest_amount = rev_arb_invest_amount_Curr2 / arb.getForward_ask();
	}
	
	public void idGeneration() {
		calculatedArbitrage.setId(++ArbServiceImpl.id);
	}

	@Override
	public FXCalculatedArbitrage checkArbitrage(FXArbitrage arb) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
	    Date date = new Date();
		this.normalArbitrageCalc(arb);
		this.reverseArbitrageCalc(arb);
		if(arb.getMapping() == true) {
			this.idGeneration();
		}
		
		
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
		calculatedArbitrage.setArbitrage(arb);
		calculatedArbitrage.setDate(df.format(date));

		if (profit_loss_fwd > 0) {
			calculatedArbitrage.setFwdArbitrage(true);
		} else
			calculatedArbitrage.setFwdArbitrage(false);

		if (profit_loss_rev > 0) {
			calculatedArbitrage.setRevArbitrage(true);
		} else
			calculatedArbitrage.setRevArbitrage(false);

		return calculatedArbitrage;
	}   
	
}
