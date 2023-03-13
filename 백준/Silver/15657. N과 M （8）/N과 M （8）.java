import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int[] inputArr;
    public static int[] printArr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(printArr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            printArr[depth] = inputArr[i];
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputArr = new int[n];
        printArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);
        dfs(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}