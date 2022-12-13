package com.webproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "store_level", schema = "final_web_project", catalog = "")
public class StoreLevel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_level_id", nullable = false)
    private int storeLevelId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "minPoint", nullable = false)
    private int minPoint;
    @Basic
    @Column(name = "isDeleted", nullable = true)
    private Boolean isDeleted= false;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate= new Date(new java.util.Date().getTime());
    @Basic
    @Column(name = "updateDate", nullable = true)
    private Date updateDate;
    @OneToMany(mappedBy = "storeLevel")
    private Collection<Store> stores;

    public int getStoreLevelId() {
        return storeLevelId;
    }

    public void setStoreLevelId(int storeLevelId) {
        this.storeLevelId = storeLevelId;
    }

    public Collection<Store> getStores() {
        return stores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(int minPoint) {
        this.minPoint = minPoint;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public void setStores(Collection<Store> stores) {
        this.stores = stores;
    }
}
