package com.inventario.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.DatabaseConnection;
import com.inventario.model.Orders;

public class OrdersDAO {

    public void addOrder(Orders order) {
    	String URL = "jdbc:mysql://localhost:8080/Inventario?user=host&password=";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL);

            String sql = "INSERT INTO Orders (Ord_no, Purch_amt, Ord_date, Customer_Id, Salesman_Id) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, order.getOrdNo());
            statement.setInt(2, order.getPurchAmt());
            statement.setDate(3, (Date) order.getOrdDate());
            statement.setInt(4, order.getCustomerId());
            statement.setInt(5, order.getSalesmanId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    public static List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Orders order = new Orders();
                order.setOrdNo(resultSet.getInt("Ord_no"));
                order.setPurchAmt(resultSet.getInt("Purch_amt"));
                order.setOrdDate(resultSet.getDate("Ord_date"));
                order.setCustomerId(resultSet.getInt("Customer_Id"));
                order.setSalesmanId(resultSet.getInt("Salesman_Id"));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
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
