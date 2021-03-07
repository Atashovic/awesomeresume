<%-- 
    Document   : user
    Created on : 6 Jan 2021, 15:37:43
    Author     : jabir.amirkhanli
--%>

<%@page import="com.company.entity.User"%>
<%@page import="main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            if (request.getAttribute("owner")==null)
//            {
//                response.sendRedirect("error.jsp?msg=not found");
//                return;
//            }
            User u = (User) request.getAttribute("user");

        %>

        <div>
            <form action="userdetail" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <br/>
                <label>name</label>
                <input type="text" name="name" value="<%=u.getName()%>"/>
                <br/>
                <br/>
                <label>surname</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>"/>
                <br/>
                <br/>
                <label>address</label>
                <input type="text" name="address" value="<%=u.getAddress()%>"/>
                <br/>
                <br/>
                <label>phone</label>
                <input type="text" name="phone" value="<%=u.getPhone()%>"/>
                <br/>
                <br/>
                <label>email</label>
                <input type="text" name="email" value="<%=u.getEmail()%>"/>
                <br/>
                <input type="submit" name="save" value="Save">
            </form>
        </div>
<%--    <% } %>--%>
    </body>
</html>
