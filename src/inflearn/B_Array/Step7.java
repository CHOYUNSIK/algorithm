package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        int score = 1;
        int result = 0;

        while(st.hasMoreTokens()){
            if(st.nextToken().equals("0")){
                score = 1;
            }else{
                result+=score;
                score+=1;
            }
        }
        System.out.println(result);


    }
}
