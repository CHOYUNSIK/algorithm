package baekJoon.Step.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(a*(b%10));
        sb.append("\n");
        sb.append(((b%100)/10)*a);
        sb.append("\n");
        sb.append(a*(b/100));
        sb.append("\n");
        sb.append(a*b);
        System.out.println(sb);
    }
}
