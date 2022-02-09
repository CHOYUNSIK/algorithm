package baekJoon.Step.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= a; i++){
            String s = br.readLine();
            int target = s.indexOf(" ");
            int result = Integer.parseInt(s.substring(0,target)) + Integer.parseInt(s.substring(target + 1));
            sb.append("Case #"+i);
            sb.append(": ");
            sb.append(result+"\n");

        }
        br.close();
        System.out.println(sb);

    }
}
