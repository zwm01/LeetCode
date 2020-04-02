package Array.num174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int M=dungeon.length;
        int N=dungeon[0].length;
        int dp[][]=new int[M][N];
        dp[M-1][N-1]=dungeon[M-1][N-1]>=0?1:-dungeon[M-1][N-1]+1;
        for (int i = M-2; i>=0 ; i--) {
            if (dungeon[i][N-1]>=dp[i+1][N-1])
                dp[i][N-1]=1;
            else
                dp[i][N-1]=dp[i+1][N-1]-dungeon[i][N-1];
        }
        for (int i = N-2; i>=0 ; i--) {
            if (dungeon[M-1][i]>=dp[M-1][i+1])
                dp[M-1][i]=1;
            else
                dp[M-1][i]=dp[M-1][i+1]-dungeon[M-1][i];
        }
        for (int i = M-2; i>=0 ; i--) {
            for (int j = N-2; j >=0 ; j--) {
                if (dungeon[i][j]>=dp[i+1][j]||dungeon[i][j]>=dp[i][j+1])
                    dp[i][j]=1;
                else
                    dp[i][j]=Math.min(dp[i+1][j]-dungeon[i][j],dp[i][j+1]-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
