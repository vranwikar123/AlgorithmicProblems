package SlidingWindow;

public class AverageOfContigousSubarrays
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        double[] res = findingAverages(nums, K);
        for(double db : res)
        {
            System.out.println(" " +db);
        }
    }

    private static double[] findingAverages(int[] nums, int K)
    {
        double[] res = new double[nums.length - K + 1];
        int windowStart = 0;
        double windowSum = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++)
        {
            windowSum += nums[windowEnd];

            if(windowEnd >= K-1)
            {
                res[windowStart] = windowSum / K;
                windowSum = windowSum - nums[windowStart];
                windowStart++;
            }
        }
        return res;
    }
}
