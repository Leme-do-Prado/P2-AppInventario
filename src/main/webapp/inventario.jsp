<!DOCTYPE html>
<html>
<head>
    <title>Inventário</title>
</head>
<body>
    <h1>Clientes:</h1>
    <ul>
        <% for (Customer customer : (List<Customer>)request.getAttribute("customers")) { %>
            <li>ID: <%= customer.getId() %>, Nome: <%= customer.getName() %>, Cidade: <%= customer.getCity() %></li>
        <% } %>
    </ul>

    <h1>Vendedores:</h1>
    <ul>
        <% for (Salesman salesman : (List<Salesman>)request.getAttribute("salesmen")) { %>
            <li>ID: <%= salesman.getId() %>, Nome: <%= salesman.getName() %>, Cidade: <%= salesman.getCity() %></li>
        <% } %>
    </ul>

    <h1>Ordens de Venda:</h1>
    <ul>
        <% for (Orders order : (List<Orders>)request.getAttribute("orders")) { %>
            <li>Número: <%= order.getOrdNo() %>, Quantidade: <%= order.getPurchAmt() %>, Data: <%= order.getOrdDate() %></li>
        <% } %>
    </ul>
</body>
</html>
