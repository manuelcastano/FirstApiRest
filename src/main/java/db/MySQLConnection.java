package db;

import java.sql.*;

public class MySQLConnection {

    private Connection connection;
    private boolean inUse;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            inUse = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean createDatabase(){
        boolean success = false;
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS profesores(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), facultad VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS cursos(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), programa VARCHAR(100), profesorID INT, FOREIGN KEY(profesorID) REFERENCES TO profesores(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiante(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), codigo VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiante_curso(id INT PRIMARY KEY AUTO_INCREMENT, estudianteID INT, cursoID INT, FOREIGN KEY(estudianteID) REFERENCES TO estudiantes(id), FOREIGN KEY(cursoID) REFERENCES TO cursos(id)");
            success = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return success;
    }

    public void executeSQL(String sql){
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            inUse = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        ResultSet output = null;
        try {
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
            inUse = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }
}
