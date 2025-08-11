package ebay_japan;

import java.util.Arrays;

/*
문제 설명

당신은 다음과 같은 세금 정책을 시뮬레이션하려고 합니다.

* 이 정책은 모든 시민에 대해 해당 시민이 소유하는 금액을 매달 말에 징수하는 정책입니다.

* 이 정책에 쓰이는 파라미터는 minratio, maxratio, ranksize, threshold 4가지입니다.

* 어떤 시민이 소유하고 있는 금액을 m원이라고 할 때, 이 시민에게서 걷을 세금을 계산할 때는 m의 백의 자리 미만을 버림 하고 계산합니다. 이 금액을 "소유 가정 금액"이라고 정의합니다.

  예를 들어, 어떤 시민이 21,025,667원을 소유하고 있다면 이 사람의 "소유 가정 금액"은 21,025,600원이며, 세율이 50%라면 10,512,800원을 징수하는 식입니다.

* 어떤 시민의 "소유 가정 금액"이 threshold 미만일 경우, 해당 시민에게서 세금을 걷지 않습니다.

* threshold 이상의 "소유 가정 금액"을 갖는 시민은 threshold로부터 ranksize 단위만큼 소유 금액이 올라갈 때마다 1%의 세율이 추가적으로 붙습니다. (아래 표 참조)

* 세율의 상한은 maxratio로 제한되며, 그 어떤 경우에도 maxratio보다 높은 세율을 적용하지 않습니다.

* 다음은 위 사항들을 종합적으로 반영한 세율 표입니다.

| 재산 범위 (KRW)                                                  | 세율 (%)       |
| ------------------------------------------------------------ | ------------ |
| threshold 미만                                                 | 0            |
| threshold \~ (threshold + ranksize - 1)                      | minratio     |
| (threshold + ranksize) \~ (threshold + 2 x ranksize - 1)     | minratio + 1 |
| (threshold + 2 x ranksize) \~ (threshold + 3 x ranksize - 1) | minratio + 2 |
| ...                                                          | ...          |
| 특정 범위 이상                                                     | maxratio     |

가상의 시민의 초기 소유 금액 money, 세금 정책 파라미터 minratio, maxratio, ranksize, threshold, 그리고 정책을 시뮬레이션할 횟수 months가 매개변수로 주어집니다.
이 시민의 초가 소유액인 money와 앞서 정의된 세금정책에 의하여, 이 사람이 보유하게 될 금액을 return 하도록 solution 함수를 완성해주세요.

제한사항

* 0 ≤ money ≤ 1,000,000,000 입니다.
* 0 ≤ minratio ≤ maxratio ≤ 100 입니다.
* 1 ≤ ranksize ≤ 1,000,000,000 입니다.
* 0 ≤ threshold ≤ 1,000,000,000 입니다.
* 1 ≤ months ≤ 360 입니다.

입출력 예

| money      | minratio | maxratio | ranksize | threshold | months | result    |
| ---------- | -------- | -------- | -------- | --------- | ------ | --------- |
| 12345678   | 10       | 20       | 250000   | 10000000  | 4      | 9000014   |
| 1000000000 | 50       | 99       | 100000   | 0         | 6      | 6150      |
| 123456789  | 0        | 0        | 1        | 0         | 360    | 123456789 |

입출력 예 설명

입출력 예 #1

* 소유 가정 금액에 따른 세율은 다음과 같습니다.

| 소유 가정 금액                   | 세율  |
| -------------------------- | --- |
| 10,000,000원 미만             | 0%  |
| 10,000,000원 ~ 10,249,999원 | 10% |
| 10,250,000원 ~ 10,499,999원 | 11% |
| …                          | …   |
| 12,250,000원 ~ 12,499,999원 | 19% |
| 12,500,000원 이상             | 20% |

* 따라서, 첫 2달 동안 시민의 소유 금액이 바뀌는 과정은 다음과 같습니다.

| 월차 |       소유 금액 |    소유 가정 금액 |  세율 |      징수 금액 |       최종 금액 |
| -- | ----------: | ----------: | --: | ---------: | ----------: |
| 1  | 12,345,678원 | 12,345,600원 | 19% | 2,345,664원 | 10,000,014원 |
| 2  | 10,000,014원 | 10,000,000원 | 10% | 1,000,000원 |  9,000,014원 |
| 3  |  9,000,014원 |  9,000,000원 |  0% |         0원 |  9,000,014원 |
| 4  |  9,000,014원 |  9,000,000원 |  0% |         0원 |  9,000,014원 |

입출력 예 #2

* 소유 가정 금액에 따른 세율은 다음과 같습니다. threshold가 0이므로, 면세 구간이 없다는 점에 유의해 주세요.

| 소유 가정 금액                 | 세율  |
| ------------------------ | --- |
| 0원 ~ 99,999원            | 50% |
| 100,000원 ~ 199,999원     | 51% |
| 200,000원 ~ 299,999원     | 52% |
| …                        | …   |
| 4,800,000원 ~ 4,899,999원 | 98% |
| 4,900,000원 이상            | 99% |

* 6달 동안 시민의 소유 금액이 바뀌는 과정은 다음과 같습니다.

| 월차 |          소유 금액 |       소유 가정 금액 |  세율 |        징수 금액 |       최종 금액 |
| -: | -------------: | -------------: | :-: | -----------: | ----------: |
|  1 | 1,000,000,000원 | 1,000,000,000원 | 99% | 990,000,000원 | 10,000,000원 |
|  2 |    10,000,000원 |    10,000,000원 | 99% |   9,900,000원 |    100,000원 |
|  3 |       100,000원 |       100,000원 | 51% |      51,000원 |     49,000원 |
|  4 |        49,000원 |        49,000원 | 50% |      24,500원 |     24,500원 |
|  5 |        24,500원 |        24,500원 | 50% |      12,250원 |     12,250원 |
|  6 |        12,250원 |        12,200원 | 50% |       6,100원 |      6,150원 |

입출력 예 #3

* 세율이 항상 0%이므로, 시민의 소유 금액은 30년(360개월) 동안 바뀌지 않습니다.

class Solution {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        int answer = -1;
        return answer;
    }
}


 */
public class Step2 {

    /*public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        long m = money;
        long rs = ranksize;
        long th = threshold;

        for (int i = 0; i < months; i++) {
            long assumed = (m / 100L) * 100L;     // 백의 자리 버림
            if (assumed < th) break;              // 면세 구간

            long levels = (assumed - th) / rs;    // ranksize마다 +1%
            long rate = minratio + levels;
            if (rate > maxratio) rate = maxratio;
            if (rate <= 0) break;                 // 세율 0%면 변화 없음

            long tax = (assumed * rate) / 100L;   // 정수 나눗셈(버림)
            if (tax <= 0) break;                  // 더 이상 줄지 않음

            m -= tax;
            if (m <= 0) {                         // 안전 클램프 (선택)
                m = 0;
                break;
            }
        }
        return (int) m;
    }*/

    public int solution(int money, int minratio, int maxratio,
                        int ranksize, int threshold, int months) {

        long m = money;
        final long rs = ranksize;
        final long th = threshold;

        for (int i = 0; i < months; i++) {
            long assumed = (m / 100L) * 100L;     // 백의 자리 버림
            if (assumed < th) break;              // 면세 구간 → 이후 변화 없음

            long levels = (rs == 0) ? 0 : (assumed - th) / rs; // rs는 ≥1이지만 안전망
            long rate = Math.min(maxratio, (long) minratio + levels);
            if (rate <= 0) break;                 // 세율 0%면 변화 없음

            long tax = (assumed * rate) / 100L;   // 정수 나눗셈(버림)
            if (tax == 0) break;                  // 더 이상 줄지 않음

            m -= tax;
            if (m <= 0) { m = 0; break; }         // 안전 클램프
        }
        return (int) m;
    }

    public static void main(String[] args) {
        Step2 sol = new Step2();

        int r1 = sol.solution(12_345_678, 10, 20, 250_000, 10_000_000, 4);
        int r2 = sol.solution(1_000_000_000, 50, 99, 100_000, 0, 6);
        int r3 = sol.solution(123_456_789, 0, 0, 1, 0, 360);

        System.out.println(r1); // 9000014
        System.out.println(r2); // 6150
        System.out.println(r3); // 123456789

    }
}
