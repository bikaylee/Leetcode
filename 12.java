//12.Integer to Roman
/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
*/


class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> roman = new HashMap<>();
        roman.put(1, 'I');
        roman.put(5, 'V');
        roman.put(10, 'X');
        roman.put(50, 'L');
        roman.put(100, 'C');
        roman.put(500, 'D');
        roman.put(1000, 'M');
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(num >= 1)
        {
            int d = num % 10;
           
            num /= 10;
            int leftover = 0;
            if(d == 9)
            {
                sb.append(roman.get((int)(1*Math.pow(10, i+1))));
                sb.append(roman.get((int)(1*Math.pow(10, i))));
            }
            else if(d >= 5)
            {
                for(int n = 0; n < d-5; n++)
                    sb.append(roman.get((int) (1*Math.pow(10,i))));
                sb.append(roman.get((int) (5*Math.pow(10,i))));
            }
            else if(d == 4)
            {
                sb.append(roman.get((int) (5*Math.pow(10,i))));
                sb.append(roman.get((int) (1*Math.pow(10,i))));
            }
            else
            {
                for(int n = 0; n < d; n++)
                    sb.append(roman.get((int) (1*Math.pow(10,i))));
            }
             i++;
        }
        return sb.reverse().toString();
    }
}