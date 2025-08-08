package ploonet;

import java.util.*;

/*
* 문제 설명
당신은 전화가 걸려 왔을 때 스팸 전화일 가능성이 높은 전화번호에 대해 경고 문구 표시해주는 애플리케이션을 개발 중입니다. 만약 걸려온 전화번호가 연락처에 등록되지 않은 전화번호면서,
이전에 걸려온 적이 k 번 미만인 전화번호라면 경고 문구를 표시해야 합니다. (즉, k 번째 걸려온 전화까지 경고 문구를 표시해야 합니다.)
단, 스팸 번호로 등록된 전화번호는 다른 조건에 관계없이 경고 문구를 표시해야 합니다.
다음은 연락서 목록, 스팸 번호 목록과 걸려온 전화가 아래와 같고 k= 2일 때 경고 문구를 표시하는 예시입니다.

<연락처 목록>
전화번호
123-4567
451-2314
015-1643

<스팸 번호 목록>
전화번호
111-1111

<걸려온 전화>
전화번호    		경고 표시 유무			비고
123-4567		x					연락처 목록에 있는 전화번호
000-0022		o					처음 걸려온 전화번호
015-1643		x					연락서 목록에 있는 전화번호
000-0022		o					두 번째 걸려온 전화번호
111-1111		o					스팸 번호로 등록된 전화번호
000-0022		x					세 번째 걸려온 전화번호
111-1111		o					스팸 번호로 등록된 전화번호
111-1111		o					스팸 번호로 등록된 전화번호


111-1111은 스팸 번호로 등록된 전화번호이므로, 항상 경고 문구를 표시해야 합니다.
123-4567 과 015-1643은 연락처에 등록된 전화번호이므로, 항상 경고 문구를 표시하지 않아야 합니다.
000-0022는 연락처 목록과 스팸 번호 목록 중 어디에도 등록되지 않은 전화번호입니다. k = 2 이므로 두 번째 걸려온 전화까지 경고 문구들 표시하고, 그 뒤로는 경고 문구를 표시하지 않아야 합니다.

연락처 목록이 담긴 문자열 배열 approved , 스팸 번호 목록이 담긴 문자열 배열 spams  걸려온 전화번호들이 순서대로 담긴 문자열 배열 calls 와 경고 문구들 표시하는 기준을 나타내는
정수 k 가 매개변수로 주어집니다. 이때, 경고 문구를 표시해야 할 경우 1, 표시하지 않아야 할 경우 0을 에 주어진 순서대로 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.


제한사항
1 <= approved의 길이 spams의 길이 <= 50
	 approved 와 spams 의 원소는  "???-????" 형태이며 ?는 0~9 사이의 숫자를 나타냅니다
	 approved는 연락처 목록, spams는 스팸 번호 목록을 나타냅니다
	 approved와 spams를 통틀어 똑같은 전화번호가 두 번 이상 등장하지 않습니다
1 <= calls의 길이 <= 500
	calls는 걸려운 전화번호를 전화가 걸려온 순서대로 담고 있습니다.
	calls의 원소 "???-????" 형태이며 ?는 0 ~ 9 사이의 숫자를 나타냅니다
1 <= k <= 5

임스력예
approved								spams			calls																											k	result
["123-4567", "451-2314", "015-1643"] 	["111-1111"]	["123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"]				2	[0,1,0,1,1,0,1,1]
["123-1000"]							["456-2000"]	["456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"]	3	[1,1,0,0,1,1,1,0,0]


*
* */

public class Test3 {
    public int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        Set<String> approvedSet = new HashSet<>(Arrays.asList(approved));
        Set<String> spamSet = new HashSet<>(Arrays.asList(spams));
        Map<String, Integer> callCounts = new HashMap<>();

        int[] result = new int[calls.length];

        for (int i = 0; i < calls.length; i++) {
            String number = calls[i];

            if (spamSet.contains(number)) {
                result[i] = 1;
            } else if (approvedSet.contains(number)) {
                result[i] = 0;
            } else {
                int count = callCounts.getOrDefault(number, 0) + 1;
                callCounts.put(number, count);
                result[i] = (count <= k) ? 1 : 0;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        Test3 sol = new Test3();

        String[] approved1 = {"123-4567", "451-2314", "015-1643"};
        String[] spams1 = {"111-1111"};
        String[] calls1 = {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"};
        System.out.println(Arrays.toString(sol.solution(approved1, spams1, calls1, 2))); // [0,1,0,1,1,0,1,1]

        String[] approved2 = {"123-1000"};
        String[] spams2 = {"456-2000"};
        String[] calls2 = {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"};
        System.out.println(Arrays.toString(sol.solution(approved2, spams2, calls2, 3))); // [1,1,0,0,1,1,1,0,0]
    }
}
