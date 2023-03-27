package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class baekjoon22865 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //  자취할 땅 후보의 개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); //  땅과 땅 사이를 잇는 도로의 개수

        ArrayList<int[]>[] map = new ArrayList[M + 1];

        for (int i = 1; i <= M; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map[D].add(new int[]{E, L});
            map[E].add(new int[]{D, L});
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{A, 0});
        queue.add(new int[]{B, 0});
        queue.add(new int[]{C, 0});

        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[A] = dist[B] = dist[C] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            if (dist[x] != y) continue;

            for (int[] next : map[x]) {
                if (dist[next[0]] > y + next[1]) {
                    dist[next[0]] = y + next[1];
                    queue.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        int max = 0, result = 0;

        for (int i = 1; i <= N; i++) {
            if (max < dist[i]) {
                max = dist[i];
                result = i;
            }
        }

        System.out.println(result);

    }


}
