package kia_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {

     static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++){
                int nx =  x + move[i][0];
                int ny =  y + move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if (visited[nx][ny] || arr[nx][ny] == 0){
                    continue;
                }

                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y] + 1;
                queue.add(new int[]{nx, ny});
             }
        }


        System.out.println(arr[n-1][m-1]);


    }
}
