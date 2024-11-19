package org.example;


public class MarsRover {
    private int x;
    private int y;

    private Direction direction;

    public MarsRover() {
        this.direction = Direction.N;
    }

    public String showStatus() {
        return String.format("%d:%d:%s", x, y, direction);
    }

    public String executeCommand(String command) {
        if (!isValidCommand(command)) {
            return showStatus();
        }
        Command cmd = Command.valueOf(command);
        switch (cmd) {
            case Command.L:
                direction = turnLeft(direction);
                break;
            case Command.R:
                direction = turnRight(direction);
                break;
            case Command.M:
                moveForward();
                break;
            case Command.B:
                moveBackward();
                break;
            default:
                break;
        }
        return showStatus();
    }

    public boolean isValidCommand(String command) {
        try {
            Command.valueOf(command);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private Direction turnLeft(Direction currentDirection) {
        return switch (currentDirection) {
            case N -> Direction.W;
            case W -> Direction.S;
            case S -> Direction.E;
            case E -> Direction.N;
        };
    }

    private Direction turnRight(Direction currentDirection) {
        return switch (currentDirection) {
            case N -> Direction.E;
            case E -> Direction.S;
            case S -> Direction.W;
            case W -> Direction.N;
        };
    }

    private void moveForward() {
        switch (direction) {
            case N -> y++;
            case S -> y--;
            case E -> x++;
            case W -> x--;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case N -> y--;
            case S -> y++;
            case E -> x--;
            case W -> x++;
        }
    }
}
