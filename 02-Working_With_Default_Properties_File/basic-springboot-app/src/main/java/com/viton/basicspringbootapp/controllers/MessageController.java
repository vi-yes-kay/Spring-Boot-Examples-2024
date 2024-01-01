package com.viton.basicspringbootapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MessageController {

    @Value("${User.Name}")
    private String userName;

    @Value("${User.Course}")
    private String userCourse;


    @GetMapping
    @ResponseBody // When your class is decorated as @Controller, the addition of this annotation will impose Spring to consider return type as text response and not view name.
    public String getWelcomeMessage(){
        return "<H1>Hello World,</H1>"+
        "<p> Welcome to Basic Spring Boot App.<br/>" + 
        "This message is rendered as JSON String to browser and not a VIEW page.";
    }

    /*
     * This request-handler sends greetings based on time of the day.Eg:- good morning, good afternoon, or good evening. 
     */
    @GetMapping("/home")
    public String getGreetingsForTheDayMessage(Model model){
      
        model.addAttribute("greetingsForTheDay", getGreetingsForTheDay() +  "Custom greetings from ThymeLeaf Template engine.");
        return "home";
    }

    @GetMapping("/user")
    public String getGreetingsForUser(Model model){
        
        model.addAttribute("greetingsForTheDay", getGreetingsForTheDay());
        model.addAttribute("userName", userName);
        model.addAttribute("userCourse", userCourse);

        return "home";

    }

    private String getGreetingsForTheDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM aa");
        String date = sdf.format(new Date());
        System.out.println("Current time: " + date);
        String greetings = null;
        if(date.contains("am")){
            greetings = "Good Morning! ";
        }else if(date.contains("pm")){
            String[] dateChars = date.split(":");
            greetings = Integer.parseInt(dateChars[0]) >= 18 ? "Good Evening!" : "Good Afternoon!"; 
        }
        return greetings;
    }


}
