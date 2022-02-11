package com.mudzingwa.sec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudzingwa.sec.Entity.Product;
import com.mudzingwa.sec.Exceptions.ProductNotFoundException;
import com.mudzingwa.sec.Repository.ProductRepository;
@Service
public class ProductSrviceimpl implements IproductService {
	@Autowired
	private ProductRepository repos;

	@Override
	public Integer create(Product p) {
		Product pr = repos.save(p);
		return pr.getPid();
	}

	@Override
	public List<Product> fetchAll() {
		List<Product> prod = repos.findAll();
		return prod;
	}

	@Override
	public Integer UpdateProduct(Product pd) {
		Product prd = repos.saveAndFlush(pd);
		return prd.getPid();
	}

	

	@Override
	public Product find(Integer id) {
//		Optional<Product> pd = repos.findById(id);
		/*
		if(pd.isPresent()) 
			return pd.get();
				else 
			 throw new ProductNotFoundException("Product with"+pd.get()+ "not found");
			*/ 
		return repos.findById(id).orElseThrow(()->new ProductNotFoundException("Product with"+id+ "not found"));
		
	}
	public void deleteProduct(Integer id) {
		repos.delete(find(id));
		
	}
}
