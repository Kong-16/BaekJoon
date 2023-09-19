import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inpStr = br.readLine();
        int len = inpStr.length();
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = inpStr.charAt(i);
            if (c == '(') stack.push(i);
            else {
                if (stack.pop() + 1 == i)
                    cnt += stack.size();
                else cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}