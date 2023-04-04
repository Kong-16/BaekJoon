import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // dp[i][0] => i가 중심인 가장 긴 팰린드롬 수열의 길이.
        // dp[i][1] => i와 i+1이 중심인 가장 긴 팰린드롬 수열의 길이.
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        // 모든 길이에 대해
        for (int i = n - 1; 0 < i; i--) {
            // 배열의 모든 숫자에 대해
            for (int j = 0; j + i < n; j++) {
                int start = j;
                int end = j + i;
//                if ((start + end) % 2 != 0) continue;
                while (arr[start] == arr[end]) {
                    start++;
                    end--;
                    // 모두 같은 경우,
                    // 중간에서 만나는 경우, 중간 값(dp[mid][0])에 길이 저장.
                    if (start == end) {
                        if (dp[start][0] == 1)
                            dp[start][0] = i + 1;
                        break;
                    }
                    // 지나친 경우, 중간 - 1 값 (dp[mid][1]에 길이 저장.
                    if (end < start) {
                        if (dp[start - 1][1] == 0)
                            dp[start - 1][1] = i + 1;
                        break;
                    }

                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            //  팰린드롬 수열의 길이가 s~e의 범위 밖이면 불가능.
            if (dp[(s + e) / 2][(s + e) % 2] < (e - s + 1))
                bw.write(0 + "\n");
            else bw.write(1 + "\n");
        }
        bw.flush();
        bw.close();
    }
}