

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String message = (String) request.getAttribute("message");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Xin Chào ${fullname} </h1>
        <script type="text/javascript">
            var msg = "<%=message%>";
            alert(msg);
        </script>

        <ul><h3>Phòng Ban </h3>
            <li><a href="depart.htm"> Quản Lý Phòng Ban </a></li>
        </ul>


        <ul><h3>Thành tích</h3>
            <li><a href="achive1.htm"> Ghi Nhận Thành Tích</a></li>
            <li><a href="achive2.htm"> Tổng Kết Thành Tích </a></li>
        </ul>

        <ul><h3>Nhân Sự</h3>
            <li><a href="staff1.htm"> Quản Lý Nhân Viên </a></li>
            <li><a href="staff2.htm"> Tìm Kiếm Nhân Viên </a></li>
        </ul>


    </body>
</html>
