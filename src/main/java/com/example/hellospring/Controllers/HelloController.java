package com.example.hellospring.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@RestController
public class HelloController {

    //Her får vi Hello world frem. Vi får det med stort
    //pga. tegnene <b> er indsat.
    @GetMapping("/first-mapping")
    public String firstMapping(){
            return "<b>Hello World<b>";
    }
    //Her får vi "This is second mapping frem" ved at bruge
    //følgende localhost:8080/second-mapping
    @GetMapping("/second-mapping")
    public String secoundMapping() {
        return "This is the second mapping";
    }
    //Her får vi blot welkomst besked frem hvis vi skriver
    //følgende: localhost:8080/
    @GetMapping("/")
    public String Index() {
        return "Welcome";
    }
    //Her Skriver vi noget ud, MEN brugeren sætter
    //også input ind og det er det der menes med
    //RequestParam. SÅ alt det efter ?input= er det som
    //brugeren skriver ind som i dette tilfælde er
    //HelloWOrld.
    @GetMapping("/parameter")
    public String parameter(@RequestParam String input){
        //For this to work:
        //localhost:8080/parameter?input=HelloWorld
        return input + " " + "end of string";
    }
    @GetMapping("fredag")
    public String DayOFWeek(){

        //Hvordan finder jeg ud af hvilken dag det er:
        //LocalDate.now ligger i java som tager tiden fra operativsystemet.
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        //todayAsNumber er en variable jeg laver hvor jeg tager today og tager værdien altså
        //tiden fra operativsystemet.
        int todayAsNumber = today.getValue();

        //Hvis det er fredag - returner en Streng: Ja
        //Hvis ikke returner en Streng: Nope
        //todayAsNumber som er taget fra linje 53 skal jeg sætte som en int(tal)
        //Da fredag er 5 dag i ugen er den sat som 5 da den er inkoporeret i operativsystemet.
        if (todayAsNumber == 5) {
            return "<b>JA<b>";
        }else
            return "nope";
    }
}

