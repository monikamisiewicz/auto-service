package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerOrders")
public class CustomerOrders extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int customerId = Integer.valueOf(req.getParameter("id"));
        Customer customer = customerDao.read(customerId);

        List<Order> customerOrders = orderDao.findAllByCustomerId(customerId);

        req.getSession().setAttribute("orders", customerOrders);
        req.getSession().setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/customer/customerOrders.jsp")
                .forward(req, resp);

    }
}
