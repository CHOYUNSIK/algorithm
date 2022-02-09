package inflearn.H_DfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step10 {

    static int[][] board;

    static int cnt = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static void DFS(int a, int b) throws IOException {
        if(a==7 && b==7) cnt++;
        else{
            for(int i = 0; i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[8][8];
        for (int i = 1; i < 8; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < 8; j++ ){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        board[1][1]=1;
        DFS(1,1);

        System.out.print(cnt);

    }
}