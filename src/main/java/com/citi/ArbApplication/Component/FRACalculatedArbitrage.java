package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class FRACalculatedArbitrage {

	private int id;
	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private boolean isFwdArbitrage;
	private boolean isRevArbitrage;
	private String date;
	private FRAArbitrage arbitrage;

	public FRACalculatedArbitrage() {
		
	}

	public FRACalculatedArbitrage(int id, double fwd_arb_amount, double fwd_arb_invest_amount, double profit_loss_fwd,
			double profit_loss_rev, double rev_arb_amount, double rev_arb_invest_amount, boolean isFwdArbitrage,
			boolean isRevArbitrage, String date, FRAArbitrage arbitrage) {
		super();
		this.id = id;
		this.fwd_arb_amount = fwd_arb_amount;
		this.fwd_arb_invest_amount = fwd_arb_invest_amount;
		this.profit_loss_fwd = profit_loss_fwd;
		this.profit_loss_rev = profit_loss_rev;
		this.rev_arb_amount = rev_arb_amount;
		this.rev_arb_invest_amount = rev_arb_invest_amount;
		this.isFwdArbitrage = isFwdArbitrage;
		this.isRevArbitrage = isRevArbitrage;
		this.date = date;
		this.arbitrage = arbitrage;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFwd_arb_amount() {
		return fwd_arb_amount;
	}

	public void setFwd_arb_amount(double fwd_arb_amount) {
		this.fwd_arb_amount = fwd_arb_amount;
	}

	public double getFwd_arb_invest_amount() {
		return fwd_arb_invest_amount;
	}

	public void setFwd_arb_invest_amount(double fwd_arb_invest_amount) {
		this.fwd_arb_invest_amount = fwd_arb_invest_amount;
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

	public double getRev_arb_invest_amount() {
		return rev_arb_invest_amount;
	}

	public void setRev_arb_invest_amount(double rev_arb_invest_amount) {
		this.rev_arb_invest_amount = rev_arb_invest_amount;
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

	public FRAArbitrage getArbitrage() {
		return arbitrage;
	}

	public void setArbitrage(FRAArbitrage arbitrage) {
		this.arbitrage = arbitrage;
	}

	@Override
	public String toString() {
		return "FRACalculatedArbitrage [fwd_arb_amount=" + fwd_arb_amount + ", fwd_arb_invest_amount="
				+ fwd_arb_invest_amount + ", profit_loss_fwd=" + profit_loss_fwd + ", profit_loss_rev="
				+ profit_loss_rev + ", rev_arb_amount=" + rev_arb_amount + ", rev_arb_invest_amount="
				+ rev_arb_invest_amount + ", isFwdArbitrage=" + isFwdArbitrage + ", isRevArbitrage=" + isRevArbitrage
				+ ", arbitrage=" + arbitrage + "]";
	}

}
