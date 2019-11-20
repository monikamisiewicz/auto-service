package pl.coderslab.dao;

import pl.coderslab.model.Status;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {


    private static final String CREATE_QUERY = "INSERT INTO statuses(name) VALUES (?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM statuses WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE statuses SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM statuses WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM statuses";

    public Status create(Status status) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, status.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                status.setId(rs.getInt(1));
            }
            return status;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Status read(int id) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Status status = new Status();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                return status;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Status status) {
        try (Connection conn = DbUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, status.getName());
            statement.setString(2, status.getName());
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

    public List<Status> findAll() {
        List<Status> statuses = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Status status =  new Status();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                statuses.add(status);
            }
            return statuses;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
