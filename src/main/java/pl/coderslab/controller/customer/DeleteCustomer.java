package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {

    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDao.read(id);

        req.getSession().setAttribute("customer", customer);

        getServletContext()
                .getRequestDispatcher("/customer/deleteCustomer.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String delete = req.getParameter("delete");

        if("Ok".equals(delete)) {
            customerDao.delete(id);
            resp.getWriter().println("Customer deleted!");
            resp.sendRedirect("/customerList");

        } else if("Cancel".equals(delete)) {
            resp.sendRedirect("/customerList");
        }

        //jak zrobić, aby po usunięciu, id kolejnych wierszy zmieniło się odpowiednio????

    }
}

