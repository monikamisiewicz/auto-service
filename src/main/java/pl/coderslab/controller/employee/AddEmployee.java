package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {

    EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/employee/addEmployee.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        String note = req.getParameter("note");
        String hourCost = req.getParameter("manHourCost");

        Employee employee = new Employee();
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

        employeeDao.create(employee);

        resp.sendRedirect("/employeeList");

    }
}
