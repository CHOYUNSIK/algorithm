package inflearn.K_ReferralProblem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step2 {
    static int r, c, k;
    static int xLength = 3, yLength = 3;
    static int[][] map = new int[101][101];

    static class Number implements Comparable<Number> {
        int num;
        int count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {

            if (this.count == o.count) {
                return this.num - o.num;
            } else {
                return this.count - o.count;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken()); // 찾을 행
        c = Integer.parseInt(st.nextToken()); // 찾을 열
        k = Integer.parseInt(st.nextToken()); // 찾을 값

        for (int i = 1; i <= xLength; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= yLength; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(sorting());
    }

    private static int sorting() {
        for (int i = 0; i <= 100; i++) {
            if (map[r][c] == k) {
                return i;
            }
            sortSeparation();
        }
        return -1;
    }

    private static void sortSeparation() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                r(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                c(i);
            }
        }
    }

    private static void r(int key) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        PriorityQueue<Number> q = new PriorityQueue<>();

        for (int i = 1; i <= yLength; i++) {
            if (map[key][i] == 0) continue;
            tempMap.compute(map[key][i], (num, count) -> count == null ? 1 : count + 1);
        }

        tempMap.forEach((k, v) -> q.offer(new Number(k, v)));

        int i = 1;
        while (!q.isEmpty()) {
            Number cur = q.poll();
            map[key][i++] = cur.num;
            map[key][i++] = cur.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            map[key][i++] = 0;
            map[key][i++] = 0;
        }
    }

    private static void c(int key) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        PriorityQueue<Number> q = new PriorityQueue<>();

        for (int i = 1; i <= xLength; i++) {
            if (map[i][key] == 0) continue;
            tempMap.compute(map[i][key], (k, v) -> v == null ? 1 : v + 1);
        }

        tempMap.forEach((k, v) -> q.offer(new Number(k, v)));

        int i = 1;
        while (!q.isEmpty()) {
            Number cur = q.poll();
            map[i++][key] = cur.num;
            map[i++][key] = cur.count;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99){
            map[i++][key] = 0;
            map[i++][key] = 0;
        }
    }


}
