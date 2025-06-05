package com.d3vlin13.market.persistence.crud;

import com.d3vlin13.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Producto>> findByStockQuantityLessThanAndState(int stockQuantity, Boolean state);
}
