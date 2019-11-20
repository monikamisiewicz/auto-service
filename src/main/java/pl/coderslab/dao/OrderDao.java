package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderDao {


    private static final String CREATE_QUERY = "INSERT INTO orders(repair_acceptance_date, planned_repair_start, repair_start, problem_description, repair_description, customer_cost, spareparts_cost, man_hour_cost, man_hour_amount, customer_id, employee_id, vehicle_id, status_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE orders SET repair_acceptance_date=?, planned_repair_start=?, repair_start=?, problem_description=?, repair_description=?, customer_cost=?, spareparts_cost=?, man_hour_cost=?, man_hour_amount=?, customer_id=?, employee_id=?, vehicle_id=?, status_id=?  WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM orders WHERE id = ?";
    private static final String FIND_RECENT = "SELECT * FROM orders ORDER BY repair_start DESC LIMIT ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM orders ORDER BY repair_acceptance_date DESC";
    private static final String FIND_ALL_BY_STATUS_QUERY = "SELECT * FROM orders WHERE status_id=? ORDER BY repair_acceptance_date DESC";
    private static final String FIND_ALL_BY_EMPLOYEE_ID_QUERY = "SELECT * FROM orders WHERE employee_id=? ORDER BY repair_start DESC";
    private static final String FIND_ALL_BY_CUSTOMER_ID_QUERY = "SELECT * FROM orders WHERE customer_id=? ORDER BY repair_acceptance_date DESC";
    private static final String FIND_ALL_BY_VEHICLE_ID_QUERY = "SELECT * FROM orders WHERE vehicle_id=?";
    private static final String FIND_ALL_BY_CUSTOMER_AND_VEHICLE_ID_QUERY = "SELECT * FROM orders WHERE customer_id=? AND vehicle_id=?";
    private static final String CALCULATE_MAN_HOURS_QUERY = "select concat(e.first_name, ' ', e.last_name) as 'employee_name'\n" +
            ", SUM(o.man_hour_amount) as 'total_man_hours' from orders o join employees e on o.employee_id = e.id\n" +
            "            where o.repair_start between cast(? as date) and cast(? as date) group by o.employee_id;";


    public Order create(Order order) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, order.getRepairAcceptanceDate());
            statement.setDate(2, order.getPlannedRepairStart());
            statement.setDate(3, order.getRepairStart());
            statement.setString(4, order.getProblemDescription());
            statement.setString(5, order.getRepairDescription());
            statement.setDouble(6, order.getCustomerCost());
            statement.setDouble(7, order.getSparepartsCost());
            statement.setDouble(8, order.getManHourCost());
            statement.setInt(9, order.getManHourAmount());
            statement.setInt(10, order.getCustomerId());
            statement.setInt(11, order.getEmployeeId());
            statement.setInt(12, order.getVehicleId());
            statement.setInt(13, order.getStatusId());

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
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

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
            statement.setDouble(6, order.getCustomerCost());
            statement.setDouble(7, order.getSparepartsCost());
            statement.setDouble(8, order.getManHourCost());
            statement.setInt(9, order.getManHourAmount());
            statement.setInt(10, order.getCustomerId());
            statement.setInt(11, order.getEmployeeId());
            statement.setInt(12, order.getVehicleId());
            statement.setInt(13, order.getStatusId());
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

    public List<Order> findRecent(int n) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(FIND_RECENT);
            statement.setInt(1, n);

            ResultSet rs = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findAllById(int id) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_STATUS_QUERY)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> findAllByStatus(int statusId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_STATUS_QUERY)) {
            statement.setInt(1, statusId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> findAllByEmployeeId(int employeeId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_EMPLOYEE_ID_QUERY)) {
            statement.setInt(1, employeeId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> findAllByCustomerId(int customerId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_CUSTOMER_ID_QUERY)) {
            statement.setInt(1, customerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Order> findAllByVehicleId(int vehicleId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_VEHICLE_ID_QUERY)) {
            statement.setInt(1, vehicleId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> findAllByCustomerAndVehicleId(int customerId, int vehicleId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_CUSTOMER_AND_VEHICLE_ID_QUERY)) {
            statement.setInt(1, customerId);
            statement.setInt(2, vehicleId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
                order.setRepairStart(rs.getDate("repair_start"));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setCustomerCost(rs.getDouble("customer_cost"));
                order.setSparepartsCost(rs.getDouble("spareparts_cost"));
                order.setManHourCost(rs.getDouble("man_hour_cost"));
                order.setManHourAmount(rs.getInt("man_hour_amount"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setStatusId(rs.getInt("status_id"));

                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public Map<String, Integer> calculateManHours(Date fromDate, Date toDate) {
//        Map<String, Integer> map = new HashMap<>();
//        try (Connection conn = DbUtil.getConn();
//             PreparedStatement statement = conn.prepareStatement(CALCULATE_MAN_HOURS_QUERY);
//             statement.setDate(1, fromDate);
//             statement.setDate(2, toDate);
//             ResultSet rs = statement.executeQuery()) {
//
//            while (rs.next()) {
//                map.put(rs.getString("name"),
//                        rs.getInt("man_hours_amount"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        return map;
//    }

//    public List<Order> calculateManHours(Date fromDate, Date toDate) {
//        List<Order> orders = new ArrayList<>();
//        try (Connection conn = DbUtil.getConn();
//             PreparedStatement statement = conn.prepareStatement(CALCULATE_MAN_HOURS_QUERY);
//             statement.setDate(1, fromDate);
//             statement.setDate(2, toDate);
//             ResultSet rs = statement.executeQuery()) {
//
//            Order order = new Order();
//            order.setId(rs.getInt("id"));
//            order.setRepairAcceptanceDate(rs.getDate("repair_acceptance_date"));
//            order.setPlannedRepairStart(rs.getDate("planned_repair_start"));
//            order.setRepairStart(rs.getDate("repair_start"));
//            order.setProblemDescription(rs.getString("problem_description"));
//            order.setRepairDescription(rs.getString("repair_description"));
//            order.setCustomerCost(rs.getDouble("customer_cost"));
//            order.setSparepartsCost(rs.getDouble("spareparts_cost"));
//            order.setManHourCost(rs.getDouble("man_hour_cost"));
//            order.setManHourAmount(rs.getInt("man_hour_amount"));
//            order.setCustomerId(rs.getInt("customer_id"));
//            order.setEmployeeId(rs.getInt("employee_id"));
//            order.setVehicleId(rs.getInt("vehicle_id"));
//            order.setStatusId(rs.getInt("status_id"));
//
//            orders.add(order);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        return orders;
//    }

}
