package com.skycloud.refactor.compsite;

import org.junit.Assert;
import org.junit.Test;

import com.skycloud.refactor.simplify.composed.latest.OrdersWriterRefactor;
import com.skycloud.refactor.simplify.composed.latest.TagNode;
import com.skycloud.refactor.simplify.composed.latest.XmlNode;
import com.skycloud.refactor.simplify.composed.old.Order;
import com.skycloud.refactor.simplify.composed.old.OrderList;
import com.skycloud.refactor.simplify.composed.old.OrdersWriter;
import com.skycloud.refactor.simplify.composed.old.Product;
import com.skycloud.refactor.simplify.composed.old.ProductSize;

public class XmlCreateTest {
	
	@Test
	public void testOneNodeXml(){
		XmlNode node = new TagNode("price");
		node.addValue("SAMPLE_PRICE");
		node.addAttributes("currency", "USD");
		
		System.out.println(node.toXml());
		
		String expected = "<price currency='USD'>SAMPLE_PRICE</price>";
		Assert.assertEquals(expected, node.toXml());
	}
	
	@Test
	public void testChildrenXml(){
		XmlNode product = new TagNode("product");
		TagNode price = new TagNode("price");
		product.add(price);
		System.out.println(product.toXml());
		String expected = "<product><price></price></product>";
		Assert.assertEquals(expected, product.toXml());
	}
	
	@Test
	public void testChildAndChildXml(){
		XmlNode orders = new TagNode("orders");
		TagNode order = new TagNode("order");
		TagNode product = new TagNode("product");
		order.add(product);
		orders.add(order);
		System.out.println(orders.toXml());
		
		String expected = "<orders><order><product></product></order></orders>";
		Assert.assertEquals(expected, orders.toXml());
	}
	
	@Test
	public void testOrderWriter(){
		OrderList list = new OrderList();
		Order order = new Order(1);
		Product p = new Product(11, "订单1", ProductSize.Small, "8.95");
		order.Add(p);
		list.add(order);
		OrdersWriterRefactor refactor = new OrdersWriterRefactor(list);
		System.out.println("重构："+refactor.GetContents());
		OrdersWriter writer = new OrdersWriter(list);
		System.out.println("XML拼装："+writer.GetContents());
		Assert.assertEquals(writer.GetContents(), refactor.GetContents());
	}

}
