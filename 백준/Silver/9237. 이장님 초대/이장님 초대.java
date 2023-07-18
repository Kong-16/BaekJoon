import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] trees = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int day = 2;
        int maxDay = 0;
        for (int i = n - 1; 0 <= i; i--) {
            maxDay = Math.max(day + trees[i], maxDay);
            day++;
        }
        bw.write(maxDay + "\n");
        bw.flush();
        bw.close();

    }
}