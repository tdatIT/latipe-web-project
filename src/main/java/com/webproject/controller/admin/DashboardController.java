package com.webproject.controller.admin;

import com.webproject.model.Orders;
import com.webproject.model.Product;
import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.service.IOrderService;
import com.webproject.service.IProductService;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.OrderServiceImpl;
import com.webproject.service.impl.ProductServiceImpl;
import com.webproject.service.impl.StoreServiceImpl;
import com.webproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = {"/admin"})
public class DashboardController extends HttpServlet {

    IUserService userService = new UserServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    IProductService prodService = new ProductServiceImpl();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            String option = req.getParameter("option") != null ? req.getParameter("option") : "0";
            LocalDate date = req.getParameter("date") != null ? LocalDate.parse(req.getParameter("date")) : LocalDate.now();
            List<User> users = userService.getStatistic(option, date);
            List<Store> stores = storeService.getStatistic(option, date);
            List<Orders> orders = orderService.getStatistic(option, date);
            List<Product> prods = prodService.getStatistic(option, date);


            // thong ke
            HashMap<Integer, Integer> dataUser = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> dataStore = new HashMap<Integer, Integer>();
            HashMap<Integer, Double> dataOrder = new HashMap<Integer, Double>();
            HashMap<Integer, Integer> dataProd = new HashMap<Integer, Integer>();

            //////user
            if (users != null) {
                for (User user : users) {
                    switch (option) {
                        case "0": {
                            if (!dataUser.containsKey(user.getCreateDate().getMonth() + 1))
                                dataUser.put(user.getCreateDate().getMonth() + 1, 1);
                            else
                                dataUser.replace(user.getCreateDate().getMonth() + 1, 1 + dataUser.get(user.getCreateDate().getMonth() + 1));
                            break;
                        }
                        case "1": {
                            if (!dataUser.containsKey(user.getCreateDate().getDate()))
                                dataUser.put(user.getCreateDate().getDate(), 1);
                            else
                                dataUser.replace(user.getCreateDate().getDate(), 1 + dataUser.get(user.getCreateDate().getDate()));
                            break;
                        }
                        case "2": {
                            if (!dataUser.containsKey(user.getCreateDate().getDate()))
                                dataUser.put(user.getCreateDate().getDate(), 1);
                            else
                                dataUser.replace(user.getCreateDate().getDate(), 1 + dataUser.get(user.getCreateDate().getDate()));
                            break;
                        }
                    }

                }
            }
            /// store
            if (stores != null) {
                for (Store store : stores) {
                    switch (option) {
                        case "0": {
                            if (!dataStore.containsKey(store.getCreateDate().getMonth() + 1))
                                dataStore.put(store.getCreateDate().getMonth() + 1, 1);
                            else
                                dataStore.replace(store.getCreateDate().getMonth() + 1, 1 + dataStore.get(store.getCreateDate().getMonth() + 1));
                            break;
                        }
                        case "1": {
                            if (!dataStore.containsKey(store.getCreateDate().getDate()))
                                dataStore.put(store.getCreateDate().getDate(), 1);
                            else
                                dataStore.replace(store.getCreateDate().getDate(), 1 + dataStore.get(store.getCreateDate().getDate()));
                            break;
                        }
                        case "2": {
                            if (!dataStore.containsKey(store.getCreateDate().getDate()))
                                dataStore.put(store.getCreateDate().getDate(), 1);
                            else
                                dataStore.replace(store.getCreateDate().getDate(), 1 + dataStore.get(store.getCreateDate().getDate()));
                            break;
                        }
                    }

                }
            }
            /// order
            if (orders != null) {
                for (Orders store : orders) {
                    switch (option) {
                        case "0": {
                            if (!dataOrder.containsKey(store.getCreateDate().getMonth() + 1))
                                dataOrder.put(store.getCreateDate().getMonth() + 1, store.getAmountToGd());
                            else
                                dataOrder.replace(store.getCreateDate().getMonth() + 1, store.getAmountToGd() + dataOrder.get(store.getCreateDate().getMonth() + 1));
                            break;
                        }
                        case "1": {
                            if (!dataOrder.containsKey(store.getCreateDate().getDate()))
                                dataOrder.put(store.getCreateDate().getDate(), store.getAmountToGd());
                            else
                                dataOrder.replace(store.getCreateDate().getDate(), store.getAmountToGd() + dataOrder.get(store.getCreateDate().getDate()));
                            break;
                        }
                        case "2": {
                            if (!dataOrder.containsKey(store.getCreateDate().getDate()))
                                dataOrder.put(store.getCreateDate().getDate(), store.getAmountToGd());
                            else
                                dataOrder.replace(store.getCreateDate().getDate(), store.getAmountToGd() + dataOrder.get(store.getCreateDate().getDate()));
                            break;
                        }
                    }

                }
            }
            /// product
            if (prods != null) {
                for (Product store : prods) {
                    switch (option) {
                        case "0": {
                            if (!dataProd.containsKey(store.getCreateDate().getMonth() + 1))
                                dataProd.put(store.getCreateDate().getMonth() + 1, 1);
                            else
                                dataProd.replace(store.getCreateDate().getMonth() + 1, 1 + dataProd.get(store.getCreateDate().getMonth() + 1));
                            break;
                        }
                        case "1": {
                            if (!dataProd.containsKey(store.getCreateDate().getDate()))
                                dataProd.put(store.getCreateDate().getDate(), 1);
                            else
                                dataProd.replace(store.getCreateDate().getDate(), 1 + dataProd.get(store.getCreateDate().getDate()));
                            break;
                        }
                        case "2": {
                            if (!dataProd.containsKey(store.getCreateDate().getDate()))
                                dataProd.put(store.getCreateDate().getDate(), 1);
                            else
                                dataProd.replace(store.getCreateDate().getDate(), 1 + dataProd.get(store.getCreateDate().getDate()));
                            break;
                        }
                    }

                }
            }

            req.setAttribute("users", dataUser);
            req.setAttribute("stores", dataStore);
            req.setAttribute("orders", dataOrder);
            req.setAttribute("prods", dataProd);

            // count
            req.setAttribute("coutUser", userService.findAll().stream().count());
            req.setAttribute("coutShop", storeService.findAll().stream().count());
            req.setAttribute("coutProd", prodService.findAll().stream().count());

            //
            double money = 0;
            if (orders != null)
                for (Orders f : orders) {
                    money += f.getAmountToGd();
                }
            req.setAttribute("coutNewUser", users != null ? users.stream().count() : 0);
            req.setAttribute("coutNewShop", stores != null ? stores.stream().count() : 0);
            req.setAttribute("coutNewProfit", money);

            // test admin
            req.setAttribute("user", userService.findById(999));
            req.setAttribute("date", date);
            req.setAttribute("option", option);
            req.getRequestDispatcher("view/admin/Dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
