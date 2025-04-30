package com.anand.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.dao.Product;

@RestController
public class ProductController {

	
	@GetMapping(value = "/product/{pid}"
			,produces = "application/json")
	public ResponseEntity<Product> getProductDetailes
	(@PathVariable ("pid")Integer pid){
	   //create A product Object
		Product p1=new Product();
		p1.setPid(pid);p1.setPname("Anand");p1.setPrice(50);
		return new ResponseEntity<Product>(p1,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/products"
			,produces = "application/json")
	public ResponseEntity<List<Product>> getListOFProduct(){
		Product p1=new Product(2,"Rani",1542);
		Product p2=new Product(3,"Latha",78453);
		Product p3=new Product(4,"headPhone",47826);
	    List<Product> list=	Arrays.asList(p1,p2,p3);
	    return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	//Post Method
	@PostMapping(value = "/product",
			consumes = "application/json"
			,produces = "text/string")
	public ResponseEntity<String> addProducts(@RequestBody Product product){
		System.out.println(product);
		//logic to save product Object
		String msg="Product is saved";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	//put mapping data Update
	@PutMapping(value = "/product",
			consumes = "application/json"
			,produces = "text/string")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		System.out.println(product);
		//logic to update the Product
		String msg="Product is Updated";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	//delete Method Logic 
	
	@DeleteMapping(value = "/product/{pid}"
			,produces = "text/string")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") Integer pid){
		String msg="Deleted the Record ";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
}
