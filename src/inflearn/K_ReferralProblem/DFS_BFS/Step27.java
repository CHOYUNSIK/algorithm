package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step27 {
    static int w, h, result, dirtyCheckNum;
    static char[][] map;
    static ArrayList<Node> list;
    static int[][] distance;
    static boolean[] check;

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static void dfs(int start, int count, int num) {

        if (count == list.size()) {
            result = Math.min(result, num);
        }

        for (int i = 1; i < list.size(); i++) {
            if(!check[i]){
                check[i] = true;
                dfs(i,count+1,num + distance[start][i]);
                check[i] = false;
            }
        }

    }

    static void bfs(Node node, int start) {
        boolean[][] visited = new boolean[h][w];
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited[node.x][node.y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.x][cur.y] == '*') {
                if (start == 0) dirtyCheckNum++;

                for (int i = 1; i < list.size(); i++) {
                    if (cur.x == list.get(i).x && cur.y == list.get(i).y) {
                        distance[start][i] = cur.n;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + move[i][0];
                int ny = cur.y + move[i][1];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visited[nx][ny] || map[nx][ny] == 'x') continue;

                q.offer(new Node(nx, ny, cur.n + 1));
                visited[nx][ny] = true;
            }

        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();


        while (true) {

            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            list = new ArrayList<>();

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 'o') {
                        list.add(0, new Node(i, j, 0));
                    }
                    if (map[i][j] == '*') {
                        list.add(new Node(i, j, 0));
                    }
                }
            }

            int size = list.size();
            distance = new int[size][size];
            check = new boolean[size];

            dirtyCheckNum = 0;
            for (int i = 0; i < size; i++) {
                bfs(list.get(i), i);
            }

            if (dirtyCheckNum == list.size() - 1) {
                result = Integer.MAX_VALUE;
                check = new boolean[size];
                check[0] = true;
                dfs(0, 1, 0);
                sb.append(result).append("\n");
            } else {
                sb.append(-1).append("\n");
            }

          /*  for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(i + " 에서 ");
                    System.out.println(j + "까지 거리 " + distance[i][j] + " ");
                }
                System.out.println();
            }*/


        }
        System.out.println(sb);

    }

    static class Node {
        int x;
        int y;
        int n;

        public Node(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
