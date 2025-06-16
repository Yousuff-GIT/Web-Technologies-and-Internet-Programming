<!-- Product.jsp -->
<!-- JSP frontend for capturing user selection of product to predict sales -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
</head>
<body>
    <div align="center" style="margin-left: 30%; margin-top: 10%; width: 40%; height: 10%; background-color: #99ffff;">
        <h1>Product Sales Prediction</h1>
        <form action="Sales.jsp" method="post">
            <label>Select the Product </label>
            <select name="laptop">
                <option value="Lenovo_laptop">Lenovo Laptop</option>
                <option value="Dell_laptop">Dell Laptop</option>
                <option value="Acer_laptop">Acer Laptop</option>
                <option value="HP_laptop">HP Laptop</option>
            </select>
            <input type="submit" value="Predict"/>
        </form>
    </div>
</body>
</html>