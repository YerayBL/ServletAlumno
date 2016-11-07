<%-- 
    Document   : index
    Created on : 02-nov-2016, 10:39:20
    Author     : yeray
--%>

<%@page import="ServletAl.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <%
        ArrayList listaA= (ArrayList)request.getAttribute("Arraylist"); 
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
    </head>
    <body>
              <h1>Seleccionar alumno</h1>
        <form method="POST" action="" >    
            <select id="selector" name="selector">
                
        <%
            Alumno aux;
        for(int i=0;i<listaA.size();i++){
            aux=(Alumno)listaA.get(i);
        %><option  value="<%=aux.getCodi()%>"><% out.println(listaA.get(i).toString());%></option><%   }

        %>
       </select>
       
       <input type="submit" value="enviar"/>
        </form >
    </body>
</html>
