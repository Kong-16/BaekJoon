import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static class Tower {
        public int index;
        public int height;

        Tower(int i, int h) {
            index = i;
            height = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] tower = new int[n + 1];
        tower[0] = Integer.MAX_VALUE;
        Deque<Tower> deque = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            tower[i] = Integer.parseInt(st.nextToken());
        deque.addLast(new Tower(0, tower[0]));

        for (int i = 1; i <= n; i++) {
            Tower tmp = new Tower(i, tower[i]);
            while (!deque.isEmpty() && deque.peekLast().height < tower[i]) {
                deque.pollLast();
            }
            ans.addLast(deque.peekLast().index);
            deque.addLast(tmp);
        }
        for (int idx : ans) {
            bw.write(idx + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

}
