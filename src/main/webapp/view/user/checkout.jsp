<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

<head>

    <title>Ogani | Template</title>
    <c:import url="head_link_v1.jsp">

    </c:import>
    <!-- Google Font -->

</head>

<body>
<c:import url="header.jsp">

</c:import>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/bread.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>THANH TOÁN </h2>
                    <div class="breadcrumb__option">
                        <a href="./index.html">Home</a>
                        <span>checkout</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <h4>Thông tin cá nhân</h4>
            <div class="row">
                <div class="col-lg-8 col-md-6">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>

                            <tr>
                                <th>Lựa chọn</th>
                                <th>Tên người nhận</th>
                                <th>Địa chỉ</th>
                                <th>Số điện thoại</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${user.userAddressesByUserId}" var="a">
                                <tr>
                                    <td class="shoping__cart">
                                        <input type="checkbox" data-id="${a.addressId}" class="check-address">
                                    </td>
                                    <td class="shoping__cart">
                                            ${a.nameRecipient}
                                    </td>
                                    <td class="shoping__cart">
                                            ${a.zipcode}
                                    </td>
                                    <td class="shoping__cart">
                                            ${a.numberPhone}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <input id="selected-id" type="number" hidden>

                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="checkout__order">
                        <h4>Chi tiết thanh toán</h4>
                        <div class="checkout__order__products">Sản phẩm <span>Tổng cộng</span></div>
                        <ul>
                            <c:forEach var="i" items="${cart.cartItemsByCartId}">
                                <li>${fn:substring(i.productByProductId.name, 0, 20)}<span>${i.productByProductId.price.intValue()}</span>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="checkout__order__subtotal">Tổng tiền sản phẩm
                            <span>${cart.getTotalPrice().intValue()}</span></div>
                        <div class="checkout__order__subtotal">Vận chuyển (Viettel) <span>15000</span>
                        </div>
                        <div class="checkout__order__total">Tổng cộng

                            <span id="total-price"><c:out
                                    value="${cart.getTotalPrice().intValue()+1500}"></c:out></span></div>

                        <div class="checkout__input__checkbox">
                            <label for="payment">
                                Thanh Toán Khi Nhận Hàng
                                <input type="checkbox" id="payment">
                                <span class="checkmark"></span>
                            </label>
                        </div>
                        <button id="order-btn" class="site-btn">ĐẶT HÀNG</button>
                    </div>
                </div>
            </div>
        </div>
</section>
<!-- Checkout Section End -->

<c:import url="footer.jsp">

</c:import>
<script>
    $('.check-address').on('click', function () {
        let id = $(this).data("id")
        $('#selected-id').val(id);
    })
    $('#order-btn').on('click', function () {
        let total = $('#total-price').text()
        let addressId = $('#selected-id').val()
        $.ajax({
            url: '${pageContext.request.contextPath}/checkout',
            method: 'post',
            data: {
                'total': total,
                'addressId': addressId
            },
            success: function (e) {
                window.location.href='${pageContext.request.contextPath}/thanks'
            },
            error:function (e){
                console.log(e)
            }
        })
    })
</script>

</body>

</html>