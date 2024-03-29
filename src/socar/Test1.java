package socar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/*
문제 설명
도시에 n개의 전기 자전거 보관소가 있습니다. 각 보관소에는 0부터 n - 1까지 번호가 하나씩 붙어 있으며, 보관소 사이를 연결해주는 자전거 도로가 있습니다. 단, 아직 도로를 내는 종이라서 다른 보관소와 연결되지 않은 보관소가 있을 수 있습니다. 자전거 도로는 양방향 통행이 가능하며, 어느 방향으로 이동하든 걸리는 시 간은 동일합니다. 전기 자전거 대여 시간은 K분이며, 대여 시간이 끝나면 즉시 자전거를 보관소에 반납해야 합니다. 이때 자전거는 아무 보관소에나 반납해도 됩니다.
당신은 0번 보관소에서 전기 자전거를 대여하여 자전거 도로를 따라 K분 동안 쉬지 않고 자전거를 탄 후, 대 여시간이 끝나는 시각에 즉시 자전거를 반납할 수 있는 보관소는 어디인지 알아보려 합니다. 즉 번 보관소 에서 출발하여 K분 동안 쉬지 않고 자전거를 단 후, 대여 종료 시각에 정확히 도달할 수 있는 보관소를 찾아야 합니다. 이때, 한번 이용한 자전거 도로를 여러 번 이용하는 것은 가능하지만, 자전거 도로를 따라 달리다가 중간에 멈추거나 중간에서 방향을 바꾸어 되돌아 갈 수는 없습니다.
아래 그림은 각 보관소와 자전거 도로를 이용하는데 걸리는 시간(분)을 나타낸 예시입니다.


위 그림에서 보관소는 총 6군데이며, 각각 0번부터 5번까지 번호들 가집니다. 이 예시에서 자전거 대여 시간
(k)은 17분이라고 가정합니다.
17분 후 1번 보관소에 도달하는 방법은 경로 (0 - 1 - 2 - 1)을 따르는 것입니다. 0번 보관소에서 1번 보관소 까지 3분, 1번 보관소에서 2번 보관소까지 7분, 2번 보관소에서 1번 보관소까지 7분이 걸리므로 3+7+7=17 분 후에 1번 보관소에서 자전거들 반납할 수 있습니다.
경로 (0 - 4 - 0 - 4 5 - 2)를 따라 2번 보관소에, 경로 (0 - 4 - 0 - 1 - 2 - 3)을 따라 3번 보관소에 정확 히 17분 후에 도착해서 자전거를 반납할 수 있습니다. 0번, 4번, 5번 보관소에는 어떤 방법으로도 17분 후에 도착할 수 없습니다.
자전거 보관소의 수를 나타내는 정수 0 , 자전거 대여시간을 나타내는 정수 k , 각 지점을 연결하는 자전 거 도로와 도로를 이용하는데 결리는 시간을 나타내는 2차원 정수 배열 roads 가 매개변수로 주어집니다.
0번 보관소부터 자전거들 타기 시작했을 때, 쉬지 않고 K분 동안 자전거를 탄 뒤 도착할 수 있는 보관소의 번 호를 배열에 담아 오름차순 정렬하여 return 하도록 solution 함수를 완성해주세요. 만약 조건을 만족하는 보관소가 없을 경우, -1을 배열에 담아 return 해주세요.
제한사항
• 2 ≤ n ≤ 100
• 1 ≤ k ≤ 2,000
• 1 ≤ roads 의 길이 ≤ min (n *(n -1)/2,5* n )
	• roads의 원소는 (a, b, t] 형식입니다.
	• 보관소 a와 보관소 b을 직접 연결하는 길을 자전거를 타고 갈 때 걸리는 시간이 t일을 의미합니다.
	• 0 ≤ a, b ≤ n - 1
	• 1≤t≤k
• a‡ b
• 같은 길이 중복하여 등장하지 않습니다.
• 0번 보관소는 함상 1개 이상의 다른 보관소와 연결되어 있습니다.

입출력 예
n  k   roads                                                              result
6  17  [[5, 4, 6], [5, 2, 5], [0, 4, 2], [2, 3, 3], [1, 2, 7], [0, 1, 3]] [1, 2, 3]
4  10  [[0, 1, 2], [0, 2, 3]]                                             [0, 1]
4  11  [[0, 1, 2], [1, 2, 7], [2, 3, 10], [3, 0, 9]]                      [-1]


* */
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

