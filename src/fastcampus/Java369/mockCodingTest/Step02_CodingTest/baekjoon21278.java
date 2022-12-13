package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21278 {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        int result1 = -1, result2 = -1, min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int[] dist = new int[N + 1];
                Arrays.fill(dist, -1);
                dist[i] = 0;
                dist[j] = 0;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                queue.add(j);
                int tot = 0;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int k = 1; k <= N; k++) {

                        if (arr[k][cur] == 0) continue;
                        if (dist[k] != -1) continue;

                        dist[k] = dist[cur] + 1;
                        queue.add(k);

                        tot += dist[k];
                    }
                }

                if (tot < min) {
                    min = tot;
                    result1 = i;
                    result2 = j;
                }

            }

        }

        System.out.println(result1 + " " + result2 + " " + min * 2);

    }
}

