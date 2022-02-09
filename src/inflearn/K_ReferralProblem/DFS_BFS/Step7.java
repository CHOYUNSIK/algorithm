package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step7 {

    static int b;
    static String result;
    static char[] arr = {'D', 'S', 'L', 'R'};

    static class registry {
        int num;
        String comd;

        public registry(int num, String comd) {
            this.num = num;
            this.comd = comd;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return (num % 1000) * 10 + (num / 1000);
        }

        int R() {
            return (num % 10) * 1000 + (num / 10);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];

            Queue<registry> q = new LinkedList<>();

            q.offer(new registry(a, ""));

            while (!q.isEmpty()){
                registry r = q.poll();
                if(r.num == b){
                    System.out.println(r.comd);
                    break;
                }
                if(!visited[r.D()]){
                    visited[r.D()] = true;
                    q.offer(new registry(r.D(), r.comd + "D"));
                }
                if(!visited[r.S()]){
                    visited[r.S()] = true;
                    q.offer(new registry(r.S(), r.comd + "S"));
                }
                if(!visited[r.L()]){
                    visited[r.L()] = true;
                    q.offer(new registry(r.L(), r.comd + "L"));
                }
                if(!visited[r.R()]){
                    visited[r.R()] = true;
                    q.offer(new registry(r.R(), r.comd + "R"));
                }
            }

        }
    }
}
