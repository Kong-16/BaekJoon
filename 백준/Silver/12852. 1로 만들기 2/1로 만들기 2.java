import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] dp;
    public static int[] parent;

    public static int dfs(int num) {
        if (num == 1) return dp[num];
        if (dp[num] != 0) return dp[num];
        int div3 = num % 3 == 0 ? dfs(num / 3) : Integer.MAX_VALUE;
        int div2 = num % 2 == 0 ? dfs(num / 2) : Integer.MAX_VALUE;
        int minus1 = dfs(num - 1);
        // 세가지 연산 중 가장 연산 수 적은 값 +1 저장.
        dp[num] = Math.min(div3, Math.min(div2, minus1)) + 1;

        // 이전 숫자 저장.
        if (dp[num] == div3 + 1) parent[num] = num / 3;
        else if (dp[num] == div2 + 1) parent[num] = num / 2;
        else parent[num] = num - 1;

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        // dp[i] : i 까지 연산의 최솟값.
        dp = new int[n + 1];
        // parent[i] : 최소 연산으로 i를 만들기 위해 연산한 i 이전의 수.
        parent = new int[n + 1];


        bw.write(dfs(n) + "\n");

        while (true) {
            bw.write(n + " ");
            if (n == 1) break;
            n = parent[n];
        }
        bw.flush();
        bw.close();
    }
}