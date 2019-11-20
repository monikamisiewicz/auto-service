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

@WebServlet("/deleteVehicle")
public class DeleteVehicle extends HttpServlet {

    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("customers", customerDao.findAll());

        int id = Integer.parseInt(req.getParameter("id"));
        Vehicle vehicle = vehicleDao.read(id);

        req.getSession().setAttribute("vehicle", vehicle);

        getServletContext()
                .getRequestDispatcher("/vehicle/deleteVehicle.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String delete = req.getParameter("delete");

        if("Ok".equals(delete)) {
            vehicleDao.delete(id);
            resp.getWriter().println("Vehicle deleted!");
            resp.sendRedirect("/vehicle/customerList");

        } else if("Cancel".equals(delete)) {
            resp.sendRedirect("/vehicle/customerList");
        }
    }
}
