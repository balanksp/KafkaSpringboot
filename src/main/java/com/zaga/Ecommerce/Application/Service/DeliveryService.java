package com.zaga.Ecommerce.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.Ecommerce.Application.Kafka.Consumer;
import com.zaga.Ecommerce.Application.Model.ProductDetails;
import com.zaga.Ecommerce.Application.Repository.ProductRepo;

@Service
public class DeliveryService {

    @Autowired
    ProductRepo repo;

    @Autowired
    Consumer consumer;

    // step-04:- product received to user 
    public ProductDetails recivingMessage(ProductDetails productDetails) {
        // ProductDetails consume = repo.save(productDetails);
        consumer.customerGetMsg(productDetails);
        return productDetails;
    }

}
