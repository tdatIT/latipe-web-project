package com.webproject.dao;

import com.webproject.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();

    List<Product> findByCategoryId(int id);

    List<Product> findProductByStoreId(int id);

    List<Product> fullTextSearch(String keyword);

    Product findById(int id);

    Product findByName(String name);

    int insertProduct(Product product);

    boolean updateProduct(Product product);

    boolean disableProduct(int id);


}
