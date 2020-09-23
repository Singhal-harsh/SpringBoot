package com.citiarb.springboot.Service;

import com.citiarb.springboot.entity.Arbitrage;

public interface ArbService {
	
	public double sixMonthAmountFwd(Arbitrage arb);
	public double investAmountFwd(Arbitrage arb);
	

}
