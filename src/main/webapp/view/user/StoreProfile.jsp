<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/3/2022
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>${store.name} - Latipe</title>


    <!-- Google Font -->
    <link
            href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet"/>
    <%--  //${pageContext.request.contextPath}/view/vendor/assets--%>
    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/bootstrap.min.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/font-awesome.min.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/elegant-icons.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/nice-select.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/owl.carousel.min.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/slicknav.min.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/style.css" type="text/css"/>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/user/assets/css/962.1dfe27476d9b724913f1.legacy.css"
          type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/bundle.babe0501a8e8b29b.css"
          type="text/css"/>

</head>

<body>
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
                        <div class="header__top__right__social">
                            <a href="signin.html"><i class="fa fa-sign-in" style="margin-right:5px ;"></i>Đăng Nhập</a>

                        </div>
                        <div class="header__top__right__auth">
                            <a href="signup.html"><i class="fa fa-user"></i>Đăng ký</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="/trang-chu"><img src="${pageContext.request.contextPath}/view/assets/img/logo.png" alt=""></a>
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


<div class="shop-page__info">
    <div class="section-seller-overview-horizontal container">
        <div class="section-seller-overview-horizontal__leading">
            <div class="section-seller-overview-horizontal__leading-background"
                 style="background-image: url(&quot;https://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/shopmicrofe/dc2a8ae5803b2531c9a537ae6432ce08.jpg&quot;);">

            </div>
            <div class="section-seller-overview-horizontal__leading-background-mask">

            </div>
            <div class="section-seller-overview-horizontal__leading-content">
                <div class="section-seller-overview-horizontal__seller-portrait _3_slsd">
                    <a class="section-seller-overview-horizontal__seller-portrait-link" href="/hp_flagship_store">
                        <div class="shopee-avatar _1a-fH5">
                            <div class="shopee-avatar__placeholder">
                                <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0"
                                     class="shopee-svg-icon icon-headshot">
                                    <g>
                                        <circle cx="7.5" cy="4.5" fill="none" r="3.8" stroke-miterlimit="10"></circle>
                                        <path d="m1.5 14.2c0-3.3 2.7-6 6-6s6 2.7 6 6" fill="none" stroke-linecap="round"
                                              stroke-miterlimit="10"></path>
                                    </g>
                                </svg>
                            </div>
                            <img class="shopee-avatar__img"
                                 src="${pageContext.request.contextPath}/upload/${store.avatar}"></div>
                        <div class="section-seller-overview-horizontal__preferred-badge-wrapper">
                            <div class="official-shop-new-badge"><img class="_3Iy9lW"
                                                                      src="https://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/shopmicrofe/483071c49603aa7163a7f51708bff61b.png"
                                                                      loading="lazy" width="64" height="16"></div>
                        </div>
                    </a>
                    <div class="section-seller-overview-horizontal__portrait-info"><h1
                            class="section-seller-overview-horizontal__portrait-name">HP_Flagship_Store</h1>
                        <div class="section-seller-overview-horizontal__portrait-status">
                            <div class="section-seller-overview-horizontal__active-time">Online 1 giờ trước</div>
                        </div>
                    </div>
                </div>
                <div class="section-seller-overview-horizontal__buttons"><a
                        class="section-seller-overview-horizontal__button">
                    <button class="shopee-button-outline shopee-button-outline--complement shopee-button-outline--fill">
                        <span class="section-seller-overview-horizontal__icon"><svg enable-background="new 0 0 10 10"
                                                                                    viewBox="0 0 10 10" x="0" y="0"
                                                                                    class="shopee-svg-icon icon-plus-sign"><polygon
                                points="10 4.5 5.5 4.5 5.5 0 4.5 0 4.5 4.5 0 4.5 0 5.5 4.5 5.5 4.5 10 5.5 10 5.5 5.5 10 5.5"></polygon></svg></span>theo
                        dõi
                    </button>
                </a><a argettype="chatButton" class="section-seller-overview-horizontal__button">
                    <button class="shopee-button-outline shopee-button-outline--complement shopee-button-outline--fill">
                        <span class="section-seller-overview-horizontal__icon"><svg viewBox="0 0 16 16"
                                                                                    class="shopee-svg-icon"><g
                                fill-rule="evenodd"><path
                                d="M15 4a1 1 0 01.993.883L16 5v9.932a.5.5 0 01-.82.385l-2.061-1.718-8.199.001a1 1 0 01-.98-.8l-.016-.117-.108-1.284 8.058.001a2 2 0 001.976-1.692l.018-.155L14.293 4H15zm-2.48-4a1 1 0 011 1l-.003.077-.646 8.4a1 1 0 01-.997.923l-8.994-.001-2.06 1.718a.5.5 0 01-.233.108l-.087.007a.5.5 0 01-.492-.41L0 11.732V1a1 1 0 011-1h11.52zM3.646 4.246a.5.5 0 000 .708c.305.304.694.526 1.146.682A4.936 4.936 0 006.4 5.9c.464 0 1.02-.062 1.608-.264.452-.156.841-.378 1.146-.682a.5.5 0 10-.708-.708c-.185.186-.445.335-.764.444a4.004 4.004 0 01-2.564 0c-.319-.11-.579-.258-.764-.444a.5.5 0 00-.708 0z"></path></g></svg></span>chat
                    </button>
                </a></div>
            </div>
        </div>
        <div class="section-seller-overview-horizontal__seller-info-list">
            <div class="section-seller-overview__item section-seller-overview__item--clickable">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" stroke-width="0"
                         class="shopee-svg-icon">
                        <path d="m13 1.9c-.2-.5-.8-1-1.4-1h-8.4c-.6.1-1.2.5-1.4 1l-1.4 4.3c0 .8.3 1.6.9 2.1v4.8c0 .6.5 1 1.1 1h10.2c.6 0 1.1-.5 1.1-1v-4.6c.6-.4.9-1.2.9-2.3zm-11.4 3.4 1-3c .1-.2.4-.4.6-.4h8.3c.3 0 .5.2.6.4l1 3zm .6 3.5h.4c.7 0 1.4-.3 1.8-.8.4.5.9.8 1.5.8.7 0 1.3-.5 1.5-.8.2.3.8.8 1.5.8.6 0 1.1-.3 1.5-.8.4.5 1.1.8 1.7.8h.4v3.9c0 .1 0 .2-.1.3s-.2.1-.3.1h-9.5c-.1 0-.2 0-.3-.1s-.1-.2-.1-.3zm8.8-1.7h-1v .1s0 .3-.2.6c-.2.1-.5.2-.9.2-.3 0-.6-.1-.8-.3-.2-.3-.2-.6-.2-.6v-.1h-1v .1s0 .3-.2.5c-.2.3-.5.4-.8.4-1 0-1-.8-1-.8h-1c0 .8-.7.8-1.3.8s-1.1-1-1.2-1.7h12.1c0 .2-.1.9-.5 1.4-.2.2-.5.3-.8.3-1.2 0-1.2-.8-1.2-.9z"></path>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">Sản phẩm:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">82</div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">82</div>
                    <div class="section-seller-overview__item-text-name">Sản phẩm</div>
                </div>
            </div>
            <div class="section-seller-overview__item">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" class="shopee-svg-icon">
                        <g>
                            <circle cx="7" cy="4.5" fill="none" r="3.8" stroke-miterlimit="10"></circle>
                            <line fill="none" stroke-linecap="round" stroke-miterlimit="10" x1="12" x2="12" y1="11.2"
                                  y2="14.2"></line>
                            <line fill="none" stroke-linecap="round" stroke-miterlimit="10" x1="10.5" x2="13.5"
                                  y1="12.8" y2="12.8"></line>
                            <path d="m1.5 13.8c0-3 2.5-5.5 5.5-5.5 1.5 0 2.9.6 3.9 1.6" fill="none"
                                  stroke-linecap="round" stroke-miterlimit="10"></path>
                        </g>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">Đang Theo:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">1</div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">1</div>
                    <div class="section-seller-overview__item-text-name">Đang Theo</div>
                </div>
            </div>
            <div class="section-seller-overview__item">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" class="shopee-svg-icon">
                        <g>
                            <polygon fill="none" points="14 10.8 7 10.8 3 13.8 3 10.8 1 10.8 1 1.2 14 1.2"
                                     stroke-linejoin="round" stroke-miterlimit="10"></polygon>
                            <circle cx="4" cy="5.8" r="1" stroke="none"></circle>
                            <circle cx="7.5" cy="5.8" r="1" stroke="none"></circle>
                            <circle cx="11" cy="5.8" r="1" stroke="none"></circle>
                        </g>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">Tỉ lệ phản hồi Chat:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">99% (trong vài giờ)
                        <div class="section-seller-overview__inline-icon section-seller-overview__inline-icon--help">
                            <svg width="10" height="10">
                                <g fill="currentColor" fill-rule="nonzero" color="currentColor" stroke-width="0">
                                    <path d="M5 10A5 5 0 1 1 5 0a5 5 0 0 1 0 10zM5 .675a4.325 4.325 0 1 0 0 8.65 4.325 4.325 0 0 0 0-8.65z"></path>
                                    <path d="M6.235 5.073c.334-.335.519-.79.514-1.264a1.715 1.715 0 0 0-.14-.684 1.814 1.814 0 0 0-.933-.951A1.623 1.623 0 0 0 5 2.03a1.66 1.66 0 0 0-.676.14 1.772 1.772 0 0 0-.934.948c-.093.219-.14.454-.138.691a.381.381 0 0 0 .106.276c.07.073.168.113.27.11a.37.37 0 0 0 .348-.235c.02-.047.031-.099.03-.15a1.006 1.006 0 0 1 .607-.933.954.954 0 0 1 .772.002 1.032 1.032 0 0 1 .61.93c.003.267-.1.525-.288.716l-.567.537c-.343.35-.514.746-.514 1.187a.37.37 0 0 0 .379.382c.1.002.195-.037.265-.108a.375.375 0 0 0 .106-.274c0-.232.097-.446.29-.642l.568-.534zM5 6.927a.491.491 0 0 0-.363.152.53.53 0 0 0 0 .74.508.508 0 0 0 .726 0 .53.53 0 0 0 0-.74A.491.491 0 0 0 5 6.927z"></path>
                                </g>
                            </svg>
                        </div>
                    </div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">99% (trong vài giờ)</div>
                    <div class="section-seller-overview__item-text-name">Tỉ lệ phản hồi Chat</div>
                </div>
            </div>
            <div class="section-seller-overview__item">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" class="shopee-svg-icon">
                        <g>
                            <circle cx="5.5" cy="5" fill="none" r="4" stroke-miterlimit="10"></circle>
                            <path d="m8.4 7.5c.7 0 1.1.7 1.1 1.6v4.9h-8v-4.9c0-.9.4-1.6 1.1-1.6" fill="none"
                                  stroke-linejoin="round" stroke-miterlimit="10"></path>
                            <path d="m12.6 6.9c.7 0 .9.6.9 1.2v5.7h-2" fill="none" stroke-linecap="round"
                                  stroke-linejoin="round" stroke-miterlimit="10"></path>
                            <path d="m9.5 1.2c1.9 0 3.5 1.6 3.5 3.5 0 1.4-.9 2.7-2.1 3.2" fill="none"
                                  stroke-linecap="round" stroke-miterlimit="10"></path>
                        </g>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">Người theo dõi:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">1,3k</div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">1,3k</div>
                    <div class="section-seller-overview__item-text-name">Người theo dõi</div>
                </div>
            </div>
            <div class="section-seller-overview__item section-seller-overview__item--clickable">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0"
                         class="shopee-svg-icon icon-rating">
                        <polygon fill="none"
                                 points="7.5 .8 9.7 5.4 14.5 5.9 10.7 9.1 11.8 14.2 7.5 11.6 3.2 14.2 4.3 9.1 .5 5.9 5.3 5.4"
                                 stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10"></polygon>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">đánh giá:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">4.8 (43 đánh giá)</div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">4.8 (43 đánh giá)</div>
                    <div class="section-seller-overview__item-text-name">đánh giá</div>
                </div>
            </div>
            <div class="section-seller-overview__item">
                <div class="section-seller-overview__item-icon-wrapper">
                    <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" class="shopee-svg-icon">
                        <g>
                            <circle cx="6.8" cy="4.2" fill="none" r="3.8" stroke-miterlimit="10"></circle>
                            <polyline fill="none" points="9.2 12.5 11.2 14.5 14.2 11" stroke-linecap="round"
                                      stroke-linejoin="round" stroke-miterlimit="10"></polyline>
                            <path d="m .8 14c0-3.3 2.7-6 6-6 2.1 0 3.9 1 5 2.6" fill="none" stroke-linecap="round"
                                  stroke-miterlimit="10"></path>
                        </g>
                    </svg>
                </div>
                <div class="section-seller-overview__item-text">
                    <div class="section-seller-overview__item-text-name">tham gia:&nbsp;</div>
                    <div class="section-seller-overview__item-text-value">30 tháng trước</div>
                </div>
                <div class="section-seller-overview__item-text section-seller-overview__item-text--no-product">
                    <div class="section-seller-overview__item-text-value">30 tháng trước</div>
                    <div class="section-seller-overview__item-text-name">tham gia</div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Banner Begin -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">

                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner End -->
<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Sản Phẩm Của ${store.name}</h2>
                </div>
                <div class="featured__controls">
                </div>
            </div>
        </div>
        <div class="row featured__filter">
            <!-- Featured Section Begin -->
            <c:forEach items="${products}" var="i">
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg"
                             data-setbg="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">${i.name}</a></h6>
                            <h5>${i.price.intValue()}₫</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Featured Section End -->


<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="./index.html"><img src="assets/img/logo.png" alt=""></a>
                    </div>
                    <ul>
                        <li>Địa chỉ: Số 1, Võ Văn Ngân, P. Linh Trung, Tp. Thủ Đức, TP. HCM</li>
                        <li>Phone: 1900 1099</li>
                        <li>Email: f-prj-web@utefit.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Các Trang</h6>
                    <ul>
                        <li><a href="#">Về chúng tôi</a></li>
                        <li><a href="#">Chính sách mua hàng</a></li>
                        <li><a href="#">Đăng ký</a></li>
                        <li><a href="#">Tuyển dụng</a></li>
                        <li><a href="#">Bảo mật</a></li>
                        <li><a href="#">Thanh toán</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">Đăng ký</a></li>
                        <li><a href="#">Thanh toán</a></li>
                        <li><a href="#">Kiếu nại</a></li>
                        <li><a href="#">Liên hệ</a></li>
                        <li><a href="#">Đóng góp</a></li>
                        <li><a href="#">Phát triên</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Nhận thông báo về các khuyến mãi</h6>
                    <p>Nhập thông tin mail để chúng tôi cung cấp thông tin khuyên mãi nhanh nhất</p>
                    <form action="#">
                        <input type="text" placeholder="Nhập vào email">
                        <button type="submit" class="site-btn">Đăng ký</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text">
                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                            - Đề tài cuối kỳ Lập Trình Web HKI 2022-2023
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                    <div class="footer__copyright__payment"><img src="assets/img/payment-item.png" alt=""></div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/main.js"></script>


</body>

</html>