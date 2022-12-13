package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon21277 {


    static int n1, m1, n2, m2;
    static char[][] arr1 = new char[100][100];
    static char[][] arr2 = new char[100][100];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n1; i++) {
            arr1[i] = br.readLine().toCharArray();
        }
        st = new StringTokenizer(br.readLine(), " ");

        n2 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n2; i++) {
            arr2[i] = br.readLine().toCharArray();
        }


        int result = 99999999;

        for (int rotation = 0; rotation < 4; rotation++) {
            for (int x = -100; x <= 100; x++) {
                for (int y = -100; y <= 100; y++) {
                    int v1, v2;
                    int l, r;

                    l = Math.min(1, 1 + x);
                    r = Math.max(n2, n1 + x);
                    v1 = r - l + 1;

                    l = Math.min(1, 1 + y);
                    r = Math.max(m2, m1 + y);
                    v2 = r - l + 1;

                    if (v1 * v2 >= result) continue;

                    if (chk(x, y)) {
                        result = v1 * v2;
                    }
                }
            }

            rotation();
            int tmp = n1;
            n1 = m1;
            m1 = tmp;
        }

        System.out.println(result);

    }

    private static void rotation() {
        char[][] tmp = new char[n1][m1];
        for(int i = 0; i < n1; i++) for(int j = 0; j < m1; j++) tmp[i][j] = arr1[i][j];

        for(int i = 0; i < m1; i++) for(int j = 0; j < n1; j++){
            arr1[i][j] = tmp[n1-1-j][i];
        }


    }

    private static boolean chk(int x, int y) {

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                if (arr1[i][j] == '0') continue;

                int idx1 = i + x;
                int idx2 = j + y;

                if(0 <= idx1 && idx1 < n2 && 0 <= idx2 && idx2 < m2 && arr2[idx1][idx2] == '1') return false;

            }
        }

        return true;
    }

}

