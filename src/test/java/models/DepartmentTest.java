package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    public void NewDepartmentIsCreated() throws Exception {
        Department department = setupNewDepartment();
        assertTrue(department instanceof Department);
    }

    @Test
    void getNameInstantiatesCorrectly() {
        Department department = setupNewDepartment();
        assertEquals("Finance", department.getName());
    }
    @Test
    void getCreatedCorrectly() {
        Department department = setupNewDepartment();
        assertEquals("01-01-01", department.getdateCreated());
    }

    @Test
    public void DepartmentWithGetId() throws Exception {
        Department department = setupNewDepartment();
        department.setId(1);
        assertEquals(1, department.getId());
    }

    @Test
    public void DepartmentWithUpdate() throws Exception {
        Department department = setupNewDepartment();
        department.setUpdated("01-01-01");
        assertEquals("01-01-01", department.getUpdated());
    }

    public Department setupNewDepartment(){
        return new Department("Finance", "01-01-01");
    }
}
