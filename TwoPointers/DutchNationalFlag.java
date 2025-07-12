package educative.TwoPointers;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args){
        int[] inp = {2,0,1};
        dutchNationalFlag(inp);
        Arrays.stream(inp).forEach(e->System.out.print(e+" "));
    }

    private static void dutchNationalFlag(int[] inp) {
        int low = 0;
        int high = inp.length-1;

        for(int i=0; i<=high; ){
            if(inp[i] == 0){
                swap(inp, i, low);
                i++;
                low++;
            }
            else if(inp[i] == 1){
                i++;
            }
            else{
                swap(inp, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] inp, int i, int low) {
        int temp = inp[i];
        inp[i] = inp[low];
        inp[low] = temp;
    }
}
