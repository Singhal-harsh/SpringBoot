package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class CashandCarryCalculatedArbitrage {

	private double fwd_arb_amount;
	private double future_bid;
	private double spot_bid;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private boolean isFwdArbitrage;
	private boolean isRevArbitrage;
	private CashAndCarryArbitrage arbitrage;

	public CashandCarryCalculatedArbitrage() {

	}

	public CashandCarryCalculatedArbitrage(double fwd_arb_amount, double future_bid, double spot_bid,
			double profit_loss_fwd, double profit_loss_rev, double rev_arb_amount, boolean isFwdArbitrage,
			boolean isRevArbitrage, CashAndCarryArbitrage arbitrage) {
		super();
		this.fwd_arb_amount = fwd_arb_amount;
		this.future_bid = future_bid;
		this.spot_bid = spot_bid;
		this.profit_loss_fwd = profit_loss_fwd;
		this.profit_loss_rev = profit_loss_rev;
		this.rev_arb_amount = rev_arb_amount;
		this.isFwdArbitrage = isFwdArbitrage;
		this.isRevArbitrage = isRevArbitrage;
		this.arbitrage = arbitrage;
	}

	public double getFwd_arb_amount() {
		return fwd_arb_amount;
	}

	public void setFwd_arb_amount(double fwd_arb_amount) {
		this.fwd_arb_amount = fwd_arb_amount;
	}

	public double getFuture_bid() {
		return future_bid;
	}

	public void setFuture_bid(double future_bid) {
		this.future_bid = future_bid;
	}

	public double getSpot_bid() {
		return spot_bid;
	}

	public void setSpot_bid(double spot_bid) {
		this.spot_bid = spot_bid;
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
		return "CashandCarryCalculatedArbitrage [fwd_arb_amount=" + fwd_arb_amount + ", future_bid=" + future_bid
				+ ", spot_bid=" + spot_bid + ", profit_loss_fwd=" + profit_loss_fwd + ", profit_loss_rev="
				+ profit_loss_rev + ", rev_arb_amount=" + rev_arb_amount + ", isFwdArbitrage=" + isFwdArbitrage
				+ ", isRevArbitrage=" + isRevArbitrage + ", arbitrage=" + arbitrage + "]";
	}

}
