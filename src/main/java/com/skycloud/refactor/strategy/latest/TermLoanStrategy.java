package com.skycloud.refactor.strategy.latest;

public class TermLoanStrategy extends AbstractStrategy{

	public double capital(Loan loan){
       return loan.getCommitment() * duration(loan) * loan.riskFactor();
	}
	
	public double duration(Loan loan){
	   return loan.weightedAverageDuration();
	}
	
}
