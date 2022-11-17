<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard - Laptipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/view/web/assets/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/vendor/assets/css/adminx.css"
          media="screen"/>
</head>
<body>
<div class="adminx-container">
    <c:import url="vendor-header.jsp"></c:import>

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
                                        Số nhân viên (Không tính chủ)
                                    </h5>

                                    <div class="card-title-sub">
                                        ${numEmp}
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
                                        ${chart_data_2[0].value.intValue()}
                                    </h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <div class="card-header-title">Số đơn hàng trong 5 tháng gần nhất</div>
                                <nav class="card-header-actions">
                                    <a class="card-header-action" data-toggle="collapse" href="#card1"
                                       aria-expanded="false"
                                       aria-controls="card1">
                                        <i data-feather="minus-circle"></i>
                                    </a>
                                    <a href="#" class="card-header-action">
                                        <i data-feather="x-circle"></i>
                                    </a>
                                </nav>
                            </div>
                            <div class="card-body collapse show" id="card1">
                                <canvas id="so-luong-5-thang" width="600" height="400"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <div class="card-header-title">Doanh thu trong 5 tháng gần nhất</div>
                                <nav class="card-header-actions">
                                    <a class="card-header-action" data-toggle="collapse" href="#card1"
                                       aria-expanded="false"
                                       aria-controls="card1">
                                        <i data-feather="minus-circle"></i>
                                    </a>
                                    <a href="#" class="card-header-action">
                                        <i data-feather="x-circle"></i>
                                    </a>
                                </nav>
                            </div>
                            <div class="card-body collapse show" id="card2">
                                <canvas id="doanh-thu-5-thang" width="600" height="400"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <div class="card-header-title">Sản phẩm bán trong 1 tháng</div>
                                <nav class="card-header-actions">
                                    <a class="card-header-action" data-toggle="collapse" href="#card3"
                                       aria-expanded="false"
                                       aria-controls="card3">
                                        <i data-feather="minus-circle"></i>
                                    </a>
                                    <a href="#" class="card-header-action">
                                        <i data-feather="x-circle"></i>
                                    </a>
                                </nav>
                            </div>
                            <div class="card-body collapse show" id="card3">
                                <canvas id="san-pham-trong-1-thang" width="600" height="400"></canvas>
                            </div>
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
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/vendor.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/adminx.js"></script>
<script>
    //Line chart
    const labels_1 = [
        <c:forEach var="month" items="${chart_data_1}">'Tháng ${month.key}', </c:forEach>
    ];
    const data_1 = {
        labels: labels_1,
        datasets: [{
            label: 'Số đơn hàng ${chart_data.size()} tháng gần nhất',
            data: [<c:forEach var="month" items="${chart_data_1}">${month.value}, </c:forEach>],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1
        }]
    };
    const config_1 = {
        type: 'line',
        data: data_1,
    };
    const canvas_1 = document.getElementById('so-luong-5-thang')
    const chart_1 = new Chart(canvas_1, config_1)
    //Bar chart
    const labels_2 = [
        <c:forEach var="month" items="${chart_data_2}">'Tháng ${month.key}', </c:forEach>
    ];
    const data_2 = {
        labels: labels_2,
        datasets: [{
            label: 'Doanh thu trong 5 tháng',
            data: [<c:forEach var="month" items="${chart_data_2}">${month.value.intValue()}, </c:forEach>],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 205, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(54, 162, 235, 0.2)',
            ],
            borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)',
            ],
            borderWidth: 1
        }]
    };
    const config_2 = {
        type: 'bar',
        data: data_2,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };
    const canvas_2 = document.getElementById('doanh-thu-5-thang')
    const chart_2 = new Chart(canvas_2, config_2)
    //Pie
    const labels_3 = [
        <c:forEach items="${chart_data_3}" var="i">'${i.key}', </c:forEach>
    ];
    const data_3 = {
        labels: labels_3,
        datasets: [{
            label: 'Sản phẩm trong 1 tháng',
            data: [
                <c:forEach items="${chart_data_3}" var="i">${i.value}, </c:forEach>
            ],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 205, 86)'
            ],
            hoverOffset: 4
        }]
    };
    const config_3 = {
        type: 'pie',
        data: data_3,
    };
    const canvas_3 = document.getElementById('san-pham-trong-1-thang')
    const chart_3 = new Chart(canvas_3, config_3)
</script>

</body>
</html>