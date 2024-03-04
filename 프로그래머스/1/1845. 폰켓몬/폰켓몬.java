import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length / 2;
        Map<Integer, Boolean> choice = new HashMap<>();
        
        for(int n : nums) {
            if(!choice.containsKey(n)) {
                choice.put(n, true);
                answer++;
            }
            if(answer==count) {
                break;
            }
        }
        
        return answer;
    }
}