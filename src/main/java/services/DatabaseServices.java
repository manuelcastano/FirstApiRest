package services;

import db.MySQLConnection;
import model.dto.Response;

import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("db")
public class DatabaseServices {

    @POST
    @Path("create")
    @Produces("application/json")
    public Response createDB(){
        MySQLConnection connection = new MySQLConnection();
        if(connection.createDatabase()){
            return new Response("Base de datos creada con exito");
        } else{
            return new Response("Error al crear la base de datos");
        }
    }
}
