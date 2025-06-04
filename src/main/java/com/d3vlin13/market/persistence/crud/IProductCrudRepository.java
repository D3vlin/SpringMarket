package com.d3vlin13.market.persistence.crud;

import com.d3vlin13.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, Boolean state);
}
