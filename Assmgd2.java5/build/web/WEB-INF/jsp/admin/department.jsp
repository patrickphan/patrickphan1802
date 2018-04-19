

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quản Lý Phòng Ban</h1>
        ${message}
        <form action="show.htm" method="post">
            <div>Mã Phòng Ban : </div>
            <input type="text" name="id"/>
            <br>
            <div>Tên Phòng Ban : </div>
            <input type="text" name="name"/>
            <hr>
            <div>
                <input type="submit" name="btnInsert" value="Thêm"/>
                <input type="submit" name="btnDelete" value="Xóa"/>
                <input type="submit" name="btnUpdate" value="Cập Nhập"/>
            </div>
            <hr>
            <table border="1">
                <tr>
                    <td>Mã Phòng Ban</td>
                    <td>Tên Phòng Ban</td>
                </tr>
                <c:forEach var="item" items="${listDepart}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td><a href="#"> Sửa</a>  </td>
                    </tr>
                </c:forEach>
            </table>
            <hr>
            <a href="back.htm" > Quay lại trang chủ </a>
        </form>
    </body>
</html>
