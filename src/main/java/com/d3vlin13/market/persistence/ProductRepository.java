package com.d3vlin13.market.persistence;

import com.d3vlin13.market.persistence.crud.IProductCrudRepository;
import com.d3vlin13.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private IProductCrudRepository productCrudRepository;

    public List<Product> findAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getLessThan(int stockQuantity) {
        return productCrudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
    }

    public Optional<Product> findById(int idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteById(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
