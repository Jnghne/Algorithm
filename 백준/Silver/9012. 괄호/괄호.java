import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            // ps 입력
            String psStr = br.readLine();
            ArrayList<Boolean> tempArr = getVpsYnList(psStr);

            if(tempArr.isEmpty()) {
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    private static ArrayList<Boolean> getVpsYnList(String psStr) {
        char[] psArr = psStr.toCharArray();
        ArrayList<Boolean> tempArr = new ArrayList<>();
        int lastIdx = 0;

        // vps 인지 확인
        for (char c : psArr) {
            boolean psType = c == '(';
            if(lastIdx != 0 &&
                    tempArr.get(lastIdx-1).equals(!psType)
                    && !psType
            ){
                tempArr.remove(lastIdx-1);
                lastIdx--;
                continue;
            }
            tempArr.add(psType);
            lastIdx++;
        }
        return tempArr;
    }
}