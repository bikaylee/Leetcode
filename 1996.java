// 1996. The Number of Weak Characters in the Game

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        // First, sort the attacks in properties
        // Then, we will only need to deal with the defense
        
        // If the attacks equal, then compare the defense 
        // put smaller defense first, then it would over count the weaks
        //      if put larger defense first, 
        //          we are over-counting the invalid characters that are not strictly greater
        
        //      ex. input: [[4,5],[4,6],[4,3],[4,7]] output: 0
        //      if sorted with greater defense first: [[4,7],[4,6],[4,5],[4,3]] -> 3 
        //          the maxDefense will be overwritten at 7 and miscount all the characters after
        //      if sorted with smaller defense first: [[4,3],[4,5],[4,6],[4,7]] -> 0
        //          the maxDefense will only be updated at the next element 
        
        Arrays.sort(properties, (a,b) -> a[0] == b[0] ? b[1] - a[1]: b[0] - a[0]);

        for (int[]x : properties) 
            System.out.println(x[0] + " " + x[1]);
        
        System.out.println();
        
        int maxDefense = 0;
        int weaks = 0;
        for (int [] p: properties) {
            System.out.println(maxDefense);
            if (maxDefense > p[1])
                weaks++;
            maxDefense = Math.max(maxDefense, p[1]);
        }
        
        return weaks;
    }
}
