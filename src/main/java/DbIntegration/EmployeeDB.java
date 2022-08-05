package DbIntegration;

import models.Employees;

import java.util.List;

public interface EmployeeDB {

    // READ
    List<Employees> getAll();

    // CREATE
    void add(Employees employee);


    // READ ONE
    Employees findById(int id);

    // UPDATE
    void update(int id,String firstName, String lastName, String staffId, String role, String phoneNo, String email, int positionId, int departmentId, String updated);

    // DELETE
    void deleteById(int id);
    void clearAllEmployees();

}
