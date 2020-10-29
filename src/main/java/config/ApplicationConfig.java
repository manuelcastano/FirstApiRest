package config;

import db.ConnectionPool;
import services.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(EchoService.class);
        resources.add(CalculoService.class);
        resources.add(DatabaseServices.class);
        resources.add(CursoServices.class);
        resources.add(EstudianteService.class);
        resources.add(ProfesorService.class);
        resources.add(CursoServices.class);
        ConnectionPool.getInstance();
        return resources;
    }
}
