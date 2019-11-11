package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    private static final String CREATE_QUERY = "INSERT INTO employees(first_name, last_name, address, telephone, note, man_hour_cost) VALUES (?,?,?,?,?,?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM employees WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE employees SET first_name = ?, last_name = ?, address = ?, telephone = ?, note = ?, man_hour_cost = ?  WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM employees WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM employees";

    public Employee create(Employee employee) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getTelephone());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManHourCost());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                employee.setId(rs.getInt(1));
            }
            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Employee read(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setAddress(rs.getString("address"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setNote(rs.getString("note"));
                employee.setManHourCost(rs.getDouble("man_hour_cost"));
                return employee;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Employee employee) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getTelephone());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManHourCost());
            statement.setInt(7, employee.getId());
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

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Employee employee =  new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setAddress(rs.getString("address"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setNote(rs.getString("note"));
                employee.setManHourCost(rs.getDouble("man_hour_cost"));

                employees.add(employee);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
