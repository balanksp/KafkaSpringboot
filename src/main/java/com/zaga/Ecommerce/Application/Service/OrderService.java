package com.zaga.Ecommerce.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.Ecommerce.Application.Kafka.Producer;
import com.zaga.Ecommerce.Application.Model.ProductDetails;
import com.zaga.Ecommerce.Application.Repository.ProductRepo;

@Service
public class OrderService {

    @Autowired
    ProductRepo repo;

    @Autowired
    Producer producer;

    @Autowired
    ProviderService provider;

    @Autowired
    DeliveryService deliveryService;

    // step-01 :- user order the product
    public ProductDetails createProductDetails(ProductDetails productDetail) {
     ProductDetails details = repo.save(productDetail);
     producer.orderToProvider(productDetail);
      provider.getProductDetails(productDetail);
      provider.readyToDelivery(productDetail);
      deliveryService.recivingMessage(productDetail);
     return details;
    }
}
