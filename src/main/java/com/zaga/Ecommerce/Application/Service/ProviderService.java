package com.zaga.Ecommerce.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.Ecommerce.Application.Kafka.Consumer;
import com.zaga.Ecommerce.Application.Kafka.Producer;
import com.zaga.Ecommerce.Application.Model.ProductDetails;
import com.zaga.Ecommerce.Application.Repository.ProductRepo;

@Service
public class ProviderService {

    @Autowired
    ProductRepo repo;

    @Autowired
    Consumer consumer;

    @Autowired
    Producer producer;

    // Step-02:- vendor getting the orderDetails
    public ProductDetails getProductDetails(ProductDetails productdetails) {
     ProductDetails consume = repo.save(productdetails);
        consumer.receivingOrder(productdetails);
        return consume;
    }
   // step-03:- product is ready to dispatch
    public ProductDetails readyToDelivery(ProductDetails productDetails) {
        // ProductDetails  publish = repo.save(productDetails);
        producer.orderToDelivery(productDetails);
        return productDetails;
    }
}
