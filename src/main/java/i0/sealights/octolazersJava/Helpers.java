package i0.sealights.octolazersJava;

import org.jline.terminal.Size;
import org.parboiled.common.Tuple2;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Helpers {
    public static int statsLine = 1;
    private static int sizehori = 0;
    /**
     * Generates a random grid
     * @param sizeh the horizontal size
     * @param sizev the vertical size
     * @param dots the amount of dots
     * @param maxFails the amount of tries before considering a fail; default is 10
     * @return a 2D string array representing the random grid
     */
    public static String[][] rndGrid(int sizeh, int sizev, int dots, int maxFails) {
        String[][] grid = new String[sizeh][sizev];
        int a1, a2;
        int count = 0;
        boolean b = false;
        int failcount = 0;
        boolean fail = false;
        Random rand = new Random();

        while (count < dots && !fail) {
            a1 = rand.nextInt(sizeh - 2) + 1;
            a2 = rand.nextInt(sizev - 2) + 1;

            for (int i1 = 0; i1 < grid.length; i1++) {
                for (int i2 = 0; i2 < grid[0].length; i2++) {
                    if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5)) {
                        if (grid[i1][i2] == "●") {
                            b = true;
                        }
                    }
                }
            }

            if (!b) {
                failcount = 0;
                grid[a1][a2] = "●";
                count++;
            } else {
                failcount++;
            }

            b = false;

            if (failcount >= maxFails) {
                fail = true;
            }
        }

        return grid;
    }
    /**
     * Generates a random grid
     * @param sizeh the horizontal size
     * @param sizev the vertical size
     * @param dots the amount of dots
     * @return a 2D string array representing the random grid
     */
    public static String[][] rndGrid(int sizeh, int sizev, int dots) {
        int maxFails = 10;
        String[][] grid = new String[sizeh][sizev];
        int a1, a2;
        int count = 0;
        boolean b = false;
        int failcount = 0;
        boolean fail = false;
        Random rand = new Random();

        while (count < dots && !fail) {
            a1 = rand.nextInt(sizeh - 2) + 1;
            a2 = rand.nextInt(sizev - 2) + 1;

            for (int i1 = 0; i1 < grid.length; i1++) {
                for (int i2 = 0; i2 < grid[0].length; i2++) {
                    if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5)) {
                        if (grid[i1][i2] == "●") {
                            b = true;
                        }
                    }
                }
            }

            if (!b) {
                failcount = 0;
                grid[a1][a2] = "●";
                count++;
            } else {
                failcount++;
            }

            b = false;

            if (failcount >= maxFails) {
                fail = true;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = "";
                }
            }
        }
        return grid;
    }
    /**
     * Generates a random grid
     *
     * @param sizeh     the horizontal size
     * @param sizev     the vertical size
     * @param dots      the amount of dots
     * @param maxFails  the amount of tries before considering a fail; default is 10
     * @param maxTries  the amount of retries considered before giving up; default is 100
     * @return an array of randomly generated grids
     */
    public static String[][][] rndGrids(int sizeh, int sizev, int dots, int maxFails, int maxTries) {
        String[][][] grids = new String[maxTries][sizeh][sizev];
        int a1, a2;
        int failCount = 0;
        int successes = 0;
        Random rand = new Random();
        for (int i = 0; i < maxTries; i++) {
            grids[i] = new String[sizeh][sizev];
            boolean fail = false;
            boolean b = false;
            int count = 0;
            while (count < dots && !fail) {
                a1 = rand.nextInt(sizeh - 1) + 1;
                a2 = rand.nextInt(sizev - 1) + 1;
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    for (int i2 = 0; i2 < grids[i][i1].length; i2++) {
                        if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5)) {
                            if ("●".equals(grids[i][i1][i2])) {
                                b = true;
                            }
                        }
                    }
                }
                if (!b) {
                    failCount = 0;
                    grids[i][a1][a2] = "●";
                    count++;
                } else {
                    failCount++;
                }
                b = false;
                if (failCount >= maxFails) {
                    fail = true;
                }
            }
            if (count == dots) {
                successes++;
            }
        }
        return grids;
    }
    /**
     * Generates a random grid
     *
     * @param sizeh     the horizontal size
     * @param sizev     the vertical size
     * @param dots      the amount of dots
     * @param maxFails  the amount of tries before considering a fail; default is 10
     * @return an array of randomly generated grids
     */
    public static String[][][] rndGrids(int sizeh, int sizev, int dots, int maxFails) {
        int maxTries = 100;
        String[][][] grids = new String[maxTries][sizeh][sizev];
        int a1, a2;
        int failCount = 0;
        int successes = 0;
        Random rand = new Random();
        for (int i = 0; i < maxTries; i++) {
            grids[i] = new String[sizeh][sizev];
            boolean fail = false;
            boolean b = false;
            int count = 0;
            while (count < dots && !fail) {
                a1 = rand.nextInt(sizeh - 1) + 1;
                a2 = rand.nextInt(sizev - 1) + 1;
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    for (int i2 = 0; i2 < grids[i][i1].length; i2++) {
                        if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5)) {
                            if ("●".equals(grids[i][i1][i2])) {
                                b = true;
                            }
                        }
                    }
                }
                if (!b) {
                    failCount = 0;
                    grids[i][a1][a2] = "●";
                    count++;
                } else {
                    failCount++;
                }
                b = false;
                if (failCount >= maxFails) {
                    fail = true;
                }
            }
            if (count == dots) {
                successes++;
            }
        }
        return grids;
    }
    /**
     * Generates a random grid
     *
     * @param sizeh     the horizontal size
     * @param sizev     the vertical size
     * @param dots      the amount of dots
     * @return an array of randomly generated grids
     */
    public static String[][][] rndGrids(int sizeh, int sizev, int dots) {
        int maxFails = 10;
        int maxTries = 100;
        String[][][] grids = new String[maxTries][sizeh][sizev];
        int a1, a2;
        int failCount = 0;
        int successes = 0;
        Random rand = new Random();
        for (int i = 0; i < maxTries; i++) {
            grids[i] = new String[sizeh][sizev];
            boolean fail = false;
            boolean b = false;
            int count = 0;
            while (count < dots && !fail) {
                a1 = rand.nextInt(sizeh - 1) + 1;
                a2 = rand.nextInt(sizev - 1) + 1;
                for (int i1 = 0; i1 < grids[i].length; i1++) {
                    for (int i2 = 0; i2 < grids[i][i1].length; i2++) {
                        if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5)) {
                            if ("●".equals(grids[i][i1][i2])) {
                                b = true;
                            }
                        }
                    }
                }
                if (!b) {
                    failCount = 0;
                    grids[i][a1][a2] = "●";
                    count++;
                } else {
                    failCount++;
                }
                b = false;
                if (failCount >= maxFails) {
                    fail = true;
                }
            }
            if (count == dots) {
                successes++;
            }
        }
        return grids;
    }
    /**
     * Returns coordinates on board
     * @param x coordinates on grid
     * @param y coordinates on grid
     * @return a tuple of integers representing the coordinates on the board
     */
    public static Tuple2<Integer, Integer> gridify(int x, int y) {
        return new Tuple2<>(x * 4, y * 2 + 1);
    }
    /**
     * Awaits user input
     */
    public static void awaitKey() {
        System.out.println("press any key to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    /**
     * Writes a statistic
     * @param s the statistic to write
     */
    public static void statically(String s) {
        int times = count(s, "\n");
        if (times != 0) {
            for (int i = 0; i < times; i++) {
                System.out.print("\033[" + statsLine + ";" + sizehori + "H");
                System.out.println(s.substring(0, s.indexOf("\n")));
                s = s.substring(s.indexOf("\n") + "\n".length());
                statsLine++;
            }
        }
        System.out.print("\033[" + statsLine + ";" + sizehori + "H");
        System.out.println(s);
        statsLine++;
    }
    /**
     * utility: checks how many v`s are in s
     * @param s
     * @param v
     * @return
     */
    public static int count(String s, String v) {
        int count = 0;
        while (s.contains(v)) {
            count++;
            s = s.substring(s.indexOf(v) + v.length());
        }
        return count;
    }
    /**
     * advances the point in the requested direction
     * @param pos
     * @param LeftTopRightDown
     * @return
     */
    public static Tuple2<Integer, Integer> advance(Tuple2<Integer, Integer> pos, LazerData.Direction LeftTopRightDown) {
        switch (LeftTopRightDown) {
            case left:
                pos = new Tuple2<>(pos.a + 1, pos.b);
                break;
            case top:
                pos = new Tuple2<>(pos.a, pos.b + 1);
                break;
            case right:
                pos = new Tuple2<>(pos.a - 1, pos.b);
                break;
            case down:
                pos = new Tuple2<>(pos.a, pos.b - 1);
                break;
            default:
                break;
        }
        return pos;
    }
    /**
     * shoots a lazer
     * @param grid the grid in question
     * @param entry
     * @param entryLeftTopRightDown
     * @return
     */
    public static Tuple2<Integer, LazerData.Direction> Shoot(String[][] grid, int entry, LazerData.Direction entryLeftTopRightDown) {
        Tuple2<Integer, LazerData.Direction> exit = new Tuple2(0, entryLeftTopRightDown);
//C# TO JAVA CONVERTER TASK: Tuple variables are not converted by C# to Java Converter:
        Tuple2<Integer, Integer> point = new Tuple2<>(0, 0);
        switch (entryLeftTopRightDown)
        {
            case left:
                point = new Tuple2<>(0, entry);
                break;
            case top:
                point = new Tuple2<>(entry, 0);
                break;
            case right:
                point = new Tuple2<>(grid.length - 1, entry);
                break;
            case down:
                point = new Tuple2<>(entry, grid.length - 1);
                break;
            default:
                break;
        }
        do
        {
            switch (exit.b)
            {
                case left:
                    if (point.a < grid.length - 1 && grid[point.a + 1][point.b].equals("●"))
                    {
                        return new Tuple2<>(entry, entryLeftTopRightDown);
                    }
                    else if (point.b < grid.length - 1 && point.a < grid.length - 1 && grid[point.a + 1][point.b + 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.down);
                    }
                    else if (point.b > 0 && point.a < grid.length - 1 && grid[point.a + 1][point.b - 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.top);
                    }
                    point = advance(point, exit.b);
                    break;
                case top:
                    if (point.b < grid.length - 1 && grid[point.a][point.b + 1].equals("●"))
                    {
                        return new Tuple2<>(entry, entryLeftTopRightDown);
                    }
                    else if (point.b < grid.length - 1 && point.a < grid.length - 1 && grid[point.a + 1][point.b + 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.right);
                    }
                    else if (point.b < grid.length - 1 && point.a > 0 && grid[point.a - 1][point.b + 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.left);
                    }
                    point = advance(point, exit.b);
                    break;
                case right:
                    if (point.a > 0 && grid[point.a - 1][point.b].equals("●"))
                    {
                        return new Tuple2<>(entry, entryLeftTopRightDown);
                    }
                    else if (point.a > 0 && point.b < grid.length - 1 && grid[point.a - 1][point.b + 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.top);
                    }
                    else if (point.a > 0 && point.b > 0 && grid[point.a - 1][point.b - 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.down);
                    }
                    point = advance(point, exit.b);
                    break;
                case down:
                    if (point.b > 0 && grid[point.a][point.b - 1].equals("●"))
                    {
                        return new Tuple2<>(entry, entryLeftTopRightDown);
                    }
                    else if (point.b > 0 && point.a < grid.length - 1 && grid[point.a + 1][point.b - 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.left);
                    }
                    else if (point.b > 0 && point.a > 0 && grid[point.a - 1][point.b - 1].equals("●"))
                    {
                        exit = new Tuple2<>(exit.a, LazerData.Direction.right);
                    }
                    point = advance(point, exit.b);
                    break;
                default:
                    break;
            }
        } while (point.a >= 0 && point.b >= 0 && point.a <= grid.length - 1 && point.b <= grid.length - 1);
        if (exit.b == LazerData.Direction.left || exit.b == LazerData.Direction.right)
        {
            exit = new Tuple2<>(point.b, exit.b);
        }
        else
        {
            exit = new Tuple2<>(point.a, exit.b);
        }
        exit = new Tuple2<>(exit.a, LazerData.invert(exit.b));
        return exit;
    }
    public static void update(String[][] grid) throws IOException {
        Terminal term = TerminalBuilder.terminal();
        sizehori = grid.length * 4 + 20;
        //Runtime.getRuntime().exec("cls");
        System.out.println("octolasers");
        term.setSize(new Size(sizehori + 100, (grid.length == 0 ? 0 : grid[0].length) * 2 + 30));
        //Console.CursorVisible = false;
        //Console.OutputEncoding = Encoding.UTF8;
        System.out.print("    0 ");
        int i, j;
        for (i = 0; i < grid.length - 1; i++)
        {
            if (i > 8)
            {
                System.out.print(" " + (i + 1) + " ");
            }
            else
            {
                System.out.print("  " + (i + 1) + " ");
            }
        }
        System.out.println("");
        System.out.print("  ╔");
        for (i = 0; i < grid.length - 1; i++)
        {
            System.out.print("═══╦");
        }
        System.out.println("═══╗");
        for (j = 0; j < (grid.length == 0 ? 0 : grid[0].length) - 1; j++)
        {
            if (j > 9)
            {
                System.out.print(j + "║");
            }
            else
            {
                System.out.print(j + " ║");
            }
            for (i = 0; i < grid.length - 1; i++)
            {
                System.out.print("   ║");
            }
            System.out.println("   ║");
            System.out.print("  ╠");
            for (i = 0; i < grid.length - 1; i++)
            {
                System.out.print("═══╬");
            }
            System.out.println("═══╣");
        }
        if (j > 9)
        {
            System.out.print(j + "║");
        }
        else
        {
            System.out.print(j + " ║");
        }
        for (i = 0; i < grid.length - 1; i++)
        {
            System.out.print("   ║");
        }
        System.out.println("   ║");
        System.out.print("  ╚");
        for (i = 0; i < grid.length - 1; i++)
        {
            System.out.print("═══╩");
        }
        System.out.println("═══╝");
        //Tuple2<Integer, Integer> pos = new Tuple2<>(term.getCursorPosition(term.).getX(), term.getCursorPosition(null).getY());
        i = 0;
        j = 0;
        if (grid[i][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("●");
        }
        if (grid[i][j + 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("─");
        }
        if (grid[i + 1][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("│");
        }
        if (grid[i + 1][j + 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("/");
        }
        for (j = 1; j < (grid.length == 0 ? 0 : grid[i].length) - 1; j++)
        {
            if (grid[i][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
            if (grid[i][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("●");
            }
            if (grid[i][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
            if (grid[i + 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i + 1][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("/");
            }
            if (grid[i + 1][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("\\");
            }
        }
        if (grid[i][j - 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("─");
        }
        if (grid[i][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("●");
        }
        if (grid[i + 1][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("│");
        }
        if (grid[i + 1][j - 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("\\");
        }
        for (i = 1; i < grid.length - 1; i++)
        {
            j = 0;
            if (grid[i - 1][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("\\");
            }
            if (grid[i - 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("●");
            }
            if (grid[i][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
            if (grid[i + 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i + 1][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("/");
            }
            for (j = 1; j < grid.length - 1; j++)
            {
                if (grid[i - 1][j + 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("\\");
                }
                if (grid[i - 1][j - 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("/");
                }
                if (grid[i - 1][j].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("│");
                }
                if (grid[i][j - 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("─");
                }
                if (grid[i][j].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("●");
                }
                if (grid[i][j + 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("─");
                }
                if (grid[i + 1][j].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("│");
                }
                if (grid[i + 1][j + 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("/");
                }
                if (grid[i + 1][j - 1].equals("●"))
                {
                    System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                    System.out.print("\\");
                }
            }
            if (grid[i - 1][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("/");
            }
            if (grid[i - 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
            if (grid[i][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("●");
            }
            if (grid[i + 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i + 1][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("\\");
            }
        }
        j = 0;
        if (grid[i - 1][j + 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("\\");
        }
        if (grid[i - 1][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("│");
        }
        if (grid[i][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("●");
        }
        if (grid[i][j + 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("─");
        }
        for (j = 1; j < grid[i].length - 1; j++)
        {
            if (grid[i - 1][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("\\");
            }
            if (grid[i - 1][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("/");
            }
            if (grid[i - 1][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("│");
            }
            if (grid[i][j - 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
            if (grid[i][j].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("●");
            }
            if (grid[i][j + 1].equals("●"))
            {
                System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
                System.out.print("─");
            }
        }
        if (grid[i - 1][j - 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("/");
        }
        if (grid[i - 1][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("│");
        }
        if (grid[i][j - 1].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("─");
        }
        if (grid[i][j].equals("●"))
        {
            System.out.print("\033[" + gridify(i + 1, j + 1).a + ";" + gridify(i + 1, j + 1).b + "H");
            System.out.print("●");
        }
        //System.out.print(String.format("%c[%d;%df",0x1B,pos.a, pos.b));
    }
}