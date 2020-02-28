# Rock, Paper, Scissors - REST Service

## Overview
The Game is built with REST service implementation using Spring Boot framework.

## Requirements
To build the app:

- Java JDK 8+
- Maven 3+

To launch it in local server: open cmd and open the directory of the game, then run either of the following commands:

To compile and build it:

``` mvn clean package ```

To run it:
 
``` mvn spring-boot:run ```

The app can also be run directly from cmd using jar file in the app's directory file:

``` cd ...\rock_paper_scissor_rest-service ```

using the following command:

``` java -jar Appgame_run.jar ```

It's configured to be launched:

* Port: 8080
* Context Path: /
* Server: http://localhost:8080/score

## Documentation

The game is designed for 2 players. One player(person) plays against the computer.

Once the App is launched, a welcome message is displayed in the cmd. Enter one move(stein, papier, schere) and the result will be displayed.

The player is allowed to repeat the move (play again). 

A score (win, lose, or tie) is recorded and calculated and the results are displayed in the JSON template on the server.

## Sources

- https://stackoverflow.com/questions/929554/is-there-a-way-to-get-the-value-of-a-hashmap-randomly-in-java
- https://www.geeksforgeeks.org/arraylist-vs-hashmap-in-java/
- https://stackoverflow.com/questions/34381348/comparing-user-input-values
- https://www.javatpoint.com/java-object-to-string
- https://spring.io/guides/gs/rest-service/
- https://mkyong.com/tutorials/spring-boot-tutorials/
- https://www.baeldung.com/java-create-jar#2-indicating-the-main-class
- https://www.baeldung.com/executable-jar-with-maven


