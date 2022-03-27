package com.skycloud.refactor.interpreter.after;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.skycloud.refactor.interpreter.old.Product;
import com.skycloud.refactor.interpreter.old.ProductRepository;


/**
 * 产品查找类
 * @author QQ445161315
 *
 */
public class ProductFinderAfter {
	
	private ProductRepository repository = new ProductRepository();
	
	private List<Product> selectBy(Spec spec){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfied(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byColor(Color color){
		Spec spec = new ColorSpec(color);
		return selectBy(spec);
	}
	
	public List<Product> byPrice(float priceLimit){
		Spec spec = new PriceSpec(priceLimit);
		return selectBy(spec);
	}
	
	public List<Product> bySize(int size){
		Spec spec = new SizeSpec(size);
		return selectBy(spec);
	}
	
	public List<Product> belowPrice(float price){
		Spec spec = new BelowSpec(price);
		return selectBy(spec);
	}
	
	public List<Product> belowPriceAvoidingColor(float price,Color color){
		Spec left = new BelowSpec(price);
		Spec right = new NotSpec(new ColorSpec(color));
		Spec spec = new AndSpec(left,right);
		return selectBy(spec);
	}
	
	public List<Product> byColorAndBelowPrice(float price,Color color){
		Spec left = new ColorSpec(color);
		Spec right = new BelowSpec(price);
		Spec spec = new AndSpec(left,right);
		return selectBy(spec);
	}
	
	public List<Product> ByColorSizeAndBelowPrice(float price,int size,Color color){
		Spec left = new ColorSpec(color);
		Spec right = new SizeSpec(size);
		Spec left2 = new AndSpec(left,right);
		Spec right2 = new BelowSpec(price);
		Spec spec = new AndSpec(left2,right2);
		return selectBy(spec);
	}

}
