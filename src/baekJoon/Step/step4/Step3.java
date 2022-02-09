package baekJoon.Step.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int temp = n;
        int count = 0;

        do{
            n = (n%10)*10 + ((n/10)+(n%10))%10;
            count++;
        }while (n != temp);

        System.out.println(count);

    }
}
