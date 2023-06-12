package socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Test1 {
    public static void main(String[] args) {
        int n = 6;
        int k = 17;
        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};

        int[] result = solution(n, k, roads);
        System.out.println(Arrays.toString(result)); // 출력: [1, 2, 3]

        n = 4;
        k = 10;
        roads = new int[][]{{0, 1, 2}, {0, 2, 3}};

        result = solution(n, k, roads);
        System.out.println(Arrays.toString(result)); // 출력: [0, 1]

        n = 4;
        k = 11;
        roads = new int[][]{{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}};

        result = solution(n, k, roads);
        System.out.println(Arrays.toString(result)); // 출력: [-1]
    }

    public static int[] solution(int n, int k, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int t = road[2];
            graph.get(a).add(new int[]{b, t});
            graph.get(b).add(new int[]{a, t});
        }

        int[][] dist = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node][2]) continue;
            else if (time <= dist[node][0]) {
                dist[node][2] = dist[node][1];
                dist[node][1] = dist[node][0];
                dist[node][0] = time;
            } else if (time <= dist[node][1]) {
                dist[node][2] = dist[node][1];
                dist[node][1] = time;
            } else if (time < dist[node][2]) {
                dist[node][2] = time;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextTime = time + neighbor[1];
                if (nextTime < dist[nextNode][2]) {
                    pq.offer(new int[]{nextNode, nextTime});
                }
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i][0] <= k) {
                answerList.add(i);
            }
        }

        if (answerList.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] answer = new int[answerList.size()];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }

}

