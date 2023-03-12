package i0.sealights.octolazersJava;

import org.parboiled.common.Tuple2;
import java.util.ArrayList;
import java.util.List;

public class Game extends Helpers {
    public static String[][] assumeSimple() {
        return new String[0][0];
    }
    public static String[][] assumeRandom() {
        return new String[0][0];
    }
    public static List<String[][]> allPossibilities(Tuple2<Tuple2<Integer, LazerData.Direction>, Tuple2<Integer, LazerData.Direction>> position) {
        return new ArrayList<String[][]>();
    }
    public static List<Tuple2<Integer, Integer>> boardToPositions(String[][] positions) {
        for (String[] pos : positions) {

        }
        return new ArrayList<Tuple2<Integer, Integer>>();
    }
    public static List<Tuple2<Integer, Integer>> boardSSSToPositions(List<String[][]> positions) {
        for (String[][] pos : positions) {

        }
        return new ArrayList<Tuple2<Integer, Integer>>();
    }
    public static List<String[][]> positionsToBoard(List<Tuple2<Integer, Integer>> positions) {
        for (Tuple2<Integer, Integer> pos : positions) {

        }
        return new ArrayList<String[][]>();
    }
    public static List<String[][]> positionsToBoardSSS(List<Tuple2<Integer, Integer>> positions) {
        for (Tuple2<Integer, Integer> pos : positions) {

        }
        return new ArrayList<String[][]>();
    }
    public static String[][] whatWeKnowForSure() {
        return new String[0][0];
    }
    public static List<String[][]> simpleProblemSolver(Tuple2<Tuple2<Integer, LazerData.Direction>, Tuple2<Integer, LazerData.Direction>>[] position, List<String[][]> grid) {
        for (Tuple2<Tuple2<Integer, LazerData.Direction>, Tuple2<Integer, LazerData.Direction>> item : position) {
            if ((item.a.a <= 2 || item.b.a <= 2) && item.a.b != item.b.b) {

            }
        }
        return grid;
    }
}