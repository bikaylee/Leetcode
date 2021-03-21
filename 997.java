//997. Find the Town Judge

/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
*/
//Edge Approach
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust.length < 1)
        {
            if(N == 1)
                return 1;
            else
                return -1;
        }
        
        
        int [] out = new int[N];
        int [] in = new int[N];
        
        for(int i = 0; i < trust.length; i++)
        {
            out[trust[i][0]-1]++;
            in[trust[i][1]-1]++;
        }
        
        int i = 0;
        int judge = -1;
        int maxTrust = 0;
        while(i < N)
        {      
            if(in[i] > maxTrust)
            {
                maxTrust = in[i];
                judge = i;
            }
            i++;
        }
        
        if(out[judge] == 0 && maxTrust == N-1)
            return judge+1;
        
        return -1;
    }
}


// First Approach
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length < 1 && N == 1)
            return 1;
        // if(N==1 && trust[0][0] == trust[0][1]){
        //     return -1;
        // }
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        
        for(int i = 0; i < trust.length; i++)
        {
            first.add(trust[i][0]);
            if(!second.contains(trust[i][0]))
                second.add(trust[i][1]);
            else
                second.remove(trust[i][0]);
            if(first.contains(trust[i][1]))
                second.remove(trust[i][1]);
        }
        
        // System.out.println(first.toString());
        // System.out.println(second.toString());
        
        if(second.size() == 1)
            return (int) second.toArray()[0];
        
        return -1;
    }
}