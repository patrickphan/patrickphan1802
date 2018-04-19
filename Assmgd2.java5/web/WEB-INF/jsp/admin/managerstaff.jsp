

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quản Lý Nhân Viên</h1>
        ${message}
        <form action="show1.htm" method="post"> 
            Mã NV : <input type="text" name="id"/>
            <br> <br>
            Họ Và Tên : <input type="text" name="name"/>
            <br> <br>
            Giới tính :
            <input type="radio" name="gender" value="Nam"/> Nam
            <input type="radio" name="gender" value="Nu"/> Nu
            <br> <br>
            Hình Ảnh : <input type="file" name="photo"/>
            <br> <br>
            Ngày Sinh : <input type="date" name="birthday"/>
            <br> <br>
            Lương : <input type="text" name="salary"/>
            <br> <br>
            Phòng Ban : <select name="departid">
                <c:forEach var="item" items="${listDp}">
                    <option> ${item.name}</option>
                </c:forEach>
            </select>
            <br> <br>
            Cấp Độ : <select name="level">
                <option value="Junior">Junior</option>
                <option value="Senior">Senior</option>
                <option value="Manager">Manager</option>
            </select>
            <br> <br>
            Email : <input type="text" name="email"/>
            <br> <br>
            Điện Thoại : <input type="text" name="phone"/>
            <br> <br>
            Ghi Chú : <textarea name="notes"> </textarea>
            <br>
            <hr>
            <div>
                <input type="submit" name="btnInsert" value="Thêm"/>
                <input type="submit" name="btnDelete" value="Xóa"/>
                <input type="submit" name="btnUpdate" value="Cập Nhập"/>
            </div>
            <hr>
            <table border="1">
                <tr>
                    <td>Mã NV</td>
                    <td>Tên Nhân Viên</td>
                    <td>Giới Tính</td>
                    <td>Ngày Sinh</td>
                    <td>Email</td>
                    <td>Phòng Ban</td>
                    <td>Cấp Độ</td>
                    <td>Ghi Chú</td>
                </tr>
                <c:forEach var="items" items="${listStaff}">
                    <tr>
                        <td>${items.id}</td>
                        <td>${items.name}</td>
                        <td>${items.gender}</td>
                        <td>${items.birthday}</td>
                        <td>${items.email}</td>
                        <td>${items.departid}</td>
                        <td>${items.level}</td>
                        <td>${items.notes}</td>
                        <td><a href="#"> Sửa</a>  </td>
                    </tr>
                </c:forEach>
            </table
            <hr>
            <a href="back.htm" > Quay lại trang chủ </a>
        </form>
    </body>
</html>
