<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
  <meta charset="UTF-8">
  <meta name="description" content="Ogani Template">
  <meta name="keywords" content="Ogani, unica, creative, html">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="icon" type="image/x-icon" href="view/web/assets/img/favicon.png">
  <title>Latipe - Đăng ký tài khoản</title>

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

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="view/assets/img/bread.jpg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <div class="breadcrumb__text">
          <h2>Quên mật khẩu</h2>

        </div>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->
<div class="row mt-5">
  <div class="col-lg-12 d-flex justify-content-center">

    <div class="hero__search__form ">
      <form action="#">
        <input type="text" placeholder="Nhập vào email">
        <button type="submit" class="site-btn">Tìm lại tài khoản</button>
      </form>
    </div>
  </div>
</div>





< <!-- Contact Section Begin -->
<section class="contact spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_phone"></span>
          <h4>SĐT</h4>
          <p>1900 1099</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_pin_alt"></span>
          <h4>Văn phòng</h4>
          <p>1900 1099</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_clock_alt"></span>
          <h4>Hỗ trợ</h4>
          <p>24/7 Mọi lúc</p>
        </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-6 text-center">
        <div class="contact__widget">
          <span class="icon_mail_alt"></span>
          <h4>Email hỗ trợ</h4>
          <p>f-prj-web@utefit.com</p>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Contact Section End -->

<c:import url="footer.jsp"></c:import>


</body>

</html>