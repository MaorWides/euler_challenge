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
        LazerData.Direction direct = LazerData.nextRandom();
        Tuple2<Integer, LazerData.Direction> shot = Helpers.Shoot(grid, pos, direct);
        Helpers.statically(pos + ", " + LazerData.toString(direct) + "\n" + shot.a + ", " + LazerData.toString(shot.b));
        System.console().readLine();
    }
}
//╔╦╗/‾\
//╠╬╣|●|║═│─
//╚╩╝\_/