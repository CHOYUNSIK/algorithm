package inflearn.K_ReferralProblem.StackAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step8_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        int keyLen = key.length();
        StringBuilder text = new StringBuilder(br.readLine());
        boolean isLeft = true;

        while (true) {

            if (isLeft) {
                int position = text.indexOf(key);

                if (position > -1) {
                    text.delete(position, position + keyLen);
                    isLeft = false;
                } else break;

            }else{
                int position = text.lastIndexOf(key);

                if(position > -1){
                    text.delete(position, position+keyLen);
                    isLeft = true;
                }
                else break;

            }
        }

        System.out.println(text.toString());


    }
}
