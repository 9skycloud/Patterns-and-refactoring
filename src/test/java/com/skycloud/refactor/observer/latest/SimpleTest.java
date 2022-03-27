package com.skycloud.refactor.observer.latest;

import junit.framework.Assert;

public class SimpleTest{
	protected int fValue1;

	protected int fValue2;

	public void setUp() {
		fValue1 = 2;
		fValue2 = 3;
	}

	public void testAdd() {
		double result = fValue1 + fValue2;
		assert (result == 5);
	}

	public void testEquals() {
		Assert.assertEquals(12, 1);
		Assert.assertEquals(12L, 12L);
		Assert.assertEquals(new Long(12), new Long(12));

		Assert.assertEquals(" Size ", 12, 12);
		Assert.assertEquals(" Capacity ", 12.0, 11.99, 0.01);
	}
}
