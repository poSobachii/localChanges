alert("EveryTime page is loaded - JS apears 2222");

function myFunction() {
 document.getElementById("demo").innerHTML = "Hello World";
        }

$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
			"sAjaxSource": "/jquery",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"}

			]
	 })
});

function take_values(){
 var n=document.forms["myform"]["name"].value;
 if (n==null || n=="") {
 alert("Please enter User Name");
 return false;
 }else{
 var http = new XMLHttpRequest();
 http.open("POST", "http://localhost:8080/submitform.jsp", true);
 http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 var params = "param1=" + n;
 http.send(params);
 http.onload = function() {
 alert(http.responseText);
 }
 }
 }