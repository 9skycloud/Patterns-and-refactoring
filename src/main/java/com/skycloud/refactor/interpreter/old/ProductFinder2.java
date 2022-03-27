package com.skycloud.refactor.interpreter.old;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 产品查找类
 * @author QQ445161315
 *
 */
public class ProductFinder2 {
	
	private ProductRepository repository = new ProductRepository();
	
	public List<Product> sendBy(Spec spec){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byColor(Color color){
		Spec spec = new ColorSpec(color);
		return sendBy(spec);
	}
	
	public List<Product> byPrice(float priceLimit){
		Spec spec = new PriceSpec(priceLimit);
		return sendBy(spec);
	}
	
	public List<Product> bySize(int size){
		Spec spec = new SizeSpec(size);
		return sendBy(spec);
	}
	
	public List<Product> belowPrice(float price){
		Spec spec = new BelowPriceSpec(price);
		return sendBy(spec);
	}
	
	public List<Product> belowPriceAvoidingColor(float price,Color color){
		//数据库查询产品
		Spec spec = new PriceSpec(price);
		Spec spec1 = new NotColorSpec(new ColorSpec(color));
		Spec spec2 = new AndSpec(spec,spec1);
		return sendBy(spec2);
	}
	
	public List<Product> byColorAndBelowPrice(float price,Color color){
		Spec spec = new BelowPriceSpec(price);
		Spec spec1 = new ColorSpec(color);
		Spec spec2 = new AndSpec(spec,spec1);
		return sendBy(spec2);
	}
	
	public List<Product> ByColorSizeAndBelowPrice(float price,int size,Color color){
		Spec spec = new BelowPriceSpec(price);
		Spec spec1 = new ColorSpec(color);
		Spec spec2 = new SizeSpec(size);
		Spec spec3 = new AndSpec(spec,spec1);
		Spec spec4 = new AndSpec(spec3,spec2);
		return sendBy(spec4);
	}

}
