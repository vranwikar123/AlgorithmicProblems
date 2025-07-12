package educative.TwoPointers;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] inp = {1, 2, 3, 4, 6};
        int target = 6;
        int[] result = targetSum(inp, target);
    }

    private static int[] targetSum(int[] inp, int target) {
        int left = 0;
        int right = inp.length - 1;

        while (left < right) {
            int sum = inp[left] + inp[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}