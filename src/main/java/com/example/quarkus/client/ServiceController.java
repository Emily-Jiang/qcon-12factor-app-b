package com.example.quarkus.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/client/service")
public class ServiceController {
    static int count =0;

    @GET
    @Path("/{parameter}")
    public String doSomething(@PathParam("parameter") String parameter) throws InterruptedException {
        count ++; 
        if (count % 3 ==0) {
            throw new RuntimeException();
        } else if (count % 5 ==0) {
            Thread.sleep(1000);

        }
        return String.format("Quarkus serious '%s'", parameter);
    }
}
