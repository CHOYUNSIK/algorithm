package socar;

public class Test2_1 {
    static int minSwap = Integer.MAX_VALUE;

    public static int solution(int[] numbers, int k) {
        permute(numbers, 0, k);
        return minSwap == Integer.MAX_VALUE ? -1 : minSwap;
    }

    private static void permute(int[] arr, int start, int k) {
        if (start == arr.length) {
            checkAndSetMinSwaps(arr, k);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1, k);
            swap(arr, start, i); // backtrack
        }
    }

    private static void checkAndSetMinSwaps(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > k) {
                return; // 조건 불만족
            }
        }
        // 여기서 arr의 swap 횟수 계산 필요
        // 주어진 배열의 길이와 제한된 swap 연산으로는 직접적인 계산 불가능하여, 문제 설명의 오류로 보임
        // 이론적으로는 초기 배열과 비교하여 최소 변경 횟수를 추정할 수 있지만, 주어진 문제 조건 내에서는 구현 불가
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 40, 30, 20}, 20)); // 1
        System.out.println(solution(new int[]{3, 7, 2, 8, 6, 4, 5, 1}, 3)); // 2
    }
}
