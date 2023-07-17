package com.zaga.Ecommerce.Application.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zaga.Ecommerce.Application.Model.ProductDetails;

@Service
public class Producer {
    
  public static final String topic = "userOrder";

  @Autowired
  private KafkaTemplate<String,ProductDetails> kafkaTemp;

  // step-01
  public void orderToProvider(ProductDetails productdetails){
    this.kafkaTemp.send(topic,productdetails);
    System.out.println("user order the product ---->"+productdetails);
  }
  //step-03
   public void orderToDelivery(ProductDetails productdetails){
    this.kafkaTemp.send(topic,productdetails);
  System.out.println("product is ready to dispatch ---->"+productdetails);
  }

}
