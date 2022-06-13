package fastcampus.Java369.part3.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15663 {

    static int N, M;
    static int[] arr;
    static int[] selected, used;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        used = new int[N + 1];
        selected = new int[M + 1];


        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, 1, N + 1);


        dfs(1);

        System.out.println(sb);
    }

//    4 2
//    9 7 9 1
//    1 7 9 9
    public static void dfs(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");

        } else {
            int last = 0;
            for (int i = 1; i <= N; i++) {
                if (used[i] == 1) continue;
                if (last == arr[i]) continue;

                last = arr[i];
                used[i] = 1;

                selected[k] = arr[i];

                dfs(k + 1);

                selected[k] = 0;
                used[i] = 0;
            }
        }
    }


}
