// 1710. Maximum Units on a Truck

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.addAll(Arrays.asList(boxTypes));
        
        int units = 0;
        while(!pq.isEmpty() && truckSize > 0) {
            int[] max = pq.poll();
            int count = Math.min(truckSize, max[0]);
            units += count * max[1];
            truckSize -= count;
        }
        
        return units;
    }
}