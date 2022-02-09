package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step6 {

    public static boolean isPrime(int num){
        if(num == 1) {
            return false;
        }
        for(int i = 2; i < num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            String x = new StringBuilder(st.nextToken()).reverse().toString();
            int num = Integer.parseInt(x);
            if(isPrime(num)){
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);

    }
}
