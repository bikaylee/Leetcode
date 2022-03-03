package CodeSignal;

public class AlmostIncreasingSequence {
    boolean solution(int[] sequence) {
    
    int removed = 0;
    for (int i = 1; i < sequence.length; i++) {
        if (sequence[i] <= sequence[i-1])
            removed++;
        if (removed > 1)
            return false;
            
        // if were to remove one, the others should still follow the increasing order
        // i-2 < i (removing i-1) or i-1 < i+1 (removing i)
        if (i >= 2 && i +1 < sequence.length 
            && sequence[i] <= sequence[i-2]  
            && sequence[i+1] <= sequence[i-1])
            return false;
    }
    return true;
}
}
