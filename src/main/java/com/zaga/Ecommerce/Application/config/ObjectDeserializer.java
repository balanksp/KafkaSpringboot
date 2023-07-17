package com.zaga.Ecommerce.Application.config;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.web.context.annotation.ApplicationScope;

import com.zaga.Ecommerce.Application.Model.ProductDetails;

@ApplicationScope
public class ObjectDeserializer implements Deserializer<ProductDetails>  {

    @Override
    public ProductDetails deserialize(String topic, byte[] data) {
      try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
            ObjectInputStream objectStream = new ObjectInputStream(byteStream);
            return (ProductDetails) objectStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing MyObject: " + e);
        }   
    }
}
