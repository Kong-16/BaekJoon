import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] isSelected;
    public static int[][] arr;
    public static int n;
    public static int min_num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        isSelected = new boolean[n];
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        min_num = Integer.MAX_VALUE;
        generateSubset(0);
        bw.write(min_num + "\n");
        bw.flush();
        bw.close();
    }

    public static void generateSubset(int cnt) {
        if (cnt == n) {
            int s = 1;
            int b = 0;
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    s *= arr[i][0];
                    b += arr[i][1];
                }
            }
            boolean isContains = false;
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    isContains = true;
                    break;
                }
            }
            if (isContains)
                min_num = Math.min(min_num, Math.abs(s - b));
            return;
        }
        isSelected[cnt] = true;
        generateSubset(cnt + 1);
        isSelected[cnt] = false;
        generateSubset(cnt + 1);
    }

}
