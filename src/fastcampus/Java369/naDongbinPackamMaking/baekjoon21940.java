package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class baekjoon21940 {

    static int N;
    static int M;
    static int K;

    static final int INF = 0x3f3f3f3f;
    static int[][] dist = new int[202][202];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[from][to] = cost;

        }

        // Floyd
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        ArrayList<Integer> persons = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            persons.add(Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int cur = 0;
            for (int p : persons) {
                if (dist[p][i] == INF || dist[i][p] == INF) cur = Integer.MAX_VALUE;
                cur = Math.max(cur, dist[p][i] + dist[i][p]);
            }

            if (max > cur) {
                result.clear();
                result.add(i);
                max = cur;
            } else if (max == cur) {
                result.add(i);
            }

        }

        StringBuilder out = new StringBuilder();
        for (int x : result) out.append(x + " ");
        System.out.print(out);

    }

}
