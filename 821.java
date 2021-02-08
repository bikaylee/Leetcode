/**
* Given a string s and a character c that occurs in s, 
* return an array of integers answer where answer.length == s.
* length and answer[i] is the shortest distance from s[i] to the character c in s.
*
* Example:
* Input: s = "loveleetcode", c = "e"
* Output: [3,2,1,0,1,0,0,1,2,2,1,0]
*
* Input: s = "aaab", c = "b"
* Output: [3,2,1,0]
*/

class Solution {
    public int[] shortestToChar(String s, char c) {
        int [] arr = new int[s.length()];
        
        //Range of sliding windows
        int start = 0, end = 0;
        
        //Check for the first window
        boolean first = true;
        
        for(int i = 0; i < s.length(); i++)
        {
            
            if(c == s.charAt(i))
            {
                end = i;
                for(int j = start; j < end; j++)
                {
                    if(first)
                        arr[j] = end-j;
                    else
                        arr[j] = Math.min(Math.abs(j-end), Math.abs(j-start));
                }
                first = false;   
                start = i;
            }
            else
            {
                //Check for the last window if last occurrance not at the end
                if(i == s.length()-1)
                {
                    for(int j = start; j < s.length(); j++)
                        arr[j] = j-end;
                }
            }
        }
        return arr;
    }
}
