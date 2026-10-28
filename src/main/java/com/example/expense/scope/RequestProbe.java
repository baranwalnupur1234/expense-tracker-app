package com.example.expense.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;
/*
The important annotation is @RequestScope. Spring associates the bean instance with the current HTTP request.
 */
@Component
@RequestScope
public class RequestProbe {

    private final String instanceId = UUID.randomUUID().toString();

    public String getInstanceId(){
        return instanceId;
    }
}
