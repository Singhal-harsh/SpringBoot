package com.citi.ArbApplication.Service;

import com.citi.ArbApplication.Component.FXArbitrage;
import com.citi.ArbApplication.Component.FXCalculatedArbitrage;

public interface ArbService {
	
	//public CalculatedArbitrage sixMonthAmountFwd(Arbitrage arb);
	//public void investAmountFwd(Arbitrage arb);
	
	public void normalArbitrageCalc(FXArbitrage arb);
	public void reverseArbitrageCalc(FXArbitrage arb);
	public FXCalculatedArbitrage checkArbitrage(FXArbitrage arb);

}
