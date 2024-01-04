package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int result = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == '(') stack.push(arr[i]);
            else {
                stack.pop();
                if (arr[i-1] == '(') result += stack.size();
                else result++;
            }
        }

        System.out.println(result);

    }
}
