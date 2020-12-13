import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> c = new HashMap<>();
        
        for(String str : completion) {
            if(c.containsKey(str) == true){
                c.replace(str, c.get(str) + 1);
            } else c.put(str, 1);
        }
        
        for(String str : participant) {
            if(c.containsKey(str) == false || c.get(str) == 0) return str;
            c.replace(str, c.get(str)-1);
        }
        
        return null;
    }
}