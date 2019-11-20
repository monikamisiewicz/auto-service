package pl.coderslab.controller.employee;

import pl.coderslab.dao.*;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeList")
public class EmployeeList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();

        List<Employee> employees = employeeDao.findAll();
        req.getSession().setAttribute("employees", employees);

        getServletContext().getRequestDispatcher("/employee/employeeList.jsp")
                .forward(req, resp);
    }
}
