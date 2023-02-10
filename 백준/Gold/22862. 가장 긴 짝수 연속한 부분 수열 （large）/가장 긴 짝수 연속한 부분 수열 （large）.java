import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> prefix = new ArrayList<>();
        // int[] prefix = new int[n + 1];
        st = new StringTokenizer(bf.readLine());

        int oddCnt = 0;
        for (int i = 0; i < n; i++) {
            // 받은 값이 짝수이면 prefix에 이전까지 나온 홀수의 갯수 저장.
            if (Integer.parseInt(st.nextToken()) % 2 == 0)
                prefix.add(oddCnt);
            else
                oddCnt++;
        }
        int s = 0;
        int e = 0;
        int maxNum = 0;
        while (e < prefix.size()) {
            if (prefix.get(e) - prefix.get(s) <= m) {
                e++;
            } else {
                maxNum = Math.max(maxNum, e - s);
                s++;
            }
        }
        bw.write(Math.max(maxNum, e - s) + "\n");
        bw.flush();
        bw.close();
    }
}