

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ghi Nhận Thành Tích</h1>
        ${message}
        <form action="show2.htm" method="post">
            Tên Phòng Ban :
            <select name="departid">
                <c:forEach var="item" items="${listDp}">
                    <option> ${item.name}</option>
                </c:forEach>
            </select>
            <input type="submit" name="btnSearch" value="Search"/>
            <hr>
            <div> Tên Nhân Viên :
                <select name="name">
                    <c:forEach var="item" items="${listStaff}">
                        <option> ${item.name}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div>
                Loại :
                <input type="radio" name="type" value="KT"/> Khen Thưởng
                <input type="radio" name="type" value="KL"/> Kỷ Luật
            </div>
            <br>
            <div>
                Lý Do : <textarea name="reason"> </textarea>
            </div>
            <br>
            <div>
                Ngày Ghi Nhận : <input type="date" name="date"/>
            </div>
            <hr>
            <div>
                <input type="submit" name="btnSave" value="Lưu"/>
            </div>
            <hr>
            <table border="1">
                <tr>

                    <td>Tên Nhân Viên</td>
                    <td>Loại</td>
                    <td>Lý Do</td>
                    <td>Ngày Ghi Nhận</td>
                </tr>
                <c:forEach var="items" items="${listRecord}">
                    <tr>

                        <td>${items.name}</td>
                        <td>${items.type}</td>
                        <td>${items.reason}</td>
                        <td>${items.date}</td>
                    </tr>
                </c:forEach>
            </table>
            <hr>
            <a href="back.htm" > Quay lại trang chủ </a>
        </form>
    </body>
</html>
