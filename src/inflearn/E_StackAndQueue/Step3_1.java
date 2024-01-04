package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Step3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;

        for (int i = 0; i < m; i++) {
            int move = moves[i];
            for (int j = 0; j < n; j++) {
                int choice = arr[j][move - 1];
                if (choice > 0) {
                    if (!stack.isEmpty() && stack.peek() == choice) {
                        stack.pop();
                        result += 2;
                    } else {
                        stack.push(choice);
                    }
                    arr[j][move - 1] = 0;
                    break;
                }
            }

        }

        System.out.println(result);


    }
}
