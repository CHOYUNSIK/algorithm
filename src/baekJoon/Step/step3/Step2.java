package baekJoon.Step.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringBuilder sb ;

        for(int i = 1 ; i <= a; i++){
            sb = new StringBuilder();
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
            System.out.println(sb);
        }


    }
}
