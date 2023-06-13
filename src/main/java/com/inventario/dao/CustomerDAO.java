package com.inventario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.DatabaseConnection;
import com.inventario.model.Customer;

public class CustomerDAO {

    public void addCustomer(Customer customer) {
    	String URL = "jdbc:mysql://localhost:8080/Inventario?user=host&password=";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL);

            String sql = "INSERT INTO Customer (Customer_Id, Cust_Name, City, Grade, Salesman_Id) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCity());
            statement.setInt(4, customer.getGrade());
            statement.setInt(5, customer.getSalesmanId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("Customer_Id"));
                customer.setCustomerName(resultSet.getString("Cust_Name"));
                customer.setCity(resultSet.getString("City"));
                customer.setGrade(resultSet.getInt("Grade"));
                customer.setSalesmanId(resultSet.getInt("Salesman_Id"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
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

