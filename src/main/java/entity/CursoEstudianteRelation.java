package entity;

public class CursoEstudianteRelation {

    private int id;
    private int estudianteID;
    private int cursoID;

    public CursoEstudianteRelation(int id, int estudianteID, int cursoID) {
        this.id = id;
        this.estudianteID = estudianteID;
        this.cursoID = cursoID;
    }

    public CursoEstudianteRelation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}
