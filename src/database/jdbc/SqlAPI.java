package database.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlAPI {

    private JdbcConnection jdbcConnection;
    private ResultSet response;

    public SqlAPI() {
        this.jdbcConnection = new JdbcConnection();
    }

    public void search(String query){
        init(query);
    }

    public void init(String query) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.jdbcConnection.getConnection().prepareStatement(query);
            this.response = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean next() {
        try {
            return response.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet getResponse() {
        return response;
    }
}
