package models;

import java.util.Objects;

public class Users {
    private String name;
    private String position;
    private int id;



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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(position, users.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position,id);
    }
}
