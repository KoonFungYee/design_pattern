package com.example.dockertest1.factory;


public class EmailNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        System.out.println("Sending a email notification");
    }
}
