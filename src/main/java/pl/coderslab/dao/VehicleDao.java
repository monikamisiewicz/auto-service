package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String CREATE_QUERY = "INSERT INTO vehicles(model, brand, year_of_production, registration_number, note, next_service, customer_id) VALUES (?,?,?,?,?,?,?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM vehicles WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE vehicles SET model = ?, brand = ?, year_of_production = ?, registration_number = ?, note = ?, next_service = ?, customer_id=?  WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM vehicles WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM vehicles";
    private static final String FIND_ALL_BY_CUSTOMER_ID_QUERY = "SELECT * FROM vehicles WHERE customer_id=?";

    public Vehicle create(Vehicle vehicle) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getYearOfProduction());
            statement.setString(4, vehicle.getRegistrationNumber());
            statement.setString(5, vehicle.getNote());
            statement.setDate(6, vehicle.getNextService());
            statement.setInt(7, vehicle.getCustomerId());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                vehicle.setId(rs.getInt(1));
            }
            return vehicle;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Vehicle read(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setYearOfProduction(rs.getInt("year_of_production"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setNote(rs.getString("note"));
                vehicle.setNextService(rs.getDate("next_service"));
                vehicle.setCustomerId(rs.getInt("customer_id"));
                return vehicle;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Vehicle vehicle) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getYearOfProduction());
            statement.setString(4, vehicle.getRegistrationNumber());
            statement.setString(5, vehicle.getNote());
            statement.setDate(6, vehicle.getNextService());
            statement.setInt(7, vehicle.getCustomerId());
            statement.setInt(8, vehicle.getId());
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


    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setYearOfProduction(rs.getInt("year_of_production"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setNote(rs.getString("note"));
                vehicle.setNextService(rs.getDate("next_service"));
                vehicle.setCustomerId(rs.getInt("customer_id"));

                vehicles.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }



    public List<Vehicle> findAll(int customerId) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_CUSTOMER_ID_QUERY)) {
            statement.setInt(1, customerId);
            ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setBrand(rs.getString("brand"));
                    vehicle.setYearOfProduction(rs.getInt("year_of_production"));
                    vehicle.setRegistrationNumber(rs.getString("registration_number"));
                    vehicle.setNote(rs.getString("note"));
                    vehicle.setNextService(rs.getDate("next_service"));
                    vehicle.setCustomerId(rs.getInt("customer_id"));

                    vehicles.add(vehicle);
                }
                return vehicles;

            } catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }


}
