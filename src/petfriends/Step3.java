package petfriends;

/*
정확성 시간 제한 / 메모리 제한
10초 / 2GB

문제 설명
각 변의 길이가 모두 자연수이고,
넓이가 s인 직사각형을 만드는 방법은 여러 가지가 있을 수 있습니다.
이때, 만들 수 있는 직사각형 중, 둘레 길이의 최소값을 구하려 합니다.
예를 들어 s = 6인 경우 다음과 같이 두 가지 직사각형을 만들 수 있으며,
둘레 길이의 최소값은 10이 됩니다.

복사
편집
1 x 6 → 둘레 = 2 × (1 + 6) = 14
2 x 3 → 둘레 = 2 × (2 + 3) = 10
직사각형의 넓이 s가 매개변수로 주어질 때, 만들 수 있는 직사각형 중
둘레 길이의 최소값을 return 하도록 solution 함수를 완성해주세요.

제한사항
s는 1 이상 100,000 이하의 자연수입니다.

입출력 예
s	result
6	10

입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

*/
public class Step3 {

    public int solution(int s) {
        int minPerimeter = Integer.MAX_VALUE;

        for (int width = 1; width <= Math.sqrt(s); width++) {
            if (s % width == 0) {
                int height = s / width;
                int perimeter = 2 * (width + height);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }





    public static void main(String[] args) {
        Step3 sol = new Step3();
        System.out.println(sol.solution(6));       // 10
        System.out.println(sol.solution(30));      // 22 (5x6)
        System.out.println(sol.solution(1));       // 4 (1x1)
        System.out.println(sol.solution(100000));  // 테스트 케이스
    }
}
