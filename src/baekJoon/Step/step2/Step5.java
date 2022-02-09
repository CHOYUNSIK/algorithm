package baekJoon.Step.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s , " ");

        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        m = m - 45;

        if(m < 0){
            if(t == 0){
                t = 23;
            }else{
                t--;
            }
            m  = 60 + m;
        }

        System.out.println(t+" "+m);

    }

}
