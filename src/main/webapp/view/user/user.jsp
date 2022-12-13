<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en" class="light-style layout-navbar-fixed layout-menu-fixed" dir="ltr" data-theme="theme-default"
      data-assets-path="../admin/assets/" data-template="vertical-menu-template-no-customizer">

<head>
  <meta charset="utf-8" />
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

  <title>User View - Pages | Frest - Bootstrap Admin Template</title>

  <meta name="description" content="" />

  <!-- Favicon -->
  <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico" />

  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
          href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Rubik:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet" />

  <!-- Icons -->
  <link rel="stylesheet" href="../admin/assets/vendor/fonts/boxicons.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/fonts/fontawesome.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/fonts/flag-icons.css" />

  <!-- Core CSS -->
  <link rel="stylesheet" href="../admin/assets/vendor/css/rtl/core.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/css/rtl/theme-default.css" />
  <link rel="stylesheet" href="../admin/assets/css/demo.css" />

  <!-- Vendors CSS -->
  <link rel="stylesheet" href="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/typeahead-js/typeahead.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/datatables-bs5/datatables.bootstrap5.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/datatables-responsive-bs5/responsive.bootstrap5.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/datatables-buttons-bs5/buttons.bootstrap5.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/animate-css/animate.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/sweetalert2/sweetalert2.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/select2/select2.css" />
  <link rel="stylesheet" href="../admin/assets/vendor/libs/formvalidation/dist/css/formValidation.min.css" />




  <!-- Css Styles -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/bootstrap.min.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/font-awesome.min.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/elegant-icons.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/nice-select.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/jquery-ui.min.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/owl.carousel.min.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/slicknav.min.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/style.css" type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/profile.css" type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/bundleprofile.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/profilelegacy.css"
        type="text/css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/user/assets/css/changeemail.css"
        type="text/css"/>
  <!-- Page CSS -->

  <link rel="stylesheet" href="../admin/assets/vendor/css/pages/page-user-view.css" />
  <!-- Helpers -->
  <script src="../admin/assets/vendor/js/helpers.js"></script>

  <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
  <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
  <script src="../admin/assets/js/config.js"></script>
</head>


<header class="header">
  <div class="header__top">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6">
          <div class="header__top__left">
            <ul>
              <li><i class="fa fa-envelope"></i> f-prj-web@utefit.com</li>
              <li>Miễn phí ship cho tất cả đơn hàng trên 50K từ 20/10</li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6 col-md-6">
          <div class="header__top__right">
            <div class="header__top__right__social">
              <a href="#"><i class="fa fa-facebook"></i></a>
              <a href="#"><i class="fa fa-linkedin"></i></a>
            </div>
            <div class="header__top__right__social">
              <a href="signin.html"><i class="fa fa-sign-in" style="margin-right:5px ;"></i>Đăng Nhập</a>

            </div>
            <div class="header__top__right__auth">
              <a href="signup.html"><i class="fa fa-user"></i>Đăng ký</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container">

    <div class="row">
      <div class="col-lg-3">
        <div class="header__logo">
          <a href="./index.html"><img src="assets\img\logo.png" alt=""></a>
        </div>
      </div>
      <div class="col-lg-6">
        <nav class="header__menu">
          <ul>

            <li>
              <div class="hero__search__form">
                <form action="#">
                  <input type="text" placeholder="Tìm kiếm sản phẩm ...">
                  <button type="submit" class="site-btn">SEARCH</button>
                </form>
              </div>
            </li>
          </ul>
        </nav>
      </div>
      <div class="col-lg-3">
        <div class="header__cart">
          <ul>
            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
          </ul>
          <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
      </div>
    </div>
    <div class="humberger__open">
      <i class="fa fa-bars"></i>
    </div>
  </div>
</header>


<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
  <div class="layout-container">
    <!-- Menu -->


    <!-- / Menu -->

    <!-- Layout container -->
    <div class="layout-page">
      <!-- Navbar -->



      <!-- / Navbar -->

      <!-- Content wrapper -->
      <div class="content-wrapper">
        <!-- Content -->

        <div class="container-xxl flex-grow-1 container-p-y">

          <div class="row gy-4">
            <!-- User Sidebar -->
            <div class="col-md-5 col-lg-5 col-xl-4 order-1 order-md-0">
              <!-- User Card -->
              <div class="card mb-4">
                <div class="card-body">
                  <div class="user-avatar-section">
                    <div class="d-flex flex-column align-items-center">
                      <img class="img-fluid rounded my-4" src="../admin/assets/img/avatars/10.png" height="110"
                           width="110" alt="User avatar" />
                      <div class="user-info text-center">
                        <h5 class="mb-2">Violet Mendoza</h5>
                        <span class="badge bg-label-secondary">Author</span>
                      </div>
                    </div>
                  </div>

                  <h5 class="border-bottom pb-2 mb-4">Details</h5>
                  <div class="info-container">
                    <ul class="list-unstyled">
                      <li class="mb-3">
                        <span class="fw-bold me-2">First Name:</span>
                        <span id="userFN">violet.dev</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">Last Name:</span>
                        <span id="userLN">sdads</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">Phone:</span>
                        <span id="userPhone">12321323</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">Email:</span>
                          <span id="userEmail">vafgot@vultukir.org</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">CCCD/CMND:</span>
                        <span id="userCCCD">231232321</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">Point:</span>
                        <span>12</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">E_Wallet:</span>
                        <span>123</span>
                      </li>

                      <li class="mb-3">
                        <span class="fw-bold me-2">Status:</span>
                        <span class="badge bg-label-success">Active</span>
                      </li>
                      <li class="mb-3">
                        <span class="fw-bold me-2">Role:</span>
                        <span>User</span>
                      </li>
                    </ul>
                    <div class="d-flex justify-content-center pt-3">
                      <a href="javascript:;" class="btn btn-primary me-3" data-bs-target="#editUser" id="btn-edituser"
                         data-bs-toggle="modal">Edit</a>
                      <a href="javascript:;" class="btn btn-label-danger suspend-user">Suspended</a>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /User Card -->
              <!-- Plan Card -->
              <!-- /Plan Card -->
            </div>
            <!--/ User Sidebar -->

            <!-- User Content -->
            <div class="col-md-7 col-lg-7 col-xl-8 order-0 order-md-1">
              <!-- User Pills -->
              <ul class="nav nav-pills flex-column flex-md-row mb-3">
                <li class="nav-item">
                  <a class="nav-link active" id="display-address"><i class="bx bx-user me-1"></i>Address</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="display-sec"><i class="bx bx-lock-alt me-1"></i>Security</a>
                </li>
              </ul>
              <!--/ User Pills -->

              <!-- Project table -->

              <!-- /Project table -->

              <!-- Activity Timeline -->
              <!-- Address -->
              <div class="card mb-4" id="card-address">
                <h5 class="card-header">
                  Address
                </h5>
                <div class="card-body">
                  <button type="button" class="btn btn-label-primary mb-4" data-bs-toggle="modal"
                          data-bs-target="#addNewAddress" id="showAdd">
                    Add new address
                  </button>

                  <div class="form-check custom-option custom-option-basic checked" id="click-address">
                    <label class="form-check-label custom-option-content" for="customRadioAddress1">
                        <span class="custom-option-header">
                          <span class="h6 mb-0" id="address-name-1">John Doe (Default)</span>
                        </span>
                      <span class="custom-option-body">
                          <div>
                            <small>Phone:</small>
                            <small id="address-phone-1">03532</small>
                            <small> Zip Code:</small>
                            <small id="address-zipcode-1">TP Hcm</small>
                          </div>
                          <div> <small>Country:</small>
                            <small id="address-country-1">Viet Nam</small>
                            <small>City:</small>
                            <small id="address-city-1">TP Hcm</small>
                          </div>

                          <small class="d-flex mt-3 " style="float:right">
                            <a class="me-2 edit-address" data-bs-target="#addNewAddress" data-bs-toggle="modal"
                               id="address-1">Edit</a>
                            <a href="javascript:void(0)">Remove</a>
                          </small>
                        </span>
                    </label>
                  </div>
                </div>
              </div>
              <!-- Sec -->
              <div class="card mb-4" id="card-password" style="display: none">
                <h5 class="card-header">Change Password</h5>
                <div class="card-body">
                  <form id="formChangePassword" method="POST" onsubmit="return false">
                    <div class="alert alert-warning" role="alert">
                      <h6 class="alert-heading mb-1">Ensure that these requirements are met</h6>
                      <span>Minimum 8 characters long, uppercase & symbol</span>
                    </div>
                    <div class="row">
                      <div class="form-password-toggle col-12 col-sm-6 mb-3">
                        <label class="form-label" for="newPassword">New Password</label>
                        <div class="input-group input-group-merge">
                          <input class="form-control" type="password" id="newPassword" name="newPassword"
                                 placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;" />
                          <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                        </div>
                      </div>

                      <div class="form-password-toggle col-12 col-sm-6 mb-3">
                        <label class="form-label" for="confirmPassword">Confirm New Password</label>
                        <div class="input-group input-group-merge">
                          <input class="form-control" type="password" name="confirmPassword" id="confirmPassword"
                                 placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;" />
                          <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                        </div>
                      </div>
                      <div>
                        <button type="submit" class="btn btn-primary me-2">Change Password</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
              <!-- /Activity Timeline -->

              <!-- Invoice table -->
              <!-- /Invoice table -->
            </div>
            <!--/ User Content -->
          </div>

          <!-- Modal -->
          <!-- Address Model -->
          <div class="modal fade" id="addNewAddress" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-simple modal-add-new-address">
              <div class="modal-content p-3 p-md-5">
                <div class="modal-body">
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  <div class="text-center mb-4">
                    <h3 class="address-title" >Add New Address</h3>
                    <p class="address-subtitle">Add new address for express delivery</p>
                  </div>
                  <form id="addNewAddressForm" class="row g-3" onsubmit="return false" action="userAddress/create" >
                    <div class="col-12 " style="display: none">
                      <input type="text" id="address_id" name="address_id" class="form-control" placeholder="John" />
                    </div>
                    <div class="col-12 ">
                      <label class="form-label" for="modalAddressName">Name</label>
                      <input type="text" id="modalAddressName" name="name_recipient" class="form-control"
                             placeholder="John" />
                    </div>
                    <div class="col-12">
                      <label class="form-label" for="modalAddressPhone">Phone</label>
                      <input type="text" id="modalAddressPhone" name="number_phone" class="form-control"
                             placeholder="012323" />
                    </div>
                    <div class="col-12 col-md-6">
                      <label class="form-label" for="modalAddressCountry">Country</label>
                      <input type="text" id="modalAddressCountry" name="country" class="form-control"
                             placeholder="Viet Nam" />
                    </div>
                    <div class="col-12  col-md-6">
                      <label class="form-label" for="modalAddressCity">Address</label>
                      <input type="text" id="modalAddressCity" name="city" class="form-control"
                             placeholder="12, Business Park" />
                    </div>
                    <div class="col-12">
                      <label class="form-label" for="modalAddressZipCode">Zip Code</label>
                      <input type="text" id="modalAddressZipCode" name="zipcode" class="form-control"
                             placeholder="99950" />
                    </div>
                    <div class="col-12 text-center mt-4">
                      <button type="submit" class="btn btn-primary me-1 me-sm-3">Submit</button>
                      <button type="reset" class="btn btn-label-secondary" data-bs-dismiss="modal" aria-label="Close">
                        Cancel
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!-- Edit User Modal -->
          <div class="modal fade" id="editUser" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-simple modal-edit-user">
              <div class="modal-content p-3 p-md-5">
                <div class="modal-body">
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  <div class="text-center mb-4">
                    <h3>Edit User Information</h3>
                    <p>Updating user details will receive a privacy audit.</p>
                  </div>
                  <form id="editUserForm" class="row g-3" onsubmit="return false" action="userAddress/edit">
                    <div class="col-12">
                      <label class="form-label" for="edit-pic-review">Avatar review</label>
                      <img id="edit-pic-review" style="width: 200px; height: 200px" src="" alt="Avatar"
                           class="rounded" />
                    </div>
                    <div class="col-12">
                      <img src="" alt="">
                      <label class="input-group-text" for="inputGroupFile01">Avatar</label>
                      <input type="file" class="form-control pic-edit" id="inputGroupFile01" name="avatar" />
                    </div>
                    <div class="col-12 col-md-6">
                      <label class="form-label" for="modalEditUserFirstName">First Name</label>
                      <input type="text" id="modalEditUserFirstName" name="firstname" class="form-control"
                             placeholder="John" />
                    </div>
                    <div class="col-12 col-md-6">
                      <label class="form-label" for="modalEditUserLastName">Last Name</label>
                      <input type="text" id="modalEditUserLastName" name="lastname" class="form-control"
                             placeholder="Doe" />
                    </div>
                    <div class="col-12">
                      <label class="form-label" for="id_card">CCCD/CMND</label>
                      <input type="text" id="id_card" name="id_card" class="form-control" placeholder="232312323" />
                    </div>
                    <div class="col-12 col-md-6">
                      <label class="form-label" for="modalEditUserEmail">Email</label>
                      <input type="text" id="modalEditUserEmail" name="email" class="form-control"
                             placeholder="example@domain.com" />
                    </div>
                    <div class="col-12 col-md-6">
                      <label class="form-label" for="modalEditUserPhone">Phone Number</label>
                      <div class="input-group input-group-merge">
                        <input type="text" id="modalEditUserPhone" name="phone" class="form-control phone-number-mask"
                               placeholder="202 555 0111" />
                      </div>
                    </div>
                    <div class="col-12 text-center mt-4">
                      <button type="submit" class="btn btn-primary me-1 me-sm-3">Submit</button>
                      <button type="reset" class="btn btn-label-secondary" data-bs-dismiss="modal" aria-label="Close">
                        Cancel
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!--/ Edit User Modal -->

          <!-- Add New Credit Card Modal -->

          <!--/ Add New Credit Card Modal -->

          <!-- /Modal -->
        </div>
        <!-- / Content -->

        <!-- Footer -->

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
<!-- / Layout wrapper -->

<footer class="footer spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="footer__about">
          <div class="footer__about__logo">
            <a href="./index.html"><img src="assets\img\payment-item.png" alt=""></a>
          </div>
          <ul>
            <li>Địa chỉ: Số 1, Võ Văn Ngân, P. Linh Trung, Tp. Thủ Đức, TP. HCM</li>
            <li>Phone: 1900 1099</li>
            <li>Email: f-prj-web@utefit.com</li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
        <div class="footer__widget">
          <h6>Các Trang</h6>
          <ul>
            <li><a href="#">Về chúng tôi</a></li>
            <li><a href="#">Chính sách mua hàng</a></li>
            <li><a href="#">Đăng ký</a></li>
            <li><a href="#">Tuyển dụng</a></li>
            <li><a href="#">Bảo mật</a></li>
            <li><a href="#">Thanh toán</a></li>
          </ul>
          <ul>
            <li><a href="#">Đăng ký</a></li>
            <li><a href="#">Thanh toán</a></li>
            <li><a href="#">Kiếu nại</a></li>
            <li><a href="#">Liên hệ</a></li>
            <li><a href="#">Đóng góp</a></li>
            <li><a href="#">Phát triên</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-4 col-md-12">
        <div class="footer__widget">
          <h6>Nhận thông báo về các khuyến mãi</h6>
          <p>Nhập thông tin mail để chúng tôi cung cấp thông tin khuyên mãi nhanh nhất</p>
          <form action="#">
            <input type="text" placeholder="Nhập vào email">
            <button type="submit" class="site-btn">Đăng ký</button>
          </form>
          <div class="footer__widget__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-pinterest"></i></a>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="footer__copyright">
          <div class="footer__copyright__text">
            <p>
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a
                    href="https://colorlib.com" target="_blank">Colorlib</a>
              - Đề tài cuối kỳ Lập Trình Web HKI 2022-2023
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
          <div class="footer__copyright__payment"><img src="assets\img\payment-item.png" alt=""></div>
        </div>
      </div>
    </div>
  </div>
</footer>

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="../admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../admin/assets/vendor/libs/popper/popper.js"></script>
<script src="../admin/assets/vendor/js/bootstrap.js"></script>
<script src="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../admin/assets/vendor/libs/hammer/hammer.js"></script>
<script src="../admin/assets/vendor/libs/i18n/i18n.js"></script>
<script src="../admin/assets/vendor/libs/typeahead-js/typeahead.js"></script>

<script src="../admin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="../admin/assets/vendor/libs/moment/moment.js"></script>
<script src="../admin/assets/vendor/libs/datatables/jquery.dataTables.js"></script>
<script src="../admin/assets/vendor/libs/datatables-bs5/datatables-bootstrap5.js"></script>
<script src="../admin/assets/vendor/libs/datatables-responsive/datatables.responsive.js"></script>
<script src="../admin/assets/vendor/libs/datatables-responsive-bs5/responsive.bootstrap5.js"></script>
<script src="../admin/assets/vendor/libs/datatables-buttons/datatables-buttons.js"></script>
<script src="../admin/assets/vendor/libs/datatables-buttons-bs5/buttons.bootstrap5.js"></script>
<script src="../admin/assets/vendor/libs/jszip/jszip.js"></script>
<script src="../admin/assets/vendor/libs/pdfmake/pdfmake.js"></script>
<script src="../admin/assets/vendor/libs/datatables-buttons/buttons.html5.js"></script>
<script src="../admin/assets/vendor/libs/datatables-buttons/buttons.print.js"></script>
<script src="../admin/assets/vendor/libs/sweetalert2/sweetalert2.js"></script>
<script src="../admin/assets/vendor/libs/cleavejs/cleave.js"></script>
<script src="../admin/assets/vendor/libs/cleavejs/cleave-phone.js"></script>
<script src="../admin/assets/vendor/libs/select2/select2.js"></script>
<script src="../admin/assets/vendor/libs/formvalidation/dist/js/FormValidation.min.js"></script>
<script src="../admin/assets/vendor/libs/formvalidation/dist/js/plugins/Bootstrap5.min.js"></script>
<script src="../admin/assets/vendor/libs/formvalidation/dist/js/plugins/AutoFocus.min.js"></script>

<!-- Main JS -->
<script src="../admin/assets/js/main.js"></script>

<!-- Page JS -->
<script src="../admin/assets/js/modal-edit-user.js"></script>
<script src="../admin/assets/js/app-user-view.js"></script>
<script src="../admin/assets/js/app-user-view-account.js"></script>
<script src="../user/assets/js/user.js"></script>

</body>

</html>