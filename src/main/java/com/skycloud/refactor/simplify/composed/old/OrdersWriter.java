package com.skycloud.refactor.simplify.composed.old;

public class OrdersWriter {
	private OrderList orders;

	public OrdersWriter(OrderList orders) {
		this.orders = orders;
	}

	public String GetContents() {
		StringBuilder xml = new StringBuilder();
		xml.append("<orders>");
		for (int i = 0; i < this.orders.orderCount(); i++) {
			Order order = this.orders.order(i);
			xml.append("<order");
			xml.append(" id=\"");
			xml.append(order.OrderId());
			xml.append("\">");
			for (int j = 0; j < order.ProductCount(); j++) {
				Product product = order.Product(j);
				xml.append("<product");
				xml.append(" id=\"");
				xml.append(product.getId());
				xml.append("\"");
				xml.append(" color=\"");
				xml.append(this.ColorFor(product));
				xml.append("\"");
				if (product.getSize() != ProductSize.NotApplicable) {
					xml.append(" size=\"");
					xml.append(this.SizeFor(product));
					xml.append("\"");
				}

				xml.append(">");
				xml.append(product.getName());
				xml.append("<price");
				xml.append(" currency=\"");
				xml.append(this.CurrencyFor(product));
				xml.append("\">");
				xml.append(product.getPrice());
				xml.append("</price>");
				xml.append("</product>");
			}

			xml.append("</order>");
		}

		xml.append("</orders>");
		return xml.toString();
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
