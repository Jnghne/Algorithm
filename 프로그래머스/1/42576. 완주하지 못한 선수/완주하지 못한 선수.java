import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        LinkedHashMap<String, Integer> pMap = new LinkedHashMap<>();
        
        for(String p : participant) {
            Integer cnt = pMap.get(p);
            if(cnt != null) {
                pMap.replace(p,++cnt);
            } else {
                pMap.put(p,1);    
            }
        }
        
        String answer = "";
        for(String c : completion) {
            Integer cnt = pMap.get(c);
            
            if(cnt == 1) {
                pMap.remove(c);
            } else {
                pMap.replace(c, --cnt);
            }
        }
        
        if(!pMap.isEmpty()) {
            for(String p : pMap.keySet()) {
                answer = p;
            }    
        }
               
        return answer;
    }
}