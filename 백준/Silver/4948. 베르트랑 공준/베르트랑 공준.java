import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int n = 123456 * 2;
    public static boolean[] notPrime;

    public static void erathosthenes() {
        notPrime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                int weight = 2;
                while (weight * i <= n) {
                    notPrime[weight++ * i] = true;
                }
            }
        }
    }

    public static int getPrimeNum(int n) {
        int count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (!notPrime[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        notPrime = new boolean[n + 1];
        erathosthenes();
        while (true) {
            int input = Integer.parseInt(bf.readLine());
            if (input == 0)
                break;
            bw.write(getPrimeNum(input) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
