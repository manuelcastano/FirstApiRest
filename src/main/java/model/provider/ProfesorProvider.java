package model.provider;

import db.ConnectionPool;
import db.MySQLConnection;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorProvider {

    public ProfesorDTO getCompleteProfesorById(int id){
        MySQLConnection connection = ConnectionPool.getInstance().getConexion();
        String sql = "SELECT id, nombre, facultad FROM profesores WHERE id="+id;
        ResultSet rs = connection.query(sql);
        ProfesorDTO profesor = new ProfesorDTO();
        try {
            while(rs.next()){
                CursoProvider cursoProvider = new CursoProvider();
                ArrayList<CursoDTO> cursos = cursoProvider.getAllCursosByProfesor(id);
                profesor.setId(rs.getInt(1));
                profesor.setNombre(rs.getString(2));
                profesor.setFacultad(rs.getString(3));
                profesor.setCursos(cursos);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return profesor;
    }

    public ProfesorDTO getProfesorById(int id){
        MySQLConnection connection = ConnectionPool.getInstance().getConexion();
        String sql = "SELECT id, nombre, facultad FROM profesores WHERE id="+id;
        ResultSet rs = connection.query(sql);
        ProfesorDTO profesor = new ProfesorDTO();
        try {
            while(rs.next()){
                profesor.setId(rs.getInt(1));
                profesor.setNombre(rs.getString(2));
                profesor.setFacultad(rs.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return profesor;
    }

    public void getAllProfesores(){

    }

    public void insertProfesor(Profesor profesor){
        MySQLConnection connection = new MySQLConnection();
        connection.executeSQL("INSERT INTO profesor(nombre, facultad) VALUES('$nombre', '$facultad')".replace("$nombre", profesor.getNombre()).replace("$facultad", profesor.getFacultad()));
    }

    public void updateProfesor(){

    }

    public void deleteProfesor(){

    }

    public Profesor mapFromDTO(ProfesorDTO profesorDTO){
        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setFacultad(profesorDTO.getFacultad());
        return profesor;
    }

    public ProfesorDTO mapToDto(Profesor profesor){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setFacultad(profesor.getFacultad());
        return profesorDTO;
    }
}
