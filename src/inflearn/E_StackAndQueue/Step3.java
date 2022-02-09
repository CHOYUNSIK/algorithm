package inflearn.E_StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        int a[][] = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = Integer.parseInt(br.readLine());
        int[] b = new int[num];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < num; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            int t = b[i]-1;
            int f = 0;
            while (a[f][t] == 0 && f < n-1){
                f++;
            }
            if(a[f][t] != 0){
                if(!stack.isEmpty() && stack.peek() == a[f][t] ){
                    result=result+2;
                    stack.pop();
                }else {
                    stack.push(a[f][t]);
                }
                a[f][t] = 0;
            }


        }

        System.out.print(result);
    }
}
