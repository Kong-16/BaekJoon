import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] ans;

    public static class Pos {
        public int idx;
        public int val;

        Pos(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(-1, Integer.MAX_VALUE));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            Pos tmp = new Pos(i, input);
            while (stack.peek().val < input) {
                Pos out = stack.pop();
                ans[out.idx] = tmp.val;
            }
            stack.push(tmp);
        }
        while (1 < stack.size()) {
            ans[stack.pop().idx] = -1;
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}