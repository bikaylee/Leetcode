package CodeSignal;

public class AllLongestStrings {
    String[] solution(String[] inputArray) {

        int max = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            int len = inputArray[i].length();
            if (!map.containsKey(len))
                map.put(len, new ArrayList<>());

            map.get(len).add(i);
            max = Math.max(len, max);
        }

        if (!map.containsKey(max))
            return new String[] {};

        List<Integer> list = map.get(max);

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = inputArray[list.get(i)];

        return ans;
    }

}
