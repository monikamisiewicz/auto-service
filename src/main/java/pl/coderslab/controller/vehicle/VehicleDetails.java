package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicleDetails")
public class VehicleDetails extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int customerId = Integer.valueOf(req.getParameter("id"));
//        Customer customer = customerDao.read(customerId);
        //        req.getSession().setAttribute("customer", customer);

        int vehicleId = Integer.valueOf(req.getParameter("id"));
        Vehicle vehicle =  vehicleDao.read(vehicleId);
        req.getSession().setAttribute("vehicle", vehicle);

        Order order = orderDao.read(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("order", order);

        List<Order> orders = orderDao.findAllByVehicleId(vehicleId);
        req.getSession().setAttribute("orders", orders);

        getServletContext().getRequestDispatcher("/vehicle/vehicleDetails.jsp")
                .forward(req, resp);

    }
}
