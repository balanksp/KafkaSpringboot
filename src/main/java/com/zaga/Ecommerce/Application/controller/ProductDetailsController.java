package com.zaga.Ecommerce.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.Ecommerce.Application.Kafka.Consumer;
import com.zaga.Ecommerce.Application.Kafka.Producer;
import com.zaga.Ecommerce.Application.Model.ProductDetails;
import com.zaga.Ecommerce.Application.Service.DeliveryService;
import com.zaga.Ecommerce.Application.Service.OrderService;
import com.zaga.Ecommerce.Application.Service.ProviderService;

@RestController
@RequestMapping("/products")
public class ProductDetailsController {

	@Autowired
	OrderService service;

	@Autowired
	Producer producer;

	@Autowired
	Consumer consumer;

	@Autowired
	OrderService orderService;

	@Autowired
	ProviderService providerservice;

	@Autowired
	DeliveryService deliveryService;

	@PostMapping("/postProductDetails")
	public ProductDetails createProductDetails(@RequestBody ProductDetails productDetails) {
		ProductDetails productdetail = service.createProductDetails(productDetails);
		producer.orderToProvider(productDetails);
		return productdetail;
	}

}
