package i0.sealights.octolazersJava;

import java.util.Random;

public class LazerData {
    public Direction gridDirection;
    public int position;
    public LazerData(Direction gridDirection, int position) {
        this.gridDirection = gridDirection;
        this.position = position;
    }
    public LazerData(int position, Direction gridDirection) {
        this.gridDirection = gridDirection;
        this.position = position;
    }
    public Direction getGridDirection() {
        return gridDirection;
    }
    public void setGridDirection(Direction gridDirection) {
        this.gridDirection = gridDirection;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public enum Direction {
        left,
        top,
        right,
        down,
    }
    public static Direction invert(Direction direction) {
        switch (direction) {
            case left:
                return Direction.right;
            case top:
                return Direction.down;
            case right:
                return Direction.left;
            case down:
                return Direction.top;
            default:
                throw new RuntimeException("unrecognized direction");
        }
    }
    public static String toString(Direction direction) {
        switch (direction) {
            case left:
                return "left";
            case top:
                return "top";
            case right:
                return "right";
            case down:
                return "down";
            default:
                throw new RuntimeException("unrecognized direction");
        }
    }
    public static final Random rand = new Random();
    public static Direction nextRandom() {
        return Direction.values()[rand.nextInt(Direction.values().length)];
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LazerData) {
            LazerData data = (LazerData) obj;
            return data.gridDirection == gridDirection && data.position == position;
        }
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return gridDirection.toString() + " " + position;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}