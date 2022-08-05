package DbIntegration;

import models.Department;
import models.Employees;

import java.util.List;

public interface DepartmentDB {

    // READ
    List<Department> getAll();

    // CREATE
    void add(Department department);

    // READ ONE
    Department findById(int id);

    // UPDATE
    void update(int id, String name, String updated);

    // DELETE
    void deleteById(int id);
    void clearAllDepartments();

    List<Employees> getAllEmployeesByDepartment(int departmentId);
    void deleteAllEmployeesByDepartment(int departmentId);
}


