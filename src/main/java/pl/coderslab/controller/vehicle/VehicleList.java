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
import java.util.List;

@WebServlet("/vehicleList")
public class VehicleList extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Vehicle> vehicles = vehicleDao.findAll();
        req.getSession().setAttribute("vehicles", vehicles);

        req.setAttribute("customers", customerDao.findAll());

        getServletContext().getRequestDispatcher("/vehicle/vehicleList.jsp")
                .forward(req, resp);

    }
}
