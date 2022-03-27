package com.skycloud.refactor.simplify.composed.latest;

import com.skycloud.refactor.simplify.composed.old.Order;
import com.skycloud.refactor.simplify.composed.old.OrderList;
import com.skycloud.refactor.simplify.composed.old.Product;
import com.skycloud.refactor.simplify.composed.old.ProductSize;

public class OrdersWriterRefactor {
	private OrderList orders;

	public OrdersWriterRefactor(OrderList orders) {
		this.orders = orders;
	}

	public String GetContents() {
		
		XmlNode ordersTag = new TagNode("orders");
		for (int i = 0; i < this.orders.orderCount(); i++) {
			Order order = this.orders.order(i);
			TagNode orderTag = new TagNode("order");
			orderTag.addAttributes("id", order.OrderId()+"");
			for (int j = 0; j < order.ProductCount(); j++) {
				Product product = order.Product(j);
				TagNode proTag = new TagNode("product");
				proTag.addAttributes("id", product.getId()+"");
				proTag.addAttributes("color", this.ColorFor(product));
				if (product.getSize() != ProductSize.NotApplicable) {
					proTag.addAttributes("size", this.SizeFor(product));
				}
				TagNode priceTag = new TagNode("price");
				priceTag.addAttributes("currency", this.CurrencyFor(product));
				priceTag.addValue(product.getPrice());
				proTag.add(priceTag);
				proTag.addValue(product.getName());
				orderTag.add(proTag);
				ordersTag.add(orderTag);
			}
		}
		return ordersTag.toXml();
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
