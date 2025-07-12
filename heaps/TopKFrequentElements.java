package Blind75.heaps;

import java.security.KeyStore;
import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] op = topKFrequent(nums, k);
        Arrays.stream(op).forEach(System.out::println);
    }

    //HashMap Method
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] op = new int[k];
        for (int num: nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        Map<Integer, Integer> sortedMap = sortMapByValue(frequencyMap);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            if(count < k){
                op[count] = entry.getKey();
                count++;
            }
            else{
                break;
            }

        }

        return op;
    }

    private static Map<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> frequencyMap) {
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<Map.Entry<Integer, Integer>>(frequencyMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : entryList)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
