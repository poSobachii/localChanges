<%@ page import="RestWebApplication.Controller.AppController"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>RestWebApplication</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="css/layers5.css">
    <script type="text/javascript" src="js/scripts3.js"></script>
</head>
<body>

<div id="left">
<h2> Hello to my BookShelf </h2>
<h2> <form action = "home">
<input type="submit"  value="Home">
</form>
</h2>
</br></br></br></br></br>
</div>

<div id="center">

<form action="addBook">
<p>Name:<input type="text" name="Bname"/>
<p>Author:<input type="text" name="Bauthor"/>
<p>Publisher:<input type="text" name="Bpublisher"/>
<p>Pub. date:<input type="text" name="Bdate"/></br>
<input type="submit" value="Add/Update" />
</form>

</div>

<div id="right">

<form action="search">
<p>Search by ID or Name <input type="text" name="search"/>
<input type="submit" value="Search"/>
</form>

<form action="deleteBook">
<p>Delete by ID <input type="text" name="delete"/>
<input type="submit" value="Delete" onclick="" />
</form>

<form action="showAll">
<input type="submit" value="Show all Books"/>
</form>

</div>


<div id="bottom">
<%
StringBuffer tmp = AppController.getStrbuff();
if (tmp != null) { out.print(tmp); }

%>
</div>

</body>
</html>