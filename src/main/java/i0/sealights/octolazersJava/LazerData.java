package i0.sealights.octolazersJava;

public class LazerData {
    public Direction GridDirection;
    public int Position;
    public LazerData(Direction gridDirection, int position) {
        GridDirection = gridDirection;
        Position = position;
    }
    public LazerData(int position, Direction gridDirection) {
        GridDirection = gridDirection;
        Position = position;
    }
    public enum Direction {
        left,
        top,
        right,
        down,
    }
    public static Direction Invert(Direction direction) throws Exception {
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
                throw new Exception("unrecognized direction");
        }
    }
    public static String ToString(Direction direction) throws Exception {
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
                throw new Exception("unrecognized direction");
        }
    }
    public static Random rand = Program.rand;
    public static Direction NextRandom() {
        return Direction.values()[rand.nextInt(4)];
    }
    public boolean equals(Object obj) {
        return (obj instanceof LazerData data && data.GridDirection == GridDirection && data.Position == Position) || super.equals(obj);
    }
    public String toString() {
        return GridDirection.toString() + " " + Position;
    }
    public int hashCode() {
        return super.hashCode();
    }
}