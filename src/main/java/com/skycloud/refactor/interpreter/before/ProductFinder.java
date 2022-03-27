package com.skycloud.refactor.interpreter.before;

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
public class ProductFinder {
	
	private ProductRepository repository = new ProductRepository();
	
	public List<Product> byColor(Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getColor() == color){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byPrice(float priceLimit){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getPrice() == priceLimit){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> bySize(int size){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getSize() == size){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> belowPrice(float price){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getPrice() < price){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> belowPriceAvoidingColor(float price,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getPrice() < price && product.getColor() != color){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> byColorAndBelowPrice(float price,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getColor() == color && product.getPrice() < price){
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> ByColorSizeAndBelowPrice(float price,int size,Color color){
		List<Product> list = new ArrayList<>();
		//数据库查询产品
		Iterator<Product> iterator = repository.iterator();
		while(iterator.hasNext()){
			Product product = iterator.next();
			if(product.getColor() == color && product.getSize() == size && product.getPrice() < price){
				list.add(product);
			}
		}
		return list;
	}

}
