package petfriends;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
10초 / (입력으로 작성된 평균 코드의 실행 시간의 적정 배수) / 2GB

문제 설명
온라인으로 티켓 예매를 하기 위해 한 이용자가 홈페이지의 예매 버튼을 클릭하였고, 예매 대기열이 생성되었습니다.
이때 예매 버튼을 여러 번 중복하여 클릭한 이용자들이 있어 예매 대기열에 여러 번 등록되어 중복된 ID들이 존재하게 되었습니다.
사이트 관리자는 현재까지 생성된 예매 대기열에서 중복 등록된 이용자들을 제거하고자 합니다.
가장 먼저 예매 대기열에 들어온 순서대로 한 번만 인정하고, 나머지는 대기열에서 제거해야 합니다.
다음은 현재까지 생성된 예매 대기열에서 중복으로 등록된 이용자들을 제거하는 예시입니다.

makefile
복사
편집
ID:   1  5  8  2 10  5  4  6  4  8
인정: 1  5  8  2 10     4  6
위 예시에서 각 숫자는 이용자의 ID 번호를 나타내며 왼쪽부터 순서대로 예매 대기열의 등록 상태입니다.
이때, 동일 ID의 경우 가장 먼저 등록된 ID만 인정하고, 이후에 등록된 ID는 제거해야 합니다.
마찬가지로 8번 이용자의 경우 앞에서 한 번 인정되었기 때문에, 뒤쪽에 등록된 8은 제거 대상입니다.
따라서 위 예매 대기열은 [1, 5, 8, 2, 10, 4, 6] 순으로만 유지됩니다.

예매 대기열에 중복된 ID가 포함된 이유는 새로고침으로 인해 버튼을 여러 번 클릭하였기 때문입니다.

현재 생성된 예매 대기열 상태가 담긴 배열 waiting이 매개변수로 주어질 때,
중복으로 등록된 이용자를 제거한 결과를 배열 형태로 return 하도록 solution 함수를 완성해주세요.

제한사항
waiting은 현재 생성되어있는 예매 대기열이 담겨있는 배열이며, 길이는 1 이상 200,000 이하입니다.

waiting의 각 원소는 이용자의 ID이며, 예매 대기열에 등록된 순서대로 들어있습니다.

이용자 ID는 1 이상 20억 이하의 자연수입니다.

입출력 예
waiting	result
[1, 5, 8, 2, 10, 5, 4, 6, 4, 8]	[1, 5, 8, 2, 10, 4, 6]
[5, 4, 4, 3]	[5, 4, 3]

입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
5와 4번 이용자가 각각 중복 등록되었기 때문에 나중에 등록된 아이디는 대기열에서 삭제하면
대기열은 [5, 4, 3]이 됩니다.

*/
public class Step4 {

    public int[] solution(int[] waiting) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int id : waiting) {
            unique.add(id);
        }

        int[] result = new int[unique.size()];
        int index = 0;
        for (int id : unique) {
            result[index++] = id;
        }

        return result;
    }





    public static void main(String[] args) {
        Step4 sol = new Step4();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 5, 8, 2, 10, 5, 4, 6, 4, 8})));  // [1, 5, 8, 2, 10, 4, 6]
        System.out.println(Arrays.toString(sol.solution(new int[]{5, 4, 4, 3, 5})));
    }
}
