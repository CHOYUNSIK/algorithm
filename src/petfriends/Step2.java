package petfriends;

import java.util.Arrays;

/*
**정확성 시간 제한 / 메모리 제한**
10초 / 2GB

---

### 문제 설명

문자열 `s`가 주어졌을 때 `s`에 포함된 알파벳 중 **홀수개인 알파벳**의 개수를 구하려고 합니다.
문자열 `s`에 포함된 알파벳 중에서 **홀수 번 등장하는** 알파벳의 개수를 return 하도록 `solution` 함수를 완성해주세요.

---

### 제한사항

- 문자열 `s`의 길이는 1 이상 10,000 이하입니다.

- 문자열 `s`는 알파벳 소문자로만 이루어져 있습니다.


---

### 입출력 예

|s|result|
|---|---|
|"aabbbccd"|2|
|"abebeaeedac"|3|

---

### 입출력 예 설명

**입출력 예 #1**
a가 2개, b가 3개, c가 2개, d가 1개이므로 홀수개인 알파벳은 b, d 2개입니다.

**입출력 예 #2**
a가 3개, b가 2개, c가 1개, d가 1개, e가 4개이므로 홀수개인 알파벳은 a, c, d 3개입니다.
* */
public class Step2 {

    public int solution(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int count = 0;
        for (int f : freq) {
            if (f % 2 == 1) count++;
        }

        return count;
    }





    public static void main(String[] args) {
        Step2 sol = new Step2();
        System.out.println(sol.solution("aabbbccd"));        // 2
        System.out.println(sol.solution("abebeaeedac"));     // 3
    }
}
