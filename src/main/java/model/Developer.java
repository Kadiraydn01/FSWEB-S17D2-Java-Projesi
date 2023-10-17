package model;

public class Developer {
    private String name;
    private int id;
    private double salary;
    Experience experience;

    public Developer(String name, int id, double salary, Experience experience) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Developer.Experience getExperience() {
        return experience;
    }

    public void setExperience(Developer.Experience experience) {
        this.experience = experience;
    }


    public enum Experience {
        JUNIOR,
        MID ,
        SENIOR,
    }
}
