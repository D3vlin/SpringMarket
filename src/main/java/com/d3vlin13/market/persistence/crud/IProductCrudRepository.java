package com.d3vlin13.market.persistence.crud;

import com.d3vlin13.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {

}
