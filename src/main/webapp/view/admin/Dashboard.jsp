<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" lang="en" class="light-style layout-navbar-fixed layout-menu-fixed" dir="ltr"
      data-theme="theme-default" data-assets-path="./view/admin/assets/"
      data-template="vertical-menu-template-no-customizer">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>

    <title>Dashboard - Analytics | Frest - Bootstrap Admin Template</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="./view/admin/assets/img/favicon/favicon.ico"/>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Rubik:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"/>

    <!-- Icons -->
    <link rel="stylesheet" href="./view/admin/assets/vendor/fonts/boxicons.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/fonts/fontawesome.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/fonts/flag-icons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="./view/admin/assets/vendor/css/rtl/core.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/css/rtl/theme-default.css"/>
    <link rel="stylesheet" href="./view/admin/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/typeahead-js/typeahead.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/apex-charts/apex-charts.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/flatpickr/flatpickr.css"/>
    <link rel="stylesheet"
          href="./view/admin/assets/vendor/libs/bootstrap-datepicker/bootstrap-datepicker.css"/>
    <link rel="stylesheet"
          href="./view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.css"/>
    <link rel="stylesheet" href="./view/admin/assets/vendor/libs/pickr/pickr-themes.css"/>
    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="./view/admin/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="./view/admin/assets/js/config.js"></script>

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
                                        <img src="${pageContext.request.contextPath}/upload/uer.png}" alt
                                             class="rounded-circle"/>
                                    </div>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end">
                                    <li>
                                        <a class="dropdown-item" href="pages-account-settings-account.html">
                                            <div class="d-flex">
                                                <div class="flex-shrink-0 me-3">
                                                    <div class="avatar avatar-online">
                                                        <img src="${pageContext.request.contextPath}/upload/${user.avatar}"
                                                             alt class="rounded-circle"/>
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
                    <h4 class="breadcrumb-wrapper py-3 mb-4">
                        DashBoard
                    </h4>
                    <div class="col-12 col-sm-6 col-lg-3 mb-4">
                        <h4 class="text-light fw-semibold">Filter</h4>
                        <div class="col-12 col-md-6 mb-4">
                            <label for="flatpickr-date" class="form-label">Date Picker</label>
                            <input type="text" class="form-control" placeholder="YYYY-MM-DD"
                                   id="flatpickr-date"/>
                        </div>
                        <div class="demo-inline-spacing" id="main-data">
                            <div class="btn-group" id="hover-dropdown-demo">
                                <button type="button" class="btn btn-primary dropdown-toggle btn-filter"
                                        data-bs-toggle="dropdown" data-trigger="hover">
                                    All
                                </button>
                                <ul class="dropdown-menu dropdown-menu-filter">
                                    <li>
                                        <a class="dropdown-item">Year</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item">Month</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item">Week</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item">Day</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <!-- Website Analytics-->
                        <div class="col-md-12 mb-4">
                            <div class="card">
                                <div class="card-header d-flex justify-content-between align-items-center">
                                    <h5 class="card-title mb-0">Website Analytics</h5>
                                </div>
                                <div class="card-body pb-2">
                                    <div
                                            class="d-flex flex-wrap justify-content-around align-items-center mb-4">
                                        <div class="user-analytics text-center me-2">
                                            <i class="bx bx-user me-1"></i>
                                            <span>Users</span>
                                            <div class="d-flex align-items-center mt-2">
                                                <div class="chart-report" data-color="success"
                                                     data-series="35"></div>
                                                <h3 class="mb-0">${coutUser}</h3>
                                            </div>
                                        </div>
                                        <div class="sessions-analytics text-center me-2">
                                            <i class="menu-icon tf-icon bx bx-store"></i>
                                            <span>Shops</span>
                                            <div class="d-flex align-items-center mt-2">
                                                <div class="chart-report" data-color="warning"
                                                     data-series="76"></div>
                                                <h3 class="mb-0">${coutShop}</h3>
                                            </div>
                                        </div>
                                        <div class="bounce-rate-analytics text-center">
                                            <i class="menu-icon tf-icon bx bx-gift"></i>
                                            <span>Products</span>
                                            <div class="d-flex align-items-center mt-2">
                                                <div class="chart-report" data-color="danger"
                                                     data-series="65"></div>
                                                <h3 class="mb-0">${coutProd}</h3>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="analyticsBarChart"></div>
                                </div>
                            </div>
                        </div>
                        <%-- '    <div class="col-md-12 col-lg-6">--%>

                        <%--                        </div>' --%>
                        <div class="col-md-12 mb-4">
                            <div class="row">
                                <!-- new shop -->
                                <div class="col-md-12 mb-4">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <h2 class="mb-1">New Shop</h2>
                                            <span class="mb-1" id="newShop">${coutNewShop}</span>
                                            <div id="horizontalBarChartShop"></div>
                                        </div>
                                    </div>
                                </div>
                                <!-- new user -->
                                <div class="col-md-12 mb-4">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <h2 class="mb-1">New User</h2>
                                            <span class="mb-1" id="newUser">${coutNewUser}</span>
                                            <div id="horizontalBarChartUser"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Profit -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <div>
                                    <h2 class="card-title mb-0">Profit</h2>
                                </div>
                                <div class="d-none d-sm-flex align-items-center">
                                    <h2 class="fw-bold me-3 mb-0" id="newProfit">${ String.format("%.0f",coutNewProfit)} VND</h2>
                                </div>
                            </div>
                            <div class="card-body">
                                <div id="lineChart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <script type="module">
                    let dataX = []
                    let dataY = []
                    <c:forEach items = "${prods}" var="prod" >
                    dataX.push(${ prod.key })
                    dataY.push(${ prod.value })
                    </c:forEach>
                    const analyticsBarChartEl = document.querySelector('#analyticsBarChart'),
                        analyticsBarChartConfig = {
                            chart: {
                                height: 260,
                                type: 'bar',
                                toolbar: {
                                    show: false
                                }
                            },
                            plotOptions: {
                                bar: {
                                    horizontal: false,
                                    columnWidth: '20%',
                                    borderRadius: 3,
                                    startingShape: 'rounded'
                                }
                            },
                            dataLabels: {
                                enabled: false
                            },
                            colors: [config.colors.primary, config.colors_label.primary],
                            series: [
                                {
                                    name: 'data',
                                    data: dataY
                                }
                            ],
                            grid: {
                                borderColor: config.colors_dark.borderColor
                            },
                            xaxis: {
                                categories: dataX,
                                axisBorder: {
                                    show: false
                                },
                                axisTicks: {
                                    show: false
                                },
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor
                                    }
                                }
                            },
                            yaxis: {
                                min: 0,
                                max: 30,
                                tickAmount: 3,
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor
                                    }
                                }
                            },
                            legend: {
                                show: false
                            },
                            tooltip: {
                                y: {
                                    formatter: function (val) {
                                        return +val + ' products';
                                    }
                                }
                            }
                        };
                    if (typeof analyticsBarChartEl !== undefined && analyticsBarChartEl !== null) {
                        const analyticsBarChart = new ApexCharts(analyticsBarChartEl, analyticsBarChartConfig);
                        analyticsBarChart.render();
                    }

                    dataX = []
                    dataY = []
                    <c:forEach items = "${users}" var="user" >
                    dataX.push(${ user.key })
                    dataY.push(${ user.value })
                    </c:forEach>
                    const horizontalBarChartUserEl = document.querySelector('#horizontalBarChartUser'),
                        horizontalBarChartUserConfig = {
                            chart: {
                                height: 400,
                                fontFamily: 'IBM Plex Sans',
                                type: 'bar',
                                toolbar: {
                                    show: false
                                }
                            },
                            plotOptions: {
                                bar: {
                                    horizontal: true,
                                    barHeight: '30%',
                                    startingShape: 'rounded',
                                    borderRadius: 8
                                }
                            },
                            grid: {
                                borderColor: config.colors.borderColor,
                                xaxis: {
                                    lines: {
                                        show: false
                                    }
                                },
                                padding: {
                                    top: -20,
                                    bottom: -12
                                }
                            },
                            colors: config.colors.info,
                            dataLabels: {
                                enabled: false
                            },
                            series: [
                                {
                                    data: dataY
                                }
                            ],
                            xaxis: {
                                categories: dataX,
                                axisBorder: {
                                    show: false
                                },
                                axisTicks: {
                                    show: false
                                },
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            },
                            yaxis: {
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            }
                        };
                    if (typeof horizontalBarChartUserEl !== undefined && horizontalBarChartUserEl !== null) {
                        const horizontalBarChart = new ApexCharts(horizontalBarChartUserEl, horizontalBarChartUserConfig);
                        horizontalBarChart.render();
                    }

                    // new shop
                    dataX = []
                    dataY = []
                    <c:forEach items = "${stores}" var  ="order" >
                    dataX.push(${ order.key })
                    dataY.push(${ order.value })
                    </c:forEach>
                    const horizontalBarChartShopEl = document.querySelector('#horizontalBarChartShop'),
                        horizontalBarChartShopConfig = {
                            chart: {
                                height: 400,
                                fontFamily: 'IBM Plex Sans',
                                type: 'bar',
                                toolbar: {
                                    show: false
                                }
                            },
                            plotOptions: {
                                bar: {
                                    horizontal: true,
                                    barHeight: '30%',
                                    startingShape: 'rounded',
                                    borderRadius: 8
                                }
                            },
                            grid: {
                                borderColor: config.colors.borderColor,
                                xaxis: {
                                    lines: {
                                        show: false
                                    }
                                },
                                padding: {
                                    top: -20,
                                    bottom: -12
                                }
                            },
                            colors: config.colors.info,
                            dataLabels: {
                                enabled: false
                            },
                            series: [
                                {
                                    data: dataY
                                }
                            ],
                            xaxis: {
                                categories: dataX,
                                axisBorder: {
                                    show: false
                                },
                                axisTicks: {
                                    show: false
                                },
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            },
                            yaxis: {
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            }
                        };
                    if (typeof horizontalBarChartShopEl !== undefined && horizontalBarChartShopEl !== null) {
                        const horizontalBarChartShop = new ApexCharts(horizontalBarChartShopEl, horizontalBarChartShopConfig);
                        horizontalBarChartShop.render();
                    }
                    <c:forEach items="${orders}" var="order">
                    dataX.push(${order.key})
                    dataY.push(${order.value})
                    </c:forEach>
                    const lineChartEl = document.querySelector('#lineChart'),
                        lineChartConfig = {
                            chart: {
                                height: 400,
                                fontFamily: 'IBM Plex Sans',
                                type: 'line',
                                parentHeightOffset: 0,
                                zoom: {
                                    enabled: false
                                },
                                toolbar: {
                                    show: false
                                }
                            },
                            series: [
                                {
                                    data: dataY
                                }
                            ],
                            markers: {
                                strokeWidth: 7,
                                strokeOpacity: 1,
                                strokeColors: [config.colors.white],
                                colors: [config.colors.warning]
                            },
                            dataLabels: {
                                enabled: false
                            },
                            stroke: {
                                curve: 'straight'
                            },
                            colors: [config.colors.warning],
                            grid: {
                                borderColor: config.colors.borderColor,
                                xaxis: {
                                    lines: {
                                        show: true
                                    }
                                },
                                padding: {
                                    top: -20
                                }
                            },
                            tooltip: {
                                custom: function ({series, seriesIndex, dataPointIndex, w}) {
                                    return '<div class="px-3 py-2">' + '<span>' + series[seriesIndex][dataPointIndex] + 'VND</span>' + '</div>';
                                }
                            },
                            xaxis: {
                                categories: dataX,
                                axisBorder: {
                                    show: false
                                },
                                axisTicks: {
                                    show: false
                                },
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            },
                            yaxis: {
                                labels: {
                                    style: {
                                        colors: config.colors.axisColor,
                                        fontSize: '13px'
                                    }
                                }
                            }
                        };
                    if (typeof lineChartEl !== undefined && lineChartEl !== null) {
                        const lineChart = new ApexCharts(lineChartEl, lineChartConfig);
                        lineChart.render();
                    }
                </script>
                <!-- / Content -->

                <!-- Footer -->
                <footer class="content-footer footer bg-footer-theme">
                    <div
                            class="container-fluid d-flex flex-column flex-md-row flex-wrap justify-content-between py-2">
                        <div class="mb-2 mb-md-0">
                            ©
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            , made with ❤️ by
                            <a href="https://pixinvent.com" target="_blank"
                               class="footer-link fw-semibold">PIXINVENT</a>
                        </div>
                        <div>
                            <a href="https://themeforest.net/licenses/standard" class="footer-link me-4"
                               target="_blank">License</a>
                            <a href="https://1.envato.market/pixinvent_portfolio" target="_blank"
                               class="footer-link me-4">More Themes</a>

                            <a href="https://pixinvent.com/demo/frest-clean-bootstrap-admin/dashboard-template/documentation-bs5/"
                               target="_blank" class="footer-link me-4">Documentation</a>

                            <a href="https://pixinvent.ticksy.com/" target="_blank"
                               class="footer-link d-none d-sm-inline-block">Support</a>
                        </div>
                    </div>
                </footer>
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
<script src="./view/admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="./view/admin/assets/vendor/libs/popper/popper.js"></script>
<script src="./view/admin/assets/vendor/js/bootstrap.js"></script>
<script src="./view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="./view/admin/assets/vendor/libs/hammer/hammer.js"></script>
<script src="./view/admin/assets/vendor/libs/i18n/i18n.js"></script>
<script src="./view/admin/assets/vendor/libs/typeahead-js/typeahead.js"></script>
<script src="./view/admin/assets/vendor/js/menu.js"></script>
<%--<script src="./view/admin/assets/vendor/libs/apex-charts/apexcharts.js"></script>--%>
<script src="./view/admin/assets/vendor/libs/moment/moment.js"></script>
<script src="./view/admin/assets/vendor/libs/flatpickr/flatpickr.js"></script>
<script src="./view/admin/assets/vendor/libs/bootstrap-datepicker/bootstrap-datepicker.js"></script>
<script
        src="./view/admin/assets/vendor/libs/bootstrap-daterangepicker/bootstrap-daterangepicker.js"></script>
<script src="./view/admin/assets/vendor/libs/jquery-timepicker/jquery-timepicker.js"></script>
<script src="./view/admin/assets/vendor/libs/pickr/pickr.js"></script>
<script src="./view/admin/assets/js/main.js"></script>
<%--<script src="./view/admin/assets/js/dashboards-analytics.js"></script>--%>
<%--<script src="./view/admin/assets/js/charts-apex.js"></script>--%>
<script src="./view/admin/js/dashboard.js"></script>
<script src="./view/admin/assets/js/forms-pickers.js"></script>
</body>

</html>