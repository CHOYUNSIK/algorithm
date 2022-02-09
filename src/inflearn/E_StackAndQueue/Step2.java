package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String result = "";

        Stack<Character> de = new Stack<>();

        for (char x : s.toCharArray()) {
            if(x == ')'){
                while(de.pop() != '(');
            }else{
                de.push(x);
            }
        }

        for(char x : de){
            result+=x;
        }

        System.out.print(result);
    }
}
