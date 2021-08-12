class Solution {

    /**
     * To follow the constrain that if there exists two indices i and j such that :
     * 
     * 1. i != j 0 <= i,
     * 2. j < arr.length
     * 3. arr[i] == 2 * arr[j]
     * 
     * Remember the indices of each element in arr and check its double in the hash table
     * 
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            seen.put(arr[i], i);

        for (int i = 0; i < arr.length; i++) {
            int d = arr[i] * 2;
            if (seen.containsKey(d) && seen.get(d) != i)
                return true;
        }
        return false;
    }

    // Use two way validation, check for doubles and halves with one pass 
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();

        for (int n : arr) {
            if (seen.contains(n * 2) || (n % 2 == 0 && seen.contains(n / 2)))
                return true;
            seen.add(n);
        }
        return false;
    }
}
