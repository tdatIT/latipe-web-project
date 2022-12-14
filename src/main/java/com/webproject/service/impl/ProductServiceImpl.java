package com.webproject.service.impl;

import com.webproject.dao.IProductDAO;
import com.webproject.dao.impl.ProductDAOImpl;
import com.webproject.model.Product;
import com.webproject.service.IProductService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    private IProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByCategoryId(int id) {
        return productDAO.findByCategoryId(id);
    }

    @Override
    public List<Product> findProductByStoreId(int id) {
        return productDAO.findProductByStoreId(id);
    }

    @Override
    public List<Product> fullTextSearch(String keyword) {
        return productDAO.fullTextSearch(keyword);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public int insertProduct(Product product) {
        return productDAO.insertProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean disableProduct(int id) {
        return productDAO.disableProduct(id);
    }

    @Override
    public List<Product> getStatistic(String option, LocalDate date) {
        return productDAO.getStatistic(option, date);
    }

    @Override
    public HashMap<Integer, Object> paginate(String search, int page, int option) {
        return productDAO.paginate(search, option, page);
    }

    @Override
    public boolean setStatus(int id, boolean status) {
        return productDAO.setStatus(id, status);
    }

    @Override
    public List<Product> find6FlashSale() {
        return productDAO.find6FlashSale();
    }

    @Override
    public List<Product> newProductList() {
        return productDAO.newProductList();
    }

    @Override
    public List<Product> findHotProduct() {
        return productDAO.findHotProduct();
    }

    @Override
    public List<Product> findProductForYou(int userId) {
        return productDAO.findProductForYou(userId);
    }
}
