package baekJoon.Step.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        result = n / 5;
        if(n / 5 == 0){
            result--;
        }
        else if (n % 5 != 0) {
            result++;
        }



        System.out.println(result);

    }
}
