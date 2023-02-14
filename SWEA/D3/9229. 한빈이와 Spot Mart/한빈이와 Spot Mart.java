import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int maxNum = -1;
            int s = 0;
            int e = n - 1;
            while (s < e) {
                int weight = arr[s] + arr[e];
                if (weight <= m) {
                    maxNum = Math.max(maxNum, weight);
                    s++;
                } else
                    e--;
            }
            bw.write("#" + test_case + " " + maxNum + "\n");
        }
        bw.flush();
        bw.close();
    }

}
