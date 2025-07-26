package DP;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
 * right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any
 * square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
public class UniquePath2 {
    public static void main(String[] args) {
        int[][] inp = {
                        {0,0,0},
                        {0,1,0},
                        {0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(inp));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1)
            return 0;

        obstacleGrid[0][0] = 1;

        for(int i=1;i<obstacleGrid.length;i++)
        {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for(int i=1;i<obstacleGrid[0].length;i++)
        {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for(int i=1;i<obstacleGrid.length;i++)
        {
            for(int j=1;j<obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 0)
                {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] +
                            obstacleGrid[i][j - 1];
                }
                else
                {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
