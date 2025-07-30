package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BiggestIsland
{
    public static void main(String[] args)
    {
        int[][] grid =new int[][] {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };

        System.out.println("Result " +maxArea(grid));
    }

    public static int maxArea(int[][] grid)
    {
        int maxArea = Integer.MIN_VALUE;
        int row = grid.length;;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i< row; i++)
        {
            for(int j = 0; j< col; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {
                    int area = bfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);

                }
            }
        }

        return maxArea;
    }

    private static int bfs(int[][] grid, boolean[][] visited, int i, int j)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j]  = true;
        int area = 0;
        int[] rNbr = { 0, 0, 1, -1};
        int[] cNbr = { -1, 1, 0, 0};

        while(!queue.isEmpty())
        {
            int arr[] = queue.remove();
            int r = arr[0];
            int c = arr[1];
            area++;

            for(int k = 0; k<4; k++)
            {
                int R = r + rNbr[k];
                int C = c + cNbr[k];

                if(isSafe(R, C, grid, visited))
                {
                    visited[R][C] = true;
                    queue.add(new int[]{R, C});
                }
            }
        }

        return area;
    }

    private static boolean isSafe(int r, int c, int[][] grid, boolean[][] visited)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        return (r >= 0) && (r < rows) && (c >= 0) &&
                (c < cols) && (grid[r][c] == 1 && !visited[r][c]);
    }
}
