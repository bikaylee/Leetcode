
HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
     if (!map.contains(A[i]))
       map.put(A[i], new ArrayList<>());
      map.get(A[i]).add(i);
    }
    int [] B = A.clone();
    Arrays.sort(B);
    
    if (map.size() == 1) 
      return 0;
