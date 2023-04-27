import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if (0 < x) {
            if (0 < y)
                bw.write("1 \n");
            else
                bw.write("4 \n");
        } else if (0 < y) bw.write("2 \n");
        else bw.write("3 \n");

        bw.flush();
        bw.close();

    }
}