package ploonet;

import java.util.*;

/*
*문제 설명

이 자판기는 상품이 빠져나오는 통로가 알파벳 대문자 L 모양으로 못 설계되어 무게가 w 미만인 상품을 구매하면 동로에 걸려 빠져나오지 않습니다.
통로에 걸린 상품은 자신의 위에 쌓인 상품의 무게 합이 자신의 무게 이상이 되어야 빠져나옵니다.
예든 들이 자판기 안 상품의 무게가 내려오는 순서대로 [5, 2, 3, 10, 5]이고 무게가 10 미만인 상품은 동로에 걸리는 자판기가 있다고 가정하겠습니다.


처음 버튼을 누르면 무게가 5인 첫 번째 상품이 통로에 걸립니다.
버튼을 두 번 더 누르면 무게가 2, 3인 상품 두 개가 위에 쌓입니다.

이때 첫 빈째 상품 위 에 쌓인 상품의 무게 합이 5 이상이 되어 첫 번째 상품이 빠져나옵니다.
다음으로 통로에 걸리는 두 번째 상품의 무게 2보다 위에 쌓인 상품의 무게 3이 더 크므로 무게가 2인 상품도 빠져나옵니다.
세 번째 상품(3)은 위에 쌓인 상품이 없고 무게가 w = 10 미만이라 통로에 걸립니다.
5(3이 2보다 커서 함께 배출 ) + 2(3이 2보다 커서 배출) = 7

네 번째로 버튼을 누르면 무게가 10인 상품이 쌓입니다.
세 번째 상품의 무게 3보다 위에 쌓인 상품의 무게 10이 더 크므로 무게가 3인 상품이 빠져나옵니다.
네 번째 상품은 무게가 w = 10 이상이므로 동로에 걸리지 않고 바로 빠져나옵니다.
3(위에가 10이니깐 배출) + 10(10 이상여서 배출) = 13

마지막으로 버튼을 누르면 무게가 5인 다섯 번째 상품이 동로에 걸려 빠져나오지 않습니다.
위 예시에서 세 번째, 네 번째로 버튼을 눌렀을 때 빠져나온 상품들의 무게 합은 순서대로 7, 13입니다.

상품의 무게를 담은 1차원 정수 배열 products 와 상품이 나올 때 통로에 걸리는 무게 기준을 의미하는 정수 w가 매개변수로 주어집니다.
이때 버튼 을 눌렀을 때 빠져나온 상품들의 무게 합 중 최댓값을 return 하도록 solution 함수를 완성해 주세요.
상품들이 한 번 이상 빠져나오는 입력만 주어집니다.

제한사항
• 1 <= products 의 길이 <= 1,000,000
	• 1 <= products[i] = 버튼을 i + 1 번째로 눌렀을 때 내려오는 상품의 무게 <= 10,000,000
• 1<= w <= 10,000,000
• 상품들이 한 번 이상 빠져나오는 입력만 주어집니다.

입출력 예
products				w		result
[5, 2, 3, 10, 5]		10		13
[8, 2, 2, 2, 1, 2]		9		15

입출력 예 설명
입출력 예 #1
문제 설명의 예시와 같습니다.

입출력 예 #2
처음 자판기에서 내려오는 무게가 8인 상품이 동로에 걸립니다. 이후 다섯 번째까지는 위에 쌓인 상품의 무게 함이 8 미만이므로 상품이 빠져나오지 않습니다.
마지막으로 무게가 2인 상품이 내려오면 위에 쌓인 상품의 무게 합이 9가 되어 무게가 8인 상품이 자판기에서 빠져나옵니다.
다음으로 동로에 걸리는 상품들보다 위에 쌓인 상품의 무게 합이 더 커 마지막 무게가 2인 상품을 제외하고 전부 자판기 밖으로 빠져나옵니다.
마지막에 버튼을 눌렀을 때 빠져나온 상품의 무게 함은 15입니다. 따라서 15를 return 해야 합니다.
*
* */

public class Test4 {

    public static int solution(int[] products, int w) {
        Deque<Integer> tunnel = new ArrayDeque<>();
        int maxReleased = 0;

        for (int product : products) {
            long released = 0;


            if (product < w) {
                tunnel.addLast(product);
            } else {

                released += product;
            }


            List<Integer> temp = new ArrayList<>(tunnel);
            long sumAbove = product >= w ? product : 0;
            int removeCount = 0;

            for (int i = temp.size() - 1; i >= 0; i--) {
                int stuck = temp.get(i);
                if (sumAbove >= stuck) {
                    sumAbove += stuck;
                    released += stuck;
                    removeCount++;
                } else {
                    break;
                }
            }


            for (int i = 0; i < removeCount; i++) {
                tunnel.pollLast();
            }

            maxReleased = (int) Math.max(maxReleased, released);
        }

        return maxReleased;
    }

    public static void main(String[] args) {
        Test4 sol = new Test4();

        System.out.println(sol.solution(new int[]{5, 2, 3, 10, 5}, 10)); // 13
        System.out.println(sol.solution(new int[]{8, 2, 2, 2, 1, 2}, 9)); // 15

    }
}
