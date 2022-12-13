<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/12/2022
  Time: 9:23 PM
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
<%--<div id="preloder">
  <div class="loader"></div>
</div>--%>

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
      <li><a href="#">Pages</a>
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
              <a href="signin.html"><i class="fa fa-sign-in" style="margin-right:5px ;"></i>Đăng
                Nhập</a>

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
          <a href="./index.html"><img src="assets\img\language.png" alt=""></a>
        </div>
      </div>
      <!-- gan so luong toi da san pham -->
      <div style="visibility: hidden;" id="max-amount"> ${max_amount}</div>
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
<section class="breadcrumb-section set-bg" data-setbg="img/bread.jpg">
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
                 src="assets\img\product\details\product-details-1.jpg" alt="">
          </div>
          <!-- sub image -->
          <!-- cac anh phu la anh tu vi tri 1 -->
          <div class="product__details__pic__slider owl-carousel">
            <img data-imgbigurl="assets\img\product\details\product-details-2.jpg"
                 src="assets\img\product\details\thumb-1.jpg" alt="">
            <img data-imgbigurl="assets\img\product\details\product-details-3.jpg"
                 src="assets\img\product\details\thumb-2.jpg" alt="">
            <img data-imgbigurl="assets\img\product\details\product-details-5.jpg"
                 src="assets\img\product\details\thumb-3.jpg" alt="">
            <img data-imgbigurl="assets\img\product\details\product-details-4.jpg"
                 src="assets\img\product\details\thumb-4.jpg" alt="">
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-6">
        <div class="product__details__text">
          <h3>${ tên_sản_phẩm }</h3>
          <div class="product__details__rating">
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star"></i>
            <i class="fa fa-star-half-o"></i>
            <span>(${count_review} reviews)</span>
          </div>
          <div class="product__details__price"><del>${promote_price}</del> ${ gia_san_pham }</div>
          <div class="product__details__quantity">
            <div class="quantity">
              <div class="pro-qty">
                <input class="val-amount" type="text" value="1">
              </div>
            </div>
          </div>
          <!-- link submit   /product/id product?amount=10 -->
          <a href="/product/id product?amount=1" class="primary-btn" id="btn-submit">THÊM VÀO GIỎ HÀNG</a>
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
                <p>${mo_ta}.</p>
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
      <div class="col-lg-3 col-md-4 col-sm-6">
        <div class="product__item">
          <div class="product__item__pic set-bg" data-setbg="assets/img/product/product-1.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="#"><i class="fa fa-heart"></i></a></li>
              <li><a href="#"><i class="fa fa-retweet"></i></a></li>
              <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
          <div class="product__item__pic set-bg" data-setbg="assets/img/product/product-2.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="#"><i class="fa fa-heart"></i></a></li>
              <li><a href="#"><i class="fa fa-retweet"></i></a></li>
              <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
          <div class="product__item__pic set-bg" data-setbg="assets/img/product/product-3.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="#"><i class="fa fa-heart"></i></a></li>
              <li><a href="#"><i class="fa fa-retweet"></i></a></li>
              <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
          <div class="product__item__pic set-bg" data-setbg="assets/img/product/product-7.jpg">
            <ul class="product__item__pic__hover">
              <li><a href="#"><i class="fa fa-heart"></i></a></li>
              <li><a href="#"><i class="fa fa-retweet"></i></a></li>
              <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
