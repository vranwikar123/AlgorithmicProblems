package educative.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripleSumClosest {

    public static void main(String[] args) {
        int[] inp = {0,0,0};
        int X = 1;
        List<Integer> result = findCloseTriplet(inp, X);
        result.forEach(x -> System.out.println(x+" "));

    }

    private static List<Integer> findCloseTriplet(int[] inp, int x) {
        Arrays.sort(inp);
        int minSum = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<inp.length-2;i++) {

            int left = i+1;
            int right = inp.length-1;

            while(left < right)
            {
                int sum = inp[i] + inp[left] + inp[right];
                if(Math.abs(x-sum) < Math.abs(x-minSum)) {
                    minSum = sum;
                    res.clear();
                    res.add(inp[i]);
                    res.add(inp[left]);
                    res.add(inp[right]);
                }

                if(x > sum) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        System.out.println(minSum);
        return res;
    }
}
