package com.webproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "user_level_id", nullable = false)
    private int userLevelId;
    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    private String lastname;
    @Basic
    @Column(name = "id_card", nullable = false, length = 12)
    private String idCard;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "isEmailActive", nullable = false)
    private boolean isEmailActive;
    @Basic
    @Column(name = "isPhoneActive", nullable = false)
    private boolean isPhoneActive;
    @Basic
    @Column(name = "hashed_password", nullable = false, length = 50)
    private String hashedPassword;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "point", nullable = false)
    private int point;
    @Basic
    @Column(name = "e_wallet", nullable = false, precision = 0)
    private double eWallet;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "updateDate", nullable = true)
    private Date updateDate;
    @Basic
    @Column(name = "isDeleted", nullable = true)
    private Boolean isDeleted;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "phone", nullable = true, length = 10)
    private String phone;
    @Basic
    @Column(name = "store_emp_id", nullable = true)
    private Integer storeEmpId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Cart> cartsByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Order> ordersByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Review> reviewsByUserId;
    @OneToMany(mappedBy = "userByOwnId")
    private Collection<Store> storesByUserId;
    @ManyToOne
    @JoinColumn(name = "user_level_id", referencedColumnName = "user_level_id", nullable = false, insertable=false, updatable=false)
    private UserLevel userLevelByUserLevelId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable=false, updatable=false)
    private Role roleByRoleId;
    @ManyToOne
    @JoinColumn(name = "store_emp_id", referencedColumnName = "store_id", insertable=false, updatable=false)
    private Store storeByStoreEmpId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserAddress> userAddressesByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserFollowProduct> userFollowProductsByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserFollowStore> userFollowStoresByUserId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(int userLevelId) {
        this.userLevelId = userLevelId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailActive() {
        return isEmailActive;
    }

    public void setEmailActive(boolean emailActive) {
        isEmailActive = emailActive;
    }

    public boolean isPhoneActive() {
        return isPhoneActive;
    }

    public void setPhoneActive(boolean phoneActive) {
        isPhoneActive = phoneActive;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double geteWallet() {
        return eWallet;
    }

    public void seteWallet(double eWallet) {
        this.eWallet = eWallet;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStoreEmpId() {
        return storeEmpId;
    }

    public void setStoreEmpId(Integer storeEmpId) {
        this.storeEmpId = storeEmpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userLevelId == user.userLevelId && isEmailActive == user.isEmailActive && isPhoneActive == user.isPhoneActive && point == user.point && Double.compare(user.eWallet, eWallet) == 0 && roleId == user.roleId && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(idCard, user.idCard) && Objects.equals(email, user.email) && Objects.equals(hashedPassword, user.hashedPassword) && Objects.equals(avatar, user.avatar) && Objects.equals(createDate, user.createDate) && Objects.equals(updateDate, user.updateDate) && Objects.equals(isDeleted, user.isDeleted) && Objects.equals(phone, user.phone) && Objects.equals(storeEmpId, user.storeEmpId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userLevelId, firstname, lastname, idCard, email, isEmailActive, isPhoneActive, hashedPassword, avatar, point, eWallet, createDate, updateDate, isDeleted, roleId, phone, storeEmpId);
    }

    public Collection<Cart> getCartsByUserId() {
        return cartsByUserId;
    }

    public void setCartsByUserId(Collection<Cart> cartsByUserId) {
        this.cartsByUserId = cartsByUserId;
    }

    public Collection<Order> getOrdersByUserId() {
        return ordersByUserId;
    }

    public void setOrdersByUserId(Collection<Order> ordersByUserId) {
        this.ordersByUserId = ordersByUserId;
    }

    public Collection<Review> getReviewsByUserId() {
        return reviewsByUserId;
    }

    public void setReviewsByUserId(Collection<Review> reviewsByUserId) {
        this.reviewsByUserId = reviewsByUserId;
    }

    public Collection<Store> getStoresByUserId() {
        return storesByUserId;
    }

    public void setStoresByUserId(Collection<Store> storesByUserId) {
        this.storesByUserId = storesByUserId;
    }

    public UserLevel getUserLevelByUserLevelId() {
        return userLevelByUserLevelId;
    }

    public void setUserLevelByUserLevelId(UserLevel userLevelByUserLevelId) {
        this.userLevelByUserLevelId = userLevelByUserLevelId;
    }

    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    public Store getStoreByStoreEmpId() {
        return storeByStoreEmpId;
    }

    public void setStoreByStoreEmpId(Store storeByStoreEmpId) {
        this.storeByStoreEmpId = storeByStoreEmpId;
    }

    public Collection<UserAddress> getUserAddressesByUserId() {
        return userAddressesByUserId;
    }

    public void setUserAddressesByUserId(Collection<UserAddress> userAddressesByUserId) {
        this.userAddressesByUserId = userAddressesByUserId;
    }

    public Collection<UserFollowProduct> getUserFollowProductsByUserId() {
        return userFollowProductsByUserId;
    }

    public void setUserFollowProductsByUserId(Collection<UserFollowProduct> userFollowProductsByUserId) {
        this.userFollowProductsByUserId = userFollowProductsByUserId;
    }

    public Collection<UserFollowStore> getUserFollowStoresByUserId() {
        return userFollowStoresByUserId;
    }

    public void setUserFollowStoresByUserId(Collection<UserFollowStore> userFollowStoresByUserId) {
        this.userFollowStoresByUserId = userFollowStoresByUserId;
    }
}
