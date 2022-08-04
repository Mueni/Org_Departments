package models;

import java.util.Objects;

public class Position {
    private String name;
    private int id;
    private String dateCreated;
    private String updated;

    public Position(String name, String dateCreated){
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getId() == position.getId() && getName().equals(position.getName()) && getDateCreated().equals(position.getDateCreated()) && getUpdated().equals(position.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getDateCreated(), getUpdated());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getUpdated() {
        return updated;
    }

    public String getName() {
        return name;
    }


}
