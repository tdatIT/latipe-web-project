package com.webproject.service;

import com.webproject.model.ProductImg;

public interface IProductImgService {
    ProductImg getImageById(int id);

    void insertProductImage(ProductImg img);
}
