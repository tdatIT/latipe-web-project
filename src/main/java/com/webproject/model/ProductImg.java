package com.webproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_img", schema = "final_web_project", catalog = "")
public class ProductImg {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_image", nullable = false)
    private int idImage;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;
    @Basic
    @Column(name = "location", nullable = true, length = 255)
    private String location;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable=false, updatable=false)
    private Product productByProductId;

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImg that = (ProductImg) o;
        return idImage == that.idImage && productId == that.productId && Objects.equals(fileName, that.fileName) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImage, productId, fileName, location);
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
