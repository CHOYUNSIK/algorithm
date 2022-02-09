package baekJoon.Step.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        System.out.println(year%4 == 0 && year%100 != 0 ? 1 : year % 400 ==0 ? 1 : 0);

    }

}
