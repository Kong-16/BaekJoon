import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, lastIdx, pole[][], dp[];

    public static int binarySearch(int find) {
        int idx = 0;
        int start = 0;
        int end = lastIdx;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (find < dp[mid]) {
                end = mid - 1;
            } else {
                idx = mid;
                start = mid + 1;
            }
        }


        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        pole = new int[n][2];
        dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        lastIdx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());
        }
        // 한 쪽에 대해 정렬한 후, 반대 쪽에 대해 가장 긴 증가하는 부분 수열의 길이를 찾으면 됨.
        Arrays.sort(pole, (a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 1; i <= n; i++) {
            int input = pole[i - 1][1];
            int idx = binarySearch(input);
            dp[idx + 1] = input;
            if (idx == lastIdx) lastIdx++;
        }
        bw.write((n - lastIdx) + "\n");
        bw.flush();
        bw.close();
    }
}