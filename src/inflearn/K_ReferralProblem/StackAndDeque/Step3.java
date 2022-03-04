package inflearn.K_ReferralProblem.StackAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && count < k && stack.peek() < cur ) {
                count++;
                stack.pop();
            }
            stack.add(cur);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n - k; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);

    }
}
