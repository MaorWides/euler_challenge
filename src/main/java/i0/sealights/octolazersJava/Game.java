package i0.sealights.octolazersJava;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static String[][] AssumeSimple() {
        return new String[0][0];
    }
    public static String[][] AssumeRandom() {
        return new String[0][0];
    }
    public static List<String[][]> AllPossibilities(PositionStruct position) {
        return new ArrayList<>();
    }
    public static List<(int x, int y)> BoardToPositions(String[][] positions) {
        for (var pos : positions) {

        }
        return new ArrayList<>();
    }
    public static List<(int x, int y)> BoardSSSToPositions(List<String[][]> positions) {
        for (var pos : positions) {

        }
        return new ArrayList<>();
    }
    public static List<String[][]> PositionsToBoard(List<(int x, int y)> positions) {
        for (var (x, y) : positions) {

        }
        return new ArrayList<>();
    }
    public static List<String[][]> PositionsToBoardSSS(List<(int x, int y)> positions) {
        for (var (x, y) : positions) {

        }
        return new ArrayList<>();
    }
    public static String[][] WhatWeKnowForSure() {
        return new String[0][0];
    }
    public static List<String[][]> SimpleProblemSolver(PositionStruct[] position, List<String[][]> grid) {
        for (var item : position) {
            if ((item.Start.Pos <= 2 || item.End.Pos <= 2) && item.Start.Direct != item.End.Direct) {

            }
        }
        return grid;
    }
}

    internal record class PositionStruct(EdgeStruct Start, EdgeStruct End) {
    public static implicit operator (EdgeStruct start, EdgeStruct end)(PositionStruct value) {
        return (value.Start, value.End);
    }

    public static implicit operator PositionStruct((EdgeStruct start, EdgeStruct end) value) {
        return new PositionStruct(value.start, value.end);
    }
}

    internal record class EdgeStruct(int Pos, LazerData.Direction Direct) {
    public static implicit operator (int pos, LazerData.Direction direct)(EdgeStruct value) {
        return (value.Pos, value.Direct);
    }

    public static implicit operator EdgeStruct((int pos, LazerData.Direction direct) value) {
        return new EdgeStruct(value.pos, value.direct);
    }
}