package fastcampus.Java369.part3.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1182 {

    static int N, S, result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        if (S == 0){
            result--;
        }

        System.out.println(result);

    }


    public static void dfs(int k, int value) {

        if (k == N + 1) {
            if (S == value) result++;
        } else {

            dfs(k + 1, value + arr[k]);

            dfs(k + 1, value);

        }

    }


}
