package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Step27 {
    static int w, h, result;
    static char[][] map;
    static ArrayList<Node> list;
    static int[][] dis;

    static boolean[] selected;


    static void dfs(int depth, int dist, int from) {
        if (depth == selected.length - 1) {
            result = Math.min(result, dist);
            return;
        }
        for (int i = 1; i < selected.length; i++) {

            if(!selected[i]){
                selected[i] = true;
                dfs(depth + 1, dist + dis[from][i], i );
                selected[i] = false;
            }

        }
    }

    static int bfs(int from) {
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        int cleaningNum = 0;
        int count = 0;

        Node start = list.get(from);
        visited[start.x][start.y] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + move[j][0];
                    int ny = cur.y + move[j][1];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == 'x') continue;

                    if (map[nx][ny] == 'o' || map[nx][ny] == '*') {
                        for (int to = 0; to < list.size(); to++) {
                            Node end = list.get(to);

                            if (nx == end.x && ny == end.y) {
                                dis[from][to] = count;
                                dis[to][from] = count;

                                cleaningNum++;
                            }

                        }
                    }

                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }

            }
        }


        if (cleaningNum != list.size() - 1) {
            return -1;
        } else return 0;


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

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
                        list.add(0, new Node(i, j));
                    }
                    if (map[i][j] == '*') {
                        list.add(new Node(i, j));
                    }
                }
            }

            int size = list.size();
            dis = new int[size][size];
            selected = new boolean[size];

            for (int i = 0; i < size; i++) {
                if (bfs(i) == -1) {
                    result = -1;
                    break;
                }
            }

            if (result == -1) {
                System.out.println(result);
                continue;
            } else {
                result = Integer.MAX_VALUE;
                selected[0] = true;
                dfs(0, 0, 0);
                System.out.println(result);
            }

        }


    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
