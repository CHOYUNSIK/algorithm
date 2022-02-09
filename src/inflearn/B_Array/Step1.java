package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] as = s.split(" ");

        StringBuilder sb = new StringBuilder();
        sb.append(as[0]).append(" ");
        for (int i = 1; i < n ; i++){
            if(Integer.parseInt(as[i]) > Integer.parseInt(as[i-1])){
                sb.append(as[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
