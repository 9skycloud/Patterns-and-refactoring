package com.skycloud.refactor.strategy.latest;

public abstract class AbstractStrategy {

	public abstract double capital(Loan loan);

	public double daration(Loan loan) {
		return loan.yearsTo(loan.getExpiry());
	}

}