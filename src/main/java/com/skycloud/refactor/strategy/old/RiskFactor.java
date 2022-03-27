package com.skycloud.refactor.strategy.old;

public class RiskFactor {
	public static RiskFactor getFactors() {
		return new RiskFactor();
	}

	public int forRating(Object obj) {
		return 1;
	}
}
