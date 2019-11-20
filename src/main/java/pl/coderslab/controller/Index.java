package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;

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

    private OrderDao orderDao = new OrderDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private StatusDao statusDao = new StatusDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int statusId = 8; //in progress
        List<Order> orders = orderDao.findAllByStatus(statusId);
        req.getSession().setAttribute("orders", orders);

        Employee employee = employeeDao.read(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("employee", employee);
        Status status = statusDao.read(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("status", status);


        int n = Integer.parseInt(getServletContext().getInitParameter("number-orders"));
        //pobranie parametru inicjalizaji, który został określony w web.xml i zamiana na wart.liczbową
        List<Order> recentOrders = orderDao.findRecent(n);
        //przekazanie listy do widoku index1.jsp
        req.setAttribute("recent", recentOrders);

        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }

}
