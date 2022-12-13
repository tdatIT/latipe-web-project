package com.webproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_address", schema = "final_web_project", catalog = "")
public class UserAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "country", nullable = false, length = 255)
    private String country;
    @Basic
    @Column(name = "city", nullable = false, length = 255)
    private String city;
    @Basic
    @Column(name = "zipcode", nullable = false, length = 10)
    private String zipcode;
    @Basic
    @Column(name = "number_phone", nullable = false, length = 10)
    private String numberPhone;
    @Basic
    @Column(name = "name_recipient", nullable = false, length = 50)
    private String nameRecipient;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private User userByUserId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNameRecipient() {
        return nameRecipient;
    }

    public void setNameRecipient(String nameRecipient) {
        this.nameRecipient = nameRecipient;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAddress that = (UserAddress) o;
        return addressId == that.addressId && userId == that.userId && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(zipcode, that.zipcode) && Objects.equals(numberPhone, that.numberPhone) && Objects.equals(nameRecipient, that.nameRecipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, userId, country, city, zipcode, numberPhone, nameRecipient);
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
