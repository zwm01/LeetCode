package Array.num324;

import java.util.Arrays;
/*将数组排序后，倒序反插，偶数位插较大值，奇数位插较小值
* 时间复杂度O（NlogN）
* 空间复杂度O（N）*/
public class Solution {
    public void wiggleSort(int[] nums) {
         Arrays.sort(nums);
         int temp[]=new int[nums.length];
         int start_index=nums.length-1;
         for (int i = 1; i < nums.length ; i=i+2) {
              temp[i]=nums[start_index--];
         }
         for (int i = 0; i < nums.length ; i=i+2) {
              temp[i]=nums[start_index--];
         }
         for (int i = 0; i < nums.length; i++) {
            nums[i]=temp[i];
         }
    }

}