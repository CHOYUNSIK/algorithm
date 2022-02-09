package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String sa = br.readLine();
        String sb = br.readLine();

        StringTokenizer sta = new StringTokenizer(sa, " ");
        StringTokenizer stb = new StringTokenizer(sb, " ");

        String answer = "";

        for (int i = 0; i < n ; i++){
            int a = Integer.parseInt(sta.nextToken());
            int b = Integer.parseInt(stb.nextToken());
            if(a==b) answer = "D";
			else if(a==1 && b==3) answer="A";
            else if(a==2 && b==1) answer="A";
            else if(a==3 && b==2) answer="A";
            else answer="B";

            System.out.println(answer);
        }

    }
}
