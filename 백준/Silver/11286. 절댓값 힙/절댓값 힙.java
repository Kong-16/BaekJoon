import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        minus.add(Integer.MIN_VALUE + 1);
        plus.add(Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bf.readLine());
            if (0 < number)
                plus.add(number);
            else if (number < 0)
                minus.add(number);
            else {
                if (minus.size() + plus.size() == 2) {
                    bw.write("0" + "\n");
                    continue;
                }
                if (plus.peek() < -(minus.peek())) {
                    bw.write(plus.poll() + "\n");
                } else
                    bw.write(minus.poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
