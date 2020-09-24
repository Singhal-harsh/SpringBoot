package com.citi.ArbApplication.Service;



import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRepeat {

    private static int count = 0;
    public double randGen() {
    	double max = 105.5;
        double min = 105.0;
        double random_double = Math.random() * (max - min) + min;
        return random_double;
    }
    
    

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledExecutorRepeat ss = new ScheduledExecutorRepeat();

        Runnable task = () -> {
            while(count < 5) {
            	System.out.println(ss.randGen());
            	count++;
            }
            
        };

        
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        while (true) {
        	Thread.sleep(1000);
        	
            if (count == 5) {
                System.out.println("Count is 5, cancel the scheduledFuture!");
                scheduledFuture.cancel(true);
                ses.shutdown();
                break;
            }
        }

    }
}