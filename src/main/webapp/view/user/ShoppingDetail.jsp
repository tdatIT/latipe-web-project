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
  <meta charset="UTF-8" />
  <meta name="description" content="Ogani Template" />
  <meta name="keywords" content="Ogani, unica, creative, html" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Ogani | Template</title>

  <!-- Google Font -->
  <link
          href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
          rel="stylesheet"
  />
  <%--  //${pageContext.request.contextPath}/view/vendor/assets--%>
  <!-- Css Styles -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/bootstrap.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/elegant-icons.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/nice-select.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/owl.carousel.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/slicknav.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/style.css" type="text/css" />


</head>

<c:import url="header.jsp"></c:import>


<body>
<!-- Page Preloder -->
<%--<div id="preloder">
  <div class="loader"></div>
</div>--%>

<!-- Humberger Begin -->

<!-- Humberger End -->

<!-- Header Section Begin -->
<!-- Hero Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/bread.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-4 text-center">
        <div class="breadcrumb__text">
          <h2>Phong Vũ</h2>
          <div class="breadcrumb__option">
            <a href="/store?id=?????/">Home</a>
            <span>Mall</span>
          </div>
        </div>
      </div>
      <div class="blog__details__content col-lg-8">
        <div class="row">
          <div class="col-lg-5">
            <div class="blog__details__author">
              <div class="blog__details__author__pic">
                <img src="${pageContext.request.contextPath}/assets/img/blog/details/details-author.png" alt="">
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
                <li><span>Doanh mục sản phẩm: </span> Food</li>
                <li><span>Hoạt động: </span>12 Tháng</li>
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
                 src="${pageContext.request.contextPath}/assets/img/product/details/product-details-1.jpg" alt="">
          </div>
          <!-- sub image -->
          <!-- cac anh phu la anh tu vi tri 1 -->
          <div class="product__details__pic__slider owl-carousel">
            <c:forEach  var="item" items="${prod.productImgsByProductId}">
            <img data-imgbigurl="${pageContext.request.contextPath}/assets/img/product/details/product-details-2.jpg"
                 src="assets/img/product/details/thumb-1.jpg" alt="">
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
          <div class="product__details__price"><del>${String.format("%.0f",prod.price)}</del>         ${String.format("%.0f",prod.promotionalPrice)}</div>
          <div class="product__details__quantity">
            <div class="quantity">
<%--              <div class="pro-qty">--%>
<%--                <span class="adec qtybtn">-</span>--%>
<%--                <input class="val-amount" name="number" type="number" value="1" max="4" min="1">--%>
<%--                <span class="ainc qtybtn">+</span>--%>

                <input class="val-amount" name="number" type="number" value="1" max="${prod.quantity}" min="1">
<%--              </div>--%>
            </div>
          </div>
          <!-- link submit   /product/id product?amount=10 -->
          <a href="product/addToCart?prodID=${prod.productId}&quantity=1" class="primary-btn" id="btn-submit">THÊM VÀO GIỎ HÀNG</a>
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
                </script></div>
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
      <div class="col-lg-3 col-md-4 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/view/user/assets/img/product/product-1.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="/product?id=1"><i class="fa fa-shopping-cart"></i></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6><a href="#">Crab Pool Security</a></h6>
            <h5>$30.00</h5>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-4 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/view/user/assets/img/product/product-2.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="/product?id=1"><i class="fa fa-shopping-cart"></i></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6><a href="#">Crab Pool Security</a></h6>
            <h5>$30.00</h5>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-4 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/view/user/assets/img/product/product-3.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="/product?id=1"><i class="fa fa-shopping-cart"></i></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6><a href="#">Crab Pool Security</a></h6>
            <h5>$30.00</h5>
          </div>
        </div>
      </div>
      <div class="col-lg-3 col-md-4 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/view/user/assets/img/product/product-7.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="/product?id=1"><i class="fa fa-shopping-cart"></i></a></li>
            </ul>
          </div>
          <div class="product__item__text">
            <h6><a href="#">Crab Pool Security</a></h6>
            <h5>$30.00</h5>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Related Product Section End -->

<!-- Footer Section Begin -->
<footer class="footer spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="footer__about">
          <div class="footer__about__logo">
            <a href="./index.html"><img src="assets\img\logo.png" alt=""></a>
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
          <div class="footer__copyright__payment"><img src="assets\img\payment-item.png" alt=""></div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/main.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/addCart.js"></script>

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
