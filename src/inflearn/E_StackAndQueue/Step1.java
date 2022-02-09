package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String result = "YES";

        Deque<Character> de = new ArrayDeque<>();

        for(char x  : s.toCharArray()){
            if(x=='('){
                de.push(x);
            }else{
                if(de.isEmpty()) {
                    result = "NO";
                    break;
                }
                de.pop();
            }
        }
        if(!de.isEmpty()){
            result = "NO";
        }
        System.out.print(result);
    }
}
