package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/customerList")
public class CustomerList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerDao customerDao = new CustomerDao();

        List<Customer> customers = customerDao.findAll();
        req.getSession().setAttribute("customers", customers);

        getServletContext().getRequestDispatcher("/customer/customerList.jsp")
                .forward(req, resp);

        //Strona ma wyświetlać listę klientów grup z możliwością przejścia do szczegółów z listą wszystkich pojazdów.
//dołożyć atrybut id i przesłać do widoku (do szczegółów), metoda readById, nowy servlet???

    }
}
