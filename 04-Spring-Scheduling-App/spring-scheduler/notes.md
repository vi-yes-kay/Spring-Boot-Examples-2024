# Notes on Spring Boot Scheduler

* Spring Boot Scheduler helps execute a particular task at a given time or recurrently execute at given time intervals. . 

## Steps 

Step -1 :
 Annotate your Spring Boot main class with special annotation called - @EnableScheduling. 
 Example: 

        @SpringBootApplication
        @EnableScheduling
        public class SpringSchedulerApplication {

Step - 2: 
 Create a Spring component using @Component annotation. 

        @Component
        public class BasicScheduler {...}

Step - 3: 
 Create a method in the spring component with @Scheduled annotation so that Spring runs this method and also specify the 
 the time intervals or rate at which this method need to be executed by Spring. 
 Example :- 

     @Scheduled(fixedRate = 3000)
    public void scheduledTask(){

        // Do something meaningfull here. 
        System.out.println("This is the time now: " + dateFormat.format(new Date()));
    }
    
## Additional Information: 

* To add initial delay immediately after the application starts-up and triggers/executes the Scheduled Task, use initialDelay attribute with in the @Scheduled annotation. 
Example: 

        @Scheduled(fixedRate = 3000, initialDelay = 10000)
        public void scheduledTask() throws InterruptedException{ //..todo }

* We can let spring boot pick the timers for Spring Scheduler from application.properties file as shown below. 
       

        @Scheduled(fixedRateString = "${scheduler.rate}", initialDelayString = "${scheduler.initialDelay}")
        public void scheduledTask() throws InterruptedException{

            // Do something meaningfull here. 
            System.out.println("This is the time now: " + dateFormat.format(new Date()));
            //Thread.sleep(6000);
        }