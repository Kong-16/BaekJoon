import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String w = br.readLine();
        int cnt = 0;
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            while (line.contains(w)) {
                line = line.replaceFirst(w, "");
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();

        bw.close();
    }

}