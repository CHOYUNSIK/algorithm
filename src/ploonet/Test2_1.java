package ploonet;

import java.util.*;

/*

문제 설명

문자열 s에 있는 알파벳 중 'a'와 'z'를 하나씩 선택하려고 합니다. 이때, 선택한 'a'와 'z' 사이의 문자열에 다른 'a'와 'z'가 없어야 합니다.
예들 들어 주어진 문자열이 "zabzczxa"인 경우, 다음과 같이 세 가지 방법이 가능합니다.

• "z" "a" bzczxa
• z"a" b"z" czxa
• zabzc "z" x "a"

그러나 z "a" bzc "z" xa와 같은 선택은 선택된 'a'와 z' 사이의 문자열 "bzc"에 'z'가 포함되어있으므로 불가능합니다.
문자열 S가 매개변수로 주어질 때, 주어진 규칙에 맞게 'a'와 'z'를 선택하는 서로 다른 방법의 가짓수를 return 하도록 solution 함수를 완성해주세요.

제한사함
• 문자열 s의 길이는 1이상 100,000이하입니다.

• 문자열은 알파벳 소문자로만 이루어져 있습니다.
입출력 예
s 				result
"abcz" 				1
"zabzczxa"			3
"abcd"				0


입출력 예 설명
입출력 예 #1

다음과 같이 한 가지가 가능합니다.
• abcz

입출력 예 #2
문제의 예시와 같습니다.

입출력 예 #3
a와 z든 선택할 방법이 없습니다.
*
* */
public class Test2_1 {

    public static int solution(String s){

        List<Integer> aList = new ArrayList<>();
        List<Integer> zList = new ArrayList<>();

        for (int i = 0;  i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'a'){
                aList.add(i);
            }
            if ('z' == c){
                zList.add(i);
            }
        }
        int result = 0;
        for (int a : aList){
            for (int z : zList){
                int min = Math.min(a, z);
                int max = Math.max(a, z);

                boolean valid = true;
                for (int i = min + 1; i < max; i++){
                    if (s.charAt(i) == 'a' || s.charAt(i) == 'z'){
                        valid = false;
                        break;
                    }
                }

                if (valid) result ++;
            }
        }


        return result;
    }
    public static void main(String[] args) {
        Test2_1 sol = new Test2_1();
        System.out.println(sol.solution("abcz")); // 1
        System.out.println(sol.solution("zabzczxa")); // 3
        System.out.println(sol.solution("abcd")); // 0
    }
}
