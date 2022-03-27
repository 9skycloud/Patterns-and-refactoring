package com.skycloud.refactor.creative.builder;

import com.skycloud.refactor.simplify.composed.old.Order;
import com.skycloud.refactor.simplify.composed.old.OrderList;
import com.skycloud.refactor.simplify.composed.old.Product;
import com.skycloud.refactor.simplify.composed.old.ProductSize;

public class OrdersWriterDomAdapterBuilderRefactor {
	private OrderList orders;

	public OrdersWriterDomAdapterBuilderRefactor(OrderList orders) {
		this.orders = orders;
	}

	public String GetContents() {
		DomAdapterBuilder builder = new DomAdapterBuilder("orders");
		for (int i = 0; i < this.orders.orderCount(); i++) {
			Order order = this.orders.order(i);
			builder.addChild("order");
			builder.addAttribute("id", order.OrderId()+"");
			for (int j = 0; j < order.ProductCount(); j++) {
				Product product = order.Product(j);
				builder.addChild("product");
				builder.addAttribute("id", product.getId()+"");
				builder.addAttribute("color", this.ColorFor(product));
				if (product.getSize() != ProductSize.NotApplicable) {
					builder.addAttribute("size", this.SizeFor(product));
				}
				builder.addValue(product.getName());
				builder.addChild("price");
				builder.addAttribute("currency", this.CurrencyFor(product));
				builder.addValue(product.getPrice());
			}
		}
		return builder.printXml();
	}

	private String CurrencyFor(Product product) {
		return "USD";
	}
	
	private String priceFor(Product product){
		return product.getPrice();
	}

	private String SizeFor(Product product) {
		switch (product.getSize()) {
		case Medium:
			return "medium";
		default:
			return "NOT APPLICABLE";
		}
	}

	private String ColorFor(Product product) {
		return "red";
	}
}
