package com.skycloud.refactor.strategy.old;

import java.util.Date;

public class Payment {
	
	private double money;
	
	private Date date;
	
	public Payment(double money, Date date) {
		this.money = money;
		this.date = date;
	}

	public double amount() {
		return money;
	}

	public Date date() {
		return date;
	}

}
