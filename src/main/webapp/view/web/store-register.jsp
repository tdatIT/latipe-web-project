<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}/view/web/assets" var="contextPath"></c:set>
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
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${contextPath}/css/style.css" type="text/css">
</head>

<body>
<c:import url="header.jsp"></c:import>


<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="view/web/assets/img/bread.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Đăng ký</h2>
                    <div class="breadcrumb__option">
                        <a href="home">Home</a>
                        <span>Đăng ký cửa hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->


<!-- Contact Form Begin -->
<!-- Section: Design Block -->
<section class="">
    <!-- Jumbotron -->
    <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
        <div class="container">
            <div class="row gx-lg-5 align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <h1 class="my-5 display-3 fw-bold ls-tight">
                        Hòa mình vào <br/>
                        <span style="color: #00D852;">thế giới mua sắm</span>
                    </h1>
                    <p style="color: hsl(217, 10%, 50.8%)">
                        Nền tảng thương mại điện tử an toàn - bảo mật - uy tính đãm bảo môi trường buôn bán có lợi
                        cho người bán và người tiêu dùng
                        hãy đăng ký tài khoản ngay để nhận được nhiều ưu đãi của chúng tôi. Chúc bạn có một ngày vui
                        vẻ.
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="card">
                        <div class="card-body py-5 px-md-5">
                            <form action="register-store" method="post" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-md-12 mb-5">
                                        <h4>Nhập vào thông tin cửa hàng</h4>
                                    </div>
                                </div>
                                <c:if test="${status eq false}">
                                    <div class="alert alert-danger" role="alert">
                                        Tạo cửa hàng thất bại, vui lòng nhập lại thông tin
                                    </div>
                                </c:if>
                                <!-- 2 column grid layout with text inputs for the first and last names -->

                                <div class="form-outline mb-4">
                                    <div class="form-outline">
                                        <input name="name" type="text" id="form3Example1"
                                               class="form-control"
                                               placeholder="Tên của hàng" required/>
                                    </div>
                                </div>
                                <div class="form-outline mb-4">
                                    <div class="form-outline">
                                                <textarea name="bio" type="text" id="form3Example2"
                                                          class="form-control"
                                                          placeholder="Mô tả" required></textarea>
                                    </div>
                                </div>

                                <!-- Email input -->
                                <div class="form-outline mb-4">
                                    <label>Ảnh bìa</label>
                                    <input name="cover" type="file" id="form3Example3" class="form-control"
                                           placeholder="Ảnh bìa của store" minlength="8" required/>
                                </div>
                                <!-- Password input -->
                                <div class="form-outline mb-4">
                                    <label>Ảnh đại diện</label>
                                    <input name="avatar" type="file" id="form3Example4" class="form-control"
                                           placeholder="Ảnh đại điện của cửa hàng" minlength="8" required/>
                                </div>
                                <!-- Password input -->
                                <div class="form-outline mb-4">
                                    <label>Ảnh đặt trưng</label>
                                    <input name="featured_image" type="file" id="form3Example5"
                                           class="form-control"
                                           placeholder="Ảnh feature" required/>

                                </div>
                                <!-- Submit button -->
                                <button type="submit" class="btn btn-block mb-4"
                                        style="background-color: #00D852; color: #fff;">
                                    Đăng ký ngay
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Jumbotron -->
</section>
<!-- Section: Design Block -->
<!-- Contact Form End -->

<!-- Contact Section Begin -->
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
<!-- Footer Section End -->

<c:import url="footer.jsp"></c:import>



</body>

</html>