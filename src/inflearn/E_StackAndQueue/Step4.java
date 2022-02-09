package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for(Character x : s.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-'0');
            }else{
                int rt=stack.pop();
                int lt=stack.pop();
                switch (x){
                    case '+':
                        stack.push(lt+rt);
                        break;
                    case '-':
                        stack.push(lt-rt);
                        break;
                    case '*':
                        stack.push(lt*rt);
                        break;
                    case '/':
                        stack.push(lt/rt);
                        break;
                }
            }
        }

        result = stack.pop();

        System.out.println(result);

    }
}
