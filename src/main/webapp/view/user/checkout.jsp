<!DOCTYPE html>

<html
        lang="en"
        class="light-style"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../admin/assets/"
        data-template="horizontal-menu-template">
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
    <title>Checkout - Wizard Examples | Frest - Bootstrap Admin Template</title>
    <meta name="description" content=""/>

    <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico"/>
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Rubik:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"/>
    <!-- Icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/fonts/boxicons.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/fonts/fontawesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/fonts/flag-icons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/css/rtl/core.css"
          class="template-customizer-core-css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/css/rtl/theme-default.css"
          class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/typeahead-js/typeahead.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/select2/select2.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/bs-stepper/bs-stepper.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/rateyo/rateyo.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/formvalidation/dist/css/formValidation.min.css"/>

    <!-- Page CSS -->

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/view/admin/assets/vendor/css/pages/wizard-ex-checkout.css"/>
    <!-- Helpers -->
    <script src="${pageContext.request.contextPath}/view/admin/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Template customizer: To hide customizer set displayCustomizer value false in config.js.  -->
    <script src="${pageContext.request.contextPath}/view/admin/assets/vendor/js/template-customizer.js"></script>
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="${pageContext.request.contextPath}/view/admin/assets/js/config.js"></script>
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-navbar-full layout-horizontal layout-without-menu">
    <div class="layout-container">
        <!-- Navbar -->


        <!-- / Navbar -->

        <!-- Layout container -->
        <div class="layout-page">
            <!-- Content wrapper -->
            <div class="content-wrapper">
                <!-- Menu -->
                <!-- / Menu -->
                <!-- Content -->
                <div class="container-xxl flex-grow-1 container-p-y">
                    <h4 class="breadcrumb-wrapper py-3 mb-4">
                        <span class="text-muted fw-light">Wizard examples /</span> Checkout
                    </h4>
                    <!-- Checkout Wizard -->
                    <div id="wizard-checkout" class="bs-stepper wizard-icons wizard-icons-example mt-2">
                        <div class="bs-stepper-header border-0 m-auto">
                            <div class="step" data-target="#checkout-cart">
                                <button type="button" class="step-trigger">
                      <span class="bs-stepper-icon">
                        <svg viewBox="0 0 58 54">
                          <use xlink:href="${pageContext.request.contextPath}/view/admin/assets/svg/icons/wizard-checkout-cart.svg#wizardCart"></use>
                        </svg>
                      </span>
                                    <span class="bs-stepper-label">Cart</span>
                                </button>
                            </div>
                            <div class="line">
                                <i class="bx bx-chevron-right"></i>
                            </div>
                            <div class="step" data-target="#checkout-address">
                                <button type="button" class="step-trigger">
                      <span class="bs-stepper-icon">
                        <svg viewBox="0 0 54 54">
                          <use
                                  xlink:href="${pageContext.request.contextPath}/view/admin/assets/svg/icons/wizard-checkout-address.svg#wizardCheckoutAddress"
                          ></use>
                        </svg>
                      </span>
                                    <span class="bs-stepper-label">Address</span>
                                </button>
                            </div>
                            <div class="line">
                                <i class="bx bx-chevron-right"></i>
                            </div>
                            <div class="step" data-target="#checkout-payment">
                                <button type="button" class="step-trigger">
                      <span class="bs-stepper-icon">
                        <svg viewBox="0 0 58 54">
                          <use xlink:href="${pageContext.request.contextPath}/view/admin/assets/svg/icons/wizard-checkout-payment.svg#wizardPayment"></use>
                        </svg>
                      </span>
                                    <span class="bs-stepper-label">Payment</span>
                                </button>
                            </div>
                            <div class="line">
                                <i class="bx bx-chevron-right"></i>
                            </div>
                            <div class="step" data-target="#checkout-confirmation">
                                <button type="button" class="step-trigger">
                      <span class="bs-stepper-icon">
                        <svg viewBox="0 0 58 54">
                          <use xlink:href="${pageContext.request.contextPath}/view/admin/assets/svg/icons/wizard-checkout-confirmation.svg#wizardConfirm"></use>
                        </svg>
                      </span>
                                    <span class="bs-stepper-label">Confirmation</span>
                                </button>
                            </div>
                        </div>
                        <div class="bs-stepper-content border-top">
                            <form id="wizard-checkout-form" onSubmit="return false">
                                <!-- Cart -->
                                <div id="checkout-cart" class="content">
                                    <div class="row">
                                        <!-- Cart left -->
                                        <div class="col-xl-8 mb-3 mb-xl-0">
                                            <!-- Offer alert -->
                                            <%--                      <div class="alert alert-success alert-dismissible mb-4" role="alert">--%>
                                            <%--                        <div class="fw-bold">Available Offers</div>--%>
                                            <%--                        <ul class="list-unstyled mb-0">--%>
                                            <%--                          <li>- 10% Instant Discount on Bank of America Corp Bank Debit and Credit cards</li>--%>
                                            <%--                          <li>- 25% Cashback Voucher of up to $60 on first ever PayPal transaction. TCA</li>--%>
                                            <%--                        </ul>--%>
                                            <%--                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>--%>
                                            <%--                      </div>--%>

                                            <!-- Shopping bag -->
                                            <h5>My Shopping Bag (2 Items)</h5>
                                            <ul class="list-group mb-3">
                                                <li class="list-group-item p-4">
                                                    <div class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="${pageContext.request.contextPath}/view/admin/assets/img/products/1.png"
                                                                 alt="google home" class="w-px-100"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <div class="row">
                                                                <div class="col-md-8">
                                                                    <h6 class="fw-normal me-3 mb-2">
                                                                        <a href="javascript:void(0)" class="text-body">Google
                                                                            - Google Home - White</a>
                                                                    </h6>
                                                                    <div class="d-flex flex-wrap text-muted mb-1">
                                                                        <span class="me-1">Sold by:</span>
                                                                        <a href="javascript:void(0)"
                                                                           class="me-1">Apple</a>
                                                                        <span class="badge bg-label-success">In Stock</span>
                                                                    </div>
                                                                    <div class="read-only-ratings mb-2"
                                                                         data-rateyo-read-only="true"></div>
                                                                    <input
                                                                            type="number"
                                                                            class="form-control form-control-sm w-px-75"
                                                                            value="1"
                                                                            min="1"
                                                                            max="5"
                                                                    />
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="text-md-end">
                                                                        <button type="button"
                                                                                class="btn-close btn-pinned"
                                                                                aria-label="Close"></button>
                                                                        <div class="my-2 my-md-4">
                                                                            <span class="text-primary">$299/</span><s
                                                                                class="text-muted">$359</s>
                                                                        </div>
                                                                        <button type="button"
                                                                                class="btn btn-sm btn-label-primary">
                                                                            Move to wishlist
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item p-4">
                                                    <div class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="${pageContext.request.contextPath}/view/admin/assets/img/products/2.png"
                                                                 alt="google home" class="w-px-100"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <div class="row">
                                                                <div class="col-md-8">
                                                                    <h6 class="fw-normal me-3 mb-2">
                                                                        <a href="javascript:void(0)" class="text-body">Apple
                                                                            iPhone 11 (64GB, Black)</a>
                                                                    </h6>
                                                                    <div class="d-flex flex-wrap text-muted mb-1">
                                                                        <span class="me-1">Sold by:</span>
                                                                        <a href="javascript:void(0)"
                                                                           class="me-1">Apple</a>
                                                                        <span class="badge bg-label-success">In Stock</span>
                                                                    </div>
                                                                    <div class="read-only-ratings mb-2"
                                                                         data-rateyo-read-only="true"></div>
                                                                    <input
                                                                            type="number"
                                                                            class="form-control form-control-sm w-px-75"
                                                                            value="1"
                                                                            min="1"
                                                                            max="5"
                                                                    />
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="text-md-end">
                                                                        <button type="button"
                                                                                class="btn-close btn-pinned"
                                                                                aria-label="Close"></button>
                                                                        <div class="my-2 my-md-4">
                                                                            <span class="text-primary">$299/</span><s
                                                                                class="text-muted">$359</s>
                                                                        </div>
                                                                        <button type="button"
                                                                                class="btn btn-sm btn-label-primary">
                                                                            Move to wishlist
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>

                                            <!-- Wishlist -->
                                            <%--                      <div class="list-group">--%>
                                            <%--                        <a href="javascript:void(0)" class="list-group-item d-flex justify-content-between">--%>
                                            <%--                          <span>Add more products from wishlist</span>--%>
                                            <%--                          <i class="bx bx-sm bx-chevron-right scaleX-n1-rtl"></i>--%>
                                            <%--                        </a>--%>
                                            <%--                      </div>--%>
                                        </div>

                                        <!-- Cart right -->
                                        <div class="col-xl-4">
                                            <div class="border rounded p-3 mb-3">
                                                <!-- Offer -->
                                                <%--                        <h6>Offer</h6>--%>
                                                <%--                        <div class="row g-3 mb-3">--%>
                                                <%--                          <div class="col-xxl-8 col-8 col-xl-12">--%>
                                                <%--                            <input--%>
                                                <%--                                    type="text"--%>
                                                <%--                                    class="form-control"--%>
                                                <%--                                    placeholder="Enter Promo Code"--%>
                                                <%--                                    aria-label="Enter Promo Code"--%>
                                                <%--                            />--%>
                                                <%--                          </div>--%>
                                                <%--                          <div class="col-xxl-4 col-4 col-xl-12">--%>
                                                <%--                            <div class="d-grid">--%>
                                                <%--                              <button type="button" class="btn btn-label-primary">Apply</button>--%>
                                                <%--                            </div>--%>
                                                <%--                          </div>--%>
                                                <%--                        </div>--%>

                                                <!-- Gift wrap -->

                                                <hr class="mx-n3"/>

                                                <!-- Price Details -->
                                                <h6>Price Details</h6>
                                                <dl class="row mb-0">
                                                    <dt class="col-6 fw-normal">Bag Total</dt>
                                                    <dd class="col-6 text-end">$1198.00</dd>

                                                    <%--                          <dt class="col-6 fw-normal">Coupon Discount</dt>--%>
                                                    <%--                          <dd class="text-primary col-6 text-end">Apply Coupon</dd>--%>

                                                    <dt class="col-6 fw-normal">Order Total</dt>
                                                    <dd class="col-6 text-end">$1100.00</dd>

                                                    <dt class="col-6 fw-normal">Delivery Charges</dt>
                                                    <dd class="col-6 text-end text-muted">
                                                        <s>$5.00</s> <span class="badge bg-label-success">Free</span>
                                                    </dd>

                                                    <hr/>

                                                    <dt class="col-6">Total</dt>
                                                    <dd class="col-6 text-end fw-semibold mb-0">$1100.00</dd>
                                                </dl>
                                            </div>
                                            <div class="d-grid">
                                                <button class="btn btn-primary btn-next">Place Order</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Address -->
                                <div id="checkout-address" class="content">
                                    <div class="row">
                                        <!-- Address left -->
                                        <div class="col-xl-9 mb-3 mb-xl-0">
                                            <!-- Select address -->
                                            <p>Select your preferable address</p>
                                            <div class="row mb-3">
                                                <div class="col-md mb-2 mb-md-0">
                                                    <div class="form-check custom-option custom-option-basic checked">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioAddress1">
                                                            <input
                                                                    name="customRadioTemp"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioAddress1"
                                                                    checked=""
                                                            />
                                                            <span class="custom-option-header">
                                    <span class="h6 mb-0">John Doe (Default)</span>
                                    <span class="badge bg-label-primary">Home</span>
                                  </span>
                                                            <span class="custom-option-body">
                                    <small
                                    >4135 Parkway Street, Los Angeles, CA, 90017.<br/>
                                      Mobile : 1234567890 Cash / Card on delivery available</small
                                    >
                                    <small class="d-flex mt-3">
                                      <a class="me-2" href="javascript:void(0)">Edit</a>
                                      <a href="javascript:void(0)">Remove</a>
                                    </small>
                                  </span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md">
                                                    <div class="form-check custom-option custom-option-basic">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioAddress2">
                                                            <input
                                                                    name="customRadioTemp"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioAddress2"
                                                            />
                                                            <span class="custom-option-header">
                                    <span class="h6 mb-0">ACME Inc.</span>
                                    <span class="badge bg-label-success">Office</span>
                                  </span>
                                                            <span class="custom-option-body">
                                    <small
                                    >87 Hoffman Avenue, New York, NY, 10016.<br/>Mobile : 1234567890 Cash / Card on
                                      delivery available</small
                                    >
                                    <small class="d-flex mt-3">
                                      <a class="me-2" href="javascript:void(0)">Edit</a>
                                      <a href="javascript:void(0)">Remove</a>
                                    </small>
                                  </span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <button
                                                    type="button"
                                                    class="btn btn-label-primary mb-4"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#addNewAddress"
                                            >
                                                Add new address
                                            </button>

                                            <!-- Choose Delivery -->
                                            <p class="mt-2">Choose Delivery Speed</p>
                                            <div class="row">
                                                <div class="col-md mb-2 mb-md-0">
                                                    <div class="form-check custom-option custom-option-icon checked position-relative">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioDelivery1">
                                  <span class="custom-option-body">
                                    <i class="bx bx-shopping-bag mb-2"></i>
                                    <span class="custom-option-title">Standard</span>
                                    <span class="badge bg-label-success btn-pinned">FREE</span>
                                    <small>Get your product in 1 Week.</small>
                                  </span>
                                                            <input
                                                                    name="customRadioIcon"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioDelivery1"
                                                                    checked=""
                                                            />
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md mb-2 mb-md-0">
                                                    <div class="form-check custom-option custom-option-icon position-relative">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioDelivery2">
                                  <span class="custom-option-body">
                                    <i class="bx bx-star mb-2"></i>
                                    <span class="custom-option-title">Express</span>
                                    <span class="badge bg-label-secondary btn-pinned">$10</span>
                                    <small>Get your product in 3-4 days.</small>
                                  </span>
                                                            <input
                                                                    name="customRadioIcon"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioDelivery2"
                                                            />
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md">
                                                    <div class="form-check custom-option custom-option-icon position-relative">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioDelivery3">
                                  <span class="custom-option-body">
                                    <i class="bx bx-rocket mb-2"></i>
                                    <span class="custom-option-title">Overnight</span>
                                    <span class="badge bg-label-secondary btn-pinned">$15</span>
                                    <small>Get your product in 1 day.</small>
                                  </span>
                                                            <input
                                                                    name="customRadioIcon"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioDelivery3"
                                                            />
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Address right -->
                                        <div class="col-xl-3">
                                            <div class="border rounded p-3 mb-3">
                                                <!-- Estimated Delivery -->
                                                <h6>Estimated Delivery Date</h6>
                                                <ul class="list-unstyled">
                                                    <li class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="../admin/assets/img/products/1.png"
                                                                 alt="google home" class="w-px-50"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <p class="mb-0">
                                                                <a class="text-body" href="javascript:void(0)">Google -
                                                                    Google Home - White</a>
                                                            </p>
                                                            <p class="fw-semibold">18th Nov 2021</p>
                                                        </div>
                                                    </li>
                                                    <li class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="../admin/assets/img/products/2.png"
                                                                 alt="google home" class="w-px-50"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <p class="mb-0">
                                                                <a class="text-body" href="javascript:void(0)">Apple
                                                                    iPhone 11 (64GB, Black)</a>
                                                            </p>
                                                            <p class="fw-semibold">20th Nov 2021</p>
                                                        </div>
                                                    </li>
                                                </ul>

                                                <hr class="mx-n3"/>

                                                <!-- Price Details -->
                                                <h6>Price Details</h6>
                                                <dl class="row mb-0">
                                                    <dt class="col-6 fw-normal">Order Total</dt>
                                                    <dd class="col-6 text-end">$1100.00</dd>

                                                    <dt class="col-6 fw-normal">Delivery Charges</dt>
                                                    <dd class="col-6 text-end">
                                                        <s>$5.00</s> <span class="badge bg-label-success">Free</span>
                                                    </dd>

                                                    <hr/>

                                                    <dt class="col-6">Total</dt>
                                                    <dd class="col-6 text-end fw-semibold mb-0">$1100.00</dd>
                                                </dl>
                                            </div>
                                            <div class="d-grid">
                                                <button class="btn btn-primary btn-next">Place Order</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Payment -->
                                <div id="checkout-payment" class="content">
                                    <div class="row">
                                        <!-- Payment left -->
                                        <div class="col-xl-9 mb-3 mb-xl-0">
                                            <!-- Offer alert -->
                                            <%--                      <div class="alert alert-success alert-dismissible" role="alert">--%>
                                            <%--                        <div class="fw-bold">Bank Offers</div>--%>
                                            <%--                        <ul class="list-unstyled mb-0">--%>
                                            <%--                          <li>- 0% Instant Discount on Bank of America Corp Bank Debit and Credit cards</li>--%>
                                            <%--                          <li>- 50% Cashback Voucher of up to $60 on first ever PayPal transaction. TCA</li>--%>
                                            <%--                        </ul>--%>
                                            <%--                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>--%>
                                            <%--                      </div>--%>

                                            <!-- Payment Tabs -->
                                            <div class="col-xxl-6 col-lg-8">
                                                <ul class="nav nav-pills" id="paymentTabs" role="tablist">
                                                    <li class="nav-item" role="presentation">
                                                        <button
                                                                class="nav-link active"
                                                                id="pills-cc-tab"
                                                                data-bs-toggle="pill"
                                                                data-bs-target="#pills-cc"
                                                                type="button"
                                                                role="tab"
                                                                aria-controls="pills-cc"
                                                                aria-selected="true"
                                                        >
                                                            Point
                                                        </button>
                                                    </li>
                                                    <li class="nav-item" role="presentation">
                                                        <button
                                                                class="nav-link"
                                                                id="pills-cod-tab"
                                                                data-bs-toggle="pill"
                                                                data-bs-target="#pills-cod"
                                                                type="button"
                                                                role="tab"
                                                                aria-controls="pills-cod"
                                                                aria-selected="false"
                                                        >
                                                            Cash On Delivery
                                                        </button>
                                                    </li>
                                                </ul>
                                                <div class="tab-content" id="paymentTabsContent">
                                                    <!-- Credit card -->
                                                    <div
                                                            class="tab-pane fade show active"
                                                            id="pills-cc"
                                                            role="tabpanel"
                                                            aria-labelledby="pills-cc-tab"
                                                    >
                                                        <div class="row g-3">
                                                            <div class="col-12">
                                                                <label class="form-label w-100">Your Point</label>
                                                            </div>
                                                            <div class="col-12 col-md-6">
                                                                <label class="form-label">1000</label>
                                                            </div>
                                                            <div class="col-12">
                                                                <label class="switch">
                                                                    <span class="switch-label">Not enough point?</span>
                                                                </label>
                                                            </div>
                                                            <div class="col-12">
                                                                <button type="button"
                                                                        class="btn btn-primary btn-next me-1 me-sm-3">
                                                                    Submit
                                                                </button>
                                                                <button type="reset" class="btn btn-label-secondary">
                                                                    Cancel
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <!-- COD -->
                                                    <div class="tab-pane fade" id="pills-cod" role="tabpanel"
                                                         aria-labelledby="pills-cod-tab">
                                                        <p class="fw-semibold">
                                                            Cash on Delivery is a type of payment method where the
                                                            recipient make payment for the
                                                            order at the time of delivery rather than in advance.
                                                        </p>
                                                        <button type="button" class="btn btn-primary btn-next">Pay On
                                                            Delivery
                                                        </button>
                                                    </div>

                                                    <!-- Gift card -->

                                                </div>
                                            </div>
                                        </div>
                                        <!-- Address right -->
                                        <div class="col-xl-3">
                                            <div class="border rounded p-3">
                                                <!-- Price Details -->
                                                <h6>Price Details</h6>
                                                <dl class="row">
                                                    <dt class="col-6 fw-normal">Order Total</dt>
                                                    <dd class="col-6 text-end">$1100.00</dd>

                                                    <dt class="col-6 fw-normal">Delivery Charges</dt>
                                                    <dd class="col-6 text-end">
                                                        <s>$5.00</s> <span class="badge bg-label-success">Free</span>
                                                    </dd>

                                                    <hr/>

                                                    <dt class="col-6">Total</dt>
                                                    <dd class="col-6 text-end fw-semibold mb-0">$1100.00</dd>

                                                    <dt class="col-6">Deliver to:</dt>
                                                    <dd class="col-6 text-end fw-semibold mb-0">
                                                        <span class="badge bg-label-primary">Home</span>
                                                    </dd>
                                                </dl>
                                                <!-- Address Details -->
                                                <address>
                                                    <span class="fw-semibold"> John Doe (Default),</span><br/>
                                                    4135 Parkway Street, <br/>
                                                    Los Angeles, CA, 90017. <br/>
                                                    Mobile : +1 906 568 2332
                                                </address>
                                                <a href="javascript:void(0)">Change address</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Confirmation -->
                                <div id="checkout-confirmation" class="content">
                                    <div class="row mb-3">
                                        <div class="col-12 col-lg-8 offset-lg-2 text-center mb-3">
                                            <h4 class="mt-2">Thank You! 😇</h4>
                                            <p>Your order <a href="javascript:void(0)">#1536548131</a> has been placed!
                                            </p>
                                            <p>
                                                We sent an email to <a href="mailto:john.doe@example.com">john.doe@example.com</a>
                                                with your
                                                order confirmation and receipt. If the email hasn't arrived within two
                                                minutes, please check
                                                your spam folder to see if the email was routed there.
                                            </p>
                                            <p>
                                                <span class="fw-semibold"><i
                                                        class="bx bx-time-five"></i> Time placed:</span> 25/05/2020
                                                13:35pm
                                            </p>
                                        </div>
                                        <!-- Confirmation details -->
                                        <div class="col-12">
                                            <ul class="list-group list-group-horizontal-md">
                                                <li class="list-group-item flex-fill">
                                                    <h6><i class="bx bx-map"></i> Shipping</h6>
                                                    <address>
                                                        John Doe <br/>
                                                        4135 Parkway Street,<br/>
                                                        Los Angeles, CA 90017,<br/>
                                                        USA <br/>
                                                        +123456789
                                                    </address>
                                                </li>
                                                <li class="list-group-item flex-fill">
                                                    <h6><i class="bx bx-credit-card"></i> Billing Address</h6>
                                                    <address>
                                                        John Doe <br/>
                                                        4135 Parkway Street,<br/>
                                                        Los Angeles, CA 90017,<br/>
                                                        USA <br/>
                                                        +123456789
                                                    </address>
                                                </li>
                                                <li class="list-group-item flex-fill">
                                                    <h6><i class="bx bx-train"></i> Shipping Method</h6>
                                                    <span class="fw-semibold">Preferred Method:</span><br/>
                                                    Standard Delivery<br/>
                                                    (Normally 3-4 business days)
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <!-- Confirmation items -->
                                        <div class="col-xl-9 mb-3 mb-xl-0">
                                            <ul class="list-group">
                                                <li class="list-group-item">
                                                    <div class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="../admin/assets/img/products/1.png"
                                                                 alt="google home" class="w-px-75"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <div class="row">
                                                                <div class="d-flex col-md-8 flex-column justify-content-center">
                                                                    <a href="javascript:void(0)" class="text-body">
                                                                        <span>Google - Google Home - White</span>
                                                                    </a>
                                                                    <div class="d-flex flex-wrap text-muted my-1">
                                                                        <span class="me-1">Sold by:</span>
                                                                        <a href="javascript:void(0)"
                                                                           class="me-1">Apple</a>
                                                                        <span class="badge bg-label-success">In Stock</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="text-md-end">
                                                                        <div class="my-2 my-lg-4">
                                                                            <span class="text-primary">$299/</span><s
                                                                                class="text-muted">$359</s>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="gap-3 d-flex">
                                                        <div class="flex-shrink-0">
                                                            <img src="../admin/assets/img/products/2.png"
                                                                 alt="google home" class="w-px-75"/>
                                                        </div>
                                                        <div class="flex-grow-1">
                                                            <div class="row">
                                                                <div class="d-flex col-md-8 flex-column justify-content-center">
                                                                    <a href="javascript:void(0)" class="text-body">
                                                                        <span>Apple iPhone 11 (64GB, Black)</span>
                                                                    </a>
                                                                    <div class="d-flex flex-wrap text-muted my-1">
                                                                        <span class="me-1">Sold by:</span>
                                                                        <a href="javascript:void(0)"
                                                                           class="me-1">Apple</a>
                                                                        <span class="badge bg-label-success">In Stock</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="text-md-end">
                                                                        <div class="my-2 my-lg-4">
                                                                            <span class="text-primary">$299/</span><s
                                                                                class="text-muted">$359</s>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <!-- Confirmation total -->
                                        <div class="col-xl-3">
                                            <div class="border rounded p-3">
                                                <!-- Price Details -->
                                                <h6>Price Details</h6>
                                                <dl class="row mb-0">
                                                    <dt class="col-6 fw-normal">Order Total</dt>
                                                    <dd class="col-6 text-end">$1100.00</dd>

                                                    <dt class="col-6 fw-normal">Delivery Charges</dt>
                                                    <dd class="col-6 text-end">
                                                        <s>$5.00</s> <span class="badge bg-label-success">Free</span>
                                                    </dd>

                                                    <hr/>

                                                    <dt class="col-6">Total</dt>
                                                    <dd class="col-6 text-end fw-semibold mb-0">$1100.00</dd>
                                                </dl>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--/ Checkout Wizard -->

                    <!-- Add new address modal -->
                    <!-- Add New Address Modal -->
                    <div class="modal fade" id="addNewAddress" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog modal-lg modal-simple modal-add-new-address">
                            <div class="modal-content p-3 p-md-5">
                                <div class="modal-body">
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    <div class="text-center mb-4">
                                        <h3 class="address-title">Add New Address</h3>
                                        <p class="address-subtitle">Add new address for express delivery</p>
                                    </div>
                                    <form id="addNewAddressForm" class="row g-3" onsubmit="return false">
                                        <div class="col-12">
                                            <div class="row">
                                                <div class="col-md mb-3 mb-md-2">
                                                    <div class="form-check custom-option custom-option-icon">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioHome">
                                  <span class="custom-option-body">
                                    <i class="bx bx-home"></i>
                                    <span class="custom-option-title my-2">Home</span>
                                    <span> Delivery time (9am – 9pm) </span>
                                  </span>
                                                            <input
                                                                    name="customRadioIcon"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioHome"
                                                                    checked
                                                            />
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md mb-3 mb-md-2">
                                                    <div class="form-check custom-option custom-option-icon">
                                                        <label class="form-check-label custom-option-content"
                                                               for="customRadioOffice">
                                  <span class="custom-option-body">
                                    <i class="bx bx-briefcase"></i>
                                    <span class="custom-option-title my-2"> Office </span>
                                    <span> Delivery time (9am – 5pm) </span>
                                  </span>
                                                            <input
                                                                    name="customRadioIcon"
                                                                    class="form-check-input"
                                                                    type="radio"
                                                                    value=""
                                                                    id="customRadioOffice"
                                                            />
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12 ">
                                            <label class="form-label" for="modalAddressFirstName">Name</label>
                                            <input
                                                    type="text"
                                                    id="modalAddressFirstName"
                                                    name="modalAddressFirstName"
                                                    class="form-control"
                                                    placeholder="John"
                                            />
                                        </div>
                                        <div class="col-12">
                                            <label class="form-label" for="modalAddressLastName">Phone</label>
                                            <input
                                                    type="text"
                                                    id="modalAddressLastName"
                                                    name="modalAddressLastName"
                                                    class="form-control"
                                                    placeholder="012323"
                                            />
                                        </div>
                                        <div class="col-12">
                                            <label class="form-label" for="modalAddressCountry">Country</label>
                                            <select
                                                    id="modalAddressCountry"
                                                    name="modalAddressCountry"
                                                    class="select2 form-select"
                                                    data-allow-clear="true"
                                            >
                                                <option value="">Select</option>
                                                <option value="vietnam">Viet Nam</option>
                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label class="form-label" for="modalAddressAddress1">Address</label>
                                            <input
                                                    type="text"
                                                    id="modalAddressAddress1"
                                                    name="modalAddressAddress1"
                                                    class="form-control"
                                                    placeholder="12, Business Park"
                                            />
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label class="form-label" for="modalAddressCity">City</label>
                                            <input
                                                    type="text"
                                                    id="modalAddressCity"
                                                    name="modalAddressCity"
                                                    class="form-control"
                                                    placeholder="Los Angeles"
                                            />
                                        </div>
                                        <div class="col-12 col-md-6">
                                            <label class="form-label" for="modalAddressZipCode">Zip Code</label>
                                            <input
                                                    type="text"
                                                    id="modalAddressZipCode"
                                                    name="modalAddressZipCode"
                                                    class="form-control"
                                                    placeholder="99950"
                                            />
                                        </div>
                                        <div class="col-12 text-center mt-4">
                                            <button type="submit" class="btn btn-primary me-1 me-sm-3">Submit</button>
                                            <button
                                                    type="reset"
                                                    class="btn btn-label-secondary"
                                                    data-bs-dismiss="modal"
                                                    aria-label="Close"
                                            >
                                                Cancel
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--/ Add New Address Modal -->
                </div>
                <!--/ Content -->

                <!-- Footer -->
                <footer class="content-footer footer bg-footer-theme">
                    <div class="container-xxl d-flex flex-column flex-md-row flex-wrap justify-content-between py-2">
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
                            <a href="https://themeforest.net/licenses/standard" class="footer-link me-4" target="_blank"
                            >License</a
                            >
                            <a href="https://1.envato.market/pixinvent_portfolio" target="_blank"
                               class="footer-link me-4"
                            >More Themes</a
                            >

                            <a
                                    href="https://pixinvent.com/demo/frest-clean-bootstrap-admin-dashboard-template/documentation-bs5/"
                                    target="_blank"
                                    class="footer-link me-4"
                            >Documentation</a
                            >

                            <a href="https://pixinvent.ticksy.com/" target="_blank"
                               class="footer-link d-none d-sm-inline-block"
                            >Support</a
                            >
                        </div>
                    </div>
                </footer>
                <!-- / Footer -->

                <div class="content-backdrop fade"></div>
            </div>
            <!--/ Content wrapper -->
        </div>

        <!--/ Layout container -->
    </div>
</div>

<!-- Overlay -->
<div class="layout-overlay layout-menu-toggle"></div>

<!-- Drag Target Area To SlideIn Menu On Small Screens -->
<div class="drag-target"></div>
<!--/ Layout wrapper -->

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/popper/popper.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/hammer/hammer.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/i18n/i18n.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/typeahead-js/typeahead.js"></script>

<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/select2/select2.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/bs-stepper/bs-stepper.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/rateyo/rateyo.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/cleavejs/cleave.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/cleavejs/cleave-phone.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/formvalidation/dist/js/FormValidation.min.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/formvalidation/dist/js/plugins/Bootstrap5.min.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/vendor/libs/formvalidation/dist/js/plugins/AutoFocus.min.js"></script>

<!-- Main JS -->
<script src="${pageContext.request.contextPath}/view/admin/assets/js/main.js"></script>

<!-- Page JS -->

<script src="${pageContext.request.contextPath}/view/admin/assets/js/modal-add-new-address.js"></script>
<script src="${pageContext.request.contextPath}/view/admin/assets/js/wizard-ex-checkout.js"></script>
</body>
</html>
