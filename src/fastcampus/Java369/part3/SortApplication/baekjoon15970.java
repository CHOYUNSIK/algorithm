package fastcampus.Java369.part3.SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon15970 {

    static int N;
    static ArrayList<Integer>[] lists;

    static int leftAdd(int color, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;

        return lists[color].get(idx) - lists[color].get(idx - 1);

    }

    static int rightAdd(int color, int idx) {
        if (idx + 1 == lists[color].size()) return Integer.MAX_VALUE;
        return lists[color].get(idx + 1) - lists[color].get(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int location = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            lists[color].add(location);


        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < lists[i].size(); j++) {
                int left = leftAdd(i, j);
                int right = rightAdd(i, j);

                result += Math.min(left, right);

            }

        }

        System.out.println(result);
    }
}
