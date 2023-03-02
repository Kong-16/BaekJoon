import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double t = Double.parseDouble(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            double n = Double.parseDouble(br.readLine());
            ArrayList<Double> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Double.parseDouble(st.nextToken()));
            }
            Collections.sort(list);
            Double[] arr = list.toArray(new Double[0]);
            int cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    double f = (arr[i] + arr[j]) / 2;
                    if (-1 < Arrays.binarySearch(arr, f)) {
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}