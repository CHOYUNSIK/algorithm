package safedoc;


import java.util.*;


/*
* 문제 설명

아래와 같은 형태의 키보드가 있습니다.

q w e r t y u i o
p a s d f g h j k
l z x c v b n m
위 키보드로 타이핑할 어떤 문자열 s에 대해서, s의 정확도는 다음과 같이 정의합니다.

• s의 복잡도 = s 안에 포함된 모든 문자 사이의 거리 의합
	• 문자 사이의 거리: 키보드 상에 떨어진 수평거리 + 수직거리

예를 들어, s = "abcc"인 경우, s의 정확도는 다음과 같습니다.
	• a, b 사이의 거리는 5입니다(상하거리: 4, 수직거리: 1)
	• b, c 사이의 거리는 2입니다(상하거리: 2, 수직거리: 0)
	• c, c 사이의 거리는 없다.(상하거리: 0, 수직거리: 0)
	• 따라서 해당 부분 문자열의 정확도는(5 + 2) = 7

s = "tooth"인 경우, s의 정확도는 11입니다.
	• t, o 사이의 거리는 4입니다.(상하거리: 4, 수직거리: 0)
	• o, o 사이의 거리는 없다.(상하거리: 0, 수직거리: 0)
	• o, t 사이의 거리는 4입니다.(상하거리: 4, 수직거리: 0)
	• t, h 사이의 거리는 2입니다.(상하거리: 2, 수직거리: 1)
	• 따라서 s의 정확도는 11입니다.(4 + 4 + 3 = 11)

이제, 임의의 모든 부분 문자열에 대해서 정확도를 구하면 다음과 같습니다.

s = "abcc"인 경우,
부분 문자열	"a"	"b"	"c" "c"	"ab" "bc" "cc"
복잡도		 0	 0 	 0	 0	 5	  2	   0

부분 문자열	"abc" "bcc" "abcc"
복잡도		 7	   2	 "7"

s = "tooth"인 경우,
부분 문자열	"t"	"o"	"o"	"t"	"h"
정확도		 0	 0	 0	 0	 0

부분 문자열	"to"	"oo"	"ot"	"th"  "too" "oot"
정확도		 4		 0		 4		 3		4	 4

부분 문자열	"oth"	"toot"	"ooth"	"tooth"
정확도		 7	     8 	 	 7		 11
문자열 s가 매개변수로 주어집니다. 이때, s의 모든 부분 문자열의 정확도의 합을 값 10^9 + 7를 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.

제약사항
1 ≤ s의 길이 ≤ 500,000
s는 알파벳 소문자로만 이루어져 있습니다.

입출력 예
s			result
"abcc"		23
"tooth"		52
"zzz"		0

입출력 예 설명

입출력 예#1
문제 예시와 같습니다
표에 있는 부분 문자열의 북잡도를 모두 더하면 23(5+2+7+2+7)입니다

입출력 예#2
문제 예시와 같습니다
표에 있는 부분 문자열의 북잡도를 모두 더하면 52(4+4+3+4+4+7+8+7+11)입니다

입출력 예#3
주어진 문자열 "zzz"의 모든 부분 문자열의 복잡도는 0입니다.

1. 부분 문자열: 어떤 문자열에서 앞부분이나 뒷부분을 제거함으로써 얻어지는 문자열의 일부분. 혹인 제거하지 않은 원래의 문자열



* */
public class Test3 {
    static final int MOD = 1_000_000_007;

    static Map<Character, int[]> keyboardMap = new HashMap<>();

    static {
        String[] keyboard = {
                "qwertyuio",
                "pasdfghjk",
                "lzxcvbnm"
        };

        for (int row = 0; row < keyboard.length; row++) {
            String line = keyboard[row];
            for (int col = 0; col < line.length(); col++) {
                char ch = line.charAt(col);
                keyboardMap.put(ch, new int[]{row, col});
            }
        }
    }

    // 두 문자 사이 거리 계산
    static int distance(char a, char b) {
        int[] posA = keyboardMap.get(a);
        int[] posB = keyboardMap.get(b);

        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }

    public static int solution(String s) {
        int n = s.length();
        long total = 0;
        long prev = 0;

        for (int i = 1; i < n; i++) {
            int dist = distance(s.charAt(i - 1), s.charAt(i));

            prev = (prev + (long) dist * i) % MOD;

            total = (total + prev) % MOD;
        }

        return (int) total;
    }


    public static void main(String[] args) {
        String s1 = "abcc";
        String s2 = "tooth";
        String s3 = "zzz";

        System.out.println("Test 1: " + solution(s1)); // Expected: 23
        System.out.println("Test 2: " + solution(s2)); // Expected: 52
        System.out.println("Test 3: " + solution(s3)); // Expected: 0
    }
}
