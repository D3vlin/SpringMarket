package com.d3vlin13.market.persistence;

import com.d3vlin13.market.persistence.crud.IProductCrudRepository;
import com.d3vlin13.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private IProductCrudRepository productCrudRepository;

    public List<Product> findAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
