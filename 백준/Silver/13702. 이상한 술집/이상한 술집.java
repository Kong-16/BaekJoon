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
        long k = Long.parseLong(st.nextToken());
        long[] bowl = new long[n];
        long MaxNum = 0;
        for (int i = 0; i < n; i++) {
            bowl[i] = Long.parseLong(br.readLine());
            MaxNum = Math.max(MaxNum, bowl[i]);
        }
        long start = 1;
        long end = MaxNum;
        long ans = 1;
        while (start <= end) {
            // 찾고싶은 값
            long mid = (start + end) / 2;
            // 줄 수 있는 애들
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                // mid로 나눠서 애들한테 줌.
                cnt += (bowl[i] / mid);
            }
            if (k <= cnt) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}