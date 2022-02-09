package inflearn.K_ReferralProblem.DFS_BFS;

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

        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 강호 위치
        int G = Integer.parseInt(st.nextToken()); // 스타크링크 위치
        int U = Integer.parseInt(st.nextToken()); // 위로 버튼
        int D = Integer.parseInt(st.nextToken()); // 아래로 버튼

        int[] visit = new int[F + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visit[S] = 1;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp == G) {
                System.out.println(visit[tmp] - 1);
                break;
            } else {
                if (tmp + U <= F && visit[tmp + U] == 0) {
                    visit[tmp + U] = visit[tmp] + 1;
                    q.offer(tmp + U);
                }
                if (tmp - D > 0 && visit[tmp - D] == 0) {
                    visit[tmp - D] = visit[tmp] + 1;
                    q.offer(tmp - D);
                }
            }
        }
        if (visit[G] == 0) {
            System.out.println("use the stairs");
        }

    }
}
