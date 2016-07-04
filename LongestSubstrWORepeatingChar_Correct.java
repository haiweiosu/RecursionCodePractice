public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null){
            return max;
        }
        if (s.length() == 1){
            return 1;
        }
        
        /* We use two pointer to keep track of the max length. */
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}