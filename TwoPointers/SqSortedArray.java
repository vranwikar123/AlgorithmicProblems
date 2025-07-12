package educative.TwoPointers;

import java.util.Arrays;

public class SqSortedArray {

    public static void main(String[] args){
        int[] inp = {-3, -1, 0, 1, 2};
        int[] op = findSqSortedArray(inp);
        Arrays.stream(op).forEach(System.out::println);
    }

    private static int[] findSqSortedArray(int[] inp) {
        int left = 0;
        int right = inp.length-1;
        int[] res = new int[inp.length];
        int resIndex = right;
        while(left < right){

            int leftSq = inp[left] * inp[left];
            int rightSq = inp[right] * inp[right];

            if(leftSq < rightSq){
                res[resIndex] = rightSq;
                resIndex--;
                right--;
            }
            else{
                res[resIndex] = leftSq;
                resIndex--;
                left++;
            }
        }
        return res;
    }
}
