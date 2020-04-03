package Array.num343;

/*思路：动态规划
* 时间复杂度O(n^2)
* 空间复杂度O(n)*/
public class Solution {
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        if (n==1)
            return 1;
        if (n==2)
            return 1;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            int left=1;
            int right=i-1;
            while (left<=right){
                int left_max= Math.max(dp[left],left);
                int right_max=Math.max(dp[right],right);
                dp[i]=Math.max(left_max*right_max,dp[i]);
                left++;
                right--;
            }
        }
        return dp[n];
    }
}
