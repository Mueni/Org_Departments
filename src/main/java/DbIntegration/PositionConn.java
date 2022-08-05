package DbIntegration;

import models.Employees;
import models.Position;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class PositionConn implements PositionDB {
    private final Sql2o sql2o;

    public PositionConn(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void add(Position position) {
        String sql = "INSERT INTO positions (name, created_at) VALUES (:name, :created_at)"; //raw sql
        try(Connection con = sql2o.open()){ // open a connection
            int id = (int) con.createQuery(sql, true)
                    .bind(position)
                    .executeUpdate()
                    .getKey();
            position.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Position> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM positions") //raw sql
                    .executeAndFetch(Position.class); //fetch a list
        }
    }

    @Override
    public Position findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM positions WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Position.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newPosition, String updated){
        String sql = "UPDATE positions SET (name, updated) = (:name, :updated) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newPosition)
                    .addParameter("updated", updated)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from positions WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllPositions() {
        String sql = "DELETE from positions";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employees> getAllEmployeesByPosition(int positionId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM employees WHERE positionId = :positionId")
                    .addParameter("positionId", positionId)
                    .executeAndFetch(Employee.class);
        }
    }
}
}
