import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] jewels = new int[m];
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            sum += jewels[i];
            maxNum = Math.max(maxNum, jewels[i]);
        }
        int start = sum / n;
        int end = maxNum;
        int ans = start;
        while (start <= end) {
            // 찾고싶은 값
            int mid = (start + end) / 2;
            // 줄 수 있는 애들
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                // mid로 나눠서 애들한테 줌.
                cnt += Math.ceil(jewels[i] / (double) mid);
            }
            if (n < cnt) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}