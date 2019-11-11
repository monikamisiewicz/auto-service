package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/editCustomer")
public class EditCustomer extends HttpServlet {

    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDao.read(id);

        req.getSession().setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/editCustomer.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dOB = req.getParameter("dateOfBirth");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        try {
            Date dateOfBirth = dOB != null
                    ? Date.valueOf(req.getParameter("dateOfBirth"))
                    : null;
            customer.setDateOfBirth(dateOfBirth);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        customerDao.update(customer);

        resp.sendRedirect("/customerList");


    }
}
