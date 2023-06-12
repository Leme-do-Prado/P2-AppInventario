package com.inventario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventario.model.Salesman;

public class SalesmanDAO {
    private List<Salesman> salesmanList;

    public SalesmanDAO() {
        salesmanList = new ArrayList<>();
    }

    public void addSalesman(Salesman salesman) {
        salesmanList.add(salesman);

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            String sql = "INSERT INTO Salesman (Salesman_ID, Name, City, Commission) " +
                         "VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, salesman.getSalesmanId());
            statement.setString(2, salesman.getName());
            statement.setString(3, salesman.getCity());
            statement.setBigDecimal(4, salesman.getCommission());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }
}
