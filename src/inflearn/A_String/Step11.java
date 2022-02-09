package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s+" ";
        int count = 1;
        String result = "";

        for(int i =0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else {
                result+=s.charAt(i);
                if(count > 1){
                    result+=String.valueOf(count);
                }
                count = 1;
            }
        }
        System.out.println(result);
    }
}
