package pl.coderslab.controller.employee;

import pl.coderslab.dao.*;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editEmployee")
public class EditEmployee extends HttpServlet {

    private EmployeeDao employeeDao = new EmployeeDao();
    private OrderDao orderDao = new OrderDao();
    private VehicleDao vehicleDao = new VehicleDao();
    private CustomerDao customerDao = new CustomerDao();
    private StatusDao statusDao = new StatusDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("orders", orderDao.findAll());
        req.setAttribute("vehicles", vehicleDao.findAll());
        req.setAttribute("customers", customerDao.findAll());
        req.setAttribute("statuses", statusDao.findAll());

        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.read(id);

        req.getSession().setAttribute("employee", employee);

        getServletContext().getRequestDispatcher("/employee/editEmployee.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        String note = req.getParameter("note");
        String hourCost = req.getParameter("manHourCost");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAddress(address);
        employee.setTelephone(telephone);
        employee.setNote(note);

        try {
            double manHourCost = hourCost != null
                    ? Double.parseDouble((req.getParameter("manHourCost")))
                    : 0;
            employee.setManHourCost(manHourCost);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        employeeDao.update(employee);

        resp.sendRedirect("/employeeList");

    }
}
