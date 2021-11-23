## Football Manager

## Description
This app implements the transfer operation. You can buy and sell players in football teams. 
The cost of the transfer is equal to the number of months of player experience * 100,000 divided by the age of the player in years.
The player's price depends on the commission of the team. Сommission from the team from 0% to 10% of the transfer cost.Full amount = transfer cost + commission.
All CRUD operations were performed in REST style and you can use these endpoints:

 - GET:/players
 - POST:/players
 - PUT:/players/{id}
 - DELETE:/players/{id}
 
 - GET:/football-teams
 - POST:/football-teams
 - PUT:/football-teams/{id}
 - DELETE:/football-teams/{id}
 
It is an endpoint that performs a transaction between teams:
 - PUT:/transfer
 
 You can use a postman for this, for example:
- PUT:/transfer?playerId=1&buyingTeamId=2

Where the first parameter is the player's id,
and the second parameter is the team that buys the player.

## Technologies
 - Spring Boot
 - Java 11
 - H2
 - Maven
