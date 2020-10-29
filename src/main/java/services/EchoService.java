package services;

import db.MySQLConnection;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("echo")
public class EchoService {

    @GET
    @Path("index")
    public String index(){
        return "echo";
    }
}
