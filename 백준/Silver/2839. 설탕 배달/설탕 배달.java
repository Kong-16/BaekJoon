import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        int nCopy = n % 5;
        int five = n / 5;
        int three = 0;
        while (nCopy <= n) {
            if (nCopy % 3 == 0) {
                three = nCopy / 3;
                break;
            } else {
                nCopy += 5;
                five--;
            }
        }
        if (n < nCopy)
            bw.write(-1 + "\n");
        else
            bw.write(five + three + "\n");
        bw.flush();
        bw.close();
    }

}
