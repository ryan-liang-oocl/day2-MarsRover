package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {
    @Test
    public void  should_initialize_mars_rover() {
        MarsRover rover = new MarsRover();
        String report = rover.showStatus();

        assertEquals("0:0:N", report);

    }

    @Test
    public void should_face_west_when_orient_north_and_turn_left() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommand("L");

        assertEquals("0:0:W", response);
    }


}
