package pl.coderslab.controller.order;

import pl.coderslab.dao.*;
import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetails extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
//    private CustomerDao customerDao = new CustomerDao();
//    private StatusDao statusDao = new StatusDao();
//    private EmployeeDao employeeDao = new EmployeeDao();
//    private VehicleDao vehicleDao = new VehicleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Order order = orderDao.read(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("order", order);

//        int customerId = Integer.valueOf(req.getParameter("id"));
//        Customer customer = customerDao.read(customerId);
//        req.getSession().setAttribute("customer", customer);
//
//        int employeeId = Integer.valueOf(req.getParameter("id"));
//        Employee employee = employeeDao.read(employeeId);
//        req.getSession().setAttribute("employee", employee);
//
//
//        Status status = statusDao.read(Integer.valueOf(req.getParameter("id")));
//        req.getSession().setAttribute("status", status);
//
//        Vehicle vehicle = vehicleDao.read(Integer.valueOf(req.getParameter("id")));
//        req.getSession().setAttribute("vehicle", vehicle);

        getServletContext().getRequestDispatcher("/order/orderDetails.jsp")
                .forward(req,resp);
    }
}
