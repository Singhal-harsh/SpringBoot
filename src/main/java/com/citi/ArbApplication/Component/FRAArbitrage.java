package com.citi.ArbApplication.Component;

import org.springframework.stereotype.Component;

@Component
public class FRAArbitrage {
	
	private boolean mapping;
	private double interest_rate1_bid; //6 months
	private double interest_rate1_ask; //6 months
	private double interest_rate2_bid; //12 months
	private double interest_rate2_ask; //12 months
	
	private double fra_rate_bid; /* 6/12 fra */
	private double fra_rate_ask; /* 6/12 fra */
	
	private double transaction_cost;
	private double notional_amount;
	
	public FRAArbitrage() {
	};
	
	public FRAArbitrage(boolean mapping, double interest_rate1_bid, double interest_rate1_ask, double interest_rate2_bid,
			double interest_rate2_ask, double fra_rate_bid, double fra_rate_ask, double transaction_cost,
			double notional_amount) {
		super();
		this.mapping = mapping;
		this.interest_rate1_bid = interest_rate1_bid;
		this.interest_rate1_ask = interest_rate1_ask;
		this.interest_rate2_bid = interest_rate2_bid;
		this.interest_rate2_ask = interest_rate2_ask;
		this.fra_rate_bid = fra_rate_bid;
		this.fra_rate_ask = fra_rate_ask;
		this.transaction_cost = transaction_cost;
		this.notional_amount = notional_amount;
	}
	
	public boolean isMapping() {
		return mapping;
	}

	public void setMapping(boolean mapping) {
		this.mapping = mapping;
	}

	public double getInterest_rate1_bid() {
		return interest_rate1_bid;
	}
	public void setInterest_rate1_bid(double interest_rate1_bid) {
		this.interest_rate1_bid = interest_rate1_bid;
	}
	public double getInterest_rate1_ask() {
		return interest_rate1_ask;
	}
	public void setInterest_rate1_ask(double interest_rate1_ask) {
		this.interest_rate1_ask = interest_rate1_ask;
	}
	public double getInterest_rate2_bid() {
		return interest_rate2_bid;
	}
	public void setInterest_rate2_bid(double interest_rate2_bid) {
		this.interest_rate2_bid = interest_rate2_bid;
	}
	public double getInterest_rate2_ask() {
		return interest_rate2_ask;
	}
	public void setInterest_rate2_ask(double interest_rate2_ask) {
		this.interest_rate2_ask = interest_rate2_ask;
	}
	public double getFra_rate_bid() {
		return fra_rate_bid;
	}
	public void setFra_rate_bid(double fra_rate_bid) {
		this.fra_rate_bid = fra_rate_bid;
	}
	public double getFra_rate_ask() {
		return fra_rate_ask;
	}
	public void setFra_rate_ask(double fra_rate_ask) {
		this.fra_rate_ask = fra_rate_ask;
	}
	public double getTransaction_cost() {
		return transaction_cost;
	}
	public void setTransaction_cost(double transaction_cost) {
		this.transaction_cost = transaction_cost;
	}
	public double getNotional_amount() {
		return notional_amount;
	}
	public void setNotional_amount(double notional_amount) {
		this.notional_amount = notional_amount;
	}

	@Override
	public String toString() {
		return "FRAArbitrage [interest_rate1_bid=" + interest_rate1_bid + ", interest_rate1_ask=" + interest_rate1_ask
				+ ", interest_rate2_bid=" + interest_rate2_bid + ", interest_rate2_ask=" + interest_rate2_ask
				+ ", fra_rate_bid=" + fra_rate_bid + ", fra_rate_ask=" + fra_rate_ask + ", transaction_cost="
				+ transaction_cost + ", notional_amount=" + notional_amount + "]";
	}
}
