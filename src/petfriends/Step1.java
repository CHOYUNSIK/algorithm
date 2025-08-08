package petfriends;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
**정확성 시간 제한 / 메모리 제한**
10초 / 2GB

---

### 문제 설명

배열의 회전이란 모든 원소를 오른쪽으로 한 칸씩 이동시키고, 마지막 원소는 배열의 맨 앞에 넣는 것을 말합니다.

css

복사편집

`[4, 3, 2, 1]  → [1, 4, 3, 2]  → [2, 1, 4, 3]  → [3, 2, 1, 4]`

두 배열 `arrA`와 `arrB`가 매개변수로 주어질 때, `arrA`를 회전해 `arrB`로 만들 수 있으면 `true`를, 그렇지 않으면 `false`를 return 하는 `solution` 함수를 작성해주세요.

---

### 제한 조건

- `arrA`는 길이가 1 이상 1,500 이하인 배열입니다.
    → `arrA`의 원소는 0 이상 1,500 이하인 정수입니다.

- `arrB`는 길이가 1 이상 1,500 이하인 배열입니다.
    → `arrB`의 원소는 0 이상 1,500 이하인 정수입니다.

### 입출력 예

|arrA|arrB|return|
|---|---|---|
|[7, 8, 10]|[10, 7, 8]|true|
|[4, 3, 2, 1]|[5, 4, 1, 2]|false|

---

### 입출력 예 설명

**예시 #1**
arrA 배열을 한 번 회전하면 arrB와 같아집니다.

**예시 #2**
arrA 배열은 아무리 회전해도 arrB와 같지 않습니다.
* */
public class Step1 {

/*    public boolean solution(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) return false;

        String aStr = Arrays.stream(arrA).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String bStr = Arrays.stream(arrB).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String doubleAStr = aStr + "," + aStr;

        return doubleAStr.contains(bStr);
    }*/
    public boolean solution(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) return false;

        int n = arrA.length;
        int[] rotated = Arrays.copyOf(arrA, n);

        for (int i = 0; i < n; i++) {
            if (Arrays.equals(rotated, arrB)) return true;
            rotated = rotateRight(rotated);
        }

        return false;
    }

    private int[] rotateRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[0] = arr[n - 1];
        System.arraycopy(arr, 0, result, 1, n - 1);
        return result;
    }



    public static void main(String[] args) {
        Step1 sol = new Step1();
        int[] arrA1 = {7, 8, 10};
        int[] arrB1 = {10, 7, 8};
        System.out.println(sol.solution(arrA1, arrB1));  // true

        int[] arrA2 = {4, 3, 2, 1};
        int[] arrB2 = {5, 4, 1, 2};
        System.out.println(sol.solution(arrA2, arrB2));  // false
    }
}
