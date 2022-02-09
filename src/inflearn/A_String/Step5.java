package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int lt = 0;
        int rt = s.length()-1;

        char[] ca = s.toCharArray();

        while (lt<rt){
            if(!Character.isAlphabetic(ca[lt])){
                lt ++;
            }else if(!Character.isAlphabetic(ca[rt])){
                rt --;
            }else{

                char temp = ca[lt];
                ca[lt] = ca[rt];
                ca[rt] = temp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(ca));
    }

}
