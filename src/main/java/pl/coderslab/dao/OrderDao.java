package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDao {

//    private static final Logger LOGGER = LogManager.getLogger(OrderDao.class.getName());//co to getName??

    private static final String CREATE_QUERY = "INSERT INTO orders(repair_acceptance_date, planned_repair_start, repair_start, problem_description, repair_description, status, customer_cost, spareparts_cost, man_hour_cost, man_hour_amount, customer_id, employee_id, vehicle_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE orders SET repair_acceptance_date=?, planned_repair_start=?, repair_start=?, problem_description=?, repair_description=?, status=?, vehicle=?, customer_cost=?, spareparts_cost=?, man_hour_cost=?, man_hour_amount=?, customer_id=?, employee_id=?  WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM orders WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM orders";
    private static final String FIND_ALL_BY_STATUS_QUERY = "SELECT * FROM orders WHERE status=accepted"; //??????


    public Order create(Order order) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, order.getRepairAcceptanceDate());
            statement.setDate(2, order.getPlannedRepairStart());
            statement.setDate(3, order.getRepairStart());
            statement.setString(4, order.getProblemDescription());
            statement.setString(5, order.getRepairDescription());
            statement.setString(6, order.getStatus());
            statement.setDouble(7, order.getCustomerCost());
            statement.setDouble(8, order.getSparepartsCost());
            statement.setDouble(9,order.getManHourCost());
            statement.setInt(10, order.getManHourAmount());
            statement.setInt(11, order.getCustomerId());
            statement.setInt(12, order.getEmployeeId());
            statement.setInt(13, order.getVehicleId());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                order.setId(rs.getInt(1));
            }
            return order;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Order read(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setStatus(rs.getString("status"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));


                return order;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Order order) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setDate(1, order.getRepairAcceptanceDate());
            statement.setDate(2, order.getPlannedRepairStart());
            statement.setDate(3, order.getRepairStart());
            statement.setString(4, order.getProblemDescription());
            statement.setString(5, order.getRepairDescription());
            statement.setString(6, order.getStatus());
            statement.setDouble(7, order.getCustomerCost());
            statement.setDouble(8, order.getSparepartsCost());
            statement.setDouble(9,order.getManHourCost());
            statement.setInt(10, order.getManHourAmount());
            statement.setInt(11, order.getCustomerId());
            statement.setInt(12, order.getEmployeeId());
            statement.setInt(13, order.getVehicleId());
            statement.setInt(14, order.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Order order =  new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setStatus(rs.getString("status"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findAllByStatus(String status) {
        List<Order> orders = new ArrayList<>();
        try(Connection conn = DbUtil.getConn();
        PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_STATUS_QUERY)) {
            statement.setString(1, status);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setStatus(rs.getString("status"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
