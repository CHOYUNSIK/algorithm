package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] as = s.split(" ");
        int max = Integer.MIN_VALUE;
        int count = 0;


        for (int i = 0; i < n ; i++){
            if(Integer.parseInt(as[i]) > max){
                max = Integer.parseInt(as[i]);
                count++;
            }
        }
        System.out.println(count);
    }
}
