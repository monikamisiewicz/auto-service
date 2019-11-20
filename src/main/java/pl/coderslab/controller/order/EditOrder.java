package pl.coderslab.controller.order;

import pl.coderslab.dao.*;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/editOrder")
public class EditOrder extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    private VehicleDao vehicleDao = new VehicleDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private CustomerDao customerDao = new CustomerDao();
    private StatusDao statusDao = new StatusDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("vehicles", vehicleDao.findAll());
        req.setAttribute("employees", employeeDao.findAll());
        req.setAttribute("customers", customerDao.findAll());
        req.setAttribute("statuses", statusDao.findAll());

        int id = Integer.parseInt(req.getParameter("id"));
        Order order = orderDao.read(id);

        req.getSession().setAttribute("order", order);

        getServletContext().getRequestDispatcher("/order/editOrder.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String repairAcceptanceDatePar = req.getParameter("repairAcceptanceDate");
        String plannedRepairStartPar = req.getParameter("plannedRepairStart");
        String repairStartPar = req.getParameter("repairStart");
        String problemDescription = req.getParameter("problemDescription");
        String repairDescription = req.getParameter("repairDescription");
        String customerCostPar = req.getParameter("customerCost");
        String sparepartsCostPar = req.getParameter("sparepartsCost");
        String manHourCostPar = req.getParameter("manHourCost");
        int manHourAmount = Integer.parseInt(req.getParameter("manHourAmount"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        int vehicleId = Integer.parseInt(req.getParameter("vehicleId"));
        int statusId = Integer.parseInt(req.getParameter("statusId"));

        Order order = new Order();
        order.setId(id);
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
        order.setManHourAmount(manHourAmount);
        order.setCustomerId(customerId);
        order.setEmployeeId(employeeId);
        order.setVehicleId(vehicleId);
        order.setStatusId(statusId);

        orderDao.update(order);

        resp.sendRedirect("/order/orderList");

    }
}
