package com.webproject.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@WebServlet(urlPatterns = {"/admin/getStatitis"})
public class GetStatisticController extends HttpServlet {

    IUserService userService = new UserServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    IProductService prodService = new ProductServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.USER_ID) == null){
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        if((Integer) session.getAttribute(SessionVar.ROLE_ID) != 1) {
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        User user1 = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
        req.setAttribute("user", user1);
        req.setCharacterEncoding("utf-8");
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



        //
        double money = 0;
        if (orders != null)
            for (Orders f : orders) {
                money += f.getAmountToGd();
            }


        // test admin
        req.setAttribute("user", userService.findById(999));


        String data = "{";
        data += "\"users\": " + new ObjectMapper().writeValueAsString(dataUser);
        data += ",\"stores\": " + new ObjectMapper().writeValueAsString(dataStore);
        data += ",\"orders\": " + new ObjectMapper().writeValueAsString(dataOrder);
        data += ",\"prods\": " + new ObjectMapper().writeValueAsString(dataProd);
        data += ",\"coutNewUser\": " +  users.size() ;
        data += ",\"coutNewShop\": " +  stores.size();
        data += ",\"coutNewProfit\": " +  money + "}";
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();

    }
}
