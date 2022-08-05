package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    public void NewPositionIsCorrectlyCreated() throws Exception {
        Position position = setupNewPosition();
        assertTrue(position instanceof Position);
    }

    @Test
    void getNameCorrectly() {
        Position position = setupNewPosition();
        assertEquals("CFO", position.getName());
    }

    @Test
    void getCreatedCorrectly() {
        Position position = setupNewPosition();
        assertEquals("01-01-01", position.getDateCreated());
    }

    @Test
    public void PositionWithGetId() throws Exception {
        Position position = setupNewPosition();
        position.setId(1);
        assertEquals(1, position.getId());
    }

    @Test
    public void PositionWithUpdated() throws Exception {
        Position position = setupNewPosition();
        position.setUpdated("01-01-01");
        assertEquals("01-01-01", position.getUpdated());
    }

    public Position setupNewPosition(){
        return new Position("CFO", "01-01-01");
    }
}
