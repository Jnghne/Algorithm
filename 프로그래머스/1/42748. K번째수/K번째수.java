import java.util.*;
class Solution {
    public static int[] answer;
    public int[] solution(int[] array, int[][] commands) {
        answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            sort(array, command, idx);    
            ++idx;
        }
        return answer;
    }
    public static void sort(int[] array, int[] command, int idx) {
        int i = command[0];
        int j = command[1];
        int k = command[2];

        ArrayList<Integer> splitArr = new ArrayList<>();

        for(int a=1; a<=array.length; a++) {
            if(a >= i && a <= j) {
                splitArr.add(array[a-1]);
            }
        }
        Collections.sort(splitArr);
        answer[idx] = splitArr.get(k-1);
    }
}