// 253. Meeting Rooms II

class Solution {
    
    // Case 1 (overlapping):  [[1, 10], [2, 7]]   endTime(10)  > startTime(2), there is time conflict so two meeting rooms are required
    // Case 2 (!overlapping): [[1, 10], [10, 18]] endTime(10) <= startTime(10), these two intervals can be merged meaning they can use the same meeting room
        
    public int minMeetingRooms(int[][] intervals) {
        
        // Sort all intervals by their starting time 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    
        // store all end times to keep track of rooms that can be freed/merged
        PriorityQueue<Integer> minEndTime = new PriorityQueue<>();
        minEndTime.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int earliest = minEndTime.poll();
            
            // Case 2: merge intervals, does not need to worry about in-between cases since intervals are sorted by starting time
            if (earliest <= intervals[i][0]) 
                earliest = intervals[i][1];
            
            // Case 1: endTime of earliest can be freed room > startTime of next meeting, assign it to a new room (add to priority queue)
            else 
                minEndTime.add(intervals[i][1]);
            
            // Add back the merged intervals to the occupied rooms
            minEndTime.add(earliest);
        }
        
        // now, priority queue stores all occupied rooms 
        return minEndTime.size();
    }
}