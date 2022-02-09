package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3{
    int x;
    int y;
    Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Step14 {
    static int n, result = 0;
    static int[][] board;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    static void BFS(int x, int y){
        Queue<Point3> queue = new LinkedList<>();
        queue.offer(new Point3(x,y));

        while (!queue.isEmpty()){
            Point3 tmp = queue.poll();
            for (int i = 0; i < 8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    queue.offer(new Point3(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    result++;
                    board[i][j] = 0;
                    BFS(i, j);
                }
            }
        }

        System.out.println(result);

    }
}
