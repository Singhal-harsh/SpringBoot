package com.citi.ArbApplication.Service;

import com.citi.ArbApplication.Component.Arbitrage;

public interface RandomArbService {
	public Arbitrage randomGeneration() throws InterruptedException;

}
