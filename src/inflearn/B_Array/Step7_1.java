package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step7_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scoreArr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            scoreArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (scoreArr[i] == 1) {
                cnt++;
                result += cnt;
            }else {
                cnt = 0;
            }
        }

        System.out.println(result);


    }
}
