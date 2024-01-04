package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ca = br.readLine().toCharArray();


        Stack<Character> stack = new Stack<>();

        StringBuilder sb= new StringBuilder();

        for (char c : ca){
            if (c == '('){
                stack.push(c);
            }else if(c == ')') {
                stack.pop();
            }else{
                if (stack.isEmpty()){
                    sb.append(c);
                }
            }
        }

        System.out.println(sb);

    }
}
