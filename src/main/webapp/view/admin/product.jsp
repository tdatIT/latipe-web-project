<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" lang="en"
      class="light-style layout-navbar-fixed layout-menu-fixed"
      dir="ltr"
      data-theme="theme-default"
      data-assets-path="../view/admin/assets/"
      data-template="vertical-menu-template-no-customizer">
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Dashboard - Analytics | Frest - Bootstrap Admin Template</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="../view/admin/assets/img/favicon/favicon.ico"/>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Rubik:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons -->
    <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/boxicons.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/fontawesome.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/flag-icons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="../view/admin/assets/vendor/css/rtl/core.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/css/rtl/theme-default.css"/>
    <link rel="stylesheet" href="../view/admin/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/typeahead-js/typeahead.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/apex-charts/apex-charts.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/flatpickr/flatpickr.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/bootstrap-datepicker/bootstrap-datepicker.css"/>
    <link
            rel="stylesheet"
            href="../view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.css"
    />
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.css"/>
    <link rel="stylesheet" href="../view/admin/assets/vendor/libs/pickr/pickr-themes.css"/>
    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="../view/admin/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="../view/admin/assets/js/config.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.36.3/apexcharts.min.js"
            integrity="sha512-sa449wQ9TM6SvZV7TK7Zx/SjVR6bc7lR8tRz1Ar4/R6X2jOLaFln/9C+6Ak2OkAKZ/xBAKJ94dQMeYa0JT1RLg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->

        <c:import url="header.jsp"></c:import>
        <!-- / Menu -->
        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->
            <nav
                    class="layout-navbar navbar navbar-expand-xl align-items-center bg-navbar-theme"
                    id="layout-navbar"
            >
                <div class="container-fluid">
                    <div class="layout-menu-toggle navbar-nav d-xl-none align-items-xl-center me-3 me-xl-0">
                        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                            <i class="bx bx-menu bx-sm"></i>
                        </a>
                    </div>

                    <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
                        <ul class="navbar-nav flex-row align-items-center ms-auto">
                            <!-- Style Switcher -->
                            <li class="nav-item me-2 me-xl-0">
                                <a class="nav-link style-switcher-toggle hide-arrow" href="javascript:void(0);">
                                    <i class="bx bx-sm"></i>
                                </a>
                            </li>
                            <!--/ Style Switcher -->

                            <!-- User -->
                            <li class="nav-item navbar-dropdown dropdown-user dropdown">
                                <a
                                        class="nav-link dropdown-toggle hide-arrow"
                                        href="javascript:void(0);"
                                        data-bs-toggle="dropdown"
                                >
                                    <div class="avatar avatar-online">
                                        <img src="../view/admin/assets/img/avatars/1.png" alt class="rounded-circle"/>
                                    </div>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end">
                                    <li>
                                        <a class="dropdown-item" href="pages-account-settings-account.html">
                                            <div class="d-flex">
                                                <div class="flex-shrink-0 me-3">
                                                    <div class="avatar avatar-online">
                                                        <img
                                                                src="${pageContext.request.contextPath}/upload/${user.avatar}"
                                                                alt
                                                                class="rounded-circle"
                                                        />
                                                    </div>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <span class="lh-1 d-block fw-semibold">${user.firstname}</span>
                                                    <small>Admin</small>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="dropdown-divider"></div>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/admin/profile">
                                            <i class="bx bx-user me-2"></i>
                                            <span class="align-middle">My Profile</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/admin/setting">
                                            <i class="bx bx-cog me-2"></i>
                                            <span class="align-middle">Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                                            <i class="bx bx-power-off me-2"></i>
                                            <span class="align-middle">Log Out</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <!-- / Navbar -->
            <!-- Content wrapper -->
            <div class="content-wrapper">
                <!-- Content -->

                <div class="container-xxl flex-grow-1 container-p-y">
                    <!-- Users List Table -->
                    <div class="card">
                        <div class="card-header border-bottom">
                            <h5 class="card-title">Search Filter</h5>
                            <div
                                    class="row gap-3 gap-md-0 d-flex justify-content-between align-items-center py-3"
                            >
                                <div class="product_status col-md-4">
                                    <select id="FilterTransaction" class="form-select text-capitalize">
                                        <option value="All" ${option=="0" ? ' selected="selected"' : ''}>All</option>
                                        <option value="Active" ${option=="1" ? ' selected="selected"' : ''}>Active
                                        </option>
                                        <option value="Inactive" ${option=="2" ? ' selected="selected"' : ''}> Inactive
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="card-datatable table-responsive">
                            <div
                                    id="DataTables_Table_0_wrapper"
                                    class="dataTables_wrapper dt-bootstrap5 no-footer"
                            >
                                <div class="row mx-2">
                                    <div class="col-mx-2">
                                        <div
                                                class="dt-action-buttons text-xl-end text-xl-start text-md-end text-start d-flex justify-content-between"
                                        >
                                            <div
                                                    class="dataTables_filter"
                                                    style="margin-right: 50px"
                                            >
                                                <label
                                                ><input
                                                        type="search"
                                                        class="form-control mb-3 mt-3"
                                                        placeholder="Search.."
                                                        aria-controls="DataTables_Table_0"
                                                        id="search_box" ,
                                                        value="${search}"
                                                /></label>
                                                <button type="button" class="dt-button btn btn-primary mb-3 mt-3"
                                                        id="btn-search"
                                                >Search
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- table -->
                                <table
                                        class="datatables-products table border-top dataTable no-footer dtr-column collapsed"
                                        id="DataTables_Table_0"
                                        role="grid"
                                >
                                    <thead>
                                    <tr role="row">
                                        <th
                                                class="control "
                                                rowspan="1"
                                                colspan="1"
                                                style="width: 200px"
                                                aria-label=""
                                        >
                                            Product Id
                                        </th>
                                        <th
                                                class="sorting"
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="User: activate to sort column ascending"
                                                aria-sort="descending"
                                        >
                                            Name
                                        </th>
                                        <th
                                                class="sorting "
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="User: activate to sort column ascending"
                                                aria-sort="descending"
                                        >
                                            Picture
                                        </th>
                                        <th
                                                class="sorting "
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="User: activate to sort column ascending"
                                                aria-sort="descending"
                                        >
                                            Store
                                        </th>
                                        <th
                                                class="sorting "
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="User: activate to sort column ascending"
                                                aria-sort="descending"
                                        >
                                            Category
                                        </th>
                                        <th
                                                class="sorting "
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="User: activate to sort column ascending"
                                                aria-sort="descending"
                                        >
                                            Price
                                        </th>
                                        <th
                                                class=""
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="Role: activate to sort column ascending"
                                        >
                                            Promotional Price
                                        </th>

                                        <th
                                                class=""
                                                tabindex="0"
                                                aria-controls="DataTables_Table_0"
                                                rowspan="1"
                                                colspan="1"
                                                style="width: auto"
                                                aria-label="Role: activate to sort column ascending"
                                        >
                                            Status
                                        </th>
                                        <th
                                                rowspan="1"
                                                colspan="1"
                                                style="width: 100px"
                                                aria-label="Actions"
                                        >
                                            Actions
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody id="action-click">
                                    <c:forEach var="item" items="${products}">
                                        <tr class="odd">
                                            <td class="sorting_1"><a
                                                    href="link toi profile :))">${item.productId}</a></td>
                                            <td class="sorting_1"><a
                                                    href="link toi profile :))">${item.name}</a></td>
                                            <td>
                                                <img style="width: 50px; height: 50px" src="${pageContext.request.contextPath}/upload/${item.productImgsByProductId[0].fileName}" id="image-${item.categoryId}">
                                            </td>
                                            <td>
                                                <div class="d-flex justify-content-start align-items-center">
                                                    <div class="avatar-wrapper">
                                                        <div class="avatar avatar-sm me-3">
                                                            <img
                                                                    src="${pageContext.request.contextPath}/upload/${item.storeByStoreId.avatar}"
                                                                    alt="Avatar"
                                                                    class="rounded-circle"
                                                            />
                                                        </div>
                                                    </div>
                                                    <div class="d-flex flex-column">
                                                        <a
                                                                href="link toi profile :))"
                                                                class="text-body text-truncate"
                                                        ><span class="fw-semibold">${item.storeByStoreId.name}</span></a
                                                        >
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <span class="fw-semibold"
                                                >${item.categoryByCategoryId.name}</span>
                                            </td>
                                            <td>
                                                <span class="fw-semibold"
                                                >${String.format("%.0f", item.price)}</span>
                                            </td>
                                            <td>
                                                <span class="fw-semibold"
                                                >${String.format("%.0f", item.promotionalPrice)}</span>
                                            </td>
                                            <td>
                                                    ${item.isActive() != false ?'<span class="badge bg-label-success"> Active</span>' : '<span class="badge bg-label-secondary"> inactive</span>'                                                        }
                                            </td>
                                            <td style="text-align: center">
                                                <div class="d-inline-block">
                                                    <button
                                                            class="btn btn-sm btn-icon dropdown-toggle hide-arrow"
                                                            data-bs-toggle="dropdown"
                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a
                                                                class="dropdown-item text-success"
                                                                href="product/active?productId=${item.productId}"
                                                        >Active</a
                                                        >
                                                        <div class="dropdown-divider"></div>
                                                        <a
                                                                href="product/delete?productId=${item.productId}"
                                                                class="dropdown-item text-danger delete-record btn-delete"
                                                        >Suspend</a
                                                        >
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- pagination -->
                                <div id="paginate-product" class="row mx-2 mt-2">
                                    <div class="col-12">
                                        <div class="col-sm-12 col-md-6">
                                            <div
                                                    class="paging_simple_numbers"
                                            >
                                                <ul class="pagination">
                                                    <c:if test="${tag>0}">
                                                        <li class="paginate_button page-item previous"><a
                                                                class="page-link"
                                                                href="product?page=${tag-1}"
                                                                tabindex="-1">Previous</a>
                                                        </li>
                                                    </c:if>
                                                    <c:forEach begin="0" end="${endPage}" var="i">
                                                        <li class="page-item paginate_button ${tag==i ? "active" : ""}">
                                                            <a
                                                                    class="page-link"
                                                                    href="product?page=${i}">${i+1}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <c:if test="${tag<endPage}">
                                                        <li class="page-item page-item next"><a class="page-link"
                                                                                                href="product?page=${tag+1}">Next</a>
                                                        </li>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- / Content -->
                <!-- Footer -->
                <c:import url="footer.jsp"></c:import>
                <!-- / Footer -->

                <div class="content-backdrop fade"></div>
            </div>
            <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
    </div>

    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>

    <!-- Drag Target Area To SlideIn Menu On Small Screens -->
    <div class="drag-target"></div>
</div>
<script src="../view/admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../view/admin/assets/vendor/libs/popper/popper.js"></script>
<script src="../view/admin/assets/vendor/js/bootstrap.js"></script>
<script src="../view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../view/admin/assets/vendor/libs/hammer/hammer.js"></script>
<script src="../view/admin/assets/vendor/libs/i18n/i18n.js"></script>
<script src="../view/admin/assets/vendor/libs/typeahead-js/typeahead.js"></script>
<script src="../view/admin/assets/vendor/js/menu.js"></script>
<%--<script src="../view/admin/assets/vendor/libs/apex-charts/apexcharts.js"></script>--%>
<script src="../view/admin/assets/vendor/libs/moment/moment.js"></script>
<script src="../view/admin/assets/vendor/libs/flatpickr/flatpickr.js"></script>
<script src="../view/admin/assets/vendor/libs/bootstrap-datepicker/bootstrap-datepicker.js"></script>
<script src="../view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.js"></script>
<script src="../view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.js"></script>
<script src="../view/admin/assets/vendor/libs/pickr/pickr.js"></script>
<script src="../view/admin/assets/js/main.js"></script>
<%--<script src="../view/admin/assets/js/dashboards-analytics.js"></script>--%>
<%--<script src="../view/admin/assets/js/charts-apex.js"></script>--%>
<script src="../view/admin/js/product.js"></script>
<script src="../view/admin/assets/js/forms-pickers.js"></script>
</body>
</html>
