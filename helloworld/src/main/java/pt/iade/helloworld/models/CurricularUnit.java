package pt.iade.helloworld.models;

public class CurricularUnit{
    private String name;
    private double grade;
    private double ects;
    private int semester;

    public CurricularUnit(String name, double grade, double ects, int semester) {
        this.name = name;
        this.grade = grade;
        this.ects = ects;
        this.semester = semester;
    }
    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getEcts() {
        return ects;
    }

    public int getSemester() {
        return semester;
    }
    public boolean isAccepted() {
        return grade >= 9.5;
    }
}

