package services;

import model.dto.CursoDTO;
import model.dto.Response;
import model.provider.CursoProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("cursos")
@Stateless
public class CursoServices {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCurso(CursoDTO cursoDTO){
        CursoProvider cursoProvider = new CursoProvider();
        cursoProvider.insertCurso(cursoProvider.mapFromDTO(cursoDTO));
        return new Response("Operación exitosa");
    }

    @GET
    @Path("all")
    @Produces("application/json")
    public ArrayList<CursoDTO> getAllCursos(){
        CursoProvider provider = new CursoProvider();
        return provider.getAllCursos();
    }
}
