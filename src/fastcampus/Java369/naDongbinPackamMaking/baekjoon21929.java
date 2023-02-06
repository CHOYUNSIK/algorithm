package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon21929 {

    static class Pair implements Comparable<Pair> {
        int fist;
        int second;

        public Pair(int fist, int second) {
            this.fist = fist;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.fist != o.fist) return this.fist - o.fist;
            return this.second - o.second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Pair> problemList = new TreeSet<>();
        HashMap<Integer, Integer> problemMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            problemList.add(new Pair(y, x));
            problemMap.put(x, y);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();

            switch (key) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    problemList.add(new Pair(y, x));
                    problemMap.put(x, y);
                    break;
                }
                case "recommend": {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == -1) {
                        System.out.println(problemList.first().second);
                    } else {
                        System.out.println(problemList.last().second);
                    }
                    break;
                }
                case "solved": {
                    int x = Integer.parseInt(st.nextToken());
                    int y = problemMap.get(x);

                    problemMap.remove(x);
                    problemList.remove(new Pair(y, x));
                    break;
                }
            }
        }

    }

}
