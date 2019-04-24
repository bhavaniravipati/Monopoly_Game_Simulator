<!-- This is the final page of the application where winners name is displayed-->
<!-- Author: Priyanka Umesh Pandit Tailapur -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
<head>
<title>Monopoly End Page</title>
<!-- Styling options for game logo and other elements -->
<style>
    img
    {
        display: block;
        margin-left: auto;
        margin-right: auto;
    } 
    
    .button 
    {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        text-decoration: none;
        font-size: 16px;
        margin: 4px 2px;
        -webkit-transition-duration: 0.4s; 
        transition-duration: 0.4s;
        cursor: pointer;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
    
    .button1 
    {
        background-color: white; 
        color: black;
        border: 2px solid #008CBA;
    }

    .button1:hover
    {
        background-color: #008CBA;
        color: white;
    }
    
</style>
<!-- Getting winner from servlet -->
<%
String winner = (String) request.getAttribute("winner");
%>
</head>
<!-- processUser() script is called when the page loads -->
<body style="background-color:antiquewhite" onload="processUser()">
    <br/>
    <br/>
    <div><img src="Monopoly.png" height="300px" width="600px"/></div>
    <br/>
    <div><img src="Winner.png" height="200px" width="200px"/></div>
    <br/>
    <div style="text-align: center" id="winner"> WINNER - <%=winner%> </div>
    <br/>
 

<script>
    function processUser()
        {
    		//Winner is displayed
            document.getElementById("winner").innerHTML += <%=winner%>;
        }
    
</script>
</body>
</html>