package com.viton.springscheduler.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BasicScheduler {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * To run a particular task at fixed rate of time interval usually specified in milliseconds. 
     * @throws InterruptedException 
     */
    
     /*@Scheduled(fixedRate = 3000)
    public void scheduledTask(){

        // Do something meaningfull here. 
        System.out.println("This is the time now: " + dateFormat.format(new Date()));
    } */

    /**
     * Here, fixedDelay introduces a delay of specified milliseconds after every task executed.
     * @throws InterruptedException
     */

    /* @Scheduled(fixedDelay = 5000)
    public void scheduledTask() throws InterruptedException{

        // Do something meaningfull here. 
        System.out.println("This is the time now: " + dateFormat.format(new Date()));
        Thread.sleep(5000);
    } */


    /* @Scheduled(fixedRate = 3000, initialDelay = 10000)
    public void scheduledTask() throws InterruptedException{

        // Do something meaningfull here. 
        System.out.println("This is the time now: " + dateFormat.format(new Date()));
        Thread.sleep(6000);
    } */

    /**
     * Below is the example for reading the Scheduler params from application.properties file. 
     * @throws InterruptedException
     */

    @Scheduled(fixedRateString = "${scheduler.rate}", initialDelayString = "${scheduler.initialDelay}")
    public void scheduledTask() throws InterruptedException{

        // Do something meaningfull here. 
        System.out.println("This is the time now: " + dateFormat.format(new Date()));
        //Thread.sleep(6000);
    }
}
