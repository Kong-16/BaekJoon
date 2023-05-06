import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (Integer.parseInt(br.readLine()) == 0) bw.write("YONSEI\n");
        else bw.write("Leading the Way to the Future\n");

        bw.flush();
        bw.close();
    }
}