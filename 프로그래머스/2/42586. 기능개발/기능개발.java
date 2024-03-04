import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
    
        // 프로세스 별 남은 기간 계산
        for(int p = 0 ; p < progresses.length; p++) {
            int day = (int) Math.ceil((100 - progresses[p]) / (double)speeds[p]);
            days.add(day);
        }

        int prev = days.poll();
        int operationCnt = 1;
        while(!days.isEmpty()) {
            if(days.peek() <= prev) {
                days.poll();
                operationCnt ++;
            }
            else {
                answer.add(operationCnt);
                prev = days.poll();
                operationCnt = 1;
            }
        }
        answer.add(operationCnt);
        return answer;
    }
}