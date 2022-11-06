<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/1/2022
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> f-prj-web@utefit.com</li>
                            <li>Miễn phí ship cho tất cả đơn hàng trên 50K từ 20/10</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                        </div>
                        <c:if test="${sessionScope.user_id eq null}">
                            <div class="header__top__right__social">
                                <a href="login"><i class="fa fa-sign-in" style="margin-right:5px ;"></i>Đăng Nhập</a>

                            </div>
                            <div class="header__top__right__auth">
                                <a href="signup"><i class="fa fa-user"></i>Đăng ký</a>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.user_id ne null}">
                            <div class="header__top__right__social">
                                <a href="login"><i class="fa fa-user" style="margin-right:5px ;"></i>Xin
                                    chào ${sessionScope.lastname}</a>

                            </div>
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-sign-in"></i>Đăng xuất</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="home"><img src="view/web/assets/img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li>
                            <div class="hero__search__form">
                                <form action="#">
                                    <input type="text" placeholder="Tìm kiếm sản phẩm ...">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                        <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                    </ul>
                    <div class="header__cart__price">item: <span>$150.00</span></div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
<!-- Header Section End -->

<!-- Product Search Section End -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="featured__controls">
                <ul>
                    <li>Iphone 14</li>
                    <li>quần áo</li>
                    <li>tai nghe</li>
                    <li>sạc dự phòng</li>
                    <li>thú cưng</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- FProduct Search Section End -->
