package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String CREATE_QUERY = "INSERT INTO customers(first_name, last_name, date_of_birth) VALUES (?,?,?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM customers WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE customers SET first_name = ?, last_name = ?, date_of_birth = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM customers WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM customers";

    public Customer create(Customer customer) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setDate(3, customer.getDateOfBirth());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                customer.setId(rs.getInt(1));
            }
            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Customer read(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setDateOfBirth(rs.getDate("date_of_birth"));
                return customer;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Customer customer) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setDate(3, customer.getDateOfBirth());
            statement.setInt(4, customer.getId());
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

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Customer customer =  new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setDateOfBirth(rs.getDate("date_of_birth"));
                customers.add(customer);
            }
            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
