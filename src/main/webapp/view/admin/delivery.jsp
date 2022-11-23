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

        <%--        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">--%>
        <%--            <div class="app-brand demo">--%>
        <%--                <a href="${pageContext.request.contextPath}/admin" class="app-brand-link">--%>
        <%--                     <span class="app-brand-logo demo">--%>
        <%--                        <svg--%>
        <%--                                width="26px"--%>
        <%--                                height="26px"--%>
        <%--                                viewBox="0 0 26 26"--%>
        <%--                                version="1.1"--%>
        <%--                                xmlns="http://www.w3.org/2000/svg"--%>
        <%--                        >--%>
        <%--                           <title>icon</title>--%>
        <%--                           <defs>--%>
        <%--                              <linearGradient x1="50%" y1="0%" x2="50%" y2="100%" id="linearGradient-1">--%>
        <%--                                 <stop stop-color="#5A8DEE" offset="0%"></stop>--%>
        <%--                                 <stop stop-color="#699AF9" offset="100%"></stop>--%>
        <%--                              </linearGradient>--%>
        <%--                              <linearGradient x1="0%" y1="0%" x2="100%" y2="100%" id="linearGradient-2">--%>
        <%--                                 <stop stop-color="#FDAC41" offset="0%"></stop>--%>
        <%--                                 <stop stop-color="#E38100" offset="100%"></stop>--%>
        <%--                              </linearGradient>--%>
        <%--                           </defs>--%>
        <%--                           <g id="Pages" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">--%>
        <%--                              <g id="Login---V2" transform="translate(-667.000000, -290.000000)">--%>
        <%--                                 <g id="Login" transform="translate(519.000000, 244.000000)">--%>
        <%--                                    <g id="Logo" transform="translate(148.000000, 42.000000)">--%>
        <%--                                       <g id="icon" transform="translate(0.000000, 4.000000)">--%>
        <%--                                          <path--%>
        <%--                                                  d="M13.8863636,4.72727273 C18.9447899,4.72727273 23.0454545,8.82793741 23.0454545,13.8863636 C23.0454545,18.9447899 18.9447899,23.0454545 13.8863636,23.0454545 C8.82793741,23.0454545 4.72727273,18.9447899 4.72727273,13.8863636 C4.72727273,13.5423509 4.74623858,13.2027679 4.78318172,12.8686032 L8.54810407,12.8689442 C8.48567157,13.19852 8.45300462,13.5386269 8.45300462,13.8863636 C8.45300462,16.887125 10.8856023,19.3197227 13.8863636,19.3197227 C16.887125,19.3197227 19.3197227,16.887125 19.3197227,13.8863636 C19.3197227,10.8856023 16.887125,8.45300462 13.8863636,8.45300462 C13.5386269,8.45300462 13.19852,8.48567157 12.8689442,8.54810407 L12.8686032,4.78318172 C13.2027679,4.74623858 13.5423509,4.72727273 13.8863636,4.72727273 Z"--%>
        <%--                                                  id="Combined-Shape"--%>
        <%--                                                  fill="#4880EA"--%>
        <%--                                          ></path>--%>
        <%--                                          <path--%>
        <%--                                                  d="M13.5909091,1.77272727 C20.4442608,1.77272727 26,7.19618701 26,13.8863636 C26,20.5765403 20.4442608,26 13.5909091,26 C6.73755742,26 1.18181818,20.5765403 1.18181818,13.8863636 C1.18181818,13.540626 1.19665566,13.1982714 1.22574292,12.8598734 L6.30410592,12.859962 C6.25499466,13.1951893 6.22958398,13.5378796 6.22958398,13.8863636 C6.22958398,17.8551125 9.52536149,21.0724191 13.5909091,21.0724191 C17.6564567,21.0724191 20.9522342,17.8551125 20.9522342,13.8863636 C20.9522342,9.91761479 17.6564567,6.70030817 13.5909091,6.70030817 C13.2336969,6.70030817 12.8824272,6.72514561 12.5388136,6.77314791 L12.5392575,1.81561642 C12.8859498,1.78721495 13.2366963,1.77272727 13.5909091,1.77272727 Z"--%>
        <%--                                                  id="Combined-Shape2"--%>
        <%--                                                  fill="url(#linearGradient-1)"--%>
        <%--                                          ></path>--%>
        <%--                                          <rect--%>
        <%--                                                  id="Rectangle"--%>
        <%--                                                  fill="url(#linearGradient-2)"--%>
        <%--                                                  x="0"--%>
        <%--                                                  y="0"--%>
        <%--                                                  width="7.68181818"--%>
        <%--                                                  height="7.68181818"--%>
        <%--                                          ></rect>--%>
        <%--                                       </g>--%>
        <%--                                    </g>--%>
        <%--                                 </g>--%>
        <%--                              </g>--%>
        <%--                           </g>--%>
        <%--                        </svg>--%>
        <%--                     </span>--%>
        <%--                    <span class="app-brand-text demo menu-text fw-bold ms-2">Latipe</span>--%>
        <%--                </a>--%>

        <%--                <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto">--%>
        <%--                    <i class="bx menu-toggle-icon fs-4 d-none d-xl-block align-middle"></i>--%>
        <%--                    <i class="bx bx-x bx-sm d-xl-none d-block align-middle"></i>--%>
        <%--                </a>--%>
        <%--            </div>--%>
        <%--            <div class="menu-divider mt-0"></div>--%>
        <%--            <div class="menu-inner-shadow"></div>--%>
        <%--            <!-- Menu -->--%>
        <%--            <ul class="menu-inner py-1">--%>
        <%--                <!-- Dashboards -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-home-circle"></i>--%>
        <%--                        <div data-i18n="Dashboards">Dashboards</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Users -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/user" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-user-circle"></i>--%>
        <%--                        <div>Users</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Store -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="javascript:void(0);" class="menu-link menu-toggle">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-store"></i>--%>
        <%--                        <div>Store</div>--%>
        <%--                    </a>--%>
        <%--                    <ul class="menu-sub">--%>
        <%--                        <li class="menu-item">--%>
        <%--                            <a href="${pageContext.request.contextPath}/admin/store" class="menu-link">--%>
        <%--                                <div data-i18n="List">List</div>--%>
        <%--                            </a>--%>
        <%--                        </li>--%>
        <%--                        <li class="menu-item">--%>
        <%--                            <a href="${pageContext.request.contextPath}/admin/store-level" class="menu-link">--%>
        <%--                                <div>Manage Level</div>--%>
        <%--                            </a>--%>
        <%--                        </li>--%>
        <%--                    </ul>--%>
        <%--                </li>--%>
        <%--                <!-- Transaction -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}admin/transaction" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-food-menu"></i>--%>
        <%--                        <div>Transaction</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Order -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/order" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-layout"></i>--%>
        <%--                        <div>Order</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Category -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/category" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-category"></i>--%>
        <%--                        <div>Category</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Delivery -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/delivery" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-money"></i>--%>
        <%--                        <div>Delivery</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Delivery -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/delivery" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-send"></i>--%>
        <%--                        <div>Delivery</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--                <!-- Product -->--%>
        <%--                <li class="menu-item">--%>
        <%--                    <a href="${pageContext.request.contextPath}/admin/product" class="menu-link">--%>
        <%--                        <i class="menu-icon tf-icons bx bx-send"></i>--%>
        <%--                        <div>Delivery</div>--%>
        <%--                    </a>--%>
        <%--                </li>--%>
        <%--            </ul>--%>
        <%--        </aside>--%>

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
                                <div class="delivery_status col-md-4">
                                    <select id="FilterTransaction" class="form-select text-capitalize">
                                        <option value="All" ${option=="0" ? ' selected="selected"' : ''}>All</option>
                                        <option value="Active" ${option=="1" ? ' selected="selected"' : ''}>Active</option>
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
                                                        id="search_box"
                                                        value="${search}"
                                                /></label>
                                                <button type="button" class="dt-button btn btn-primary mb-3 mt-3"
                                                        id="btn-search"
                                                >Search</button>
                                            </div>

                                            <button
                                                    class="dt-button add-new btn btn-primary mb-3 mt-3"
                                                    tabindex="0"
                                                    aria-controls="DataTables_Table_0"
                                                    type="button"
                                                    data-bs-toggle="offcanvas"
                                                    data-bs-target="#offcanvasAddUser"
                                            >
                                          <span
                                          ><i class="bx bx-plus me-0 me-lg-2"></i
                                          ><span class="d-none d-lg-inline-block"
                                          >Add New Delivery</span
                                          ></span
                                          >
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <!-- table -->
                                <table
                                        class="datatables-users table border-top dataTable no-footer dtr-column collapsed"
                                        id="DataTables_Table_0"
                                        role="grid"
                                >
                                    <thead>
                                    <tr role="row" >
                                        <th
                                                class="control "
                                                rowspan="1"
                                                colspan="1"
                                                style="width: 200px"
                                                aria-label=""
                                        >
                                            Delivery Id
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
                                            Description
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
                                    <c:forEach var="item" items="${deliverys}">
                                        <tr class="odd">
                                            <td class="sorting_1"><a href="app-invoice-preview.html">${item.deliveryId}</a></td>
                                            <td class="sorting_1">
                                                <span class="fw-semibold" id="name-${item.deliveryId}">${item.name}</span>
                                            </td>
                                            <td>
                                                <span class="fw-semibold" id="price-${item.deliveryId}">${item.price}</span>
                                            </td>
                                            <td>
                                                <span class="fw-semibold" id="des-${item.deliveryId}">${item.description}</span>
                                            </td>
                                            <td style="text-align: center">
                                                <div class="d-inline-block"  >
                                                    <button
                                                            class="btn btn-sm btn-icon dropdown-toggle hide-arrow"
                                                            data-bs-toggle="dropdown"

                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a
                                                                href="javascript:;"
                                                                class="dropdown-item text-success delete-record btn-edit"
                                                                data-bs-toggle="offcanvas"
                                                                data-bs-target="#offcanvasEditDelivery"
                                                        >Edit</a
                                                        >
                                                        <div class="dropdown-divider"></div>
                                                        <a
                                                                href="delivery/delete?deliveryId=${item.deliveryId}"
                                                                class="dropdown-item text-danger delete-record btn-delete"
                                                        >Delete</a
                                                        >
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- pagination -->
                                <div id="paginate-delivery" class="row mx-2 mt-2">
                                    <div class="col-12">
                                        <div class="col-sm-12 col-md-6">
                                            <div
                                                    class="paging_simple_numbers"
                                            >
                                                <ul class="pagination">
                                                    <c:if test="${tag>0}">
                                                        <li class="paginate_button page-item previous"><a
                                                                class="page-link"
                                                                href="delivery?page=${tag-1}"
                                                                tabindex="-1">Previous</a>
                                                        </li>
                                                    </c:if>
                                                    <c:forEach begin="0" end="${endPage}" var="i">
                                                        <li class="page-item paginate_button ${tag==i ? "active" : ""}">
                                                            <a
                                                                    class="page-link"
                                                                    href="delivery?page=${i}">${i+1}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <c:if test="${tag<endPage}">
                                                        <li class="page-item page-item next"><a class="page-link"
                                                                                                href="delivery?page=${tag+1}">Next</a>
                                                        </li>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Offcanvas to add new shop level -->
                        <div
                                class="offcanvas offcanvas-end"
                                tabindex="-1"
                                id="offcanvasAddUser"
                                aria-labelledby="offcanvasAddUserLabel"
                        >
                            <div class="offcanvas-header border-bottom">
                                <h6 id="offcanvasAddUserLabel" class="offcanvas-title">Add New Delivery </h6>
                                <button
                                        type="button"
                                        class="btn-close text-reset"
                                        data-bs-dismiss="offcanvas"
                                        aria-label="Close"
                                ></button>
                            </div>
                            <div  class="offcanvas-body flex-grow-0 mx-0">
                                <form
                                        class="add-new-user pt-0"
                                        id="addNewDeliveryForm"
                                        method="post"
                                        role="form"
                                        action="delivery/create"
                                >
                                    <div class="mb-3">
                                        <label class="form-label" for="add-delivery-name">Name</label>
                                        <input
                                                type="text"
                                                class="form-control"
                                                id="add-delivery-name"
                                                placeholder="John Doe"
                                                name="name"
                                        />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="delivery-cost">Price</label>
                                        <input
                                                type="number"
                                                id="delivery-cost"
                                                class="form-control"
                                                name="price"
                                        />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="add-delivery-des">Description</label>
                                        <input
                                                type="text-area"
                                                id="add-delivery-des"
                                                class="form-control"
                                                name="description"
                                        />
                                    </div>
                                    <button type="submit" class="btn btn-primary data-submit me-1 me-sm-3">
                                        Submit
                                    </button>
                                    <button
                                            type="reset"
                                            class="btn btn-label-secondary"
                                            data-bs-dismiss="offcanvas"
                                    >
                                        Cancel
                                    </button>
                                </form>
                            </div>
                        </div>
                        <!-- Offcanvas to edit new shop level -->
                        <div
                                class="offcanvas offcanvas-end"
                                tabindex="-1"
                                id="offcanvasEditDelivery"
                                aria-labelledby="offcanvasEditDeliveryLabel"
                        >
                            <div class="offcanvas-header border-bottom">
                                <h6 id="offcanvasEditDeliveryLabel" class="offcanvas-title">
                                    Edit Delivery
                                </h6>
                                <button
                                        type="button"
                                        class="btn-close text-reset"
                                        data-bs-dismiss="offcanvas"
                                        aria-label="Close"
                                ></button>
                            </div>
                            <div class="offcanvas-body flex-grow-0 mx-0">
                                <form
                                        class="add-new-user pt-0"
                                        id="editNewDeliveryForm"
                                        method="post"
                                        role="form"
                                        action="delivery/edit"
                                >
                                    <div class="mb-3">
                                        <label class="form-label" for="name-delivery">Name</label>
                                        <input
                                                type="text"
                                                class="form-control"
                                                id="name-delivery"
                                                placeholder="John Doe"
                                                name="name"
                                        />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="price-delivery">Price</label>
                                        <input
                                                type="number"
                                                id="price-delivery"
                                                class="form-control"
                                                name="cost"
                                        />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="des-delivery">Description</label>
                                        <input
                                                type="text"
                                                class="form-control"
                                                id="des-delivery"
                                                placeholder="John Doe"
                                                name="description"
                                        />
                                    </div>
                                    <button type="submit" class="btn btn-primary data-submit me-1 me-sm-3">
                                        Submit
                                    </button>
                                    <button
                                            type="reset"
                                            class="btn btn-label-secondary"
                                            data-bs-dismiss="offcanvas"
                                    >
                                        Cancel
                                    </button>
                                </form>
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
<script src="../view/admin/js/delivery.js"></script>
<script src="../view/admin/assets/js/forms-pickers.js"></script>
</body>
</html>
