<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>
        <html lang="en" lang="en" class="light-style layout-navbar-fixed layout-menu-fixed" dir="ltr"
            data-theme="theme-default" data-assets-path="../view/admin/assets/"
            data-template="vertical-menu-template-no-customizer">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>Dashboard - Analytics | Frest - Bootstrap Admin Template</title>

            <meta name="description" content="" />

            <!-- Favicon -->
            <link rel="icon" type="image/x-icon" href="../view/admin/assets/img/favicon/favicon.ico" />

            <!-- Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com" />
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
            <link
                href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Rubik:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
                rel="stylesheet" />

            <!-- Icons -->
            <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/boxicons.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/fontawesome.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/fonts/flag-icons.css" />

            <!-- Core CSS -->
            <link rel="stylesheet" href="../view/admin/assets/vendor/css/rtl/core.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/css/rtl/theme-default.css" />
            <link rel="stylesheet" href="../view/admin/assets/css/demo.css" />

            <!-- Vendors CSS -->
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/typeahead-js/typeahead.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/apex-charts/apex-charts.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/flatpickr/flatpickr.css" />
            <link rel="stylesheet"
                href="../view/admin/assets/vendor/libs/bootstrap-datepicker/bootstrap-datepicker.css" />
            <link rel="stylesheet"
                href="../view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.css" />
            <link rel="stylesheet" href="../view/admin/assets/vendor/libs/pickr/pickr-themes.css" />
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
                        <nav class="layout-navbar navbar navbar-expand-xl align-items-center bg-navbar-theme"
                            id="layout-navbar">
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
                                            <a class="nav-link style-switcher-toggle hide-arrow"
                                                href="javascript:void(0);">
                                                <i class="bx bx-sm"></i>
                                            </a>
                                        </li>
                                        <!--/ Style Switcher -->

                                        <!-- User -->
                                        <li class="nav-item navbar-dropdown dropdown-user dropdown">
                                            <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);"
                                                data-bs-toggle="dropdown">
                                                <div class="avatar avatar-online">
                                                    <img src=".${pageContext.request.contextPath}/upload/uer.png}" alt
                                                        class="rounded-circle" />
                                                </div>
                                            </a>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                                <li>
                                                    <a class="dropdown-item" href="pages-account-settings-account.html">
                                                        <div class="d-flex">
                                                            <div class="flex-shrink-0 me-3">
                                                                <div class="avatar avatar-online">
                                                                    <img src="${pageContext.request.contextPath}/upload/${user.avatar}"
                                                                        alt class="rounded-circle" />
                                                                </div>
                                                            </div>
                                                            <div class="flex-grow-1">
                                                                <span
                                                                    class="lh-1 d-block fw-semibold">${user.firstname}</span>
                                                                <small>Admin</small>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li>
                                                    <div class="dropdown-divider"></div>
                                                </li>
                                                <li>
                                                    <a class="dropdown-item"
                                                        href="${pageContext.request.contextPath}/logout">
                                                        <i class="bx bx-power-off me-2"></i>
                                                        <span class="align-middle"><a
                                                                href="${pageContext.request.contextPath}/logout">Log
                                                                Out</a></span>
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
                                <h4 class="breadcrumb-wrapper py-3 mb-4">
                                    Commission
                                </h4>
                                <div class="card">
                                    <div class="card-header border-bottom">
                                        <h5 class="card-title">Search Filter</h5>
                                        <div
                                            class="row gap-3 gap-md-0 d-flex justify-content-between align-items-center py-3">
                                            <div class="commission_status col-md-4">
                                                <select id="FilterTransaction" class="form-select text-capitalize">
                                                    <option value="All" ${option=="0" ? ' selected="selected"' : '' }>
                                                        All</option>
                                                    <option value="Active" ${option=="1" ? ' selected="selected"' : ''
                                                        }>Active</option>
                                                    <option value="Inactive" ${option=="2" ? ' selected="selected"' : ''
                                                        }> Inactive
                                                    </option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-datatable table-responsive">
                                        <div id="DataTables_Table_0_wrapper"
                                            class="dataTables_wrapper dt-bootstrap5 no-footer">
                                            <div class="row mx-2">
                                                <div class="col-mx-2">
                                                    <div
                                                        class="dt-action-buttons text-xl-end text-xl-start text-md-end text-start d-flex justify-content-between">
                                                        <div class="dataTables_filter" style="margin-right: 50px">
                                                            <label><input type="search" class="form-control mb-3 mt-3"
                                                                    placeholder="Search.."
                                                                    aria-controls="DataTables_Table_0" id="search_box" ,
                                                                    value="${search}" /></label>
                                                            <button type="button"
                                                                class="dt-button btn btn-primary mb-3 mt-3"
                                                                id="btn-search">Search
                                                            </button>
                                                        </div>

                                                        <button class="dt-button add-new btn btn-primary mb-3 mt-3"
                                                            tabindex="0" aria-controls="DataTables_Table_0"
                                                            type="button" data-bs-toggle="offcanvas"
                                                            data-bs-target="#offcanvasAddUser">
                                                            <span><i class="bx bx-plus me-0 me-lg-2"></i><span
                                                                    class="d-none d-lg-inline-block">Add New
                                                                    Commission</span></span>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- table -->
                                            <table
                                                class="datatables-users table border-top dataTable no-footer dtr-column collapsed"
                                                id="DataTables_Table_0" role="grid">
                                                <thead>
                                                    <tr role="row">
                                                        <th class="control " rowspan="1" colspan="1"
                                                            style="width: 200px" aria-label="">
                                                            Commission Id
                                                        </th>
                                                        <th class="sorting" tabindex="0"
                                                            aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
                                                            style="width: auto"
                                                            aria-label="User: activate to sort column ascending"
                                                            aria-sort="descending">
                                                            Name
                                                        </th>
                                                        <th class="sorting " tabindex="0"
                                                            aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
                                                            style="width: auto"
                                                            aria-label="User: activate to sort column ascending"
                                                            aria-sort="descending">
                                                            Cost
                                                        </th>
                                                        <th class="" tabindex="0" aria-controls="DataTables_Table_0"
                                                            rowspan="1" colspan="1" style="width: auto"
                                                            aria-label="Role: activate to sort column ascending">
                                                            Description
                                                        </th>
                                                        <th rowspan="1" colspan="1" style="width: 100px"
                                                            aria-label="Actions">
                                                            Actions
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="action-click">
                                                    <c:forEach var="item" items="${commissions}">
                                                        <tr class="odd">
                                                            <td class="sorting_1"><a>${item.commissionId}</a>
                                                            </td>
                                                            <td class="sorting_1">
                                                                <span class="fw-semibold"
                                                                    id="name-${item.commissionId}">${item.name}</span>
                                                            </td>
                                                            <td>
                                                                <span class="fw-semibold"
                                                                    id="cost-${item.commissionId}">${item.cost}</span>
                                                            </td>
                                                            <td>
                                                                <span class="fw-semibold"
                                                                    id="des-${item.commissionId}">${item.description}</span>
                                                            </td>
                                                            <td style="text-align: center">
                                                                <div class="d-inline-block">
                                                                    <button
                                                                        class="btn btn-sm btn-icon dropdown-toggle hide-arrow"
                                                                        data-bs-toggle="dropdown">
                                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                                    </button>
                                                                    <div class="dropdown-menu dropdown-menu-end">
                                                                        <a href="javascript:;"
                                                                            class="dropdown-item text-success delete-record btn-edit"
                                                                            data-bs-toggle="offcanvas"
                                                                            data-bs-target="#offcanvasEditCommission">Edit</a>
                                                                        <div class="dropdown-divider"></div>
                                                                        <a href="commission/delete?commissionId=${item.commissionId}"
                                                                            class="dropdown-item text-danger delete-record btn-delete">Delete</a>
                                                                    </div>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <!-- pagination -->
                                            <div id="paginate-commission" class="row mx-2 mt-2">
                                                <div class="col-12">
                                                    <div class="col-sm-12 col-md-6">
                                                        <div class="paging_simple_numbers">
                                                            <ul class="pagination">
                                                                <c:if test="${tag>0}">
                                                                    <li class="paginate_button page-item previous"><a
                                                                            class="page-link"
                                                                            href="commission?page=${tag-1}"
                                                                            tabindex="-1">Previous</a>
                                                                    </li>
                                                                </c:if>
                                                                <c:forEach begin="0" end="${endPage}" var="i">
                                                                    <li class="page-item paginate_button ${tag==i ? "active" : "" }">
                                                                        <a class="page-link"
                                                                            href="commission?page=${i}">${i+1}</a>
                                                                    </li>
                                                                </c:forEach>
                                                                <c:if test="${tag<endPage}">
                                                                    <li class="page-item page-item next"><a
                                                                            class="page-link"
                                                                            href="commission?page=${tag+1}">Next</a>
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
                                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddUser"
                                        aria-labelledby="offcanvasAddUserLabel">
                                        <div class="offcanvas-header border-bottom">
                                            <h6 id="offcanvasAddUserLabel" class="offcanvas-title">Add Commission Level
                                            </h6>
                                            <button type="button" class="btn-close text-reset"
                                                data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                        </div>
                                        <div class="offcanvas-body flex-grow-0 mx-0">
                                            <form class="add-new-user pt-0" id="addNewCommissionLevelForm" method="post"
                                                role="form" action="commission/create">
                                                <div class="mb-3">
                                                    <label class="form-label" for="add-commission-name">Name</label>
                                                    <input type="text" class="form-control" id="add-commission-name"
                                                        placeholder="John Doe" name="name" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label" for="commission-cost">Cost</label>
                                                    <input type="number" id="commission-cost" class="form-control"
                                                        name="cost" step="0.01" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label"
                                                        for="add-commission-des">Description</label>
                                                    <input type="text-area" id="add-commission-des" class="form-control"
                                                        name="description" />
                                                </div>
                                                <button type="submit" class="btn btn-primary data-submit me-1 me-sm-3">
                                                    Submit
                                                </button>
                                                <button type="reset" class="btn btn-label-secondary"
                                                    data-bs-dismiss="offcanvas">
                                                    Cancel
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                    <!-- Offcanvas to edit new shop level -->
                                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasEditCommission"
                                        aria-labelledby="offcanvasEditCommissionLabel">
                                        <div class="offcanvas-header border-bottom">
                                            <h6 id="offcanvasEditCommissionLabel" class="offcanvas-title">
                                                Edit Commission
                                            </h6>
                                            <button type="button" class="btn-close text-reset"
                                                data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                        </div>
                                        <div class="offcanvas-body flex-grow-0 mx-0">
                                            <form class="add-new-user pt-0" id="editNewCommissionLevelForm"
                                                method="post" role="form" action="commission/edit">
                                                <div class="mb-3">
                                                    <label class="form-label" for="name-commission">Name</label>
                                                    <input type="text" class="form-control" id="name-commission"
                                                        placeholder="John Doe" name="name" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label" for="cost-commission">Cost</label>
                                                    <input type="number" id="cost-commission" class="form-control"
                                                        name="cost" step="0.01" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label" for="des-commission">Description</label>
                                                    <input type="text" class="form-control" id="des-commission"
                                                        placeholder="John Doe" name="description" />
                                                </div>
                                                <button type="submit" class="btn btn-primary data-submit me-1 me-sm-3">
                                                    Submit
                                                </button>
                                                <button type="reset" class="btn btn-label-secondary"
                                                    data-bs-dismiss="offcanvas">
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
                <script
                    src="../view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.js"></script>
                <script src="../view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.js"></script>
                <script src="../view/admin/assets/vendor/libs/pickr/pickr.js"></script>
                <script src="../view/admin/assets/js/main.js"></script>
                <%--<script src="../view/admin/assets/js/dashboards-analytics.js"></script>--%>
                    <%--<script src="../view/admin/assets/js/charts-apex.js"></script>--%>
                        <script src="../view/admin/js/commission.js"></script>
                        <script src="../view/admin/assets/js/forms-pickers.js"></script>
        </body>

        </html>