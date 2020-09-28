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
	private static int id;
	private double future_arb_amount;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;

	@Override
	public void normalCashArbCalc(CashAndCarryArbitrage cashAndCarryArb) {
		future_arb_amount = cashAndCarryArb.getSpot_ask()
				+ (cashAndCarryArb.getSpot_ask() * cashAndCarryArb.getInterest_rate_ask()
						* (cashAndCarryArb.getTime_months() / 12) * 0.01)
				+ (cashAndCarryArb.getSpot_ask() * cashAndCarryArb.getTransaction_cost() * 0.01);

		profit_loss_fwd = (cashAndCarryArb.getFuture_bid() - future_arb_amount) * cashAndCarryArb.getQuantity();

	}

	@Override
	public void reverseCashArbCalc(CashAndCarryArbitrage cashAndCarryArbitrage) {
		rev_arb_amount = cashAndCarryArbitrage.getFuture_ask()
				+ (cashAndCarryArbitrage.getFuture_ask() * cashAndCarryArbitrage.getInterest_rate_ask()
						* (cashAndCarryArbitrage.getTime_months() / 12) * 0.01)
				+ (cashAndCarryArbitrage.getFuture_ask() * cashAndCarryArbitrage.getTransaction_cost() * 0.01);

		profit_loss_rev = (cashAndCarryArbitrage.getSpot_bid() - rev_arb_amount) * cashAndCarryArbitrage.getQuantity();

	}

	
	@Override
	public CashandCarryCalculatedArbitrage checkArbitrage(CashAndCarryArbitrage cashAndCarryArbitrage) {
		if (cashAndCarryArbitrage.getSpot_ask() < cashAndCarryArbitrage.getFuture_bid()) {
			this.normalCashArbCalc(cashAndCarryArbitrage);
			cashAndCarryCalculated.setId(CashAndCarryServiceImpl.id++);
			cashAndCarryCalculated.setFuture_arb_amount(future_arb_amount);
			cashAndCarryCalculated.setProfit_loss_fwd(profit_loss_fwd);
			cashAndCarryCalculated.setRev_arb_amount(0.00);
			cashAndCarryCalculated.setProfit_loss_rev(0.00);
			cashAndCarryCalculated.setArbitrage(cashAndCarryArbitrage);
			cashAndCarryCalculated.setRevArbitrage(false);
			
			if (cashAndCarryCalculated.getProfit_loss_fwd() > 0)
				cashAndCarryCalculated.setFwdArbitrage(true);
			else
				cashAndCarryCalculated.setFwdArbitrage(false);
		}
		else if (cashAndCarryArbitrage.getFuture_ask() < cashAndCarryArbitrage.getSpot_bid()) {
			this.reverseCashArbCalc(cashAndCarryArbitrage);
			cashAndCarryCalculated.setId(CashAndCarryServiceImpl.id++);
			cashAndCarryCalculated.setFuture_arb_amount(0.00);
			cashAndCarryCalculated.setProfit_loss_fwd(0.00);
			cashAndCarryCalculated.setRev_arb_amount(rev_arb_amount);
			cashAndCarryCalculated.setProfit_loss_rev(profit_loss_rev);
			cashAndCarryCalculated.setArbitrage(cashAndCarryArbitrage);
			cashAndCarryCalculated.setFwdArbitrage(false);
			if (cashAndCarryCalculated.getProfit_loss_rev() > 0)
				cashAndCarryCalculated.setRevArbitrage(true);
			else
				cashAndCarryCalculated.setRevArbitrage(false);
		}

		
			
			

		return cashAndCarryCalculated;

	}

}
