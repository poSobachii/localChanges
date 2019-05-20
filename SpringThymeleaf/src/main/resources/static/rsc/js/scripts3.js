alert("JSSSSSSSSSSSSSSS loaded");

function print(){
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/responses/addBasketResponse.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  http.onload = function() {
  };
  alert("done #2");
  };
