package DP;

/**
 * https://leetcode.com/problems/maximal-square/description/
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] inp = {
                {'0', '1'},
                {'1', '0'}
        };

        System.out.println(maxSquareArea(inp));
    }

    public static int maxSquareArea(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int maxSize = 1;

        for(int i = 0; i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i==0 || j==0)
                {
                    if(grid[i][j] == '1')
                        dp[i][j] = 1;
                }
                else
                {
                    if(grid[i][j] == '1')
                    {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    }
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize*maxSize;
    }

}
