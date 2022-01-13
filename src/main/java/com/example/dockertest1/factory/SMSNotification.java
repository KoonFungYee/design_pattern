package com.example.dockertest1.factory;

public class SMSNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        System.out.println("Sending an SMS notification");
    }
}
