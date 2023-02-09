import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean[] arr;

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int cipher = (int) Math.pow(10, n);
        for (int i = cipher / 10; i < cipher; i++) {
            int weight = cipher / 10;
            boolean isAmazing = true;
            while (weight > 0) {
                if (!isPrime(i / weight)) {
                    isAmazing = false;
                    break;
                }
                weight /= 10;
            }
            if (isAmazing)
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

}
