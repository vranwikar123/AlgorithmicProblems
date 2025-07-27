package heaps;

import java.util.*;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required
 * to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the
 * two rooms later.
 */

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MinMeetingRooms {

    public static void main(String[] args) {

        List<Meeting> input = new ArrayList<Meeting>();
        input.add(new Meeting(1, 4));
        input.add(new Meeting(2, 5));
        input.add(new Meeting(7, 9));
        int result = minMeetingRoomNeeded(input);
        System.out.println("Minimum meeting rooms required: " + result);

    }

    public static int minMeetingRoomNeeded(List<Meeting> meetingList)
    {
        Collections.sort(meetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Meeting> minQueue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        int minRooms = 0;

        for(Meeting meeting: meetingList)
        {
            while (!minQueue.isEmpty() && meeting.start >= minQueue.peek().end)
            {
                minQueue.poll();
            }

            minQueue.offer(meeting);
            minRooms = Math.max(minRooms, minQueue.size());
        }

        return minRooms;
    }

}
