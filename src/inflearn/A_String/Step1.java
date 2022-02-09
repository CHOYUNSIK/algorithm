package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int count = 0;

        /*for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }
        }*/

        for(char x : str.toCharArray()){
            if(x == c){
                count++;
            }
        }

        System.out.print(count);
    }

}
