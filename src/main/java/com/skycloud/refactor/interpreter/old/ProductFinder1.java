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
public class ProductFinder1 {
	
	private ProductRepository repository;
	
	public List<Product> byColor(Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new ColorSpec(color);
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byPrice(float priceLimit){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new PriceSpec(priceLimit);
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> bySize(int size){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new SizeSpec(size);
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> belowPrice(float price){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new BelowPriceSpec(price);
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> belowPriceAvoidingColor(float price,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new PriceSpec(price);
		Spec spec1 = new NotColorSpec(new ColorSpec(color));
		
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(new AndSpec(spec,spec1).isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byColorAndBelowPrice(float price,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new BelowPriceSpec(price);
		Spec spec1 = new ColorSpec(color);
		
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(new AndSpec(spec,spec1).isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> ByColorSizeAndBelowPrice(float price,int size,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		Spec spec = new BelowPriceSpec(price);
		Spec spec1 = new ColorSpec(color);
		Spec spec2 = new SizeSpec(size);
		
		Spec spec3 = new AndSpec(spec,spec1);
		Spec spec4 = new AndSpec(spec3,spec2);
		
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(spec4.isSatisfiedBy(product)){
				list.add(product);
			}
		}
		return list;
	}

}
