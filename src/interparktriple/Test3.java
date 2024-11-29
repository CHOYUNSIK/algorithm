package interparktriple;

/*
정확성 시간 제한 / 효율성 시간 제한 / 메모리 제한
10초 / 언어별로 작성된 정답 코드의 실행 시간의 적정 배수 / 2GB

문제 설명
문자열에서 일정한 간격으로 같은 문자열이 반복해서 나타난다면 이를 문자열의 주기 라고 합니다. 예를 들어 문자열 "abababab"에서 문자열의 주기는 다음과 같이 세 가 지가 있습니다.
    1. 문자열 "ab"가 네 번 반복해서 나타납니다.
    2. 문자열 "abab 가 두 번 반복해서 나타납니다.
    3. 문자열 "abababab"가 한 번 반복해서 나타납니다.
이때, 가능한 짧은 주기를 문자열의 주기로 정합니다. 따라서 위 문자열의 주기는 2가 됩니다.
문자열 s가 매개변수로 주어질 때, 문자열의 주기를 return 하도록 solution 함수를 완성해주세요.

제한사항
• s는 알파벳 소문자로만 이루어진 문자열입니다.
• s의 길이는 1 이상 1,000,000 이하입니다.

입출력 예
s               result
"abababab"      2
"abcabcabd"     9



입줄력 예 설명
입줄력 예 #1
문제의 예시와 같습니다.
입출력 예 #2
"abc"가 s[3]~ S[5]에서 한번 반복해서 나타나지만, s[6]~s[8]에서는 나타나지 않으므로 가장 짧은 주기는 전체 문자열의 길이인 9가 됩니다.

 */
public class Test3 {
    public static int solution(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) { // 주기의 후보가 전체 길이를 나눌 수 있는지 확인
                String pattern = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(pattern);
                }
                if (s.equals(sb.toString())) {
                    return i; // 주기를 찾았으므로 반환
                }
            }
        }
        return n; // 주기를 찾지 못하면 전체 길이 반환
    }

    public static void main(String[] args) {
        System.out.println(solution("abababab"));  // 2
        System.out.println(solution("abcabcabd")); // 9
    }

}
