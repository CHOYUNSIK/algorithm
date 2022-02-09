package inflearn.G_RecursiveAndTreeAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] c = new int[10001];
        int[] step = {1, -1, 5};

        q.offer(s);
        c[s] = 1;
        int L = 0;
        boolean b = false;

        while (!q.isEmpty()) {
            if (b) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (b) break;
                int x = q.poll();
                for (int d : step) {
                    int a = x + d;
                    if (a == e) {
                        b = true;
                        break;
                    }
                    if (a >= 1 && a <= 10000 && c[a] == 0) {
                        q.offer(a);
                        c[a] = 1;
                    }
                }
            }
            L++;
        }
        System.out.print(L);
    }
}
