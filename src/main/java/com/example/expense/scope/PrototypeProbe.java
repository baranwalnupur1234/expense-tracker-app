package com.example.expense.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
/*
The important line is @Scope("prototype"). It tells Spring to create a new instance whenever the bean is requested from the container
 */
@Scope("prototype")
public class PrototypeProbe {

    private final String instanceId = UUID.randomUUID().toString();

    public String getInstanceId(){

        return instanceId;
    }

}
