package models;

import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int numberOfStaff;

    public Department(String name,String description,int numberOfStaff){
        this.name=name;
        this.description=description;
        this.numberOfStaff=numberOfStaff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department department = (Department) o;
        return numberOfStaff == department.numberOfStaff &&
                Objects.equals(name, department.name) &&
                Objects.equals(description, department.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, numberOfStaff);
    }
}
