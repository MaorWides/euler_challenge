package i0.sealights.octolazersJava;
import java.util.Random;

public class Main {
    public static Random rand = new Random();
    public static void main(String[] args) {
        int[][] grid = Helpers.RndGrid(12, 12, 6);
        Helpers.Update(grid);
        int pos = rand.nextInt(1, grid.length);
        LazerData.Direction direct = LazerData.NextRandom();
        int[] shot = Helpers.Shoot(grid, pos, direct);
        Helpers.Statically(pos +  ", " + LazerData.ToString(direct) + "\n" + shot[0] + ", " + LazerData.ToString(shot[1]));
    }
}
//???/?\
//???|?|????
//???\_/