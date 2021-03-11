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

        <form>
            <div class="form-group row">
                <label for="Name" class="col-sm-1 col-form-label">Name</label>
                <div class="col-sm-5">
                    <input type="text" readonly class="form-control" id="Name" value="<%=u.getName()%>">
                </div>
            </div>
            <div class="form-group row">
                <label for="Surname" class="col-sm-1 col-form-label">Surname</label>
                <div class="col-sm-5">
                    <input type="text" readonly class="form-control" id="Surname" value="<%=u.getSurname()%>">
                </div>
            </div>
            <div class="form-group row">
                <label for="Address" class="col-sm-1 col-form-label">Address</label>
                <div class="col-sm-5">
                    <input type="text" readonly class="form-control" id="Address" value="<%=u.getAddress()%>">
                </div>
            </div>
            <div class="form-group row">
                <label for="Phone" class="col-sm-1 col-form-label">Phone</label>
                <div class="col-sm-5">
                    <input type="text" readonly class="form-control" id="Phone" value="<%=u.getPhone()%>">
                </div>
            </div>
            <div class="form-group row" >
                <label for="Email" class="col-sm-1 col-form-label">Email</label>
                <div class="col-sm-5">
                    <input type="text" readonly class="form-control"   id="Email" value="<%=u.getEmail()%>">
                </div>
            </div>
        </form>

<%--        <div>--%>
<%--            <form action="userdetail" method="POST">--%>
<%--                <input type="hidden" name="action" value="update"/>--%>
<%--                <input type="hidden" name="id" value="<%=u.getId()%>"/>--%>
<%--                <br/>--%>
<%--                <label>name</label>--%>
<%--                <input type="text" name="name" value="<%=u.getName()%>"/>--%>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>surname</label>--%>
<%--                <input type="text" name="surname" value="<%=u.getSurname()%>"/>--%>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>address</label>--%>
<%--                <input type="text" name="address" value="<%=u.getAddress()%>"/>--%>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>phone</label>--%>
<%--                <input type="text" name="phone" value="<%=u.getPhone()%>"/>--%>
<%--                <br/>--%>
<%--                <br/>--%>
<%--                <label>email</label>--%>
<%--                <input type="text" name="email" value="<%=u.getEmail()%>"/>--%>
<%--                <br/>--%>
<%--                <input type="submit" name="save" value="Save">--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    <% } %>--%>
    </body>
</html>
