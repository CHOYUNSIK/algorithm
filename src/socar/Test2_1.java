package socar;

public class Test2_1 {
    private int minSwap = Integer.MAX_VALUE;

    public int solution(int[] numbers, int k) {
        minSwap = Integer.MAX_VALUE;
        permute(numbers, 0, k, 0);
        return minSwap == Integer.MAX_VALUE ? -1 : minSwap;
    }

    private void permute(int[] arr, int l, int k, int swapCount) {
        if (isKDiff(arr, k)) {
            minSwap = Math.min(minSwap, swapCount);
            return;
        }
        if (l == arr.length) return;
        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, k, l == i ? swapCount : swapCount + 1);
            swap(arr, l, i); // backtrack
        }
    }

    private boolean isKDiff(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > k) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Test2_1 solution = new Test2_1();

        // 입력 예 #1
        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;
        System.out.println("입력 예 #1 결과: " + solution.solution(numbers1, k1));


        // 입력 예 #2
        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;
        System.out.println("입력 예 #2 결과: " + solution.solution(numbers2, k2));
    }
}
