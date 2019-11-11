package pl.coderslab.controller;

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

@WebServlet("/customerVehicle")
public class CustomerVehicles extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VehicleDao vehicleDao = new VehicleDao();
//      zle, jak pokazać listę danego customera
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        int customerId = customer.getId();

        List<Vehicle> vehicles = vehicleDao.findAll(customerId);
        req.getSession().setAttribute("vehicles", vehicles);

        getServletContext().getRequestDispatcher("/customerVehicles.jsp")
                .forward(req, resp);


    }
}
