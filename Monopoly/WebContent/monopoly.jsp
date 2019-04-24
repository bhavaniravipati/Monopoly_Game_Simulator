<!-- This file consists of code to the main page of the application where players are provided with buttons to roll die, end their turn, buy plots and build houses-->
<!-- There are 24 tiles depicting go cell, jail, avenues, railroads, community chest and chance cards, electricity, income tax, and free parking plot along with their details-->
<!-- Author: Priyanka Umesh Pandit Tailapur -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
<head>
<title>Monopoly</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Styling options for all the elements of the board-->
<style>
    html 
    {
        text-align: center;
        font-family:minion;
    }
    
    .row 
    {   display:flex;
        height:100px;
        width:700px;
    }

    .col 
    {
        width:100px;
        padding: 1em;
        border-style: solid;
        border-width: thin;
        text-align: center;
    }
    
    .col1
    {
        width:100px;
        padding: 1em;
    }
    
    .cellContainer 
    {
        width: 50%;
        float: left;
    }
    
    .layera 
    {
        width:100px;
        padding: 1em;
        border-style: solid;
        border-width: thin;
        text-align: center;
        box-shadow: inset 0 0 0 100px rgba(36, 70, 105, 0.76);        
    }
    
    .layerb 
    {
        width:100px;
        padding: 1em;
        border-style: solid;
        border-width: thin;
        text-align: center;
        box-shadow: inset 0 0 0 100px rgba(36, 70, 105, 0.76);       
    }
          
    .button 
    {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 10px 10px;
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
    
    .ca
    {
    display:block !important;
    }
    
    .cb
    {
    display:none !important;
    }
</style>
</head>
<!-- On loading of this page processUser() JavaScript function runs and displays current position of players along with their details -->
<body style="background-color: antiquewhite" onload="processUser()">
<!-- This section receives all the parameters of players and bank from the Servlet-->
<%
//totalRounds keeps track of the current turn
int totalRounds=(int)request.getAttribute("totalRounds");
String a,b,ca,cb;
//Switch of players based on their turns
if(totalRounds == 0)
{
    a = "Pawn1";
    b = "Pawn2";
}
else
{
if(totalRounds%2==0)	
{
	a="Pawn1";
	b="Pawn2";
}
else
{
	a="Pawn2";
	b="Pawn1";
}
}
//Getting player names and amount they own from servlet
String player1Name=(String)request.getAttribute("player1Name");
String player2Name=(String)request.getAttribute("player2Name");
int player1Balance=(int)request.getAttribute("player1Balance");
int player2Balance=(int)request.getAttribute("player2Balance");

//Getting bank balance from servlet
int bankerBalance = (int)request.getAttribute("bankBalance");

//Getting the value of rolled die from servlet
int dice=(int)request.getAttribute("dice");

//Getting current location of the both the players from servlet
int player1Location=(int)request.getAttribute("player1Location");
int player2Location=(int)request.getAttribute("player2Location");

//Getting options to enable the buy plot and buy house option based on the players from servlet
int enableBuy=(int)request.getAttribute("enableBuy");
int enableBuild=(int)request.getAttribute("enableBuild");
String description=(String)request.getAttribute("description");

//Activate hide and visible option class for buy plot and build house button
if(enableBuy == 1)
{
	ca = "ca";
}
else
{
	ca = "cb";
}
if(enableBuild == 1)
{
	cb = "ca";
}
else
{
	cb = "cb";
}
%>

<form method="post">
    <!-- Monopoly Logo Image -->
    <img src="Monopoly.png" height="90px" width="360px">
    <!--Div section containing 24 Tiles -->
    <div class="cellContainer">  
        <div class="row">
            <div class="col" id="7" style="background-color:white;background-image:url(VisitJail.jpg);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="8" style="background-color:white;background-image:url(Electricity.gif);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="9"  style="background-color:white;background-image:url(Blueberry.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>      
            </div>
            <div class="col" id="10" style="background-color:white;background-image:url(Blackhawk.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="11" style="background-color:white;background-image:url(Railway.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="12" style="background-color:white;background-image:url(Chance.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="13" style="background-color:white;background-image:url(Parking.gif);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
        </div>
        <div class="row">
            <div class="col" id="6" style="background-color:white;background-image:url(Rockmont.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col" id="14" style="background-color:white;background-image:url(Grapewood.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
        </div>
        <div class="row">
            <div class="col" id="5" style="background-color:white;background-image:url(Railway.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col" id="15"  style="background-color:white;background-image:url(Community%20Chest.gif);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
        </div>
        <div class="row">
            <div class="col" id="4" style="background-color:white;background-image:url(Rainbow.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col" id="16" style="background-color:white;background-image:url(Goldhill.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
        </div>
        <div class="row">
            <div class="col" id="3" style="background-color:white;background-image:url(Community%20Chest.gif);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
            <div class="col1"> </div>
        <div class="col" id="17" style="background-color:white;background-image:url(Railway.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
        </div>
    </div>
        <div class="row">
        <div class="col" id="2" style="background-color:white;background-image:url(Red.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>  
        </div>
        <div class="col1"> </div>
        <div class="col1"> </div>
        <div class="col1"> </div>
        <div class="col1"> </div>
        <div class="col1"> </div>
        <div class="col" id="18" style="background-color:white;background-image:url(Glacier.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
        </div>
    </div>
        <div class="row">
            <div class="col" id="1" style="background-color:white;background-image:url(Go.jpg);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="24"  style="background-color:white;background-image:url(Chance.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="23" style="background-color:white;background-image:url(Yellowpine.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="22" style="background-color:white;background-image:url(Yale.PNG);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="21" style="background-color:white;background-image:url(Railway.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="20" style="background-color:white;background-image:url(IncomeTax.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
            <div class="col" id="19" style="background-image:url(GoToJail.png);background-size:cover;background-repeat:no-repeat;">
                <div style="height:35px;width:35px;display:none;" class="player1div" id="player1"><img src="Pawn1.png" height="40px" width="40px"></div>             
                <div style="height:35px;width:35px;display:none;" class="player2div" id="player2"><img src="Pawn2.png" height="40px" width="40px"></div>
            </div>
        </div>
    </div>
    <!-- Button for Rolling die and ending turn -->
     <div class="cellContainer">
      <div style="height:50px;width:300px;float:left;top:10px;left:190px;position:relative;"> <button class="button button1 center" id="diceid" name="Dice">ROLL DIE</button></div>
    	<div style="height:50px;width:300px;float:left;top:10px;position:relative;" id="end"><button class="button button1 center" id="endid" name="End">END TURN</button></div>
    </div>
    <!-- Div section to show rolled number -->
    <div class="cellContainer">
        <div style="float:left;overflow:hidden;top:20px;left:280px;position:relative;color:brown;">The Rolled Number</div>
    </div> 
    <div class="cellContainer">
        <div style="float:left;overflow:hidden;top:20px;left:340px;position:relative;color:brown;" id="dice"><%=dice %></div>
    </div>
    <!-- Div section containing Player1, Player2, Bank Name along with corresponding Images and amount -->
    <div class="cellContainer">
        <div style="height:180px;width:115px;float:left;overflow:hidden;top:45px;left:200px;position:relative;text-align:center" id="player1"><p id="player1name"><%=player1Name %><br/> </p><img src="<%=a%>.png" height="80px" width="80px"/><p id="player1money"><%=player1Balance %> </p></div>         
        <div style="height:180px;width:115px;float:left;overflow:hidden;top:45px;left:200px;position:relative;text-align:center" id="player2"><p id="player2name"><%=player2Name %> <br/></p><img src="<%=b%>.png" height="80px" width="80px"/><p id="player2money"><%=player2Balance %></p></div> 
        <div style="height:180px;width:115px;float:left;overflow:hidden;top:45px;left:200px;position:relative;text-align:center" id="bank"><p>BANK <br/></p> <img src="Bank.png" height="80px" width="80px"/><p id="bankmoney"><%= bankerBalance%></p></div> 
    </div>
    <!-- Div section having game movement details-->
    <div class="cellContainer">
        <div style="height:180px;width:300px;float:left;overflow-y:auto;top:100px;left:230px;position:relative;text-align:center;border:solid" id="transactions">
            Game Movements <br>
        </div>         
        
    </div>
    <!-- Div section having buy plot and build house buttons -->
        <div class="cellContainer">
         <div style="height:50px;width:300px;float:left;top:110px;left:150px;position:relative;" class="<%= ca %>" id="buy"><button class="button button1 center" type="submit" id="Buy" name="Buy">BUY PLOT</button></div>
         <div style="height:50px;width:300px;float:left;top:110px;position:relative;" class="<%= cb %>" id="build"><button class="button button1 center" type="submit" id="Build" name="Build">BUILD HOUSE</button></div>
        
        </div>
       </form>
    <script>
    
      //Ajax call to servlet when dice button is clicked by the player
        $(document).ready(function() {                       
            $('#diceid').click(function() {               
                $.get('MonopolyController', function() { 
                            
                });
                
            });
  
            randomGenerator();
        });
      
       //Ajax call to servlet when buy plot button is clicked by the player 
        ("#Buy").on('click',function(){
            $.ajax({url:"/MonopolyController", success: function(result){

            }});
            
        }) ;
        
       //Ajax call to servlet when end turn button is clicked by the player
        ("#endid").on('click',function(){
            $.ajax({url:"/MonopolyController", success: function(result){

            }});
           
        }) ;
       
       //Ajax call to servlet when build house button is clicked by the player
        ("#Build").on('click',function(){
            $.ajax({url:"/MonopolyController", success: function(result){

            }});
            
        }) ;
        
          
        //randomGenerator function that gets current player details from servlet and displays on the main board
        function randomGenerator() 
        {
            if (<%=totalRounds%> <50 )
            	
            {
                var my_num = <%=dice%>;
                document.getElementById("dice").innerHTML=my_num; // Getting the rolled die number
                $('.player1div').hide(); //Hiding the previous move of the current player
                $(".layera").attr('class', 'col'); //Removing the block shadow
                $('.player2div').hide();  //Hiding the previous move of the second player
                $(".layerb").attr('class', 'col'); //Removing the block shadow
                var location1 = document.getElementById(<%=player1Location%>);// Getting new location of current player
                var location2 = document.getElementById(<%=player2Location%>);//Getting location of second player
                location1.className = "layera"; //Adding the block shadow
                location2.className = "layerb";//Adding block shadow
                
                //Display game movements and place the players in current location
                if((<%=totalRounds %> % 2)==0)
                {
                	
                	location1.getElementsByTagName('div')[0].style.display = "block";
                	document.getElementById('transactions').innerHTML += " Turn: " + <%= totalRounds + 1 %> + " " + '<%=player1Name%>' + " has moved to Plot "+<%=player1Location%>+"<br/>"+'<%=description%>'+"<br/>";               	
                	location2.getElementsByTagName('div')[1].style.display = "block";
            	}
                else
                	{
                	
                	location1.getElementsByTagName('div')[1].style.display = "block";
                	location2.getElementsByTagName('div')[0].style.display = "block";
                	document.getElementById('transactions').innerHTML += " Turn: " + <%= totalRounds + 1 %> + " " + '<%=player1Name%>' + " has moved to Plot "+<%=player1Location%>+ "<br/>"+'<%=description%>'+"<br/>" ;
                	 
                	}
                	}
            
        }     
    </script>
</body>
</html>