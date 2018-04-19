

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tìm Kiếm Nhân Viên</h1>
        <form action="show1.htm" method="post">
            Tên Phòng Ban :
            <select name="departid">
                <c:forEach var="item" items="${listDp}">
                    <option> ${item.name}</option>
                </c:forEach>
            </select>
            <input type="submit" name="btnChoose" value="Choose"/>
            <hr>
            Tên Nhân Viên :
            <select name="name">
                <c:forEach var="item" items="${listStaff}">
                    <option> ${item.name}</option>
                </c:forEach>
            </select>
            <input type="submit" name="btnSearch" value="Search"/>
            <hr>
            <h1> Thông Tin Nhân Viên </h1>
            <c:forEach var="items" items="${listStaffinfo}">
                <div> Mã Nhân Viên : ${items.id} </div>
                <div> Tên Nhân Viên :${items.name} </div>
                <div> Giới Tính :${items.gender} </div>
                <div> Sinh Nhật :${items.birthday} </div>
                <div> Hình Ảnh:<img src="${items.photo}"/> </div>
                <div> Email :${items.email} </div>
                <div> Số Điện Thoại : ${items.phone}</div>
                <div> Lương Căn Bản : ${items.salary} /tháng</div>
                <div> Ghi Chú : ${items.notes}</div>
                <div> Phòng Ban :${items.departid} </div>
                <div> Cấp Độ :${items.level} </div>
            </c:forEach>
                <hr>
                <a href="back.htm" > Quay lại trang chủ </a>
        </form>
    </body>
</html>
