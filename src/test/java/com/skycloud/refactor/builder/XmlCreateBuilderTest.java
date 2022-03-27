package com.skycloud.refactor.builder;

import org.junit.Assert;
import org.junit.Test;

import com.skycloud.refactor.creative.builder.OrdersWriterBuilderRefactor;
import com.skycloud.refactor.creative.builder.TagNodeBuilder;
import com.skycloud.refactor.simplify.composed.old.Order;
import com.skycloud.refactor.simplify.composed.old.OrderList;
import com.skycloud.refactor.simplify.composed.old.OrdersWriter;
import com.skycloud.refactor.simplify.composed.old.Product;
import com.skycloud.refactor.simplify.composed.old.ProductSize;

public class XmlCreateBuilderTest {
	
	@Test
	public void testOneNodeXml(){
		
		TagNodeBuilder builder =new TagNodeBuilder("price");
		builder.addAttribute("currency", "USD");
		builder.addValue("SAMPLE_PRICE");
		
//		TagNode node = new TagNode("price");
//		node.addValue("SAMPLE_PRICE");
//		node.addAttributes("currency", "USD");
		
		System.out.println(builder.printXml());
		
		String expected = "<price currency='USD'>SAMPLE_PRICE</price>";
		Assert.assertEquals(expected, builder.printXml());
	}
	
	@Test
	public void testChildrenXml(){
		TagNodeBuilder builder =new TagNodeBuilder("product");
		builder.addChild("price");
		
		
//		TagNode product = new TagNode("product");
//		TagNode price = new TagNode("price");
//		product.add(price);
		System.out.println(builder.printXml());
		String expected = "<product><price/></product>";
		Assert.assertEquals(expected, builder.printXml());
	}
	
	@Test
	public void testChildAndChildXml(){
		TagNodeBuilder builder =new TagNodeBuilder("orders");
		builder.addChild("order");
		builder.addChild("product");
		
		
//		TagNode orders = new TagNode("orders");
//		TagNode order = new TagNode("order");
//		TagNode product = new TagNode("product");
//		order.add(product);
//		orders.add(order);
		System.out.println(builder.printXml());
		
		String expected = "<orders><order><product/></order></orders>";
		Assert.assertEquals(expected, builder.printXml());
	}
	
	@Test
	public void testOtherChild(){
		TagNodeBuilder builder =new TagNodeBuilder("orders");
		builder.addChild("order");
		builder.addAttribute("id", "1");
		builder.addChild("product");
		builder.addAttribute("name", "产品A");
		
		builder.addToTarget("orders","order");
		builder.addAttribute("id", "2");
		builder.addChild("product");
		builder.addAttribute("name", "产品B");
		
		System.out.println(builder.printXml());
		
		String expected = "<orders><order id='1'><product name='产品A'/></order><order id='2'><product name='产品B'/></order></orders>";
		Assert.assertEquals(expected, builder.printXml());
	}
	
	@Test
	public void testOrderWriter(){
		OrderList list = new OrderList();
		Order order = new Order(1);
		Product p = new Product(11, "订单1", ProductSize.Small, "8.95");
		order.Add(p);
		list.add(order);
		OrdersWriterBuilderRefactor refactor = new OrdersWriterBuilderRefactor(list);
		System.out.println("重构："+refactor.GetContents());
		OrdersWriter writer = new OrdersWriter(list);
		System.out.println("XML拼装："+writer.GetContents());
		Assert.assertEquals(writer.GetContents(), refactor.GetContents());
	}

}
