package baekJoon.Step.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = a ; i > 0; i--){
            int j ;
            for(j=1; j < i; j++){
                sb.append(" ");
            }
            for(int s = 0; s < (a-i)+1; s++ ){
                sb.append("*");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);

    }
}
