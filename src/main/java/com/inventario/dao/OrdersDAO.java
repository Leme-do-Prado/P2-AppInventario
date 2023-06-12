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
        // L�gica para adicionar a ordem ao banco de dados
    }

    // Outros m�todos para atualiza��o, exclus�o e consulta das ordens no banco de dados
}
