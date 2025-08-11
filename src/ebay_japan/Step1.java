package ebay_japan;

import java.util.*;

/*
정확성 시간 제한 / 메모리 제한
10초 / 2GB

문제 설명
길이가 n인 정수 배열 arr가 주어집니다. arr를 다음과 같은 과정을 거쳐서 섞은 결과를 return 하도록 solution 함수를 완성해주세요.

arr의 길이가 1이라면, arr를 그냥 그대로 두고 과정을 종료합니다.

arr를 앞뒤로 뒤집습니다.

만약 arr의 길이가 짝수(2k)라면, 앞뒤로 길이가 k, k인 두 배열로 나눕니다.

만약 arr의 길이가 홀수(2k+1)라면, 앞뒤로 길이가 k+1, k인 두 배열로 나눕니다.

두 배열에 대해 과정을 다시 반복한 뒤, 다시 이어 붙입니다.

제한사항

1 ≤ arr의 길이 ≤ 400,000

-10⁹ ≤ arr의 모든 수 ≤ 10⁹

입출력 예

| arr            | result         |
| -------------- | -------------- |
| \[1,2,3,4,5,6] | \[5,4,6,2,1,3] |


입출력 예 설명

입출력 예 #1

[1,2,3,4,5,6]이 섞이는 과정은 다음과 같습니다.

| 오리지널 배열        | 앞뒤 뒤집음         | 앞 배열     | 앞 배열 섞은 결과 | 뒷 배열     | 뒷 배열 섞은 결과 | 최종 결과          |
| -------------- | -------------- | -------- | ---------- | -------- | ---------- | -------------- |
| \[1,2,3,4,5,6] | \[6,5,4,3,2,1] | \[6,5,4] | \[5,4,6]   | \[3,2,1] | \[2,1,3]   | \[5,4,6,2,1,3] |
| \[6,5,4]       | \[4,5,6]       | \[4,5]   | \[5,4]     | \[6]     | \[6]       | \[5,4,6]       |
| \[3,2,1]       | \[1,2,3]       | \[1,2]   | \[2,1]     | \[3]     | \[3]       | \[2,1,3]       |
| \[4,5]         | \[5,4]         | \[5]     | \[5]       | \[4]     | \[4]       | \[5,4]         |
| \[1,2]         | \[2,1]         | \[2]     | \[2]       | \[1]     | \[1]       | \[2,1]         |


따라서, [5,4,6,2,1,3]을 return 해야 합니다.




class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        return answer;
    }
}

 */
public class Step1 {

   /* public int[] solution(int[] arr) {
        return shuffle(arr, 0, arr.length);
    }

    private int[] shuffle(int[] arr, int start, int end) {
        int len = end - start;
        if (len == 1) {
            return new int[]{arr[start]};
        }

        // 1. 뒤집기
        reverse(arr, start, end - 1);

        // 2. 나누기
        int mid;
        if (len % 2 == 0) {
            mid = start + len / 2;
        } else {
            mid = start + len / 2 + 1;
        }

        // 3. 재귀 처리
        int[] left = shuffle(arr, start, mid);
        int[] right = shuffle(arr, mid, end);

        // 4. 합치기
        int[] result = new int[len];
        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);
        return result;
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }*/

    public int[] solution(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];
        emit(arr, 0, n, false, out, 0); // false = 처음엔 뒤집히지 않은 뷰
        return out;
    }

    // out[pos..]에 결과를 채워 넣고, 다음 pos를 반환
    private int emit(int[] a, int l, int r, boolean rev, int[] out, int pos) {
        int len = r - l;
        if (len == 1) {
            out[pos] = rev ? a[r - 1] : a[l];
            return pos + 1;
        }

        rev = !rev; // 이번 단계의 "뒤집기"를 실제 뒤집기 대신 플래그 토글로 표현
        int m = (len + 1) / 2; // ⌈len/2⌉

        if (!rev) {
            // 뒤집힌 뷰가 아니라면: [l, l+m), [l+m, r)
            pos = emit(a, l, l + m, rev, out, pos);
            pos = emit(a, l + m, r, rev, out, pos);
        } else {
            // 뒤집힌 뷰라면: [r-m, r), [l, r-m)
            pos = emit(a, r - m, r, rev, out, pos);
            pos = emit(a, l, r - m, rev, out, pos);
        }
        return pos;
    }
    public static void main(String[] args) {
        Step1 sol = new Step1();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] result = sol.solution(arr);
        System.out.println(Arrays.toString(result)); // [5, 4, 6, 2, 1, 3]

    }
}
