package com.example.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class scoresController {
 
    @RequestMapping(value="/score", 
                method=RequestMethod.GET)
    public String getScore() {
        String template = "{\"Gewinnen\":\"%s\", \"Verlieren\":\"%s\", \"Unentschieden\":\"%s\"}";
        String myJSON = String.format(template, RestServiceApplication.getCountWin(), 
                                                RestServiceApplication.getCountLose(), 
                                                RestServiceApplication.getCountTie());
        System.out.println(myJSON);
        return myJSON;
    }
}