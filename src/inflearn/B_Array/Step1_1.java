package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder().append(arr[0]).append(" ");

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }
}
