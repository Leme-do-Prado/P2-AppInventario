package com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventario.model.Customer;

public class CustomerDAO {
    private List<Customer> customers;

    public CustomerDAO() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            String sql = "INSERT INTO Customer (Customer_Id, Cust_Name, City, Grade, Salesman_Id) " +
                         "VALUES (?, ?, ?, ?, ?)";
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

    // Outros métodos para atualização, exclusão e consulta dos clientes no banco de dados
}
