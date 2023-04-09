import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String tmp = br.readLine();

        int[] remain = new int[10];
        int[] erase = new int[10];

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int i = 0; i < input.length(); i++) {
            remain[input.charAt(i) - '0']++;
        }
        for (int i = 0; i < tmp.length(); i++) {
            erase[tmp.charAt(i) - '0']++;
        }

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            // 숫자의 남은 갯수와 지워야 할 수가 같은 경우 해당 수를 지움.
            if (remain[num] == erase[num]) {
                remain[num]--;
                erase[num]--;
                continue;
            }
            while (stack.peek() < num && 1 <= erase[stack.peek()]) {
                erase[stack.pop()]--;
            }
            stack.push(num);
            remain[num]--;
        }

        while (1 < stack.size()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
}