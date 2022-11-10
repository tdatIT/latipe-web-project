package com.webproject.service.impl;

import com.webproject.dao.IProductImgDAO;
import com.webproject.dao.impl.IProductImgDAOImpl;
import com.webproject.model.ProductImg;
import com.webproject.service.IProductImgService;

public class ProductImgImpl implements IProductImgService {
    private IProductImgDAO dao = new IProductImgDAOImpl();

    @Override
    public ProductImg getImageById(int id) {
        return dao.getImageById(id);
    }

    @Override
    public void insertProductImage(ProductImg img) {
        dao.insertProductImage(img);
    }
}
