import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String mStr = br.readLine();
        int m = Integer.parseInt(mStr);
        for (int i = 2; i > -1; i--) {
            bw.write((n * (mStr.charAt(i) - '0')) + "\n");
        }
        bw.write(n * m + "\n");
        bw.flush();
        bw.close();
    }
}