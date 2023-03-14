package i0.sealights.octolazersJava;

import org.parboiled.common.Tuple2;
import java.io.IOException;
import java.util.Random;

public class Main {
    /**
     * public random across the program
     */
    public static final Random rand = new Random();
    public static void main(String[] args) throws IOException {
        String[][] grid = Helpers.rndGrid(12, 12, 6);
        Helpers.update(grid);
        int pos = rand.nextInt(grid.length) + 1;
        LaserData.Direction direct = LaserData.nextRandom();
        Tuple2<Integer, LaserData.Direction> shot = Helpers.Shoot(grid, pos, direct);
        Helpers.statically(pos + ", " + LaserData.toString(direct) + "\n" + shot.a + ", " + LaserData.toString(shot.b));
        System.console().readLine();
    }
}
//╔╦╗/‾\
//╠╬╣|●|║═│─
//╚╩╝\_/