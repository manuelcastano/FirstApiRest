package services;

import model.dto.Division;
import model.dto.Respuesta;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("calc")
public class CalculoService {

    @GET
    @Path("suma")
    public String suma(@QueryParam("a") String a, @QueryParam("b") String b){
        return (Integer.parseInt(a) + Integer.parseInt(b)) + "";
    }

    @GET
    @Path("resta/{A}/{B}")
    public String resta(@PathParam("A") String a, @PathParam("B") String b){
        return (Integer.parseInt(a) - Integer.parseInt(b)) + "";
    }

    @POST
    @Path("multiplicacion")
    public String multiplicacion(String operacion){
        return operacion;
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("division")
    public Respuesta div(Division obj){
        double res = obj.getDividendo()/(double)obj.getDivisor();
        Respuesta respuesta = new Respuesta(obj.getUid(), res);
        return respuesta;
    }
}
