package models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    public void NewEmployeeIsCreated() throws Exception {
        Employees employee = setupNewEmployee();
        assertNotNull(employee);
    }

    @Test
    public void EmployeeWithFirstName() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("John", employee.getFirstName());
    }

    @Test
    public void EmployeeWithLastName() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("Doe", employee.getLastName());
    }

    @Test
    public void EmployeeWithStaffID() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("JM890", employee.getStaffId());
    }

    @Test
    public void EmployeeWithRole() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("Accountant", employee.getRole());
    }

    @Test
    public void EmployeeWithPhoneNumber() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("07111111", employee.getPhoneNo());
    }

    @Test
    public void EmployeeWithEmail() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("john@doe.com", employee.getEmail());
    }

    @Test
    public void EmployeeWithPositionId() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals(1, employee.getPositionId());
    }

    @Test
    public void EmployeeWithDepartmentId() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals(1, employee.getDepartmentId());
    }

    @Test
    public void EmployeeWithCreatedDate() throws Exception {
        Employees employee = setupNewEmployee();
        assertEquals("01-01-01", employee.getDateCreated());
    }

    @Test
    public void EmployeeWithGetId() throws Exception {
        Employees employee = setupNewEmployee();
        employee.setId(1);
        assertEquals(1, employee.getId());
    }

    @Test
    public void EmployeeWithUpdated() throws Exception {
        Employees employee = setupNewEmployee();
        employee.setUpdated("01-01-01");
        assertEquals("01-01-01", employee.getUpdated());
    }

    public Employees setupNewEmployee(){
        Date todayTime = new Date();
        return new Employees("John", "Doe", "JM890", "Accountant","07111111", "john@doe.com",0, 1, "01-01-01");
    }
}
