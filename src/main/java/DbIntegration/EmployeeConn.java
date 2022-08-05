package DbIntegration;

import models.Employees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class EmployeeConn implements EmployeeDB {
    private final Sql2o sql2o;

    public EmployeeConn(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Employees employee) {
        String sql = "INSERT INTO employees (firstName, lastName, staffId, role, phoneNo, email, positionId, departmentId, dateCreated) VALUES (:firstName, :lastName, :staffId, :role, :phoneNo, :email, :positionId, :departmentId, :dateCreated)"; //raw sql
        try(Connection con = sql2o.open()){ // open a connection
            int id = (int) con.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Employees> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM employees") //raw sql
                    .executeAndFetch(Employee.class); //fetch a list
        }
    }

    @Override
    public Employees findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM employees WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employee.class);
        }
    }

    @Override
    public void update(int id, String newFirstName, String newLastName, String newStaffId, String newRole, String newPhoneNo, String newEmail, int positionId, int departmentId, String updated) {
        String sql = "UPDATE employees SET (firstName, lastName, staffId, role, phoneNo, email, positionId, departmentId, updated) = (:firstName, :lastName, :staffId, :role, :phoneNo, :email, :positionId, :departmentId, :updated) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("firstName", newFirstName)
                    .addParameter("lastName", newLastName)
                    .addParameter("staffId", newStaffId)
                    .addParameter("role", newRole)
                    .addParameter("phoneNo", newPhoneNo)
                    .addParameter("email", newEmail)
                    .addParameter("id", id)
                    .addParameter("positionId", positionId)
                    .addParameter("departmentId", departmentId)
                    .addParameter("updated", updated)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from employees WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllEmployees() {
        String sql = "DELETE from employees";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
