package com.skycloud.refactor.strategy.latest;

public class AdviceLineLoanStrategy extends AbstractStrategy{
	
	
	public double capital(Loan loan){
//  	  建议信用额度贷款
      return (
    		  loan.outstandingRiskAmount() * loan.duration() * loan.riskFactor() +
        loan.unusedRiskAmount() * loan.duration() * loan.unusedRiskFactor()
      );
	}

}
