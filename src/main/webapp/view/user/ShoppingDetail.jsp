<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/12/2022
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="vi">

<head>
    <title>${prod.name}</title>
    <c:import url="head_link_v1.jsp">
    </c:import>

</head>
<c:import url="header.jsp"></c:import>
<body>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/bread.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 text-center">
                <div class="breadcrumb__text">
                    <a href="${pageContext.request.contextPath}/store-view?storeId=${prod.storeByStoreId.storeId}   ">
                        <h2>${prod.storeByStoreId.name}</h2>
                    </a>
                    <div class="breadcrumb__option">
                        <a href="${pageContext.request.contextPath}/">Home</a>
                        <span>Mall</span>
                    </div>
                </div>
            </div>
            <div class="blog__details__content col-lg-8">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="blog__details__author">
                            <div class="blog__details__author__pic">
                                <img src="${pageContext.request.contextPath}/upload/${prod.storeByStoreId.avatar}"
                                     alt="">
                            </div>
                            <div class="blog__details__author__text">
                                <h6>${prod.storeByStoreId.name}</h6>
                                <span>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="blog__details__widget">
                            <ul>
                                <li><span>Doanh mục sản phẩm: </span> Công nghệ</li>
                                <li><span>Hoạt động: </span>${prod.storeByStoreId.createDate}</li>
                            </ul>
                            <div class="blog__details__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>

                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="product__details__pic">
                    <!-- main image -->
                    <!-- pro img tra ve list anh cua san pham do mac dinh main image la phan tu 0 -->
                    <div class="product__details__pic__item">
                        <img class="product__details__pic__item--large"
                             src="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}"
                             alt="">
                    </div>
                    <!-- sub image -->
                    <!-- cac anh phu la anh tu vi tri 1 -->
                    <div class="product__details__pic__slider owl-carousel">
                        <c:forEach var="item" items="${prod.productImgsByProductId}">
                            <img data-imgbigurl="${pageContext.request.contextPath}/upload/${item.fileName}"
                                 src="${pageContext.request.contextPath}/upload/${item.fileName}" alt="">
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__text">
                    <h3>${ prod.name }</h3>
                    <div class="product__details__rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <span>(${prod.reviewsByProductId.size()} reviews)</span>
                    </div>
                    <div id="max-amount" style="display: none">${prod.quantity}</div>
                    <div class="product__details__price">
                        <c:if test="${prod.promotionalPrice != 0}">
                            <del>${prod.price.intValue()}₫</del>
                            ${prod.promotionalPrice.intValue()}₫
                        </c:if>
                        <c:if test="${prod.promotionalPrice == 0}">
                            ${prod.price.intValue()}₫
                        </c:if>

                    </div>
                    <div class="product__details__quantity">
                        <div class="quantity">
                            <input class="val-amount" name="number" type="number" value="1" max="${prod.quantity}"
                                   min="1">
                        </div>
                    </div>
                    <a href="product/addToCart?prodID=${prod.productId}&quantity=1" class="primary-btn" id="btn-submit">THÊM
                        VÀO GIỎ HÀNG</a>
                    <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                    <ul>
                        <li><b>Availability</b> <span>In Stock</span></li>
                        <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                               aria-selected="true">Mô tả</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                               aria-selected="false">Đánh giá <span>(1)</span></a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <h6>MÔ TẢ SẢN PHẨM: </h6>
                                <p>${prod.description}.</p>
                            </div>
                        </div>

                        <div class="tab-pane" id="tabs-3" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <h6>ĐÁNH GIÁ SẢN PHẨM :</h6>
                                <div class="post">
                                    <div class="text">Thanks for rating us!</div>
                                    <div class="edit">EDIT</div>
                                </div>
                                <div class="star-widget">
                                    <input type="radio" name="rate" id="rate-5">
                                    <label for="rate-5" class="fas fa-star"></label>
                                    <input type="radio" name="rate" id="rate-4">
                                    <label for="rate-4" class="fas fa-star"></label>
                                    <input type="radio" name="rate" id="rate-3">
                                    <label for="rate-3" class="fas fa-star"></label>
                                    <input type="radio" name="rate" id="rate-2">
                                    <label for="rate-2" class="fas fa-star"></label>
                                    <input type="radio" name="rate" id="rate-1">
                                    <label for="rate-1" class="fas fa-star"></label>
                                    <form action="#">
                                        <header></header>
                                        <div class="textarea">
                                            <textarea cols="30" placeholder="Describe your experience."></textarea>
                                        </div>
                                        <div class="btn">
                                            <button type="submit">Post</button>
                                        </div>
                                    </form>
                                </div>

                                <script>
                                    const btn = document.querySelector("button");
                                    const post = document.querySelector(".post");
                                    const widget = document.querySelector(".star-widget");
                                    const editBtn = document.querySelector(".edit");
                                    btn.onclick = () => {
                                        widget.style.display = "none";
                                        post.style.display = "block";
                                        editBtn.onclick = () => {
                                            widget.style.display = "block";
                                            post.style.display = "none";
                                        }
                                        return false;
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title related__product__title">
                    <h2>SẢN PHẨM LIÊN QUAN</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="i" items="${products}">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg"
                             data-setbg="${pageContext.request.contextPath}/upload/${i.productImgsByProductId[0].fileName}">
                            <ul class="product__item__pic__hover">
                                <li><a href="${pageContext.request.contextPath}/product?id=${i.productId}"><i
                                        class="fa fa-eye"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6>${i.name}</h6>
                            <h5>${i.price.intValue()}₫</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Related Product Section End -->

<c:import url="footer.jsp"></c:import>
</body>

</html>
