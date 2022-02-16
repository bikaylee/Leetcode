package CodeSignal;

public class AbsoluteValuesSumMinimization {
    int solution(int[] a) {
        // since the array is sorted, the distance can be predicted that
        // either one of the farthest elements sum is the greatest
        // hence, the middle should be minimum

        // even if the array is even, the middle two elements distance
        // are equal to respect of their farthest end
        // so return the smaller element value

        int n = a.length - 1;
        int mid = n / 2;
        return a[mid];
    }

}
