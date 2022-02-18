// 423. Reconstruct Original Digits from English

class Solution {
    
    // final HashMap<String, Character> map = new HashMap<>(){{
    //     put("zero", '0');  // z                o
    //     put("one", '1');   //              n   o
    //     put("two", '2');   // w                o
    //     put("three", '3'); //    h
    //     put("four", '4');  // u  f  v          o
    //     put("five", '5');  //    f     i
    //     put("six", '6');   // x        i
    //     put("seven", '7'); //       v      n
    //     put("eight", '8'); // g  h     i
    //     put("nine", '9');  //          i   n
    // }};
    
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(char letter: s.toCharArray()) {
          count[letter-'a']++;
        }
        
        int[] out = new int[10];
        out[0] = count['z'-'a'];
        out[2] = count['w'-'a'];
        out[4] = count['u'-'a'];
        out[6] = count['x'-'a'];
        out[8] = count['g'-'a'];
        out[3] = count['h'-'a'] - out[8];
        out[5] = count['f'-'a'] - out[4];
        out[7] = count['v'-'a'] - out[5];
        out[9] = count['i'-'a'] - out[8] - out[6] - out[5];
        out[1] = count['o'-'a'] - out[0] - out[2] - out[4];
     
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) 
            for (int j = 0; j < out[i]; j++)
                sb.append(i);
        
        
        return sb.toString();
    }
}