package com.citi.ArbApplication.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ArbApplication.Component.CashAndCarryArbitrage;
import com.citi.ArbApplication.Component.CashandCarryCalculatedArbitrage;
import com.citi.ArbApplication.Service.CashAndCarryService;

@Service
public class CashAndCarryServiceImpl implements CashAndCarryService {

	@Autowired
	public CashandCarryCalculatedArbitrage cashAndCarryCalculated;
	private static int id = 0;
	private double future_arb_amount;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;

	@Override
	public void normalCashArbCalc(CashAndCarryArbitrage cashAndCarryArb) {
		future_arb_amount = cashAndCarryArb.getSpot_ask()
				+ (cashAndCarryArb.getSpot_ask() * cashAndCarryArb.getInterest_rate_ask()
						* (cashAndCarryArb.getTime_months() / 12) * 0.01)
				+ ((cashAndCarryArb.getSpot_ask() + cashAndCarryArb.getFuture_ask())/2 * cashAndCarryArb.getTransaction_cost() * 0.01);

		profit_loss_fwd = (cashAndCarryArb.getFuture_bid() - future_arb_amount) * cashAndCarryArb.getQuantity();

	}
	


	@Override
	public void reverseCashArbCalc(CashAndCarryArbitrage cashAndCarryArb) {
		rev_arb_amount = cashAndCarryArb.getSpot_bid()
				+ (cashAndCarryArb.getSpot_bid() * cashAndCarryArb.getInterest_rate_bid()
						* (cashAndCarryArb.getTime_months() / 12) * 0.01)
				- ((cashAndCarryArb.getSpot_ask()  + cashAndCarryArb.getFuture_ask())/2 * cashAndCarryArb.getTransaction_cost() * 0.01);
		profit_loss_rev = (rev_arb_amount - cashAndCarryArb.getFuture_ask()) * cashAndCarryArb.getQuantity();

	}
	
	public void idGeneration() {
		cashAndCarryCalculated.setId(++CashAndCarryServiceImpl.id);
	}

	
	@Override
	public CashandCarryCalculatedArbitrage checkArbitrage(CashAndCarryArbitrage cashAndCarryArbitrage, String Mapping) {
		
			this.normalCashArbCalc(cashAndCarryArbitrage);
			this.reverseCashArbCalc(cashAndCarryArbitrage);
			if(cashAndCarryArbitrage.isMapping() == true) {
				this.idGeneration();
			}
			cashAndCarryCalculated.setFuture_arb_amount(future_arb_amount);
			cashAndCarryCalculated.setProfit_loss_fwd(profit_loss_fwd);
			cashAndCarryCalculated.setRev_arb_amount(rev_arb_amount);
			cashAndCarryCalculated.setProfit_loss_rev(profit_loss_rev);
			cashAndCarryCalculated.setArbitrage(cashAndCarryArbitrage);
			
			
			if (cashAndCarryCalculated.getProfit_loss_fwd() > 0)
				cashAndCarryCalculated.setFwdArbitrage(true);
			else
				cashAndCarryCalculated.setFwdArbitrage(false);
		
		
			if (cashAndCarryCalculated.getProfit_loss_rev() > 0)
				cashAndCarryCalculated.setRevArbitrage(true);
			else
				cashAndCarryCalculated.setRevArbitrage(false);
		

		
		
			

		return cashAndCarryCalculated;

	}

}
