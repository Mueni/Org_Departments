package DbIntegration;

import models.Employees;
import models.Position;

import java.util.List;

public interface PositionDB {
    // LIST
    List<Position> getAll();

    // CREATE
    void add(Position position);

    // READ
    Position findById(int id);

    // UPDATE
    void update(int id, String name, String Updated);

    // DELETE
    void deleteById(int id);
    void clearAllPositions();

    List<Employees> getAllEmployeesByPosition(int positionId);
}