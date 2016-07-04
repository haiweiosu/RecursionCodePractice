public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* Using a hashmap to store current string chracter and its position, when encounter
            a repeated char, update the hashmap and max length. */
        int max = 0;
        if (s == null){
            return max;
        }
        if (s.length() == 1){
            return 1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length() -1; i++){
            if (map.containsKey(s.charAt(i))){
                max = i;
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }
}