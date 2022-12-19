package fastcampus.Java369.mockCodingTest.Step03_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon22252 {


    static int keyNum = 0;
    static PriorityQueue<Integer>[] queues = new PriorityQueue[100005];
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());

        long result = 0;

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int kind = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (!map.containsKey(name)) {
                map.put(name, ++keyNum);
                queues[keyNum] = new PriorityQueue<>(Comparator.reverseOrder());
            }

            int key = map.get(name);

            if (kind == 1) {
                int k = Integer.parseInt(st.nextToken());
                while (k-- > 0) {
                    queues[key].add(Integer.parseInt(st.nextToken()));
                }
            } else {
                int b = Integer.parseInt(st.nextToken());

                while (b-- > 0 && !queues[key].isEmpty()) {
                    result += queues[key].poll();
                }

            }

        }

        System.out.println(result);

    }
}

