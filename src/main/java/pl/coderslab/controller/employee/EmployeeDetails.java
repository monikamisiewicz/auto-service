package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeDetails")
public class EmployeeDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(Integer.valueOf(req.getParameter("id")));

        req.getSession().setAttribute("employee", employee);

        getServletContext().getRequestDispatcher("/employee/employeeDetails.jsp")
                .forward(req,resp);

    }
}
