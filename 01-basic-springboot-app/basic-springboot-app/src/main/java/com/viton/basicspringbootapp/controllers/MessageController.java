package com.viton.basicspringbootapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MessageController {

    @GetMapping
    @ResponseBody
    public String getWelcomeMessage(){
        return "Hello World, welcome to Basic Spring Boot App";
    }

    /*
     * This request-handler sends greetings based on time of the day.Eg:- good morning, good afternoon, or good evening. 
     */
    @GetMapping("/home")
    public String getGreetingsForTheDayMessage(Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM aa");
        String date = sdf.format(new Date());
        System.out.println("Current time: " + date);
        String greetings = null;
        if(date.contains("am"))
            greetings = "Good Morning! ";
        if(date.contains("pm"))
            greetings = "Good Afternoon! ";

        greetings += "Custom greetings from ThymeLeaf Template engine.";
        
        model.addAttribute("message", greetings);
        return "home";
    }


}
