package com.citiarb.springboot.entity;

public class Arbitrage {

	private double spot_bid;
	private double spot_ask;
	private double forward_bid;
	private double forward_ask;
	private double interest_rate_curr1_bid;
	private double interest_rate_curr1_ask;
	private double interest_rate_curr2_bid;
	private double interest_rate_curr2_ask;
	private double transaction_cost;
	private double fwd_arb_quantity;
	private double rev_arb_quantity;
	private double time_months;

	public Arbitrage() {
	};

	public Arbitrage(double spot_bid, double spot_ask, double forward_bid, double forward_ask,
			double interest_rate_curr1_bid, double interest_rate_curr1_ask, double interest_rate_curr2_bid,
			double interest_rate_curr2_ask, double transaction_cost, double fwd_arb_quantity, double rev_arb_quantity,
			double time_months) {
		this.spot_bid = spot_bid;
		this.spot_ask = spot_ask;
		this.forward_bid = forward_bid;
		this.forward_ask = forward_ask;
		this.interest_rate_curr1_bid = interest_rate_curr1_bid;
		this.interest_rate_curr1_ask = interest_rate_curr1_ask;
		this.interest_rate_curr2_bid = interest_rate_curr2_bid;
		this.interest_rate_curr2_ask = interest_rate_curr2_ask;
		this.transaction_cost = transaction_cost;
		this.fwd_arb_quantity = fwd_arb_quantity;
		this.rev_arb_quantity = rev_arb_quantity;
		this.time_months = time_months;
	}

	public double getSpot_bid() {
		return spot_bid;
	}

	public void setSpot_bid(double spot_bid) {
		this.spot_bid = spot_bid;
	}

	public double getSpot_ask() {
		return spot_ask;
	}

	public void setSpot_ask(double spot_ask) {
		this.spot_ask = spot_ask;
	}

	public double getForward_bid() {
		return forward_bid;
	}

	public void setForward_bid(double forward_bid) {
		this.forward_bid = forward_bid;
	}

	public double getForward_ask() {
		return forward_ask;
	}

	public void setForward_ask(double forward_ask) {
		this.forward_ask = forward_ask;
	}

	public double getInterest_rate_curr1_bid() {
		return interest_rate_curr1_bid;
	}

	public void setInterest_rate_curr1_bid(double interest_rate_curr1_bid) {
		this.interest_rate_curr1_bid = interest_rate_curr1_bid;
	}

	public double getInterest_rate_curr1_ask() {
		return interest_rate_curr1_ask;
	}

	public void setInterest_rate_curr1_ask(double interest_rate_curr1_ask) {
		this.interest_rate_curr1_ask = interest_rate_curr1_ask;
	}

	public double getInterest_rate_curr2_bid() {
		return interest_rate_curr2_bid;
	}

	public void setInterest_rate_curr2_bid(double interest_rate_curr2_bid) {
		this.interest_rate_curr2_bid = interest_rate_curr2_bid;
	}

	public double getInterest_rate_curr2_ask() {
		return interest_rate_curr2_ask;
	}

	public void setInterest_rate_curr2_ask(double interest_rate_curr2_ask) {
		this.interest_rate_curr2_ask = interest_rate_curr2_ask;
	}

	public double getTransaction_cost() {
		return transaction_cost;
	}

	public void setTransaction_cost(double transaction_cost) {
		this.transaction_cost = transaction_cost;
	}

	public double getFwd_arb_quantity() {
		return fwd_arb_quantity;
	}

	public void setFwd_arb_quantity(double fwd_arb_quantity) {
		this.fwd_arb_quantity = fwd_arb_quantity;
	}

	public double getRev_arb_quantity() {
		return rev_arb_quantity;
	}

	public void setRev_arb_quantity(double rev_arb_quantity) {
		this.rev_arb_quantity = rev_arb_quantity;
	}

	public double getTime_months() {
		return time_months;
	}

	public void setTime_months(double time_months) {
		this.time_months = time_months;
	}
	
	@Override
	public String toString() {
		return "Arbitrage [spot_bid=" + spot_bid + ", spot_ask=" + spot_ask + ", forward_bid=" + forward_bid
				+ ", forward_ask=" + forward_ask + ", interest_rate_curr1_bid=" + interest_rate_curr1_bid
				+ ", interest_rate_curr1_ask=" + interest_rate_curr1_ask + ", interest_rate_curr2_bid="
				+ interest_rate_curr2_bid + ", interest_rate_curr2_ask=" + interest_rate_curr2_ask
				+ ", transaction_cost=" + transaction_cost + ", fwd_arb_quantity=" + fwd_arb_quantity
				+ ", rev_arb_quantity=" + rev_arb_quantity + ", time_months=" + time_months + "]";
	}

}
