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
            UserDaoInter userdao = Context.instanceUserDao();

////            out.println("name = " + u.getName());
//            if (request.getParameter("save") != null && request.getParameter("save").equals("Save")) {
//                int id = Integer.valueOf(request.getParameter("id"));
//                String name = request.getParameter("name");
//                String surname = request.getParameter("surname");
//
//                System.out.println("name" + name);
//                System.out.println("surname" + surname);
//
//                User user = userdao.getById(id);
//                user.setName(name);
//                user.setSurname(surname);
//
//                userdao.updateUser(user);
//            }
            User u = userdao.getById(5);

        %>


        <div>
            <form action="UserController" method="POST">
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
    </body>
</html>
