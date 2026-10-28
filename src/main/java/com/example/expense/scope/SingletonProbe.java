package com.example.expense.scope;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SingletonProbe {

    private final String instanceId = UUID.randomUUID().toString();

    public String getInstanceId(){
        return instanceId;
    }

}
