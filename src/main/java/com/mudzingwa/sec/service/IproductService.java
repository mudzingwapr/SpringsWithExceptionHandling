package com.mudzingwa.sec.service;

import java.util.List;

import com.mudzingwa.sec.Entity.Product;

public interface IproductService {
	public Integer create(Product p);
	public List<Product> fetchAll();
	public Integer UpdateProduct(Product pd);
	public void deleteProduct(Integer id);
	public Product find(Integer id);

}
