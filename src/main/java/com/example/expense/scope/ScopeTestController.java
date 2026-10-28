package com.example.expense.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/test/scope")
public class ScopeTestController {

    private final SingletonProbe singletonProbe;
    /*
        Why use `ObjectProvider`?

        - A Controller is Singleton, so it is created only once.
        - If we directly inject a Prototype bean, the Controller keeps the same object.
        - `ObjectProvider.getObject()` requests a new Prototype object each time we call it.

        Remember: Direct injection → same object. `getObject()` → new object each call.
     */
    private final ObjectProvider<PrototypeProbe> prototypeProbes;
    /*
        Why does this work without ObjectProvider? @RequestScope uses a scoped proxy by default.
        The controller holds the proxy, which resolves the actual RequestProbe instance for the current HTTP request.
     */
    private final RequestProbe requestProbe;

    public ScopeTestController(SingletonProbe singletonProbe,
                               ObjectProvider<PrototypeProbe> prototypeProbes,
                               RequestProbe requestProbe) {

        this.singletonProbe = singletonProbe;
        this.prototypeProbes = prototypeProbes;
        this.requestProbe = requestProbe;
    }
    // Singleton
    @GetMapping("/singleton")
    public String testSingleton(){
        return singletonProbe.getInstanceId();
    }
    // Prototype
    @GetMapping("/prototype")
    public String testPrototype(){
        PrototypeProbe probe = prototypeProbes.getObject();
        return probe.getInstanceId();
    }

    @GetMapping("/request")
    public String testRequest(){
        return requestProbe.getInstanceId();
    }

    @GetMapping("/compare")
    public Map<String, String> compareScopes(){

        // Prototype: request two objects from Spring
        PrototypeProbe p1 = prototypeProbes.getObject();
        PrototypeProbe p2 = prototypeProbes.getObject();

        // Request: access the bean twice during this HTTP request
        String r1 = requestProbe.getInstanceId();
        String r2 = requestProbe.getInstanceId();

        Map<String, String> result = new LinkedHashMap<>();
        result.put("prototypeFirstCall", p1.getInstanceId());
        result.put("prototypesSecondCall", p1.getInstanceId());
        result.put("requestFirstAccess", r1);
        result.put("requestSecondAccess",r2);

        return result;
    }

}





































