package com.webproject.service.impl;

import com.webproject.dao.IProductImgDAO;
import com.webproject.dao.impl.ProductImgDAOImpl;
import com.webproject.model.ProductImg;
import com.webproject.service.IProductImgService;

public class ProductImgServiceImpl implements IProductImgService {
    private IProductImgDAO dao = new ProductImgDAOImpl();

    @Override
    public ProductImg getImageById(int id) {
        return dao.getImageById(id);
    }

    @Override
    public void insertProductImage(ProductImg img) {
        dao.insertProductImage(img);
    }
}
