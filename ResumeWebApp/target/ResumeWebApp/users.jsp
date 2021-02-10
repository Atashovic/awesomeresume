<%-- 
    Document   : user
    Created on : 6 Jan 2021, 15:37:43
    Author     : jabir.amirkhanli
--%>

<%@page import="com.company.entity.User"%>
<%@page import="main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userdao = Context.instanceUserDao();

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String nationalityIdStr = request.getParameter("nid");
            Integer nationalityId = null;
            if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty())
            {
                nationalityId = Integer.parseInt(nationalityIdStr);
            }

            List<User> list = userdao.getAll(name,surname,nationalityId);

        %>


        <div>
            <form action="users.jsp" method="GET">
<%--                <input type="hidden" name="id" value=""/>--%>
<%--                <br/>--%>
                <label>name</label>
                <input type="text" name="name" value=""/>
                <br/>
                <br/>
                <label>surname</label>
                <input type="text" name="surname" value=""/>
                <br/>
                <br/>
                <input type="submit" name="search" value="Search">
            </form>  
        </div>

        <br/>


        <div>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Nationality</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    for (User u : list){
                %>
                    <tr>
                        <td><%=u.getName()%></td>
                        <td><%=u.getSurname()%></td>
                        <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                    </tr>
                <%}%>
                </tbody>
            </table>
        </div>

    </body>
</html>
