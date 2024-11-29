package interparktriple;

/*

정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB

문제 설명
1부터 자연수를 이어쓰면 1234567891011121314...가 됩니다. 이렇게 이어쓴 숫자를
A라 할 때, n번째에 위치하는 숫자를 반환하는 함수 Solution을 완성해주세요.

제한사항
    • 숫자의 위치 n:1 <= n  <= 1,000,000,000, n은 자연수

입출력 예
n   result
5   5
15  2

입출력 예 설명
입출력 예 #1
1234567...에서 다섯 번째에는 5가 위치합니다.

입출력 예 #2
12345678910111213...에서 15번째에는 2가 위치합니다.

 */
public class Test2 {
    public static int findNthDigit(int n) {
        long base = 9, digits = 1;
        while (n - base * digits > 0) {
            n -= base * digits;
            base *= 10;
            digits++;
        }

        long index = n % digits;
        if (index == 0) index = digits;
        long num = (index == digits) ? (n / digits) : (n / digits + 1);

        long startOfRange = (long)Math.pow(10, digits - 1);
        long targetNum = startOfRange + num - 1;

        String targetNumStr = String.valueOf(targetNum);
        char resultChar = (index == digits) ? targetNumStr.charAt(targetNumStr.length() - 1) : targetNumStr.charAt((int)index - 1);

        return Character.getNumericValue(resultChar);
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(5));  // 5
        System.out.println(findNthDigit(15)); // 2
    }
}
