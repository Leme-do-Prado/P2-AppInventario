package com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.DatabaseConnection;
import com.inventario.model.Salesman;

public class SalesmanDAO {

    public void addSalesman(Salesman salesman) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO Salesman (Salesman_ID, Name, City, Commission) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, salesman.getSalesmanId());
            statement.setString(2, salesman.getName());
            statement.setString(3, salesman.getCity());
            statement.setDouble(4, salesman.getCommission());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }
    
    public static List<Salesman> getAllSalesmen() {
        List<Salesman> salesmen = new ArrayList<>();
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Salesman");
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Salesman salesman = new Salesman();
                salesman.setSalesmanId(resultSet.getInt("Salesman_ID"));
                salesman.setName(resultSet.getString("Name"));
                salesman.setCity(resultSet.getString("City"));
                salesman.setCommission(resultSet.getDouble("Commission"));
                salesmen.add(salesman);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return salesmen;
    }

    private void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

