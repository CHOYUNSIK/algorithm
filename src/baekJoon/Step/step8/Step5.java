package baekJoon.Step.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int yy = 0;
            int xx = 0;
            if (n % h != 0) {
                yy = (n % h) * 100;
                xx = (n / h)+1;
            } else {
                yy = h * 100;
                xx = (n / h);
            }

            System.out.println(yy+xx);
        }


    }
}
