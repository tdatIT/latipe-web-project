<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/1/2022
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Latipe - Mua săm thả ga vô vàng khuyến mãi</title>
    <link rel="icon" type="image/x-icon" href="view/web/assets/img/favicon.png">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="view/web/assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="view/web/assets/css/style.css" type="text/css">
</head>

<body>
<!-- Header -->
<c:import url="header.jsp"></c:import>

<!-- Banner Begin -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="img/banner/banner-1.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="img/banner/banner-2.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner End -->
<!-- Categories Section Begin -->
<section class="categories">
    <div class="container">
        <div class="row">
            <div class="categories__slider owl-carousel">
                <c:forEach items="${categories}" var="i">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="upload/${i.image}">
                            <h5><a href="category?name=${name}">${i.name}</a></h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<!-- Categories Section End -->
<!-- Latest Product Section Begin -->
<section class="latest-product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Sản phẩm mới</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${hotProducts}" begin="0"
                                       end="2">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${hotProducts}" begin="3"
                                       end="5">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Flash Sale</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${flashSale}" begin="0"
                                       end="2">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${flashSale}" begin="3"
                                       end="5">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Sản phẩm Hot</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${newProducts}" begin="0"
                                       end="2">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach var="i" items="${newProducts}" begin="3"
                                       end="5">
                                <a href="${pageContext.request.contextPath}/product?id=${i.productId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${i.name}</h6>
                                        <span>${i.price.intValue()}₫</span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Sản Phẩm Dành Cho Bạn</h2>
                </div>
                <div class="featured__controls">

                </div>
            </div>
        </div>
        <div class="row featured__filter">
            <c:forEach items="${forYou}" var="i">
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
                            <h6><a href="${pageContext.request.contextPath}/product?id=${i.productId}">${i.name}</a></h6>
                            <h5>${i.price.intValue()} ₫</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</section>
<!-- Featured Section End -->


<!-- Footer Section Begin -->
<c:import url="footer.jsp"></c:import>


</body>

</html>
