<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/6/2022
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
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

<body>
<!-- Page Preloder -->
<div id="preloder">
  <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
  <div class="humberger__menu__logo">
    <a href="#"><img src="assets\img\logo.png" alt=""></a>
  </div>
  <div class="humberger__menu__cart">
    <ul>
      <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
      <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
    </ul>
    <div class="header__cart__price">item: <span>$150.00</span></div>
  </div>
  <div class="humberger__menu__widget">
    <div class="header__top__right__language">
      <img src="assets\img\language.png" alt="">
      <div>English</div>
      <span class="arrow_carrot-down"></span>
      <ul>
        <li><a href="#">Spanis</a></li>
        <li><a href="#">English</a></li>
      </ul>
    </div>
    <div class="header__top__right__auth">
      <a href="#"><i class="fa fa-user"></i> Login</a>
    </div>
  </div>
  <nav class="humberger__menu__nav mobile-menu">
    <ul>
      <li class="active"><a href="./index.html">Home</a></li>
      <li><a href="./shop-grid.html">Shop</a></li>
      <li>
        <a href="#">Pages</a>
        <ul class="header__menu__dropdown">
          <li><a href="./shop-details.html">Shop Details</a></li>
          <li><a href="./shoping-cart.html">Shoping Cart</a></li>
          <li><a href="./checkout.html">Check Out</a></li>
          <li><a href="./blog-details.html">Blog Details</a></li>
        </ul>
      </li>
      <li><a href="./blog.html">Blog</a></li>
      <li><a href="./contact.html">Contact</a></li>
    </ul>
  </nav>
  <div id="mobile-menu-wrap"></div>
  <div class="header__top__right__social">
    <a href="#"><i class="fa fa-facebook"></i></a>
    <a href="#"><i class="fa fa-twitter"></i></a>
    <a href="#"><i class="fa fa-linkedin"></i></a>
    <a href="#"><i class="fa fa-pinterest-p"></i></a>
  </div>
  <div class="humberger__menu__contact">
    <ul>
      <li><i class="fa fa-envelope"></i> f-prj-web@utefit.com</li>
      <li>Free Shipping for all Order of $99</li>
    </ul>
  </div>
</div>
<!-- Humberger End -->
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
            <a href="./index.html"><img src="assets\img\logo.png" alt=""></a>
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
<!-- Hero Section End -->
<!-- Breadcrumb Section Begin -->
<%--<section class="breadcrumb-section" style="background-image: url('./assets/img/bread.jpg') !important;">
  <div class="container">
    <div class="row">
      <div class="col-lg-4 text-center">
        <div class="breadcrumb__text">
          <h2>Phong Vũ</h2>
          <div class="breadcrumb__option">
            <a href="./index.html">Home</a>
            <span>Mall</span>
          </div>
        </div>
      </div>
      <div class="blog__details__content col-lg-8">
        <div class="row">
          <div class="col-lg-5">
            <div class="blog__details__author">
              <div class="blog__details__author__pic">
                <img src="assets\img\blog\details\details-author.png" alt="">
              </div>
              <div class="blog__details__author__text">
                <h6>Phong Vũ Store</h6>
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
--%>
<!-- Breadcrumb Section End -->
<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="shoping__cart__table">
          <table>
            <thead>
            <tr>
              <th class="shoping__product">Sản phẩm</th>
              <th>Giá cả </th>
              <th>Số lượng </th>
              <th>Tổng cộng</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td class="shoping__cart__item">
                <img src="assets/img/cart/cart-1.jpg" alt="">
                <h5>Vegetable’s Package</h5>
              </td>
              <td class="shoping__cart__price">
                $55.00
              </td>
              <td class="shoping__cart__quantity">
                <div class="quantity">
                  <div class="pro-qty">
                    <input type="text" value="1">
                  </div>
                </div>
              </td>
              <td class="shoping__cart__total">
                $110.00
              </td>
              <td class="shoping__cart__item__close">
                <span class="icon_close"></span>
              </td>
            </tr>
            <tr>
              <td class="shoping__cart__item">
                <img src="assets/img/cart/cart-2.jpg" alt="">
                <h5>Fresh Garden Vegetable</h5>
              </td>
              <td class="shoping__cart__price">
                $39.00
              </td>
              <td class="shoping__cart__quantity">
                <div class="quantity">
                  <div class="pro-qty">
                    <input type="text" value="1">
                  </div>
                </div>
              </td>
              <td class="shoping__cart__total">
                $39.99
              </td>
              <td class="shoping__cart__item__close">
                <span class="icon_close"></span>
              </td>
            </tr>
            <tr>
              <td class="shoping__cart__item">
                <img src="assets/img/cart/cart-3.jpg" alt="">
                <h5>Organic Bananas</h5>
              </td>
              <td class="shoping__cart__price">
                $69.00
              </td>
              <td class="shoping__cart__quantity">
                <div class="quantity">
                  <div class="pro-qty">
                    <input type="text" value="1">
                  </div>
                </div>
              </td>
              <td class="shoping__cart__total">
                $69.99
              </td>
              <td class="shoping__cart__item__close">
                <span class="icon_close"></span>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="shoping__cart__btns">
          <a href="#" class="primary-btn cart-btn">TIẾP TỤC MUA SẮM</a>
          <a href="#" class="primary-btn cart-btn cart-btn-right">
            <span class="icon_loading"></span>
            CẬP NHẬT
          </a>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="shoping__continue">
          <div class="shoping__discount">
            <h5>Mã giảm giá </h5>
            <form action="#">
              <input type="text" placeholder="Enter your coupon code">
              <button type="submit" class="site-btn">ÁP DỤNG</button>
            </form>
          </div>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="shoping__checkout">
          <h5>TỔNG ĐƠN HÀNG</h5>
          <ul>

            <li>Tổng thanh toán<span>$454.98</span></li>
          </ul>
          <a href="#" class="primary-btn">MUA HÀNG</a>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Shoping Cart Section End -->
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
              This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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



</body>

</html>