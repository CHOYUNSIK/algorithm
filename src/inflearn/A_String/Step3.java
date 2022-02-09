package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str , " ");

        int big = Integer.MIN_VALUE;
        String result =  "";

        while(st.hasMoreTokens()){
            String x = st.nextToken();
            int num = x.length();


            if(num > big){
                big = num;
                result = x;
            }

        }
        System.out.print(result);
    }

}
