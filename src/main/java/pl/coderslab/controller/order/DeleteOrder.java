package pl.coderslab.controller.order;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {

    private OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Order order = orderDao.read(id);

        req.getSession().setAttribute("order", order);

        getServletContext()
                .getRequestDispatcher("/order/deleteOrder.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String delete = req.getParameter("delete");

        if ("Ok".equals(delete)) {
            orderDao.delete(id);
            resp.getWriter().println("Order deleted!");
            resp.sendRedirect("/orderList");

        } else if ("Cancel".equals(delete)) {
            resp.sendRedirect("/orderList");
        }
    }


}
