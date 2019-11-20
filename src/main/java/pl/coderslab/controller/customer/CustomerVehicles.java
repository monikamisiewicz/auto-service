package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerVehicles")
public class CustomerVehicles extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int customerId = Integer.valueOf(req.getParameter("id"));
        Customer customer = customerDao.read(customerId);

        List<Vehicle> customerVehicles = vehicleDao.findAllbyCustomerId(customerId);

        req.getSession().setAttribute("vehicles", customerVehicles);
        req.getSession().setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/customer/customerVehicles.jsp")
                .forward(req, resp);


    }
}
