public class Solution {
    public List<String> restoreIpAddresses(String s) {
        /* Using recursion DFS to explore all possibilities of valid IP address. */
        
        ArrayList<String> result = new ArrayList<String>();
        
        /* Eliminate invalid input at first. */
        
        if (s.length() < 4 || s.length() > 12){
            return result;
        }
        
        String temp = new String();
        
        helper(result, s, temp, 0);
        
        return result;
    }
    
    private void helper(ArrayList<String> result, String s, String temp, int pos) {
        /* When pos is 3, it means we've scanned all possible cases within 3 numbers. */
        if (pos == 3 && validInput(s)){
            result.add(temp + s);
            return;
        }
        int maxDot = 3;
        for (int i = 0; i < s.length() - 1 && i < maxDot; i++){
            String substr = s.substring(0, i+1);
            String exploring = s.substring(i+1, s.length());
            if (validInput(substr)){
                helper(result, exploring, temp + substr + '.', pos + 1);
            }
        }
    }
    /* If string starts with 0, it can only contain 0. */
    public boolean validInput(String s){
        if (s.charAt(0) == '0'){
            return s.equals("0");
        }
        /* check the range of number. */
        else{
            if (Integer.valueOf(s) <= 255 && Integer.valueOf(s) >= 0){
                return true;
            }
            else{
                return false;
            }
        }
    }
}