<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard - Laptipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/vendor/assets/css/adminx.css" media="screen"/>
</head>
<body>
<div class="adminx-container">
    <nav class="navbar navbar-expand justify-content-between fixed-top">
        <a class="navbar-brand mb-0 h1 d-none d-md-block" href="store-management.html">
            <img src="${pageContext.request.contextPath}/view/web/assets/img/favicon.png" class="navbar-brand-image d-inline-block align-top mr-2" alt="">
            Quản Lý Cửa Hàng
        </a>

        <form class="form-inline form-quicksearch d-none d-md-block mx-auto">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-icon">
                        <i data-feather="search"></i>
                    </div>
                </div>
                <input type="text" class="form-control" id="search" placeholder="Type to search...">
            </div>
        </form>

        <div class="d-flex flex-1 d-block d-md-none">
            <a href="#" class="sidebar-toggle ml-3">
                <i data-feather="menu"></i>
            </a>
        </div>

        <ul class="navbar-nav d-flex justify-content-end mr-2">
            <!-- Notificatoins -->
            <li class="nav-item dropdown d-flex align-items-center mr-2">
                <a class="nav-link nav-link-notifications" id="dropdownNotifications" data-toggle="dropdown" href="#">
                    <i class="oi oi-bell display-inline-block align-middle"></i>
                    <span class="nav-link-notification-number">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-notifications"
                     aria-labelledby="dropdownNotifications">
                    <div class="notifications-header d-flex justify-content-between align-items-center">
              <span class="notifications-header-title">
                Notifications
              </span>
                        <a href="#" class="d-flex"><small>Mark all as read</small></a>
                    </div>

                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action unread">
                            <p class="mb-1">Invitation for <strong>Lunch</strong> on <strong>Jan 12th 2018</strong> by
                                <strong>Laura</strong>
                            </p>

                            <div class="mb-1">
                                <button type="button" class="btn btn-primary btn-sm">Accept invite</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Decline</button>
                            </div>

                            <small>1 hour ago</small>
                        </a>

                        <a href="#" class="list-group-item list-group-item-action">
                            <p class="mb-1"><strong class="text-success">Goal completed</strong><br/>1,000 new members
                                today</p>
                            <small>3 days ago</small>
                        </a>

                        <a href="#" class="list-group-item list-group-item-action">
                            <p class="mb-1 text-danger"><strong>System error detected</strong></p>
                            <small>3 days ago</small>
                        </a>

                        <a href="#" class="list-group-item list-group-item-action">
                            <p class="mb-1">Your task <strong>Design Draft</strong> is due today.</p>
                            <small>4 days ago</small>
                        </a>
                    </div>

                    <div class="notifications-footer text-center">
                        <a href="#"><small>View all notifications</small></a>
                    </div>
                </div>
            </li>
            <!-- Notifications -->
            <li class="nav-item dropdown">
                <a class="nav-link avatar-with-name" id="navbarDropdownMenuLink" data-toggle="dropdown" href="#">
                    <img src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"
                         class="d-inline-block align-top"
                         alt="">
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">My Profile</a>
                    <a class="dropdown-item" href="#">My Tasks</a>
                    <a class="dropdown-item" href="#">Settings</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item text-danger" href="#">Sign out</a>
                </div>
            </li>
        </ul>
    </nav>

    <!-- expand-hover push -->
    <!-- Sidebar -->
    <div class="adminx-sidebar expand-hover push">
        <ul class="sidebar-nav">
            <li class="sidebar-nav-item">
                <a href="store-management.html" class="sidebar-nav-link active">
            <span class="sidebar-nav-icon">
              <i data-feather="home"></i>
            </span>
                    <span class="sidebar-nav-name">
              Trang Chủ
            </span>
                    <span class="sidebar-nav-end">

            </span>
                </a>
            </li>

            <li class="sidebar-nav-item">
                <a href="#" class="sidebar-nav-link">
            <span class="sidebar-nav-icon">
              <i data-feather="layout"></i>
            </span>
                    <span class="sidebar-nav-name">
              Phân tích
            </span>
                    <span class="sidebar-nav-end">
              <span class="badge badge-info">4</span>
            </span>
                </a>
            </li>

            <li class="sidebar-nav-item">
                <a class="sidebar-nav-link collapsed" data-toggle="collapse" href="#example" aria-expanded="false"
                   aria-controls="example">
            <span class="sidebar-nav-icon">
              <i data-feather="pie-chart"></i>
            </span>
                    <span class="sidebar-nav-name">
              Sản Phẩm
            </span>
                    <span class="sidebar-nav-end">
              <i data-feather="chevron-right" class="nav-collapse-icon"></i>
            </span>
                </a>

                <ul class="sidebar-sub-nav collapse" id="example">
                    <li class="sidebar-nav-item">
                        <a href="./layouts/charts_chartjs.html" class="sidebar-nav-link">
                <span class="sidebar-nav-abbr">
                  SP
                </span>
                            <span class="sidebar-nav-name">
                  Sản Phẩm
                </span>
                        </a>
                    </li>

                    <li class="sidebar-nav-item">
                        <a href="./layouts/charts_morris.html" class="sidebar-nav-link">
                <span class="sidebar-nav-abbr">
                  CA
                </span>
                            <span class="sidebar-nav-name">
                  Doanh Mục
                </span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-item">
                <a class="sidebar-nav-link collapsed" data-toggle="collapse" href="#navTables" aria-expanded="false"
                   aria-controls="navTables">
            <span class="sidebar-nav-icon">
              <i data-feather="align-justify"></i>
            </span>
                    <span class="sidebar-nav-name">
              Bán hàng
            </span>
                    <span class="sidebar-nav-end">
              <i data-feather="chevron-right" class="nav-collapse-icon"></i>
            </span>
                </a>

                <ul class="sidebar-sub-nav collapse" id="navTables">
                    <li class="sidebar-nav-item">
                        <a href="./layouts/tables.html" class="sidebar-nav-link">
                <span class="sidebar-nav-abbr">
                  OR
                </span>
                            <span class="sidebar-nav-name">
                  Đơn Hàng
                </span>
                        </a>
                    </li>

                    <li class="sidebar-nav-item">
                        <a href="./layouts/tables_data.html" class="sidebar-nav-link">
                <span class="sidebar-nav-abbr">
                  SH
                </span>
                            <span class="sidebar-nav-name">
                  Vận chuyển
                </span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-item">
                <a href="store-management.html" class="sidebar-nav-link active">
            <span class="sidebar-nav-icon">
              <i data-feather="home"></i>
            </span>
                    <span class="sidebar-nav-name">
              Nhân viên
            </span>
                    <span class="sidebar-nav-end">

            </span>
                </a>
        </ul>
    </div><!-- Sidebar End -->

    <!-- adminx-content-aside -->
    <div class="adminx-content">
        <!-- <div class="adminx-aside">

          </div> -->

        <div class="adminx-main-content">
            <div class="container-fluid">
                <!-- BreadCrumb -->
                <nav aria-label="breadcrumb" role="navigation">
                    <ol class="breadcrumb adminx-page-breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Trang Chủ</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                    </ol>
                </nav>

                <div class="pb-3">
                    <h1>Dashboard</h1>
                </div>

                <div class="row">
                    <div class="col-md-6 col-lg-3 d-flex">
                        <div class="card mb-grid w-100">
                            <div class="card-body d-flex flex-column">
                                <div class="d-flex justify-content-between mb-3">
                                    <h5 class="card-title mb-0">
                                        Doanh thu
                                    </h5>

                                    <div class="card-title-sub">
                                        $753.82
                                    </div>
                                </div>

                                <div class="progress mt-auto">
                                    <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75"
                                         aria-valuemin="0" aria-valuemax="100">3/4
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 d-flex">
                        <div class="card mb-grid w-100">
                            <div class="card-body d-flex flex-column">
                                <div class="d-flex justify-content-between mb-3">
                                    <h5 class="card-title mb-0">
                                        Nhân viên hoạt động
                                    </h5>

                                    <div class="card-title-sub">
                                        18/30
                                    </div>
                                </div>

                                <div class="progress mt-auto">
                                    <div class="progress-bar" role="progressbar" style="width: 60%;" aria-valuenow="75"
                                         aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 d-flex">
                        <div class="card border-0 bg-primary text-white text-center mb-grid w-100">
                            <div class="d-flex flex-row align-items-center h-100">
                                <div class="card-icon d-flex align-items-center h-100 justify-content-center">
                                    <i data-feather="shopping-cart"></i>
                                </div>
                                <div class="card-body">
                                    <div class="card-info-title">Đơn hàng chưa xử lý</div>
                                    <h3 class="card-title mb-0">
                                        768
                                    </h3>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 d-flex">
                        <div class="card border-0 bg-success text-white text-center mb-grid w-100">
                            <div class="d-flex flex-row align-items-center h-100">
                                <div class="card-icon d-flex align-items-center h-100 justify-content-center">
                                    <i data-feather="user"></i>
                                </div>
                                <div class="card-body">
                                    <div class="card-info-title">Số lượt mua trong tháng</div>
                                    <h3 class="card-title mb-0">
                                        1,258
                                    </h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <div class="card-header-title">Thông tin hoạt động</div>

                                <nav class="card-header-actions">
                                    <a class="card-header-action" data-toggle="collapse" href="#card1"
                                       aria-expanded="false"
                                       aria-controls="card1">
                                        <i data-feather="minus-circle"></i>
                                    </a>

                                    <div class="dropdown">
                                        <a class="card-header-action" href="#" role="button" id="card1Settings"
                                           data-toggle="dropdown"
                                           aria-haspopup="true" aria-expanded="false">
                                            <i data-feather="settings"></i>
                                        </a>

                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="card1Settings">
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>

                                    <a href="#" class="card-header-action">
                                        <i data-feather="x-circle"></i>
                                    </a>
                                </nav>
                            </div>
                            <div class="card-body collapse show" id="card1">
                                <h4 class="card-title">Có 250 đơn hàng đã xử lý</h4>
                                <p class="card-text">150 Khách hàng xem cửa hàng, Doanh thu 12 000 000</p>
                                <a href="#" class="btn btn-primary">Xem phân tích</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                Thông báo
                            </div>
                            <div class="card-body">
                                <h4 class="card-title">Nội dung thông báo</h4>
                                <p class="card-text">With supporting text below as a natural lead-in to additional
                                    content.</p>
                                <a href="#" class="btn btn-primary">Đã đọc</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- If you prefer jQuery these are the required scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/vendor.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/adminx.js"></script>

<!-- If you prefer vanilla JS these are the only required scripts -->
<!-- script src="assets/js/vendor.js"></script>
<script src="assets/js/adminx.vanilla.js"></script-->
</body>
</html>