package educative.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 */
public class MinContSubArraySum
{
    public static void main(String[] args)
    {
        int[] inp = {2, 1, 5, 2, 3, 2};
        int S = 7;
        int result = smallestArrayWithSum(inp, S);
        System.out.println(result);
    }

    private static int smallestArrayWithSum(int[] inp, int s)
    {
        int i = 0, j=0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for(i=0; i<inp.length;i++)
        {
            sum += inp[i];

            while(sum >= s)
            {
                minLength = Math.min(minLength, i-j+1);
                sum -= inp[j];
                j++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0:minLength;
    }
}
