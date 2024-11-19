package org.example;


public class MarsRover {
    private String status;

    private String direction;

    public MarsRover() {
        this.direction = "N";
    }

    public String showStatus() {
        return "0:0:" + direction;
    }

    public String executeCommand(String command) {
        switch (command) {
            case "L":
                direction = turnLeft(direction);
                break;
            case "R":
                direction = turnRight(direction);
                break;
        }
        return showStatus();
    }

    private String turnLeft(String currentDirection) {
        return switch (currentDirection) {
            case "N" -> "W";
            case "W" -> "S";
            case "S" -> "E";
            case "E" -> "N";
            default -> currentDirection;
        };
    }

    private String turnRight(String currentDirection) {
        return switch (currentDirection) {
            case "N" -> "E";
            case "E" -> "S";
            case "S" -> "W";
            case "W" -> "N";
            default -> currentDirection;
        };
    }
}
