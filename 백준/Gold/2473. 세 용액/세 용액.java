import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void work() {
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] ans = new int[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;
            while (s < e) {
                if (s == i) {
                    s++;
                    continue;
                }
                if (e == i) {
                    e--;
                    continue;
                }
                long total = arr[s] + arr[e];
                total += arr[i];
                if (Math.abs(total) < min) {
                    ans[0] = arr[s];
                    ans[1] = arr[e];
                    ans[2] = arr[i];
                    min = Math.abs(total);
                }
                if (total < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        Arrays.sort(ans);
        for (int i : ans) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}