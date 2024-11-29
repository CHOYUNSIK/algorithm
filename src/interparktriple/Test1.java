package interparktriple;

/*
정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB

문제 설명
팩토리얼은 자연수 n에 대해 1부터 n까지 모든 숫자를 곱하는 것을 의미하 며 n 팩토리얼은 n! 라고 표기합니다. 예를들어 3! 은 1 x 2 x 3 = 6입니다.
그리고 n! 을 계산했을 때 가장 낮은 자리부터 연속되어 나타나는 0의 개수 를 팩토리얼 꼬리의 길이라고 합니다.
예를 들어 n = 10인 경우 10! 은 3628800이며 가장 낮은 자리부터 연속 해서 2개의 0이 있으므로 팩토리얼 꼬리의 길이는 2입니다.
입력으로 n이 주어질 때 팩토리얼 꼬리의 길이를 반환하는 함수를 완성해 주세요.

제한사항
•n은 2^31 -1 이하의 자연수입니다.

입출력 예
n   result
5   1
10  2

입출력 예 설명

입출력 예 #1
5! 은 120이며 1의 자리부터 연속해서 1개의 0이 있으므로 1을 반환합니다.

입출력 예 #2
10! 은 3628800이며 1의 자리부터 연속해서 2개의 0이 있으므로 2를 반환합니다.

 */
public class Test1 {
    public static int findFactorialZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialZeroes(5));  // 1
        System.out.println(findFactorialZeroes(10)); // 2
    }
}
