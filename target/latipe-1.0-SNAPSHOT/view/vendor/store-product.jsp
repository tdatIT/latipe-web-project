<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Quản lý sản phẩm - Laptipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/vendor/assets/css/adminx.css"
          media="screen"/>
</head>
<body>
<div class="adminx-container">
    <!-- Header -->
    <nav class="navbar navbar-expand justify-content-between fixed-top">
        <a class="navbar-brand mb-0 h1 d-none d-md-block" href="store-management.html">
            <img src="${pageContext.request.contextPath}/view/web/assets/img/favicon.png"
                 class="navbar-brand-image d-inline-block align-top mr-2" alt="">
            Latipe - ${sessionScope.store.name}
        </a>

        <form class="form-inline form-quicksearch d-none d-md-block mx-auto">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-icon">
                        <i data-feather="search"></i>
                    </div>
                </div>
                <input type="text" class="form-control" id="search" placeholder="Tìm kiếm...">
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
                                <strong>Laura</strong></p>

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
                    <img src="${pageContext.request.contextPath}/upload/${sessionScope.store.avatar}"
                         class="d-inline-block align-top" alt="">
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Xin chào ${sessionScope.lastname}</a>
                    <a class="dropdown-item" href="#">Thông tin của hàng</a>
                    <a class="dropdown-item" href="#">Cài đặt</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item text-danger" href="#">Đăng xuất</a>
                </div>
            </li>
        </ul>
    </nav>
    <!-- // Header -->

    <!-- Sidebar -->
    <div class="adminx-sidebar expand-hover push">
        <ul class="sidebar-nav">
            <li class="sidebar-nav-item">
                <a href="${pageContext.request.contextPath}/store-admin/dashboard" class="sidebar-nav-link">
                    <span class="sidebar-nav-icon">
                        <i data-feather="home"></i>
                    </span><span class="sidebar-nav-name">Trang Chủ</span>
                    <span class="sidebar-nav-end"></span>
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
                <a href="${pageContext.request.contextPath}/store-admin/product" class="sidebar-nav-link">
                    <span class="sidebar-nav-icon">
                        <i data-feather="product"></i>
                    </span><span class="sidebar-nav-name">Sản phẩm</span>
                    <span class="sidebar-nav-end"></span>
                </a>
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
                <a href="store-management.html" class="sidebar-nav-link">
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
    </div>
    <!-- Sidebar End -->


    <!-- Main Content -->
    <div class="adminx-content">
        <div class="adminx-main-content">
            <div class="container-fluid">
                <!-- BreadCrumb -->
                <nav aria-label="breadcrumb" role="navigation">
                    <ol class="breadcrumb adminx-page-breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="#">Quản lý sản phẩm</a></li>
                        <li class="breadcrumb-item active  aria-current=" page
                        ">Bảng</li>
                    </ol>
                </nav>

                <div class="pb-3">
                    <h1>Doanh mục</h1>
                </div>


                <div class="row">
                    <div class="col">
                        <div class="card mb-grid">
                            <div class="table-responsive-md">
                                <table class="table table-actions table-striped table-hover mb-0" data-table>
                                    <thead>
                                    <tr>
                                        <th scope="col">
                                            <label class="custom-control custom-checkbox m-0 p-0">
                                                <input type="checkbox" class="custom-control-input table-select-all">
                                                <span class="custom-control-indicator"></span>
                                            </label>
                                        </th>
                                        <th scope="col">ID</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Giá</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Chức năng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${product}" var="i">
                                        <tr>
                                            <th scope="row">
                                                <label class="custom-control custom-checkbox m-0 p-0">
                                                    <input type="checkbox"
                                                           class="custom-control-input table-select-row">
                                                    <span class="custom-control-indicator"></span>
                                                </label>
                                            </th>
                                            <td>${i.productId}</td>
                                            <td>${i.name}</td>
                                            <td>${i.quantity}</td>
                                            <td>${i.price.intValue()}</td>
                                            <c:if test="${i.active eq true}">
                                                <td>
                                                    <span class="badge badge-pill badge-primary">Hoạt động</span>
                                                </td>
                                            </c:if>
                                            <c:if test="${i.active ne true}">
                                                <td>
                                                    <span class="badge badge-pill badge-danger">Dừng</span>
                                                </td>
                                            </c:if>
                                            <td>
                                                <button class="btn btn-sm btn-primary">Chỉnh sửa</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- // Main Content -->
</div>

<!-- If you prefer jQuery these are the required scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/vendor.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/adminx.js"></script>
<script>
    $(document).ready(function () {
        var table = $('[data-table]').DataTable({
            "columns": [
                null,
                null,
                null,
                null,
                null,
                null,
                {"orderable": false}
            ]
        });

        /* $('.form-control-search').keyup(function(){
          table.search($(this).val()).draw() ;
        }); */
    });
</script>

<!-- If you prefer vanilla JS these are the only required scripts -->
<!-- script src="assets/js/vendor.js"></script>
<script src="assets/js/adminx.vanilla.js"></script-->
</body>
</html>