<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="myOnlineShop.TempClass" %>
<%@ page import="myOnlineShop.DataStorage" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Simple JSP Application</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
	</head>
	<body>
		<h1>Hello world!</h1>
		<h2>Current time is <%= LocalDateTime.now() %></h2>
		<%
            double num = Math.random();
            if (num > 0.01) {
          %>
              <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
          <%
            } else {
          %>
              <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
          <%
            }
          %>
           <% TempClass.saySomething(); %>
           <form action = "home.jsp">
           <input type="submit" value="open HOME jsp">
           </form>
           <form action = "main.jsp">
           <input type="submit" value="open MAIN jsp">
           </form>
           <form action = "animal.html">
           <input type="submit" value="open ANIMAL html">
           </form>
            <form action="myservlet" method="get">
                <input type="text" name="bloha">
                </br>
                <input type="submit" value="Typed value" >
            </form>
            <form action="myservlet" method="get">
             <input type="submit" name="bloha" value="Button value" >
             </form>


            <h2>So your name is : <%= request.getParameter("bloha")%> </p>


            <h1>Message: ${indexingmsg}</h1>

            <form action = "onlineshop.jsp" >
            <input type="submit" value="ENTER SHOP ONLINE QUICK FASTER NOWWW!!!!!!!!!!">
            </form>

            <button onclick="myFunction()">Click me for JAVASCRIPT</button>
            <p id="demo"></p>

            <form action="myTest" method="post">
            <input type="text" name="methodCheck">
             <input type="submit" value="Check method working ?" >
             </form>

            <table id="employeesTable">
                   <thead>
                        <tr>
                            <th>Id</th>
                        </tr>
                    </thead>
                </table>



	</body>
</html>