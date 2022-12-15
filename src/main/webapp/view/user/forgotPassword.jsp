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
    <h5 style=" color: red;">Sau khi nhập email người dùng vào kiểm tra trong hòm thư hoặc spam để lấy password mới trường hợp email không
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


<!-- Js Plugins -->
<c:import url="footer.jsp"></c:import>
</body>

</html>
