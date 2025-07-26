package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(6, 7));
        intervalList.add(new Interval(2, 4));
        intervalList.add(new Interval(5, 9));

        List<Interval> merged = mergeIntervals(intervalList);
        for (Interval interval : merged)
            System.out.print("[" + interval.start + "," + interval.end + "] ");

        System.out.println();
    }

    private static List<Interval> mergeIntervals(List<Interval> intervalList)
    {
        if(intervalList.size() < 2)
            return intervalList;

        List<Interval> result = new ArrayList<>();
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        result.add(intervalList.get(0));

        for(int i = 1; i< intervalList.size(); i++)
        {
            Interval firstInterval = result.get(result.size()-1);
            Interval secondInterval = intervalList.get(i);

            if(isOverlap(firstInterval, secondInterval))
            {
                /*Interval mergedInterval = new Interval(firstInterval.start, secondInterval.end);
                result.add(mergedInterval);*/
                firstInterval.end = Math.max(secondInterval.end, firstInterval.end);
            }
            else
            {
                result.add(secondInterval);
            }
        }

        return result;
    }

    private static boolean isOverlap(Interval firstInterval, Interval secondInterval) {
        if(secondInterval.start < firstInterval.end)
        {
            return true;
        }
        return false;
    }

}
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}