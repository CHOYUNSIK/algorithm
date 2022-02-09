package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
    public int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Step12 {
    static int[][] board, dis;
    static int m,n;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point2> queue = new LinkedList<>();

    static void BFS(){
        while(!queue.isEmpty()){
            Point2 p = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >=0 && n > nx && ny >=0 && m > ny && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point2(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) queue.offer(new Point2(i,j));
            }
        }

        BFS();

        boolean flag = true;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(board[i][j] == 0){
                    flag = false;
                }
            }
        }

        if(flag){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m ; j++){
                    result = Math.max(result, dis[i][j]);
                }
            }
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
}
