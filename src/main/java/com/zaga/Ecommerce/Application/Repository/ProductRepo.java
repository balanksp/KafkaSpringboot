package com.zaga.Ecommerce.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaga.Ecommerce.Application.Model.ProductDetails;

public interface ProductRepo extends JpaRepository<ProductDetails,Long> {


   
}
