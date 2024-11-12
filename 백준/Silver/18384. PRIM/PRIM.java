import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int maxNum = 1900001;

    public static int getPrime(int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tot = 0;
            for (int i = 0; i < 5; i++) {
                tot += getPrime(Integer.parseInt(st.nextToken()));
            }
            bw.write(tot + "\n");
        }
        bw.flush();
        bw.close();
    }
}