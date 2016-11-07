<%-- 
    Document   : Response
    Created on : 02-nov-2016, 10:55:32
    Author     : yeray
--%>

<%@page import="ServletAl.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        Alumno al= (Alumno)request.getAttribute("alumno"); 
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>
          <h1>Informacion alumno</h1>
      Alumno:  <%out.println( al.getNom() );%><br>
      Código:  <%out.println( al.getCodi() ); %><br>
      Asignaturas:  <%out.println( al.getAssignatures() ); %><br>
      Tutorias:  <%out.println( al.getTutories() ); %>
    </body>
</html>
