package com.d3vlin13.market.persistence;

import com.d3vlin13.market.domain.Product;
import com.d3vlin13.market.domain.repository.IProductRepository;
import com.d3vlin13.market.persistence.crud.IProductCrudRepository;
import com.d3vlin13.market.persistence.entity.Producto;
import com.d3vlin13.market.persistence.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private IProductCrudRepository productCrudRepository;

    @Autowired
    private IProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategory) {
        List<Producto> productos =  productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getLessThan(int stockQuantity) {
        Optional<List<Producto>> productos = productCrudRepository.findByStockQuantityLessThanAndState(stockQuantity, true);
        return productos.map(p -> productMapper.toProducts(p));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(p -> productMapper.toProduct(p));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productCrudRepository.save(producto));
    }
}
