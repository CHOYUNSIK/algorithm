package safedoc;


import java.util.*;

/*
* 정확성 시간 제한 / 메모리 제한
10소/ 2GB
문제 설명
당신은 물류 센터에서 출고 순서에 맞춰 상품을 준비하는 일을 합니다. 상품은 박스에 담겨 일렬로 놓여 있고 출고 순서에 맞게 박스의 순서를 바꾸어야 합니다.
상품은 출고할 양에 딱 맞춰 준비되며, 같은 상품이라면 이떤 박스를 가져다 놓아도 상관없습니다.
다음은 박스를 옮기는 예시입니다.
[ c ][ a ][ b ][ b ][ a ] -> [ a ][ a ][ b ][ c ][ b ]
왼쪽은 박스의 현재 순서, 오른쪽은 고 순서를 의미합니다. 위 예시에서 상품은 a, b, C 세 가지 종류가 있습니다. 현재 박스의 순서는 Cabba 이고 출고 순서는 aabcb 입니다.
초기 상태:
[ c ][ a ][ b ][ b ][ a ]

↓ (1단계: 오른쪽 a 꺼냄)
[ c ][ a ][ b ][ b ]             [ a ]

↓ (2단계: 왼쪽 c 꺼냄)
[ a ][ b ][ b ]                  [ a ][ c ]

↓ (3단계: 왼쪽 a 꺼냄)
[ b ][ b ]                       [ a ][ c ][ a ]

↓ (4단계: 왼쪽 b 꺼냄)
[ b ]                            [ a ][ c ][ a ][ b ]

↓ (5단계: 왼쪽 b 꺼냄)
[ ]                              [ a ][ c ][ a ][ b ][ b ]

→ 정렬 또는 순서 재조정 후 최종 상태:
                                  [ a ][ a ][ b ][ c ][ b ]

박스를 옮긴 거리는 현재 순서에서 박스의 위치 와 옮긴 순서에서 박스의 위치 차이의 절댓값과 같습니다.
위 그림처럼 현재 순서가 다섯 번째인 a 박스를 첫 번째 순서로 옮기면 옮긴 거리는 4입니다. 이어서 첫 번째 c 박스를 네 번째 위치로, 네 번째 b 박스를 다섯 번째 위치로 옮기면 4+3+1 = 8
만큼의 거리를 옮겨 출고 순서를 만들 수 있습니다. 같은 거리를 옮겨 출고 순서를 만드는 다른 방법은 존재하지만 이보다 더 짧은 거리를 옮겨 출고 순서를 만들 수 없습니다.
당신은 출고 순서에 맞춰 배치될 수 있도록 박스를 옮기면서 긴 거리의 합을 최소로 만들려고 합니다.

옮기기 전 박스의 현재 순서를 나타내는 문자열 box1 과 박스의 출고 순서를 나타내는 문자열 box2 가 매개변수로 주어집니다.
이때 박스의 순서를 출고 순서로 만들기 위해 박스를 옮기는 거리 합의 최솟값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
• 1 <= box1 의 길이 = box2 의 길이 <= 1,000,000
	• box1 과 box2는 알파빗 소문자로 이루어진 문자열입니다.
	• box1 과 box2 에 포함된 알파벳의 종류별 개수는 같습니다.

입출력 예
box1		box2		result
"cabba"		"aabcd"		8
"abcdefg"	"gfedcba"	24
"xxxy"		"xyxx"		4
"zzzz"		"zzzz"		0

입출력 예 설명

입출력 예 #1
문제 설명과 같습니다

입출력 예 #2
초기 상태:
[ a ][ b ][ c ][ d ][ e ][ f ][ g ]         (왼쪽: a, 오른쪽: g)

Step 1: 오른쪽 g → 왼쪽으로 이동
[ b ][ c ][ d ][ e ][ f ]                   [ g ]

Step 2: 왼쪽 a → 오른쪽으로 이동
[ b ][ c ][ d ][ e ][ f ]                   [ g ]      [ a ]

Step 3: 오른쪽 f → 왼쪽으로 이동
[ b ][ c ][ d ][ e ]                        [ g ][ f ] [ a ]

Step 4: 왼쪽 b → 오른쪽으로 이동
[ c ][ d ][ e ]                             [ g ][ f ] [ b ][ a ]

Step 5: 오른쪽 e → 왼쪽으로 이동
[ c ][ d ]                                  [ g ][ f ][ e ] [ b ][ a ]

Step 6: 왼쪽 c → 오른쪽으로 이동
[ d ]                                       [ g ][ f ][ e ] [ c ][ b ][ a ]

Step 7: 오른쪽 d → 왼쪽으로 이동
[ ]                                         [ g ][ f ][ e ][ d ][ c ][ b ][ a ]

위 방법으로 박스를 옮겼을 때 옮긴 거리의 합은 6 + 6 + 4 + 4 + 2 + 2 = 24 입니다. 이보다 더 짥은 거리를 옮겨 순서를 만들 수 없습니다. 따라서 24를 return 해야합니다

입출력 예 #3
초기 상태: [ x ][ x ][ x ][ y ]

1. y(오른쪽 끝) → 앞으로 (거리 2)  ← 이게 핵심이야! 중간으로 이동해서 2칸만 이동!
    [ x ][ x ][ y ][ x ]

2. y → 앞으로 한 칸 (거리 1)
    [ x ][ y ][ x ][ x ]

3. y → 앞으로 한 칸 (거리 1)
    [ y ][ x ][ x ][ x ]

위 방법으로 박스를 옮겼을 때 옮긴 거리의 합은 2 + 1 + 1 = 4 입니다. 이보다 더 짥은 거리를 옮겨 순서를 만들 수 없습니다. 따라서 4를 return 해야합니다


입출력 예 #4
현재 박스가 놓인 순서가 출고 순서와 같아 옮기지 않아도 됩니다 따라서 0을 return 해야합니다.


* */
public class Test2 {
    public static long solution(String box1, String box2) {
        Map<Character, List<Integer>> map1 = new HashMap<>();
        Map<Character, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < box1.length(); i++) {
            char ch = box1.charAt(i);
            map1.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < box2.length(); i++) {
            char ch = box2.charAt(i);
            map2.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        long totalDistance = 0;

        for (char ch : map1.keySet()) {
            List<Integer> list1 = map1.get(ch);
            List<Integer> list2 = map2.get(ch);

            Collections.sort(list1);
            Collections.sort(list2);

            for (int i = 0; i < list1.size(); i++) {
                totalDistance += Math.abs(list1.get(i) - list2.get(i));
            }
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        String box1_1 = "cabba";
        String box2_1 = "aabcb";
        System.out.println("Test 1: " + solution(box1_1, box2_1)); // Expected: 8

        String box1_2 = "abcdefg";
        String box2_2 = "gfedcba";
        System.out.println("Test 2: " + solution(box1_2, box2_2)); // Expected: 24

        String box1_3 = "xxxy";
        String box2_3 = "xyxx";
        System.out.println("Test 3: " + solution(box1_3, box2_3)); // Expected: 4

        String box1_4 = "zzzz";
        String box2_4 = "zzzz";
        System.out.println("Test 4: " + solution(box1_4, box2_4)); // Expected: 0
    }
}
