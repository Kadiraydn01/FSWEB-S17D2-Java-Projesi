package model;

public class MiddleDeveloper extends Developer{
    public MiddleDeveloper(String name, int id, double salary, Experience experience) {
        super(name, id, salary, Experience.MID);
    }
}
