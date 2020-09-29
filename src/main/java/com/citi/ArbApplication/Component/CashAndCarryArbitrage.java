package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class CashAndCarryArbitrage {
	private boolean mapping;
	private double spot_bid;
	private double spot_ask;
	private double future_bid;
	private double future_ask;
	private double interest_rate_bid;
	private double interest_rate_ask;
	private double time_months;
	private double transaction_cost;
	private double quantity;

	public CashAndCarryArbitrage() {

	}

	public CashAndCarryArbitrage(boolean mapping, double spot_bid, double spot_ask, double future_bid,
			double future_ask, double interest_rate_bid, double interest_rate_ask, double time_months,
			double transaction_cost, double quantity) {
		super();
		this.mapping = mapping;
		this.spot_bid = spot_bid;
		this.spot_ask = spot_ask;
		this.future_bid = future_bid;
		this.future_ask = future_ask;
		this.interest_rate_bid = interest_rate_bid;
		this.interest_rate_ask = interest_rate_ask;
		this.time_months = time_months;
		this.transaction_cost = transaction_cost;
		this.quantity = quantity;
	}

	public boolean isMapping() {
		return mapping;
	}

	public void setMapping(boolean mapping) {
		this.mapping = mapping;
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

	public double getFuture_bid() {
		return future_bid;
	}

	public void setFuture_bid(double future_bid) {
		this.future_bid = future_bid;
	}

	public double getFuture_ask() {
		return future_ask;
	}

	public void setFuture_ask(double future_ask) {
		this.future_ask = future_ask;
	}

	public double getInterest_rate_bid() {
		return interest_rate_bid;
	}

	public void setInterest_rate_bid(double interest_rate_bid) {
		this.interest_rate_bid = interest_rate_bid;
	}

	public double getInterest_rate_ask() {
		return interest_rate_ask;
	}

	public void setInterest_rate_ask(double interest_rate_ask) {
		this.interest_rate_ask = interest_rate_ask;
	}

	public double getTime_months() {
		return time_months;
	}

	public void setTime_months(double time_months) {
		this.time_months = time_months;
	}

	public double getTransaction_cost() {
		return transaction_cost;
	}

	public void setTransaction_cost(double transaction_cost) {
		this.transaction_cost = transaction_cost;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CashAndCarryArbitrage [spot_bid=" + spot_bid + ", spot_ask=" + spot_ask + ", future_bid=" + future_bid
				+ ", future_ask=" + future_ask + ", interest_rate_bid=" + interest_rate_bid + ", interst_rate_ask="
				+ interest_rate_ask + ", time_months=" + time_months + ", transaction_cost=" + transaction_cost
				+ ", quantity=" + quantity + "]";
	}

}
