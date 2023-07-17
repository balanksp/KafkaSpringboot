package com.zaga.Ecommerce.Application.config;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.web.context.annotation.ApplicationScope;

import com.zaga.Ecommerce.Application.Model.ProductDetails;

@ApplicationScope
public class ObjectSerializer implements Serializer<ProductDetails> {

    @Override
    public byte[] serialize(String topic, ProductDetails data) {
         try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(data);
            objectStream.flush();
            return byteStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error serializing MyObject: " + e);
        }
    }
    
}
