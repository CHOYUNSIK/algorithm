package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] time = new int[100001];
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        if(k == n){
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (minTime < time[cur]) break;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                if(next < 0  || next > 100000) continue;

                if(next == k){
                    minTime = time[cur];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[cur] + 1){
                    q.offer(next);
                    time[next] = time[cur] + 1;
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);

    }
}
