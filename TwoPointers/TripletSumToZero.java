package educative.TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args){
        int[] inp = {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = findTriplets(inp);
        System.out.println();
    }

    private static List<List<Integer>> findTriplets(int[] inp) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<inp.length - 2;i++){
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j = i+1;j<inp.length;j++){
                int x = -(inp[i] + inp[j]);
                if(hashSet.contains(x)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(inp[i]);temp.add(inp[j]);temp.add(x);
                    result.add(temp);
                }
                else{
                    hashSet.add(inp[j]);
                }
            }
        }
        return result;
    }
}
