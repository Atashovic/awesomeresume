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
        <link rel="stylesheet" href="assets/css/users.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

        <div class="container mycontainer">
           <div class="row">

                 <div class="col-4">
            <form action="users" method="GET">
<%--                <input type="hidden" name="id" value=""/>--%>
<%--                <br/>--%>
                <label>name</label>
                <input placeholder="Enter name" type="text" class="form-control" name="name" value=""/>
                <br/>
                <br/>
                <label>surname</label>
                <input placeholder="Enter surname" type="text" class="form-control" name="surname" value=""/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-primary" name="search" value="Search">
            </form>  
        </div>
           </div>

                 <br/>
                 <hr/>


                <div>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Nationality</th>
                        <th></th>
                        <th></th>
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
                        <td style="width:5px">
                            <form action="userdetail" method="POST">
                                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                <input type="hidden" name="action" value="delete"/>
                                <input type="submit"  value="delete" class="btn-danger" />
                            </form>
                        </td>
                        <td style="width:5px">
                            <form action="userdetail" method="GET">
                                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                <input type="hidden" name="action" value="update"/>
                                <input type="submit"  value="update" class="btn-secondary" />
                            </form>
                        </td>
                    </tr>
                <%}%>
                </tbody>
            </table>
        </div>


        </div>

    </body>
</html>
