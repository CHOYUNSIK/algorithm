
package fastcampus.Java369.part3.Step06_TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon14676 {


    static int N, M, K;

    static ArrayList<Integer>[] graph;

    static int[] indeg, checked, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indeg = new int[N + 1];
        checked = new int[N + 1];
        cnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            indeg[y]++;
        }

        boolean abnormal = false;

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (t == 1) {
                if (checked[x] < indeg[x]) abnormal = true;

                cnt[x]++;

                if (cnt[x] == 1) {
                    for (int y : graph[x]) {
                        checked[y]++;
                    }
                }

            } else {
                if (cnt[x] == 0) abnormal = true;

                cnt[x]--;

                if (cnt[x] == 0) {
                    for (int y : graph[x]) {
                        checked[y]--;
                    }
                }
            }
        }

        if (abnormal) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");
    }


}


