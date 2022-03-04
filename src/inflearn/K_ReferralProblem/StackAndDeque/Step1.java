package inflearn.K_ReferralProblem.StackAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.DatagramChannel;
import java.util.Stack;

public class Step1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean check = false;
            for(char c : s.toCharArray()){
                if(c == '('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        check = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty() || check){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }


}
