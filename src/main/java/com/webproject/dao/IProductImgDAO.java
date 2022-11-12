package com.webproject.dao;

import com.webproject.model.ProductImg;

public interface IProductImgDAO {
    ProductImg getImageById(int id);

    void insertProductImage(ProductImg img);
}
