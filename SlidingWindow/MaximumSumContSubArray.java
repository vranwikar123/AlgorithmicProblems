package educative.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumContSubArray {

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 4, 1, 5};
        int k = 2;
        int result = findMaxSumContSubArray(nums, k);
        System.out.println(result);
    }

    private static int findMaxSumContSubArray(int[] nums, int k)
    {
        int maxSum = Integer.MIN_VALUE;
        int winStart = 0;
        int tempSum = 0;

        for(int winEnd = 0; winEnd < nums.length; winEnd++)
        {
            tempSum += nums[winEnd];

            if(winEnd >= k-1)
            {
                if(tempSum > maxSum)
                {
                    maxSum = tempSum;
                }
                tempSum = tempSum - nums[winStart];
                winStart++;
            }
        }

        return maxSum;
    }
}
