package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addVehicle")
public class AddVehicle extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("vehicles", vehicleDao.findAll());
        req.setAttribute("customers", customerDao.findAll());

        getServletContext().getRequestDispatcher("/addVehicle.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VehicleDao vehicleDao = new VehicleDao();

        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        int yearOfProduction = Integer.parseInt(req.getParameter("yearOfProduction"));
        String registrationNumber = req.getParameter("registrationNumber");
        String nextServicePar = req.getParameter("nextService");
        int customerId = Integer.parseInt(req.getParameter("customerId"));

        Vehicle vehicle = new Vehicle();
        vehicle.setModel(model);
        vehicle.setBrand(brand);
        vehicle.setYearOfProduction(yearOfProduction);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setCustomerId(customerId);

        try {
            Date nextService = nextServicePar != null
                    ? Date.valueOf(req.getParameter("nextService"))
                    : null;
            vehicle.setNextService(nextService);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        vehicleDao.create(vehicle);

        resp.sendRedirect("/customerVehicles?id="+customerId);


    }
}
