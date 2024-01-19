package com.viton.basicspringbootapp.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("messages")
public class ReadingCustomProperties {

    String messages = "Good Morning";

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    

}
