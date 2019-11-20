package pl.coderslab.controller.vehicle;

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


@WebServlet("/editVehicle")
public class EditVehicle extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("vehicles", vehicleDao.findAll());
        req.setAttribute("customers", customerDao.findAll());

        int id = Integer.parseInt(req.getParameter("id"));
        Vehicle vehicle = vehicleDao.read(id);

        req.getSession().setAttribute("vehicle", vehicle);

        getServletContext().getRequestDispatcher("/vehicle/editVehicle.jsp")
                .forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        int yearOfProduction = Integer.parseInt(req.getParameter("yearOfProduction"));
        String registrationNumber = req.getParameter("registrationNumber");
        String nextServicePar = req.getParameter("nextService");
        int customerId = Integer.parseInt(req.getParameter("customerId"));

        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
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

        vehicleDao.update(vehicle);

        resp.sendRedirect("/customerVehicles?id=" + customerId);


    }
}
