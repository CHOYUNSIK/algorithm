package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Step16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] time = new int[100001];
        int[] parent = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 1;


        while (!q.isEmpty()) {
            int cur = q.poll();

            if(k == cur) break;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                if (next > 100000 || next < 0) continue;

                if(time[next] == 0 ){
                    time[next] = time[cur] + 1;
                    q.offer(next);
                    parent[next] = cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time[k]-1).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(k);

        int idx = k;
        while (n != idx){
            idx = parent[idx];
            stack.push(idx);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
