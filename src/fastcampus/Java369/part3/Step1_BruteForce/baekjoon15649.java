package fastcampus.Java369.part3.Step1_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15649 {

    static int N, M;
    static int[] selected, visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];
        //visited = new int[N+1];

        dfs(1);

        System.out.println(sb);

    }


    public static void dfs(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if(visited[i] == 0){
                    selected[k] = i;
                    visited[i] = 1;
                    dfs(k + 1);
                    selected[k] = 0;
                    visited[i] = 0;
                }
            }
        }

    }


}
