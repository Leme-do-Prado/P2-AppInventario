package com.inventario.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventario.dao.CustomerDAO;
import com.inventario.dao.OrdersDAO;
import com.inventario.dao.SalesmanDAO;
import com.inventario.model.Customer;
import com.inventario.model.Orders;
import com.inventario.model.Salesman;

@WebServlet("/mostra")
public class MostraServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = CustomerDAO.getAllCustomers();
        request.setAttribute("customers", customers);

        List<Salesman> salesmen = SalesmanDAO.getAllSalesmen();
        request.setAttribute("salesmen", salesmen);

        List<Orders> orders = OrdersDAO.getAllOrders();
        request.setAttribute("orders", orders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
