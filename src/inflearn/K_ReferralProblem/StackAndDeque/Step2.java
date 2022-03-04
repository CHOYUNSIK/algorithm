package inflearn.K_ReferralProblem.StackAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else {
                stack.pop();
                if(s.charAt(i-1) == '('){
                    result+=stack.size();
                }else{
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
