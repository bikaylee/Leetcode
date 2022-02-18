// 706. Design HashMap

class MyHashMap {
    
    private ArrayList<Integer> ind;
    private ArrayList<Integer> val;

    /** Initialize your data structure here. */
    public MyHashMap() {
        ind = new ArrayList<Integer>();
        val = new ArrayList<Integer>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = ind.indexOf(key);
        if (i >= 0) {
            val.set(i, value);
        }  else {
            ind.add(key);
            val.add(value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = ind.indexOf(key);
        if(i >= 0) 
            return val.get(i);
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = ind.indexOf(key);
        if (i >= 0) {
            ind.remove(i);
            val.remove(i);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
