package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Order;
import com.visa.prj.service.OrderService;

@RestController
@RequestMapping ("orders") //controller is handling all the uris, possible to push at the top
// many to one is default eager fetch
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping 
	public List<Order> getOrders(){
		return service.getOrders();
	}
	
	@PostMapping
	public ResponseEntity< Order> addOrder (@RequestBody Order o	){
		service.placeOrder(o);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}
}
