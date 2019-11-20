package pl.coderslab.controller.employee;

import pl.coderslab.dao.*;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/employeeOrders")
public class EmployeeOrders extends HttpServlet {
    private OrderDao orderDao = new OrderDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> employeeOrders = orderDao.findAllByEmployeeId(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("orders", employeeOrders);

        getServletContext().getRequestDispatcher("/employee/employeeOrders.jsp")
                .forward(req, resp);

    }
}
