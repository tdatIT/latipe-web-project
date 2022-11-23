package com.webproject.variable;

public class Router {
    //JSP file mapping
    //Page for user...
    public static final String HOME_PAGE = "view/web/index.jsp";
    public static final String LOGIN_PAGE = "view/web/login.jsp";
    public static final String SIGNUP_PAGE = "view/web/signup.jsp";
    public static final String FORGET_PASS_PAGE = "view/web/forget.jsp";

    public static final String ERROR_404_PAGE = "view/web/error404.html";

    //Page for vendor
    public static final String STORE_DETAIL = "view/vendor/store-detail.jsp";
    public static final String STORE_LOGIN_PAGE = "view/vendor/store-login.jsp";
    public static final String STORE_DASHBOARD = "view/vendor/dashboard.jsp";
    public static final String S_PRODUCT_PAGE = "view/vendor/store-product.jsp";
    public static final String S_PRODUCT_INFO_PAGE = "view/vendor/product-info.jsp";

    public static final String S_ORDER_M = "view/vendor/store-order.jsp";
    public static final String S_ORDER_P = "view/vendor/order-detail.jsp";
    public static final String S_EMP_M = "view/vendor/store-emp.jsp";
    public static final String S_ANALYTICS_M = "view/vendor/store-analytics.jsp";
    public static final String S_INFO_PAGE = "view/vendor/store-profile.jsp";
    public static final String S_CREATE_PAGE = "view/web/store-register.jsp";
    public static final String S_UPDATE_INF_PAGE = "view/vendor/store-update.jsp";
    //Page for admin
    public static final String ADMIN_DASHBOARD = "view/admin/index.jsp";

    //URL Servlet Mapping
    //User
    public static final String HOME = "/home";
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String FORGET = "/forget";
    public static final String ERROR404 = "/error404";
    public static final String LOGOUT = "/logout";


    //vendor
    public static final String STORE = "/store";
    public static final String STORE_LOGIN = "/store-admin-login";
    public static final String STORE_FILTER = "/store-admin";
    public static final String STORE_D = "/store-admin/dashboard";
    public static final String STORE_P = "/store-admin/product";
    public static final String S_PRODUCT_C = "/store-admin/product-create";
    public static final String S_PRODUCT_U = "/store-admin/product-update";
    public static final String S_PRODUCT_D = "/store-admin/product-delete";
    public static final String STORE_O = "/store-admin/order";
    public static final String STORE_O_P = "/store-admin/order-process";
    public static final String STORE_O_D = "/store-admin/order-delete";
    public static final String STORE_E = "/store-admin/employee";
    public static final String STORE_A = "/store-admin/analytics";

    public static final String STORE_INFO = "/store-admin/info";
    public static final String STORE_CREATE = "/register-store";
    public static final String STORE_UPDATE = "/store-admin/update-info";


    //Admin

}
