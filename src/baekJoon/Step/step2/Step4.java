package baekJoon.Step.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());


        System.out.println(a > 0 ? (b > 0 ? 1 : 4) : (b > 0 ? 2 : 3));

    }

}
