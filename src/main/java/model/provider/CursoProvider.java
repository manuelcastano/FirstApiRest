package model.provider;

import db.ConnectionPool;
import db.MySQLConnection;
import entity.Curso;
import model.dto.CursoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoProvider {

    public ArrayList<CursoDTO> getAllCursos(){
        ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
        MySQLConnection connection = ConnectionPool.getInstance().getConexion();
        ProfesorProvider profesorProvider = new ProfesorProvider();
        String sql = "SELECT nombre, programa, profesorID FROM cursos";
        ResultSet rs = connection.query(sql);
        try {
            while(rs.next()){
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(rs.getString(1));
                cursoDTO.setPrograma(rs.getString(2));
                cursoDTO.setProfesor(profesorProvider.getProfesorById(rs.getInt(3)));
                cursos.add(cursoDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cursos;
    }

    public ArrayList<CursoDTO> getAllCursosByProfesor(int id){
        ArrayList<CursoDTO> cursos = new ArrayList<CursoDTO>();
        MySQLConnection connection = ConnectionPool.getInstance().getConexion();
        String sql = "SELECT nombre, programa FROM cursos WHERE profesorID="+id;
        ResultSet rs = connection.query(sql);
        try {
            while(rs.next()){
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(rs.getString(1));
                cursoDTO.setPrograma(rs.getString(2));
                cursos.add(cursoDTO);
            }
            connection.disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cursos;
    }

    public void insertCurso(Curso curso){
        MySQLConnection connection = ConnectionPool.getInstance().getConexion();
        connection.executeSQL("INSERT INTO cursos(nombre, programa, profesorID) VALUES('$nombre', '$programa', $profesorID)".replace("$nombre", curso.getNombre()).replace("$programa", curso.getPrograma()).replace("$profesorID", ""+curso.getProfesorID()));
    }

    public void updateCurso(){

    }

    public void deleteCurso(){

    }

    public Curso mapFromDTO(CursoDTO cursoDTO){
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setPrograma(cursoDTO.getPrograma());
        curso.setProfesorID(cursoDTO.getProfesor().getId());
        return curso;
    }
}
