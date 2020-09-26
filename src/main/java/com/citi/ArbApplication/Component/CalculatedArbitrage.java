package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class CalculatedArbitrage {

	private double fwd_arb_amount;
	private double fwd_arb_invest_amount;
	private double fwd_arb_invest_amount_Curr1;
	private double profit_loss_fwd;
	private double profit_loss_rev;
	private double rev_arb_amount;
	private double rev_arb_invest_amount;
	private double rev_arb_invest_amount_Curr2;
	private boolean isFwdArbitrage;
	private boolean isRevArbitrage;
	private Arbitrage arbitrage;

	public CalculatedArbitrage() {

	}

	public CalculatedArbitrage(double fwd_arb_amount, double fwd_arb_invest_amount, double fwd_arb_invest_amount_Curr1,
			double profit_loss_fwd, double profit_loss_rev, double rev_arb_amount, double rev_arb_invest_amount,
			double rev_arb_invest_amount_Curr2, boolean isFwdArbitrage, boolean isRevArbitrage, Arbitrage arbitrage) {
		super();
		this.fwd_arb_amount = fwd_arb_amount;
		this.fwd_arb_invest_amount = fwd_arb_invest_amount;
		this.fwd_arb_invest_amount_Curr1 = fwd_arb_invest_amount_Curr1;
		this.profit_loss_fwd = profit_loss_fwd;
		this.profit_loss_rev = profit_loss_rev;
		this.rev_arb_amount = rev_arb_amount;
		this.rev_arb_invest_amount = rev_arb_invest_amount;
		this.rev_arb_invest_amount_Curr2 = rev_arb_invest_amount_Curr2;
		this.isFwdArbitrage = isFwdArbitrage;
		this.isRevArbitrage = isRevArbitrage;
		this.arbitrage = arbitrage;
		
	}

	public Arbitrage getArbitrage() {
		return arbitrage;
	}

	public void setArbitrage(Arbitrage arbitrage) {
		this.arbitrage = arbitrage;
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

	public double getFwd_arb_invest_amount_Curr1() {
		return fwd_arb_invest_amount_Curr1;
	}

	public void setFwd_arb_invest_amount_Curr1(double fwd_arb_invest_amount_Curr1) {
		this.fwd_arb_invest_amount_Curr1 = fwd_arb_invest_amount_Curr1;
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

	public double getRev_arb_invest_amount_Curr2() {
		return rev_arb_invest_amount_Curr2;
	}

	public void setRev_arb_invest_amount_Curr2(double rev_arb_invest_amount_Curr2) {
		this.rev_arb_invest_amount_Curr2 = rev_arb_invest_amount_Curr2;
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

	@Override
	public String toString() {
		return "CalculatedArbitrage [fwd_arb_amount=" + fwd_arb_amount + ", fwd_arb_invest_amount="
				+ fwd_arb_invest_amount + ", fwd_arb_invest_amount_Curr1=" + fwd_arb_invest_amount_Curr1
				+ ", profit_loss_fwd=" + profit_loss_fwd + ", profit_loss_rev=" + profit_loss_rev + ", rev_arb_amount="
				+ rev_arb_amount + ", rev_arb_invest_amount=" + rev_arb_invest_amount + ", rev_arb_invest_amount_Curr2="
				+ rev_arb_invest_amount_Curr2 + "]";
	}

}