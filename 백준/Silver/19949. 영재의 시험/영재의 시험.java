import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] answer;
    public static int[] myAns;
    public static int number;

    public static void dfs(int depth, int num, int cnt) {
        if (depth == n) {
            int cmp = 0;
            for (int i = 0; i < n; i++) {
                if (answer[i] == myAns[i])
                    cmp++;
            }
            if (cmp >= 5)
                number++;
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (i == num) {
                if (cnt == 2)
                    continue;
                myAns[depth] = i;
                dfs(depth + 1, i, cnt + 1);
            } else {
                myAns[depth] = i;
                dfs(depth + 1, i, 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = 10;
        number = 0;
        answer = new int[10];
        myAns = new int[10];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        bw.write(number + "\n");
        bw.flush();
        bw.close();
    }
}