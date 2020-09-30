package com.citi.ArbApplication.Service.Implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.FRAArbitrage;
import com.citi.ArbApplication.Component.FRACalculatedArbitrage;
import com.citi.ArbApplication.Service.FRAService;

@Service
public class FRAServiceImpl implements FRAService{
	
	@Autowired
    public FRACalculatedArbitrage calculatedArbitrage;
	
	private static int id = 0;
	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	
	
	@Override
	public void normalFRAArbCalc(FRAArbitrage fraArbitrage) {
		
		double sixMonthInterestAmount;
		
		sixMonthInterestAmount = fraArbitrage.getNotional_amount()*(1 + fraArbitrage.getInterest_rate1_ask()*0.5*0.01);
		
		fwd_arb_amount = sixMonthInterestAmount*(1 + fraArbitrage.getFra_rate_ask()*0.5*0.01) + fraArbitrage.getTransaction_cost();
		
		fwd_arb_invest_amount = fraArbitrage.getNotional_amount()*(1 + fraArbitrage.getInterest_rate2_bid()*0.01);
		
	}

	@Override
	public void reverseFRAArbCalc(FRAArbitrage fraArbitrage) {
		
		double sixMonthInvestAmount;
		
		rev_arb_amount  = fraArbitrage.getNotional_amount()*(1 + fraArbitrage.getInterest_rate2_ask()*0.01) + fraArbitrage.getTransaction_cost();;
		
		sixMonthInvestAmount = fraArbitrage.getNotional_amount()*(1 + fraArbitrage.getInterest_rate1_bid()*0.5*0.01);
		
		rev_arb_invest_amount = sixMonthInvestAmount*(1+fraArbitrage.getFra_rate_bid()*0.5*0.01);
	}
	
	public void idGeneration() {
		calculatedArbitrage.setId(++FRAServiceImpl.id);
	}
	
	  @Override 
	  public FRACalculatedArbitrage checkArbitrage(FRAArbitrage fraArbitrage){
		  
		  	DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
		    Date date = new Date();
		  	this.normalFRAArbCalc(fraArbitrage);
			this.reverseFRAArbCalc(fraArbitrage);
			
			if(fraArbitrage.isMapping() == true) {
				this.idGeneration();
			}

			calculatedArbitrage.setFwd_arb_amount(fwd_arb_amount);
			calculatedArbitrage.setFwd_arb_invest_amount(fwd_arb_invest_amount);
			calculatedArbitrage.setRev_arb_amount(rev_arb_amount);
			calculatedArbitrage.setRev_arb_invest_amount(rev_arb_invest_amount);
			profit_loss_fwd = calculatedArbitrage.getFwd_arb_invest_amount() - calculatedArbitrage.getFwd_arb_amount();
			profit_loss_rev = calculatedArbitrage.getRev_arb_invest_amount() - calculatedArbitrage.getRev_arb_amount();
			calculatedArbitrage.setProfit_loss_fwd(profit_loss_fwd);
			calculatedArbitrage.setProfit_loss_rev(profit_loss_rev);
			calculatedArbitrage.setArbitrage(fraArbitrage);
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
