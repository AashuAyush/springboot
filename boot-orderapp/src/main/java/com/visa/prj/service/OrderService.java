package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	@Transactional
	public void placeOrder(Order o) {
		orderDao.save(o);
	}

	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	@Transactional
	public void addProduct(Product p) {
		productDao.save(p); // persist becomes save, traditional -> jsp, html, controllers; in rest services
		// client gets a json and consumes it
	}

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	public List<Product> getProductByCategory(String category) {
		return productDao.findByCategory(category);
	}
}
