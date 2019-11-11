package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/addOrder.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();

        String repairAcceptanceDatePar = req.getParameter("repairAcceptanceDate");
        String plannedRepairStartPar = req.getParameter("plannedRepairStart");
        String repairStartPar = req.getParameter("repairStart");
        String problemDescription = req.getParameter("problemDescription");
        String repairDescription = req.getParameter("repairDescription");
        String status = req.getParameter("status");
        String customerCostPar = req.getParameter("customerCost");
        String sparepartsCostPar = req.getParameter("sparepartsCost");
        String manHourCostPar = req.getParameter("manHourCost");
        int manHourAmount = Integer.parseInt(req.getParameter("manHourAmount"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));


        Order order = new Order();
        try {
            Date repairAcceptanceDate = repairAcceptanceDatePar != null
                    ? Date.valueOf(req.getParameter("repairAcceptanceDate"))
                    : null;
            order.setRepairAcceptanceDate(repairAcceptanceDate);

            Date plannedRepairStart = plannedRepairStartPar != null
                    ? Date.valueOf(req.getParameter("plannedRepairStart"))
                    : null;
            order.setPlannedRepairStart(plannedRepairStart);

            Date repairStart = repairStartPar != null
                    ? Date.valueOf(req.getParameter("repairStart"))
                    : null;
            order.setRepairStart(repairStart);

            double customerCost = customerCostPar != null
                    ? Double.parseDouble((req.getParameter("customerCost")))
                    : 0;
            order.setCustomerCost(customerCost);

            double sparepartsCost = sparepartsCostPar != null
                    ? Double.parseDouble((req.getParameter("sparepartsCost")))
                    : 0;
            order.setSparepartsCost(sparepartsCost);

            double manHourCost = manHourCostPar != null
                    ? Double.parseDouble((req.getParameter("manHourCost")))
                    : 0;
            order.setManHourCost(manHourCost);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        order.setProblemDescription(problemDescription);
        order.setRepairDescription(repairDescription);
        order.setStatus(status);
        order.setManHourAmount(manHourAmount);
        order.setCustomerId(customerId);

        orderDao.create(order);


        resp.sendRedirect("/orderList");

    }
}
