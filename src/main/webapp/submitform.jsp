<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
String name=(String)request.getParameter("param1");
out.println(name+" Added Succesfullysssssssssssssssss");
System.out.println(name);
%>