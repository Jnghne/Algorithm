import java.lang.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String val = String.valueOf(order);
        
        char[] valArr = val.toCharArray();
        for(char v : valArr ){
            if(v == '3') {
            answer ++;
            }
            if(v == '6') {
            answer ++;
            }
            if(v == '9') {
            answer ++;
            }
        }
        
        return answer;
    }
}