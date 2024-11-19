package org.example;


public class MarsRover {
    private String status;

    private Direction direction;

    public MarsRover() {
        this.direction = Direction.N;
    }

    public String showStatus() {
        return "0:0:" + direction;
    }

    public String executeCommand(String command) {
        Command cmd = Command.valueOf(command);
        switch (cmd) {
            case Command.L:
                direction = turnLeft(direction);
                break;
            case Command.R:
                direction = turnRight(direction);
                break;
            default:
                break;
        }
        return showStatus();
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
}
