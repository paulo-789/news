package models;

public class Users {
    private String name;
    private String position;



    public Users (String name, String position){
        this.name=name;
        this.position=position;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
