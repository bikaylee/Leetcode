class Solution {
    // Sort the timePoints in ascending order
    // For each pair, get their minute intervals and at last get the interval of (first and last)
    
    // To calculate the minute intervals:
    // Compare the hours 
    //  if (hr_i == hr_j) 
    //      hr = 0;
    // else 
    //      hr = hr_j - hr_i
    
    // Then, compare the minutes
    // if (min_j < min_i) 
    //      hr -= 1 
    //      min = (min_j+60) - min_i
    // else 
    //      min = min_j - min_i
    
    // Lastly
    //      totalMinDiff = hr*60 + min
    //      Math.min(totalMinDiff, minInaDay - totalMinDiff)
    
    // => Converts to totalMinDiff = (hr_j - hr_i)*60 + min_j - min_i
    

    // Sort total minutes 
    public int findMinDifference(List<String> timePoints) {
        List<Integer> convertedMinutes = convertTime(timePoints);
        int minutes = Integer.MAX_VALUE;

        for (int i = 1; i < convertedMinutes.size(); i++)
            minutes = Math.min(minutes, convertedMinutes.get(i) - convertedMinutes.get(i - 1));

        return minutes;
    }

    private List<Integer> convertTime(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] token = timePoint.split(":");
            minutes.add(Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]));
        }
        Collections.sort(minutes);
        minutes.add(24 * 60 + minutes.get(0));
        return minutes;
    }

    
    // Sort hours and minutes
    public int findMinDifference(List<String> timePoints) {
        final int MIN_IN_A_DAY = 24 * 60;
        
        List<int[]> convertedTimePoints = convertTime(timePoints);
        int minutes = Integer.MAX_VALUE;

        for (int i = 1; i < convertedTimePoints.size(); i++)
            minutes = Math.min(minutes, calcInterval(convertedTimePoints.get(i - 1), convertedTimePoints.get(i)));
            
        return Math.min(minutes, MIN_IN_A_DAY-minutes);
    }
    
    private int calcInterval(int[] time1, int[] time2) {
        int min = (time2[0] - time1[0])*60 + time2[1] - time1[1];
        return min;
    }
    
    private List<int[]> convertTime(List<String> timePoints) {
        List<int[]> convertedPoints = new ArrayList<>();

        for (String timePoint: timePoints) {
            String[] token = timePoint.split(":");
            convertedPoints.add(new int[]{Integer.parseInt(token[0]), Integer.parseInt(token[1])});
        }
        
        Collections.sort(convertedPoints, (a,b) -> a[0] == b[0] ? a[1]-b[1]: a[0] - b[0]);
        int[] first = convertedPoints.get(0);
        convertedPoints.add(new int[] { first[0] + 24, first[1] });
        
        // printList(convertedPoints);
        return convertedPoints;
    }
    
    private void printList(List<int[]> list) {
        System.out.println();
        for (int[] x : list)
            System.out.println(x[0] + " " + x[1]);
    }
    
}