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
<html lang=vi">

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

    .disabled {
        pointer-events: none;
        cursor: default;
        opacity: 0.6;
    }
</style>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/bread.jpg">
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
<div class=" mt-5 mb-10" style="margin-bottom: 20px; align-items: center; text-align: center">
    <h5 style=" color: red;">Sau khi nhập email người dùng vào kiểm tra trong hòm thư hoặc spam để lấy email mới trường hợp email không
        tồn tại sẻ báo lỗi</h5>
</div>
<!-- Breadcrumb Section End -->
<div class="row mt-5 mb-10" style="margin-bottom: 20px">
    <div class="col-lg-12 d-flex justify-content-center">

        <div class="hero__search__form ">
            <form action="forgotPassword" method="post">
                <input type="text" placeholder="Nhập vào email" name="email" required>
                <button type="submit" class="site-btn">Tìm lại tài khoản</button>
            </form>
        </div>
    </div>
</div>

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
            <div class="col-lg-4 col-md-12 ">
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
<script src="${pageContext.request.contextPath}/view/user/assets/js/search.js"></script>
<script src="${pageContext.request.contextPath}/view/user/assets/js/cart.js"></script>
</script>
</body>

</html>
