package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {

    EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = employeeDao.read(id);

        req.getSession().setAttribute("employee", employee);

        getServletContext()
                .getRequestDispatcher("/employee/deleteEmployee.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String delete = req.getParameter("delete");

        if("Ok".equals(delete)) {
            employeeDao.delete(id);
            resp.getWriter().println("Employee deleted!");
            resp.sendRedirect("/employeeList");

        } else if("Cancel".equals(delete)) {
            resp.sendRedirect("/employeeList");
        }

    }
}
