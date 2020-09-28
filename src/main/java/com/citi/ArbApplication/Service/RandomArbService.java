package com.citi.ArbApplication.Service;

import com.citi.ArbApplication.Component.CashAndCarryArbitrage;
import com.citi.ArbApplication.Component.FXArbitrage;

public interface RandomArbService {
	public FXArbitrage randomGeneration() throws InterruptedException;
	public CashAndCarryArbitrage randomCashGeneration() throws InterruptedException;

}
