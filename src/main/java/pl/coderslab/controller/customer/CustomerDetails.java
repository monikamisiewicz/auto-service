package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/customerDetails")
public class CustomerDetails extends HttpServlet {

    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer customer = customerDao.read(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/customer/customerDetails.jsp")
                .forward(req,resp);

    }
}
