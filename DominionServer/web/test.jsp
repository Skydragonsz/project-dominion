<%-- 
    Document   : test
    Created on : 14-apr-2016, 15:20:03
    Author     : Arthur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,server.CallGameEngine"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p> 
        <%
            CallGameEngine cge = new CallGameEngine();
            cge.test();
            
        %>
        </p>
    </body>
</html>
