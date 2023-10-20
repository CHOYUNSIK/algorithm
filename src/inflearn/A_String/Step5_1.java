package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        int lt = 0;
        int rt = c.length - 1;

        while (lt < rt){
            if (!Character.isAlphabetic(c[lt])){
                lt++;
            } else if (!Character.isAlphabetic(c[rt])) {
                rt--;
            }else {
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;

                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(c));

    }

}
