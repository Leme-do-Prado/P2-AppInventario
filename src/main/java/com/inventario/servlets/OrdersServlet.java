package com.inventario.servlets;

import com.inventario.dao.OrdersDAO;
import com.inventario.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
    private OrdersDAO ordersDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ordersDAO = new OrdersDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ordNo = req.getParameter("ordNo");
        double purchAmt = Double.parseDouble(req.getParameter("purchAmt"));
        String ordDate = req.getParameter("ordDate");
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        int salesmanId = Integer.parseInt(req.getParameter("salesmanId"));

        Orders orders = new Orders(ordNo, purchAmt, ordDate, customerId, salesmanId);
        ordersDAO.addOrders(orders);
    }
}
