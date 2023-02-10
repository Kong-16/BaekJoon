import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main {

    // power 리스트에 제곱수를 저장해서 투포인터로 비교해감.
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(bf.readLine());
        ArrayList<Long> power = new ArrayList<>();
        power.add(1L);
        long number = 2;

        // power 에 제곱 수를 저장.
        //
        long curPow = number * number;
        long prevPow = 1;
        while (curPow - prevPow <= g) {
            power.add(curPow);
            number++;
            curPow = number * number;
            prevPow = power.get((int) number - 2);
        }
        int s = 0;
        int e = 0;
        boolean ans = false;
        while (e < power.size()) {
            long gap = power.get(e) - power.get(s);
            if (gap == g) {
                bw.write((int) Math.sqrt(power.get(e)) + "\n");
                e++;
                ans = true;
            } else if (gap > g)
                s++;
            else
                e++;
        }
        if (!ans)
            bw.write(-1 + "\n");

        bw.flush();
        bw.close();
    }
}

// a-b a+b