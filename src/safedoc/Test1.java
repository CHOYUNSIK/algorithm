package safedoc;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
다시 문제
정확성 시간 제한 / 메모리 제한
10소/ 2GB

문제 설명
당신은 무한히 긴 줄 하나를 잘라 줄 n 개로 나누려고 합니다.
당신은 줄을 하나만 자르거나, 이미 잘려있는 줄을 겹쳐 여러 줄을 한 번에 자를 수 있습니다.
예를 들어 n 이 4일 경우, 다음과 같이 자를 수 있습니다.
1. 긴 줄 하나를 잘라 두 줄로 나눕니다.
2. 두 준 중 해나를 잘라 세 줄로 나눕니다.
3. 세 줄 중 하나를 잘라 네 줄로 나눕니다.
다음과 같이 자를 수도 있습니다.
1. 긴 줄 하나를 잘라 두 줄로 나눕니다.
2. 두 개의 줄을 겹쳐 한 번에 잘라 네 줄로 나눕니다.
하지만, 줄을 한 번에 자르는 개수에 따라 줄을 자르는 시간이 달라칩니다. 한 번에 많은 줄을 자를수록 더 많은 시간이 걸리게 됩니다.
예를 들어 n= 4 이고, 줄을 자를 때 걸리는 시간은 다음과 같다고 가정해보겠습니다.

자르는 줄의 개수		소요되는 시간
1 				2
2				3

다음과 같이 줄을 자를 수 있습니다.
1. 긴 줄 하나를 잘라 두 줄로 나눔니다.
	• 시간이 2만큼 소요됩니다.
2. 두 줄 중 하나를 잘라 세 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
3. 세 줄 중 하나를 잘라 네 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
총 6만큼 시간이 소요됐습니다.

다른 방법으로는 아래와 같이 자를 수도 있습니다.
1. 긴 줄 하나를 잘라 두 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
2. 두 개의 줄을 겹쳐 한 번에 잘라 네 줄로 나눕니다.
	• 시간이 3만큼 소요됩니다.
총 5만큼 시간이 소요됐습니다. 5보다 더 빨리 줄 4개로 나누는 방법은 없습니다.
만들어야 하는 줄의 개수를 뜻하는 정수 n, 줄을 x개 잘랐을 때 소요되는 시간을 담은 1차원 정수 배열 items 가 주어졌을 때 긴 줄 하나를 잘라 줄
n개로 나누는데 걸리는 최소 시간을 return 하도록 solution 함수를 완성해주세요.
단, 줄을 잘라 n 를 초과하면 안 됩니다.

제한사항
• 2<= n <= 2,000
• times 의 길이 = cail(n/ 2)
	• cail(x) 는 x의 소수점 첫째 자리에서 올림을 의미합니다. 예를 들어 cal(3.2) = 4, cal(3.7) = 4, coi(3) = 3 입니다.
	• 1 <= times 의 원소 <= 1,000,000
	• times[i] 는 줄을 i + 1 개 잘랐을 때 소요되는 시간입니다.
	• times 의 원소는 중복 없이 오름차순으로 정렬되어있습니다.

입출력 예
n 		times			result
4		[2, 3]			5
5		[2, 4, 5]		8
6		[1, 2, 3]		5


입출력 예 설명

입출력 예 #1
문제 예시와 동일합니다

입출력 예 #2
만들어야 하는 줄의 개수는 5개입니다. 줄을 자를 때 걸리는 시간은 다음과 같습니다.

자르는 줄의 개수 			소요되는 시간
1					2
2					4
3					5
1. 긴 줄 하나를 잘라 두 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
2. 두 개의 줄을 겹쳐 한 번에 잘라 네 줄로 나눕니다.
	• 시간이 4만큼 소요됩니다.
3. 네 줄 중 하나를 잘라 다섯 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
총 8만큼 시간이 소요됐습니다. 8보다 더 빨리 줄 5개를 나누는 방법은 없습니다. 따라서 8을 retum 해야 합니다.

입출력 예 #3
만들이야 하는 줄의 개수는 6개입니다. 줄을 자를 때 걸리는 시간은 다음과 같습니다.
자르는 줄의 개수 			소요되는 시간
1					1
2					2
3					3

1. 긴 줄 하나를 잘라 두 줄로 나눕니다.
	• 시간이 1만큼 소요됩니다.
2. 두 개의 줄을 겹쳐 한 번에 잘라 네 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
3. 네 줄 중 두 개의 줄을 겹쳐 한 번에 잘라 여섯 줄로 나눕니다.
	• 시간이 2만큼 소요됩니다.
총 5만큼 시간이 소요됐습니다. 5보다 더 빨리 줄 6개를 나누는 방법은 없습니다. 따라서 5를 raturn 해야 합니다

*/
public class Test1 {
    public static int solution(int n, int[] times) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int curCount = current[1];

            if (curCount == n) return time;

            for (int i = 0; i < times.length; i++) {
                int cutCount = i + 1;

                if (curCount < cutCount) continue;

                int nextCount = curCount + cutCount;
                if (nextCount > n) continue;

                int nextTime = time + times[i];
                if (nextTime < dist[nextCount]) {
                    dist[nextCount] = nextTime;
                    pq.offer(new int[]{nextTime, nextCount});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int n1 = 4;
        int[] times1 = {2, 3};
        System.out.println("Test 1: " + solution(n1, times1));  // expected: 5

        // 테스트 케이스 2
        int n2 = 5;
        int[] times2 = {2, 4, 5};
        System.out.println("Test 2: " + solution(n2, times2));  // expected: 8

        // 테스트 케이스 3
        int n3 = 6;
        int[] times3 = {1, 2, 3};
        System.out.println("Test 3: " + solution(n3, times3));  // expected: 5

    }
}
