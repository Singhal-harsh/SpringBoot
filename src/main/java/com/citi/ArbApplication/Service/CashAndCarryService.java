package com.citi.ArbApplication.Service;

import com.citi.ArbApplication.Component.CashAndCarryArbitrage;
import com.citi.ArbApplication.Component.CashandCarryCalculatedArbitrage;

public interface CashAndCarryService {
	
	public void normalCashArbCalc(CashAndCarryArbitrage cashAndCarryArb);
	public void reverseCashArbCalc(CashAndCarryArbitrage cashAndCarryArbitrage);
	public CashandCarryCalculatedArbitrage checkArbitrage(CashAndCarryArbitrage cashAndCarryArbitrage);

}
