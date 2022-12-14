package com.webproject.dao;

import com.webproject.model.Product;
import com.webproject.model.Store;
import com.webproject.model.User;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashMap;
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

    List<Product> getStatistic(String option, LocalDate date) ;

    public HashMap<Integer, Object > paginate(String search, int page,int option);

    public boolean setStatus(int id, boolean status);

    public HashMap<Integer, Object> paginateWeb(String search,int page, int cate, int minPrice, int maxPrice, int status);

    List<Product> find6FlashSale();

    List<Product> newProductList();

    List<Product> findHotProduct();

    List<Product> findProductForYou(int userId);
}
