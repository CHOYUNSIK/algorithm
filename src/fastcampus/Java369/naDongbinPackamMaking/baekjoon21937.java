package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon21937 {

    static int N, M;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[y].add(x);
        }

        int x = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        int result = 0;
        boolean[] used = new boolean[N + 1];

        used[x] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur != x) {
                result++;
            }
            for (int next : lists[cur]) {
                if (used[next]) continue;
                used[next] = true;
                queue.add(next);
            }
        }

        System.out.println(result);

    }


}
