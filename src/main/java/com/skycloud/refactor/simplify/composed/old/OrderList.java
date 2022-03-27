package com.skycloud.refactor.simplify.composed.old;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
	private List<Order> orders;

	public OrderList() {
		this.orders = new ArrayList<Order>();
	}

	public void add(Order order) {
		this.orders.add(order);
	}

	public int orderCount() {
		return this.orders.size();
	}

	public Order order(int insertionIndex) {
		return this.orders.get(insertionIndex);
	}
}
