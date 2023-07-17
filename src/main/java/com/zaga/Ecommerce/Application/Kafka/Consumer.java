package com.zaga.Ecommerce.Application.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zaga.Ecommerce.Application.Model.ProductDetails;
import com.zaga.Ecommerce.Application.Repository.ProductRepo;

@Service
public class Consumer {

    @Autowired
    ProductRepo repo;
//step-02
    @KafkaListener(topics = "userOrder", groupId = "group-id")
    public void receivingOrder(ProductDetails productDetails) {
        repo.save(productDetails);
        System.out.println("vendor getting the orderDetails ---->"+ productDetails);
    }
// step-04
    public void customerGetMsg(ProductDetails productDetails) {
        repo.save(productDetails);
        System.out.println("product received to user -----> "+ productDetails);
    }
}
