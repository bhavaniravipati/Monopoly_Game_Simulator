<!-- This file consists of code to the second page of the application where players are provided with text boxes to enter their names and once they click on the start button, they land on main board-->
<!-- Author: Priyanka Umesh Pandit Tailapur -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
<head>
<title>Monopoly Login Page</title>
<!-- Styling options for game logo, textboxes and start button -->
<style>
    img
    {
        display: block;
        margin-left: auto;
        margin-right: auto;
    } 
    
    input
    {
        display: block;
        margin-left: auto;
        margin-right: auto;
    } 
    
    form 
    { 
        margin: 0 auto; 
        width:250px;
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
    <!-- Form consisting on text boxes for players to enter names with along with validation -->
    <form action="MonopolyController" method="post">
    <label for="player1">PLAYER 1</label>
    <input type="text" name="player1" value="" required>
    <label for="player2">PLAYER 2</label>
    <input type="text" name="player2" value="" required>
  <br/><br/>
  <!-- Start Button to land on game page -->
  <input class="button button1 center" type="submit" value="PLAY NOW">
</form> 
    
</body>
</html>