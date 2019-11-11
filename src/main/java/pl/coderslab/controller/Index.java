package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Ma mieć możliwość przejścia do poszczególnych elementów aplikacji (nawigacja w postaci linków).

        //Wyświetlać aktualnie prowadzone naprawy przez każdego z pracowników z możliwością przejścia do konkretnego zlecenia.

//        OrderDao orderDao = new OrderDao();
//        Order order = (Order) req.getSession().getAttribute("status");
//        String status = order.getStatus();
//
//        List<Order> orders = orderDao.findAllByStatus(status);
//
//        HttpSession session = req.getSession();
//        session.setAttribute("orders", orders);
//
//        getServletContext().getRequestDispatcher("/index.jsp")
//                .forward(req, resp);


    }
}
