package com.mudzingwa.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mudzingwa.sec.Entity.Product;
import com.mudzingwa.sec.Exceptions.ProductNotFoundException;
import com.mudzingwa.sec.service.IproductService;

@RestController
public class ProductController {
	@Autowired
	private IproductService service;

	@PostMapping("/save")
	public ResponseEntity<String>saveProdu(@RequestBody Product p){
		//Product prd = service.create(p);
		Integer id = service.create(p);
		String msg = "Product id "+id+" Saved";
		return new ResponseEntity<String>(msg,HttpStatus.OK);

	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Product>> findAll(){
		List<Product> allpro = service.fetchAll();
		return new ResponseEntity<List<Product>>(allpro,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?>findbyId(@PathVariable Integer id){
		ResponseEntity<?> resp =null;
		try {
		Product pr = service.find(id);
		resp= new ResponseEntity<Product>(pr,HttpStatus.OK);
		}catch(ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return resp;
		
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Product pdr){
		Integer in = service.UpdateProduct(pdr);
		String msgr= "Product with"+in +"successfully updated";
		return new ResponseEntity<String>(msgr,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>DeleteProduct(@PathVariable Integer id){
		 ResponseEntity res = null;
		try {
			service.deleteProduct(id);
			res = new ResponseEntity<String>("Product deleted Successfully",HttpStatus.OK);
			
		}catch(ProductNotFoundException ex) {
			ex.printStackTrace();
			res =new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return res;
	}

   
}
