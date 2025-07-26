package DP;

/**
 * Number of Unique Paths to Go from Top Left to Bottom Right
 */
public class RobotUniquePaths {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int res = uniquePaths(m, n);
        System.out.println(res);
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++)
        {
            for(int j  =0; j<n;j++)
            {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
