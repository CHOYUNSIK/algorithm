package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Step4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] line = reader.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (char x : line) {
            if (Character.isDigit(x)) {
                stack.push(Character.getNumericValue(x));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (x) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }

            }
        }

        System.out.println(stack.pop());
    }
}
