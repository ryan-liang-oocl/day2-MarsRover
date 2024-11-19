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

    @Test
    public void should_face_east_when_orient_north_and_turn_right() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommand("R");
        assertEquals("0:0:E", response);
    }

    @Test
    public void should_face_south_when_orient_west_and_turn_left() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        String response = rover.executeCommand("L");
        assertEquals("0:0:S", response);
    }

    @Test
    public void should_face_north_when_orient_west_and_turn_right() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        String response = rover.executeCommand("R");
        assertEquals("0:0:N", response);
    }

    @Test
    public void should_face_east_when_orient_south_and_turn_left() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("L");
        assertEquals("0:0:E", response);
    }

    @Test
    public void should_face_west_when_orient_south_and_turn_right() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("R");
        assertEquals("0:0:W", response);
    }

    @Test
    public void should_face_north_when_orient_east_and_turn_left() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        String response = rover.executeCommand("L");
        assertEquals("0:0:N", response);
    }

    @Test
    public void should_face_south_when_orient_east_and_turn_right() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        String response = rover.executeCommand("R");
        assertEquals("0:0:S", response);
    }

    @Test
    public void should_do_nothing_when_command_is_invalid() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommand("X");
        assertEquals("0:0:N", response);
    }

    @Test
    public void should_return_correction_when_orient_north_and_move_forward() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommand("M");
        assertEquals("0:1:N", response);
    }

    @Test
    public void should_return_correction_when_orient_west_and_move_forward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        String response = rover.executeCommand("M");
        assertEquals("-1:0:W", response);
    }

    @Test
    public void should_return_correction_when_orient_south_and_move_forward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("M");
        assertEquals("0:-1:S", response);
    }

    @Test
    public void should_return_correction_when_orient_east_and_move_forward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        String response = rover.executeCommand("M");
        assertEquals("1:0:E", response);
    }

    @Test
    public void should_return_correction_when_orient_north_and_move_backward() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommand("B");
        assertEquals("0:-1:N", response);
    }

    @Test
    public void should_return_correction_when_orient_west_and_move_backward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        String response = rover.executeCommand("B");
        assertEquals("1:0:W", response);
    }

    @Test
    public void should_return_correction_when_orient_south_and_move_backward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("B");
        assertEquals("0:1:S", response);
    }

    @Test
    public void should_return_correction_when_orient_east_and_move_backward() {
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        String response = rover.executeCommand("B");
        assertEquals("-1:0:E", response);
    }

    @Test
    public void should_return_correction_when_orient_north_and_execute_commands() {
        MarsRover rover = new MarsRover();
        String response = rover.executeCommands(new String[]{"M", "R", "M", "L", "M"});
        assertEquals("1:2:N", response);
    }


}
