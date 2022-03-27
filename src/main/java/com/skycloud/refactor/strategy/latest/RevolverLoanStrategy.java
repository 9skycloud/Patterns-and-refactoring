package com.skycloud.refactor.strategy.latest;

public class RevolverLoanStrategy extends AbstractStrategy {

	
	@Override
	public double capital(Loan loan){
	        return (
	        		loan.getCommitment() *
	        		loan.getUnusedPercentage() *
	        		loan.duration() *
	        		loan.riskFactor()
	        );
	}
}
