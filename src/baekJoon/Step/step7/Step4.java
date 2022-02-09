package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0;  i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j = 0 ; j  < s.length(); j++){
                char ch = s.charAt(j);
                for(int k = 0; k < c ; k++){
                    System.out.print(ch);
                }
            }
            System.out.println();
        }


    }
}
