package model;

public class Course {
    private String code;
    private String name = "";
    private int credits = 1;
    private int classCapacity = 1;

    public Course() {
    }

    public Course(String code, String name, int credits, int classCapacity) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.classCapacity = classCapacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }
}
