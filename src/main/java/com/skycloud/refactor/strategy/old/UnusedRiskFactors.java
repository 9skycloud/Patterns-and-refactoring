package com.skycloud.refactor.strategy.old;

public class UnusedRiskFactors {
	public static UnusedRiskFactors getFactors() {
		return new UnusedRiskFactors();
	}

	public int forRating(Object obj) {
		return 1;
	}
}
