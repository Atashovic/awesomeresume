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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <br/>
<%--                <label>name</label>--%>
<%--                <input type="text" name="name" value="<%=u.getName()%>"/>--%>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="name" value="<%=u.getName()%>" placeholder="Name">
                    </div>
                </div>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>surname</label>--%>
<%--                <input type="text" name="surname" value="<%=u.getSurname()%>"/>--%>
                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label">Surname</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="surname" value="<%=u.getSurname()%>" placeholder="Surname">
                    </div>
                </div>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>address</label>--%>
<%--                <input type="text" name="address" value="<%=u.getAddress()%>"/>--%>
                <div class="form-group row">
                    <label for="address" class="col-sm-2 col-form-label">Address</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="address" value="<%=u.getAddress()%>" placeholder="Address">
                    </div>
                </div>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>phone</label>--%>
<%--                <input type="text" name="phone" value="<%=u.getPhone()%>"/>--%>
                <div class="form-group row">
                    <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="phone" value="<%=u.getPhone()%>" placeholder="Phone">
                    </div>
                </div>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>email</label>--%>
<%--                <input type="text" name="email" value="<%=u.getEmail()%>"/>--%>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="email" value="<%=u.getEmail()%>" placeholder="Email">
                    </div>
                </div>
                <br/>
<%--                <input type="submit" name="save" value="Save">--%>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
<%--    <% } %>--%>
    </body>
</html>
