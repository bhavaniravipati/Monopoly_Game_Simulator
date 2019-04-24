<!-- This file consists of code to the landing page of the application where players are provided with a start button to enter to the next page (login) where players can enter their names-->
<!-- Author: Priyanka Umesh Pandit Tailapur -->
<!DOCTYPE html5>
<html>
<head>
<title>Monopoly Start Page</title>
<!-- Styling options for buttons and game logo-->
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
</head>
<body style="background-color:antiquewhite">
    <br/>
    <br/>
    <!-- Monopoly Game Logo -->
    <div><img src="Monopoly.png" height="300px" width="600px"/></div>
    <br/>
    <br/>
    <br/>
    <!-- User is provided with Start New Button to land on login.jsp to enter the names -->
    <div><button class="button button1 center" onclick="window.location.href='login.jsp'">START NEW GAME</button></div>
</body>
</html>