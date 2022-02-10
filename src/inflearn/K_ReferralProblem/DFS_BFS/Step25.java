package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step25 {

    static int n, m, result = Integer.MAX_VALUE;

    static int hong_x, hong_y, goal_x, goal_y;

    static int[][] map;
    static boolean[][][] visited;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int n;
        int flag;

        public Node(int x, int y, int n, int flag) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            return this.n - o.n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        st = new StringTokenizer(br.readLine(), " ");
        hong_x = Integer.parseInt(st.nextToken()) - 1;
        hong_y = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine(), " ");
        goal_x = Integer.parseInt(st.nextToken()) - 1;
        goal_y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(hong_x, hong_y, 0, 0));
        visited[hong_x][hong_y][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == goal_x && cur.y == goal_y) {
                result = cur.n;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + move[i][0];
                int next_y = cur.y + move[i][1];

                if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= m) continue;

                if (map[next_x][next_y] == 1 && !visited[next_x][next_y][1] && cur.flag == 0) {
                    visited[next_x][next_y][1] = true;
                    q.offer(new Node(next_x, next_y, cur.n + 1, 1));
                } else if (map[next_x][next_y] == 0 && !visited[next_x][next_y][cur.flag]) {
                    visited[next_x][next_y][cur.flag] = true;
                    q.offer(new Node(next_x, next_y, cur.n + 1, cur.flag));
                }
            }

        }
    }
    /*static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.offer(new Node(hong_x,hong_y,0,1));
        visited[hong_x][hong_y][1] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int flag = cur.flag;
            if (cur.x == goal_x && cur.y == goal_y) {
                result = cur.n;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + move[i][0];
                int nextY = cur.y + move[i][1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                if(flag > 0 && !visited[nextX][nextY][flag-1] && map[nextX][nextY] == 1  ){
                    visited[nextX][nextY][flag-1] = true;
                    q.offer(new Node(nextX, nextY, cur.n + 1, flag-1));
                }
                if(!visited[nextX][nextY][flag] && map[nextX][nextY] == 0){
                    visited[nextX][nextY][flag] = true;
                    q.offer(new Node(nextX,nextY,cur.n+1,flag));
                }
            }
        }

    }*/
}
