package models;

import java.util.Objects;

public class Employees {
    private String firstName;
    private String lastName;
    private String staffId;
    private String role;
    private int id;
    private String phoneNo;
    private String email;
    private int departmentId;
    private int positionId;
    private String dateCreated;
    private String updated;

    public Employees(String firstName, String lastName, String staffId, String role, String phoneNo, String email, int positionId, int departmentId, String dateCreated){
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffId = staffId;
        this.role = role;
        this.phoneNo = phoneNo;
        this.email = email;
        this.positionId = positionId;
        this.departmentId = departmentId;
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;
        Employees employee = (Employees) o;
        return getId() == employee.getId() && getDepartmentId() == employee.getDepartmentId() && getPositionId() == employee.getPositionId() && getFirstName().equals(employee.getFirstName()) && getLastName().equals(employee.getLastName()) && getStaffId().equals(employee.getStaffId()) && getRole().equals(employee.getRole()) && getPhoneNo().equals(employee.getPhoneNo()) && getEmail().equals(employee.getEmail()) && getDateCreated().equals(employee.getDateCreated()) && getUpdated().equals(employee.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getStaffId(), getRole(), getId(), getPhoneNo(), getEmail(), getDepartmentId(), getPositionId(), getDateCreated(), getUpdated());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public int getPositionId() {
        return positionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRole() {
        return role;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getUpdated() {
        return updated;
    }
}
