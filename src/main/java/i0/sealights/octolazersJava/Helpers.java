package i0.sealights.octolazersJava;
public class Helpers
{
    public static int statsLine = 1;
    private static int sizehori = 0;
    /**
     generates a random grid

     @param sizeh the horisontal size
     @param sizev the vertical size
     @param dots the amount of dots
     @param maxFails the amount of tries before considering a fail; default is 10
     @return
     */

    public static String[][] RndGrid(int sizeh, int sizev, int dots)
    {
        return RndGrid(sizeh, sizev, dots, 10);
    }

    //C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public static string[,] RndGrid(int sizeh, int sizev, int dots, int maxFails = 10)
    public static String[][] RndGrid(int sizeh, int sizev, int dots, int maxFails)
    {
        String[][] grid = new String[sizeh][sizev];
        int a1, a2;
        int count = 0;
        boolean b = false;
        int failcount = 0;
        boolean fail = false;
        while (count < dots && !fail)
        {
            a1 = Program.rand.Next(1, sizeh - 1);
            a2 = Program.rand.Next(1, sizev - 1);
            for (int i1 = 0; i1 < grid.length; i1++)
            {
                for (int i2 = 0; i2 < (grid.length == 0 ? 0 : grid[0].length); i2++)
                {
                    if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5))
                    {
                        if (grid[i1][i2].equals("●"))
                        {
                            b = true;
                        }
                    }
                }
            }
            if (!b)
            {
                failcount = 0;
                grid[a1][a2] = "●";
                count++;
            }
            else
            {
                failcount++;
            }
            b = false;
            if (failcount >= maxFails)
            {
                fail = true;
            }

        }
        return grid;
    }
    /**
     generates a random grid

     @param sizeh the horisontal size
     @param sizev the vertical size
     @param dots the amount of dots
     @param successes the amount of amount of successful grids
     @param maxFails the amount of tries before considering a fail; default is 10
     @param maxTries the amount of retries considered before giving up; default is 100
     @return
     */

    public static String[][][] RndGrid(int sizeh, int sizev, int dots, tangible.OutObject<Integer> successes, int maxFails)
    {
        return RndGrid(sizeh, sizev, dots, successes, maxFails, 100);
    }

    public static String[][][] RndGrid(int sizeh, int sizev, int dots, tangible.OutObject<Integer> successes)
    {
        return RndGrid(sizeh, sizev, dots, successes, 10, 100);
    }

    //C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public static string[][,] RndGrid(int sizeh, int sizev, int dots, out int successes, int maxFails = 10, int maxTries = 100)
    public static String[][][] RndGrid(int sizeh, int sizev, int dots, tangible.OutObject<Integer> successes, int maxFails, int maxTries)
    {
        String[][][] grids = new String[maxTries][][];
        int a1, a2;
        int failCount = 0;
        successes.outArgValue = 0;
        for (int i = 0; i < maxTries; i++)
        {
            grids[i] = new String[sizeh][sizev];
            boolean fail = false;
            boolean b = false;
            int count = 0;
            while (count < dots && !fail)
            {
                a1 = Program.rand.Next(1, sizeh - 1);
                a2 = Program.rand.Next(1, sizev - 1);
                for (int i1 = 0; i1 < grids[i].GetLength(0); i1++)
                {
                    for (int i2 = 0; i2 < grids[i].GetLength(1); i2++)
                    {
                        if (Math.sqrt(Math.pow(i1 - a1, 2) + Math.pow(i2 - a2, 2)) <= Math.sqrt(5))
                        {
                            if (grids[i][i1][i2].equals("●"))
                            {
                                b = true;
                            }
                        }
                    }
                }
                if (!b)
                {
                    failCount = 0;
                    grids[i][a1][a2] = "●";
                    count++;
                }
                else
                {
                    failCount++;
                }
                b = false;
                if (failCount >= maxFails)
                {
                    fail = true;
                }
            }
            if (count == dots)
            {
                successes.outArgValue++;
            }
        }
        return grids;
    }
    /**
     shoots a lazer

     @param grid the grid in question
     @param entry
     @param entryLeftTopRightDown
     @return
     */
//C# TO JAVA CONVERTER TASK: Methods returning tuples are not converted by C# to Java Converter:
//	public static(int exit, LazerData.Direction exitLeftTopRightDown) Shoot(string[,] grid, int entry, LazerData.Direction entryLeftTopRightDown)
//		{
//			(int exit, LazerData.Direction exitLeftTopRightDown) exit;
//			exit.exitLeftTopRightDown = entryLeftTopRightDown;
//			(int x, int y) point = (0, 0);
//			switch (entryLeftTopRightDown)
//			{
//				case LazerData.Direction.left:
//					point = (0, entry);
//					break;
//				case LazerData.Direction.top:
//					point = (entry, 0);
//					break;
//				case LazerData.Direction.right:
//					point = (grid.GetLength(0) - 1, entry);
//					break;
//				case LazerData.Direction.down:
//					point = (entry, grid.GetLength(0) - 1);
//					break;
//				default:
//					break;
//			}
//			do
//			{
//				switch (exit.exitLeftTopRightDown)
//				{
//					case LazerData.Direction.left:
//						if (point.x < grid.GetLength(0) - 1 && grid[point.x + 1, point.y] == "●")
//						{
//							return (entry, entryLeftTopRightDown);
//						}
//						else if (point.y < grid.GetLength(0) - 1 && point.x < grid.GetLength(0) - 1 && grid[point.x + 1, point.y + 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.down;
//						}
//						else if (point.y > 0 && point.x < grid.GetLength(0) - 1 && grid[point.x + 1, point.y - 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.top;
//						}
//						point = Advance(point, exit.exitLeftTopRightDown);
//						break;
//					case LazerData.Direction.top:
//						if (point.y < grid.GetLength(0) - 1 && grid[point.x, point.y + 1] == "●")
//						{
//							return (entry, entryLeftTopRightDown);
//						}
//						else if (point.y < grid.GetLength(0) - 1 && point.x < grid.GetLength(0) - 1 && grid[point.x + 1, point.y + 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.right;
//						}
//						else if (point.y < grid.GetLength(0) - 1 && point.x > 0 && grid[point.x - 1, point.y + 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.left;
//						}
//						point = Advance(point, exit.exitLeftTopRightDown);
//						break;
//					case LazerData.Direction.right:
//						if (point.x > 0 && grid[point.x - 1, point.y] == "●")
//						{
//							return (entry, entryLeftTopRightDown);
//						}
//						else if (point.x > 0 && point.y < grid.GetLength(0) - 1 && grid[point.x - 1, point.y + 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.top;
//						}
//						else if (point.x > 0 && point.y > 0 && grid[point.x - 1, point.y - 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.down;
//						}
//						point = Advance(point, exit.exitLeftTopRightDown);
//						break;
//					case LazerData.Direction.down:
//						if (point.y > 0 && grid[point.x, point.y - 1] == "●")
//						{
//							return (entry, entryLeftTopRightDown);
//						}
//						else if (point.y > 0 && point.x < grid.GetLength(0) - 1 && grid[point.x + 1, point.y - 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.left;
//						}
//						else if (point.y > 0 && point.x > 0 && grid[point.x - 1, point.y - 1] == "●")
//						{
//							exit.exitLeftTopRightDown = LazerData.Direction.right;
//						}
//						point = Advance(point, exit.exitLeftTopRightDown);
//						break;
//					default:
//						break;
//				}
//			}
//			while (point.x >= 0 && point.y >= 0 && point.x <= grid.GetLength(0) - 1 && point.y <= grid.GetLength(0) - 1);
//			if (exit.exitLeftTopRightDown == LazerData.Direction.left || exit.exitLeftTopRightDown == LazerData.Direction.right)
//			{
//				exit.exit = point.y;
//			}
//			else
//			{
//				exit.exit = point.x;
//			}
//			exit.exitLeftTopRightDown = LazerData.Invert(exit.exitLeftTopRightDown);
//			return exit;
//		}
    //updates board
    //input: grid to draw
    public static void Update(String[][] grid)
    {
        Console.BufferHeight = Short.MAX_VALUE - 1;
        sizehori = grid.length * 4 + 20;
        Console.Clear();
        System.out.println("octolasers");
        Console.SetWindowSize(sizehori + 100, (grid.length == 0 ? 0 : grid[0].length) * 2 + 30);
        Console.CursorVisible = false;
        Console.OutputEncoding = Encoding.UTF8;
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
