<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Latipe - Đăng nhập</title>
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
<c:import url="header.jsp"></c:import>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="view/web/assets/img/bread.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Đăng Nhập</h2>
                    <div class="breadcrumb__option">
                        <a href="home">Home</a>
                        <span>Đăng Nhập</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->


<!-- Contact Form Begin -->
<section class="mt-md-5">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="login" method="post">
                    <!-- Message -->
                    <c:if test="${status eq false}">
                        <div class="alert alert-danger" role="alert">
                            Đăng nhập thất bại kiểm tra tài khoản và mật khẩu.
                        </div>
                    </c:if>
                    <c:if test="${status eq true}">
                        <div class="alert alert-danger" role="alert">
                            Tạo tài khoản thành công đăng nhập lại !
                        </div>
                    </c:if>
                    <!-- Email input -->
                    <div class="form-outline mb-4">

                        <input name="email" type="email" id="form3Example3" class="form-control form-control-lg"
                               placeholder="Email của tài khoản"/>

                    </div>
                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input name="password" type="password" id="form3Example4" class="form-control form-control-lg"
                               placeholder="Mật khẩu"/>
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-0">

                        </div>
                        <a href="${pageContext.request.contextPath}/forgotPassword" class="text-body">Quên mật khẩu</a>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem; background-color: #00D852; color: #fff;">
                            Đăng
                            nhập
                        </button>

                        <p class="small fw-bold mt-2 pt-1 mb-0"><a href="#" class="link-danger">Đăng ký tài
                            khoản</a></p>
                    </div>

                </form>
            </div>
        </div>
    </div>
</section>
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
<c:import url="footer.jsp"></c:import>


</body>

</html>