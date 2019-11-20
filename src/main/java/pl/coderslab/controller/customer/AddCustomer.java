package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/customer/addCustomer.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerDao customerDao = new CustomerDao();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dOB = req.getParameter("dateOfBirth");

        Customer customer = new Customer();
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


        customerDao.create(customer);


        resp.sendRedirect("/customerList");

    }


}
