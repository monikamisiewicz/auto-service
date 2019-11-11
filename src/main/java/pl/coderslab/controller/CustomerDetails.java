package pl.coderslab.controller;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.read(Integer.valueOf(req.getParameter("id")));

        req.getSession().setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/customerDetails.jsp")
                .forward(req,resp);

    }
}
