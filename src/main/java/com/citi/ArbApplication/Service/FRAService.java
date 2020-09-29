package com.citi.ArbApplication.Service;

import com.citi.ArbApplication.Component.FRAArbitrage;
import com.citi.ArbApplication.Component.FRACalculatedArbitrage;

public interface FRAService {
		
	public void normalFRAArbCalc(FRAArbitrage fraArbitrage);
	public void reverseFRAArbCalc(FRAArbitrage fraArbitrage);
	public FRACalculatedArbitrage checkArbitrage(FRAArbitrage fraArbitrage);

}
