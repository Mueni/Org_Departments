package models;

import java.util.Objects;

public class Department {
    private String name;
    private int id;
    private String dateCreated;
    private String updated;

    public Department(String name, String dateCreated){
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() && getName().equals(that.getName()) && getdateCreated().equals(that.getdateCreated()) && getUpdated().equals(that.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getdateCreated(), getUpdated());
    }

    public int getId() {
        return id;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdated() {
        return updated;
    }

    public String getName() {
        return name;
    }

    public String getdateCreated() {
        return dateCreated;
    }
}
