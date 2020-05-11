package models;

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
}
