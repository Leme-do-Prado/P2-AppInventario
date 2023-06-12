package com.inventario.dao;

import com.inventario.model.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
    private List<Orders> ordersList;

    public OrdersDAO() {
        ordersList = new ArrayList<>();
    }

    public void addOrders(Orders orders) {
        ordersList.add(orders);
        // Lógica para adicionar a ordem ao banco de dados
    }

    // Outros métodos para atualização, exclusão e consulta das ordens no banco de dados
}
