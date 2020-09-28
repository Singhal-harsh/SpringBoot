package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class CashandCarryCalculatedArbitrage {
	
	private int id;
	private double future_arb_amount;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private boolean isFwdArbitrage;
	private boolean isRevArbitrage;
	private CashAndCarryArbitrage arbitrage;

	public CashandCarryCalculatedArbitrage() {

	}

	public CashandCarryCalculatedArbitrage(int id, double future_arb_amount, double profit_loss_fwd, double profit_loss_rev,
			double rev_arb_amount, boolean isFwdArbitrage, boolean isRevArbitrage, CashAndCarryArbitrage arbitrage) {
		this.id = id;
		this.future_arb_amount = future_arb_amount;
		this.profit_loss_fwd = profit_loss_fwd;
		this.profit_loss_rev = profit_loss_rev;
		this.rev_arb_amount = rev_arb_amount;
		this.isFwdArbitrage = isFwdArbitrage;
		this.isRevArbitrage = isRevArbitrage;
		this.arbitrage = arbitrage;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getFuture_arb_amount() {
		return future_arb_amount;
	}

	public void setFuture_arb_amount(double fwd_arb_amount) {
		this.future_arb_amount = fwd_arb_amount;
	}

	public double getProfit_loss_fwd() {
		return profit_loss_fwd;
	}

	public void setProfit_loss_fwd(double profit_loss_fwd) {
		this.profit_loss_fwd = profit_loss_fwd;
	}

	public double getProfit_loss_rev() {
		return profit_loss_rev;
	}

	public void setProfit_loss_rev(double profit_loss_rev) {
		this.profit_loss_rev = profit_loss_rev;
	}

	public double getRev_arb_amount() {
		return rev_arb_amount;
	}

	public void setRev_arb_amount(double rev_arb_amount) {
		this.rev_arb_amount = rev_arb_amount;
	}

	public boolean isFwdArbitrage() {
		return isFwdArbitrage;
	}

	public void setFwdArbitrage(boolean isFwdArbitrage) {
		this.isFwdArbitrage = isFwdArbitrage;
	}

	public boolean isRevArbitrage() {
		return isRevArbitrage;
	}

	public void setRevArbitrage(boolean isRevArbitrage) {
		this.isRevArbitrage = isRevArbitrage;
	}

	public CashAndCarryArbitrage getArbitrage() {
		return arbitrage;
	}

	public void setArbitrage(CashAndCarryArbitrage arbitrage) {
		this.arbitrage = arbitrage;
	}

	@Override
	public String toString() {
		return "CashandCarryCalculatedArbitrage [future_arb_amount=" + future_arb_amount + ", profit_loss_fwd="
				+ profit_loss_fwd + ", profit_loss_rev=" + profit_loss_rev + ", rev_arb_amount=" + rev_arb_amount
				+ ", isFwdArbitrage=" + isFwdArbitrage + ", isRevArbitrage=" + isRevArbitrage + ", arbitrage="
				+ arbitrage + "]";
	}

}
