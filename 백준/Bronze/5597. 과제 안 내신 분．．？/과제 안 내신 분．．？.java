import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i < 31; i++) {
            if (!arr[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();

    }
}