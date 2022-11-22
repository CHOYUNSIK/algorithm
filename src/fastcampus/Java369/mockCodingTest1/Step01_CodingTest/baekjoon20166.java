package fastcampus.Java369.mockCodingTest1.Step01_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon20166 {

    static int N, M, K;
    static String[] arr;

    static Map<String, Integer> map = new HashMap<>();

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs20166(i, j, Character.toString(arr[i].charAt(j)), 1);
            }
        }


        while (K-- > 0) {
            String str = br.readLine();

            if (map.containsKey(str)) System.out.println(map.get(str));
            else System.out.println(0);

        }

    }

    private static void dfs20166(int x, int y, String path, int length) {
        if (map.containsKey(path)) map.put(path, map.get(path) + 1);
        else map.put(path, 1);

        if (length == 5) return;

        for (int i = 0; i < 8; i++) {
            int nx = (x + move[i][0]) % N;
            int ny = (y + move[i][1]) % M;
            if (nx < 0) nx += N;
            if (ny < 0) ny += M;

            dfs20166(nx, ny, path + arr[nx].charAt(ny), length + 1);
        }
    }


}
