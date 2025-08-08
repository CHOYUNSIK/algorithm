package fortytwodot;

import java.util.*;

/*

정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB

문제 설명
책상 위에 놓인 과자를 많이 먹은 동우는 남은 과자를 친구에게 선물하기로 하였습니다.
책상 위의 과자를 먹을 때에는 다음과 같은 조건이 있습니다.

1. 처음 먹는 과자를 제외하고, 새로 먹는 과자는 이전에 먹는 과자보다 맛이 좋아야 합니다. (맛의 정도는 자연수로 표시됩니다.)

2. 위의 규칙을 지키면서 가능한 한 많은 과자를 먹어야 합니다.


예를 들어, 책상 위에 놓인 과자가 [1, 4, 2, 6, 5, 3]처럼 놓여있다면, 1, 2의 규칙을 만족하면서 먹을 수 있는 과자의 최대 개수는 3개입니다.
또한 과자를 먹을 수 있는 방법은 [1,2,6], [1,2,5], [1,2,3], [1,4,6], [1,4,5]의 5가지입니다.
책상 위에 놓인 과자 목록 cookies와 과자를 먹을 수 있는 방법의 순서 k가 주어질 때, 과자를 먹을 수 있는 방법을 사전순으로 나열하고 k번째 순서의 과자의 목록을 반환하는 함수를 완성해 주세요.

제한 사항
• 책상 위에 놓인 과자 목록 cookies 개수 : 100이하의 자연수
• 책상 위에 놓인 과자 값 : 10,000 이하의 자연수 (단, 과자 크기는 모두 다릅니다.)
• 과자를 먹을 수 있는 방법의 순서 k : 100,000,000 이하의 자연수
• k번째 순서로 과자를 먹는 방법이 있는 경우만 입력으로 주어집니다.

입출력 예

|cookies|k|result|
|---|---|---|
|[1,4,2,6,5,3]|2|[1,2,5]|

입출력 예 설명
예제의 경우 과자 중에서 먹을 수 있는 과자의 최대 개수는 3개이고, 과자를 먹을 수 있는 방법은 [1,2,6], [1,2,5], [1,2,3], [1,4,6], [1,4,5]의 5가지입니다.
이를 방법을 사전순으로 나열하면 [1,2,3], [1,2,5], [1,2,6], [1,4,5], [1,4,6]이 되므로 2번째 방법인 [1,2,5]를 반환하면 됩니다.
* */
public class Step1 {
    private List<Integer> cookiesList;
    private int k;
    private int maxLength;
    private int count = 0;
    private int[] result;

    public int[] solution(int[] cookies, int k) {
        this.k = k;
        cookiesList = new ArrayList<>();
        for (int cookie : cookies) cookiesList.add(cookie);
        int n = cookies.length;


        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (cookies[i] < cookies[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        maxLength = Arrays.stream(lis).max().getAsInt();


        for (int i = 0; i < n; i++) {
            if (lis[i] == maxLength) {
                dfs(i, new ArrayList<>(Arrays.asList(cookies[i])), lis);
                if (result != null) break;
            }
        }
        return result;
    }

    private void dfs(int index, List<Integer> path, int[] lis) {
        if (result != null) return;
        if (path.size() == maxLength) {
            count++;
            if (count == k) {
                result = path.stream().mapToInt(i -> i).toArray();
            }
            return;
        }

        TreeMap<Integer, Integer> next = new TreeMap<>();
        for (int i = index + 1; i < cookiesList.size(); i++) {
            if (cookiesList.get(i) > cookiesList.get(index) &&
                    lis[i] == maxLength - path.size()) {
                next.put(cookiesList.get(i), i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
            path.add(entry.getKey());
            dfs(entry.getValue(), path, lis);
            path.remove(path.size() - 1);
        }
    }




    public static void main(String[] args) {
        Step1 sol = new Step1();
        int[] cookies = {1, 4, 2, 6, 5, 3};
        int k = 2;
        int[] answer = sol.solution(cookies, k);
        System.out.println(Arrays.toString(answer));  // 예상 출력: [1, 2, 5]
    }
}
