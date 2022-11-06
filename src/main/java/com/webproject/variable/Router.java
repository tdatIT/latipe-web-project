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
    public static final String S_PRODUCT_M = "view/vendor/store-product.jsp";
    public static final String S_ORDER_M = "view/vendor/store-order.jsp";
    public static final String S_EMP_M = "view/vendor/store-emp.jsp";
    public static final String S_ANALYTICS_M = "view/vendor/store-analytics.jsp";
    //Page for admin


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
    public static final String STORE_O = "/store-admin/order";
    public static final String STORE_E = "/store-admin/employee";
    public static final String STORE_A = "/store-admin/analytics";

    //Admin

}
