package services;

import model.dto.ProfesorDTO;
import model.dto.Response;
import model.provider.ProfesorProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("profesor")
@Stateless
public class ProfesorService {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createProfesor(ProfesorDTO profesorDTO){
        ProfesorProvider profesorProvider = new ProfesorProvider();
        profesorProvider.insertProfesor(profesorProvider.mapFromDTO(profesorDTO));
        return new Response("Operación exitosa");
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("{id}")
    public ProfesorDTO getProfesor(@PathParam("id") String id){
        ProfesorProvider profesorProvider = new ProfesorProvider();
        ProfesorDTO profesorDTO = profesorProvider.getCompleteProfesorById(Integer.parseInt(id));
        return profesorDTO;
    }
}
