package Blind75.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MedianFinder {

    private List<Integer> store = null;
    private int size = 0;
    public MedianFinder() {
        store = new ArrayList<>();
    }

    public void addNum(int num) {
        store.add(num);
        store.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        size = store.size();
    }

    public double findMedian() {
        int med = store.size()/2;
        if(size%2 == 0){
            double d1 = store.get(med);
            double d2 = store.get(med+1);
            return (d1 + d2)/2;
        }
        else{
            return store.get(med);
        }
    }

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();

    }
}
