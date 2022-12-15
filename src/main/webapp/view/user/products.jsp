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
<html lang="zxx">

<head>
    <meta charset="UTF-8"/>
    <meta name="description" content="Ogani Template"/>
    <meta name="keywords" content="Ogani, unica, creative, html"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link
            href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet"
    />
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


</head>

<c:import url="header.jsp"></c:import>


<body>
<style>
    .active-page {
        background: #00d852;
        color: rgb(255, 255, 255) !important
    }
</style>

<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="sidebar">
                    <div class="sidebar__item">
                        <h4>Danh mục sản phẩm</h4>
                        <ul>
                            <c:forEach var="item" items="${cates}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/product?cate=${item.categoryId}">${item.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="sidebar__item">
                        <h4>Price</h4>
                        <div class="price-range-wrap">
                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                 data-min="0" data-max="10000000">
                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            </div>
                            <div class="range-slider">
                                <div class="price-input">
                                    <input type="text" id="minamount">
                                    <input type="text" id="maxamount">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Latest Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach var="i" begin="0" end="2">
                                        <a href="${pageContext.request.contextPath}/product?id=${newProd.get(i).productId}"
                                           class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${pageContext.request.contextPath}/upload/${newProd.get(i).productImgsByProductId[0].fileName}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${newProd.get(i).name}</h6>
                                                <span>${newProd.get(i).price.intValue()}₫</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach var="i" begin="3" end="5">
                                        <a href="${pageContext.request.contextPath}/product?id=${newProd.get(i).productId}"
                                           class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${pageContext.request.contextPath}/upload/${newProd.get(i).productImgsByProductId[0].fileName}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${newProd.get(i).name}</h6>
                                                <span>${newProd.get(i).price.intValue()}₫</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="product__discount">
                    <div class="section-title product__discount__title">
                        <h2>Sale Off</h2>
                    </div>
                    <div class="row">
                        <div class="product__discount__slider owl-carousel">

                            <c:forEach var="item" items="${saleProd}">
                                <div class="col-lg-4">
                                    <div class="product__discount__item">
                                        <div class="product__discount__item__pic set-bg"
                                             data-setbg="${pageContext.request.contextPath}/upload/${item.productImgsByProductId[0].fileName}">
                                            <div class="product__discount__percent">
                                                -${String.format("%.0f",(item.price - item.promotionalPrice )/item.price )}%
                                            </div>
                                            <ul class="product__item__pic__hover">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/product?id=${item.productId}"><i
                                                            class="fa fa-shopping-cart"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="product__discount__item__text">
                                            <span>${item.name}</span>
                                            <h5><a href="#">${item.categoryByCategoryId.name}</a></h5>
                                            <div class="product__item__price">${String.format("%.0f",prod.promotionalPrice)}
                                                <span>${String.format("%.0f",prod.price)}₫</span></div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="filter__sort">
                                <span>Sort By</span>
                                <select id="sortBy">
                                    <option value="0">default</option>
                                    <option value="1">asc</option>
                                    <option value="2">desc</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4">
                            <div class="filter__found">
                                <h6><span>${size}</span> Products found</h6>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <c:forEach var="item" items="${prods}">
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg"
                                     data-setbg="${pageContext.request.contextPath}/upload/${item.productImgsByProductId[0].fileName}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="${pageContext.request.contextPath}/product?id=${item.productId}"><i
                                                class="fa fa-shopping-cart"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${item.name}</a></h6>
                                    <h5>${item.price.intValue()}₫</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="product__pagination">
                    <c:if test="${tag>0}">
                        <a href="product?page=${tag-1}"><i class="fa fa-long-arrow-left"></i></a>
                    </c:if>
                    <c:forEach begin="0" end="${endPage}" var="i">
                        <a
                                class=" ${tag==i ? "active-page" : ""}"
                                href="product?page=${i}">${i+1}</a>
                    </c:forEach>
                    <c:if test="${tag<endPage}">
                        <a href="product?page=${tag+1}"><i class="fa fa-long-arrow-right"></i></a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>


<c:import url="footer.jsp"></c:import>


<%--<script>
  const inc = document.querySelector(".inc");
  const dec = document.querySelector(".dec");
  const submit = document.getElementById("btn-submit")
  const max = document.getElementById("max-amount").textContent
  if (inc) {
    inc.addEventListener('click', (e) => {
      const arr = submit.href.split("=")
      if (parseInt(arr[1]) <= parseInt(max))
        submit.href = arr[0] + `=${parseInt(arr[1]) + 1}`;
    })
  }
  if (dec) {
    dec.addEventListener('click', (e) => {
      const arr = submit.href.split("=")
      if (parseInt(arr[1]) > 0)
        submit.href = arr[0] + `=${parseInt(arr[1]) - 1}`;
    })
  }
--%>
</script>
</body>

</html>
