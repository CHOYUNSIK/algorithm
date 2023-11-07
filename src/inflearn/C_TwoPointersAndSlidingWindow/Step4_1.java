package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0 , p2 = 0;

        int sum = 0, result = 0;
        while (p1 < n){
            sum += arr[p2++];
            if (sum == m){
                p1++;
                p2 = p1;
                result++;
                continue;
            }else if (sum > m){
                p1++;
                p2 = p1;
                continue;
            }
        };

    }
}
