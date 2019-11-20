package pl.coderslab.controller;

import pl.coderslab.dao.*;
import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderList")
public class OrderList extends HttpServlet {

    private OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderDao.findAll();
        req.getSession().setAttribute("orders", orders);

        getServletContext().getRequestDispatcher("/orderList.jsp")
                .forward(req, resp);
    }
}
