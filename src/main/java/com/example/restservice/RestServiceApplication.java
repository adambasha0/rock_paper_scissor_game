/**
 *
 * @author adamb
 */
package com.example.restservice;

import java.util.Scanner;  // import package(Scanner class), um user input zu bekommen
import java.util.HashMap;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RestServiceApplication {
    
    public static int unentschieden;
    public static int gewinnen;
    public static int verloren;
    
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);

        //Willkommen Nachricht
        System.out.println("Willkommen beim Spiel: Stein, Schere, Papier."
         + " Bitte, wählen Sie eine Option aus der folgenden Liste:{stein, schere, papier}"
         +"\n" + "schreiben Sie die gewählte Option auf," + " und schauen Sie, ob Sie den Computer besiegen werden.");

        //Variablen definieren um gewinnnen, verloren, unentscheieden Ereignisse zu zählen
        unentschieden = 0;
        gewinnen = 0;
        verloren = 0;
        playGame();         
    }

    public static void playGame() {
        Scanner user_input = new Scanner(System.in);

        // user input
        String option = user_input.nextLine();
        
        // Erstellung von HashMap 
        HashMap<Integer, String> my_hm 
            = new HashMap<Integer, String>(); 
        
        // Optionen in hm hinfügen
        my_hm.put(1, "stein"); 
        my_hm.put(2, "papier"); 
        my_hm.put(3, "schere");    
        
        // Erzeuger eines zufälligen Auswahls von HashMap
        Object[] values = my_hm.values().toArray();
        Object computer_Auswahl = values[new Random().nextInt(values.length)];
        
        // computer_Auswahl Object zum String umwandeln
        String computer_String= computer_Auswahl.toString();
        
        // ordne jede zufällige computer_Auswahl eine Nummer zu
        int computer = wert(computer_String);
        
        // weiter spielen nur wenn User Input gueltig ist
        if (gueltig(option)) {
             String a="stein";
             String b="papier";
             String c="schere";
             if (a.equals(option) || b.equals(option) || c.equals(option)) {
                int spieler = wert(option);
                System.out.println("Computer wählte " + computer_Auswahl);
                System.out.println("Sie wählten " + option);
                System.out.println(konzept(spieler,computer));                
             }
        }
        // wenn nicht, dann kein gültig Input Nachricht zeigen 
        else {
            System.out.println("Ihre Eingabe ist nicht gueltig, bitte fügen Sie eine Option aus der Liste ein");
        }
        // rekursive Function um Spieler zu erlauben, noch mal zu spielen
        playGame();
    }
    
    // Spiel Regeln
    public static String konzept(int spieler, int computer) {   

        //stein=1 & papier=2 & schere=3
        // wenn Spiel_Auswhal=computer_Auswahl
        if(spieler == computer){
            unentschieden++;
            return "Unentschieden";
        }

        // wenn Spiel=stein & computer=papier
        if(spieler == 1 && computer == 2){
            verloren++;
            return "Sie haben verloren";
        }

        // wenn Spiel=stein & computer=schere
        if(spieler == 1 && computer == 3){
            gewinnen++;
            return "Glückwunsch, Sie haben gewonnen";
        }

        // wenn Spiel=papier & computer=schere
        if(spieler == 2 && computer == 3){
            verloren++;
            return "Sie haben verloren";
        }

        // wenn Spiel=papier & computer=stein
        if(spieler == 2 && computer == 1){
            gewinnen++;
            return "Glückwunsch, Sie haben gewonnen";
        }

        // wenn Spiel=schere & computer=stein
        if(spieler == 3 && computer == 1){
            verloren++;
            return "Sie haben verloren";
        }

        // wenn Spiel=schere & computer=papier
        if(spieler == 3 && computer == 2){
            gewinnen++;
            return "Glückwunsch, Sie haben gewonnen";
        }
        return "Err";
    }
    
    // nur Inputs aus der Liste:{stein, schere, papier} sind gueltig für Nutzer 
    public static boolean gueltig(String string) {
         if (string.equalsIgnoreCase("stein")) {
             return true;
         } 
         if (string.equalsIgnoreCase("schere")) {
             return true;
         } 
         if (string.equalsIgnoreCase("papier")) {
             return true;
         }
         else {
             return false;
         }
    }
    
    // um es einfacher zu machen, werde ich hier eine Nummer für jede Option zuordnen
    //stein=1 & papier=2 & schere=3
    public static int wert(String string) {

        if (string.equalsIgnoreCase("stein")) {
            return 1;
        }
        if (string.equalsIgnoreCase("papier")) {
            return 2;
        }
        if (string.equalsIgnoreCase("schere")) {
            return 3;
        }
        else {
            return 4;
        }       
    }   
    
    // gewinnen score in JSON (siehe: scoresController.java) 
    public static int getCountWin() {
        return gewinnen;
    }

    // Verlieren score in JSON (siehe: scoresController.java) 
    public static int getCountLose() {
        return verloren;
    }

    // unentschieden score in JSON (siehe: scoresController.java) 
    public static int getCountTie() {
        return unentschieden;
    }

}
    