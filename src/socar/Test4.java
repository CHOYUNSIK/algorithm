package socar;

import java.util.HashMap;
import java.util.Map;

/*
정확성 시간 제한 / 메모리 제한
10초/ 2GB

문제 설명
당신은 TFT(Ticket Finding Tactics)라는 게임을 플레이하고 있습니다.
이 게임은 주어진 자금으로 황금 티켓을 최대한 많 이 모으는 것이 목표입니다.
당신이 이 게임에서 할 수 있는 행동은 다음과 같습니다.
    1. 상점에서 일반 티켓 구매하기
    2. 상점 새로고침하기
    3. 동일한 일반 티켓 3개를 황금 티켓 1개로 교환하기

상점에는 일반 티켓 m 개가 진열되어 있습니다. 당신은 티켓의 가격을 지불하여 진열되어있는 티켓 중 원하는 티켓을 구매 할 수 있습니다.
또, 일정 금액을 상점에 지불하고 상점을 최대 n - 1번 새로고침 할 수 있습니다. 새로고침이란, 상점에 진열 중이던 티켓을 모두 폐기하고 새로운 일반 티켓 m 개를 진열하는 행동입니다.

당신은 상점에 진열되는 티켓의 패턴을 분석하여 상점을 새로고침 했을 때 매번 어떤 티켓이 진열될지 예측하는 데 성공했습니다.
당신은 예측한 결과를 바탕으로 황금 티켓을 가장 많이 모을 수 있는 방법으로 자금을 사용하려 합니다.
다음은 상점에서 티켓을 구매하여 황금 티켓을 모으는 예시입니다.
<일반 티켓의 종류>
티켓 이름 | 가격
---------------
A       |   1
B       |   2
C       |   5
D       |   3
<상점의 티켓 진열 예측>
상점 순서    |   진열 티켓
--------------------------
최초 상점    |   B, С, В, С
두 번째 상점  |  A, A, А, В
세 번째 상점  |  D, D, C, D

일반 티켓의 종류와 상점의 티켓 진열 패턴이 위 표와 같고, 상점 새로고침에 필요한 금액이 10, 당신에게 주어진 자금이 30 이라고 가정해 보겠습니다.
최초 상점에서 "B" 2개를 구매하고, 새로고침 한 뒤, 두 번째 상점에서 "A" 3개, "B" 1개 를 구매하면 총 2 x 2 + 10 + 1 x 3 + 2 x 1= 19 만큼 자금을 사용해 "A" 3개, "B" 3개를 구매할 수 있습니다.
"A" 3개, "B" 3개를 황금 티켓 2개로 교환할 수 있으며, 이보다 더 많은 황금 티켓을 모으는 방법은 없습니다.

게임에 등장하는 모든 일반 티켓의 정보가 담긴 문자열 배열 tickets , 상점 새로고침에 필요한 금액을 나타내는 정수 roll ,
상점의 새로고침 예측이 담긴 2차원 문자열 배열 Shop 과 당신에게 주어진 자금을 나타내는 정수 money 가 매개 변수로 주어집니다.
이때 모을 수 있는 황금 티켓 개수의 최댓값을 return 하도록 solution 함수를 완성해주세요.

제한사항
    • 1s <= tickets 의 길이 <= 1,000
    • tickets 의 원소는 "TICKET_NAME TICKET_PRICE 형태입니다.
        • TICKET_NAME은 티켓의 이름을 나타내며, 알파벳 대문자로만 구성된 길이 1~10 사이인 문자열입니다.
        • TICKET_PRICE는 티켓의 가격을 나타내며, 1~10000 사이의 숫자입니다.
        • TICKET_NAME(티켓의 이름)이 중복된 입력은 주어지지 않습니다.
• 1 <= roll <= 10,000
• 1 <= shop 의 길이 <= n <= 1,000
    • shop[i] 는 새로고침을 i번 했을 때 상점에 진열되는 티켓들의 이름을 담고 있습니다.
    • 0 <= i <= n-1
    • shop 의 길이 이상 새로고침 할 수는 없습니다.
    • 1 <= shop[i]의길이 = m <= 100
        • tickets 에 나타난 티켓의 이름만 담겨있습니다.
• 1 <= money <= 100,000,000

입출력 예
tickets                         | roll | shop                                                                | money  | result
-------------------------------------------------------------------------------------------------------------------------------
["A 1", "B 2", "С 5", "D 3"]    | 10   | [["B", "C", "B", "C"], ["A", "A", "A", "B"], ["D", "D", "C", "D"]]  | 30     | 2
["A 1", "B 2", "С 5", "D 3"]    | 10   | [["В", "C", "B", "C"], ["A", "A", "A", "B"], ["D", "D", "C", "D"]]  | 100    | 4
["А 2", "В 1"]                  | 1    | [["A", "A', "A"], ["A", "B", "B"], ["A", "B", "B"], ["A", "B", "B"]] | 9      | 2
["А 2", "В 1"]                  | 5    | [["A', "A", "A"], ["A", "B", "B"], ["A", "B", "B"], ["A", "B", "B"]] | 19     | 2
입출력 예 설명

입출력 예#1
문제 예시와 같습니다.

입출력 예 #2
처음 주어지는 자금인 money 가 두 번의 새로고침 비용과 모든 티켓 비용을 지불하고도 남을 만큼 충분합니다. 따라서 상점에 등장하 는 모든 티켓을 구매하면, 황금 티켓 4개를 모을 수 있습니다.

입출력 예#3
다음과 같은 방법으로 황금 티켓 2개를 모을 수 있으며, 이보다 더 많은 황금 티켓을 모으는 방법은 없습니다.
1. 첫 번째 상점에서 티켓을 구매하지 않고 새로고침 합니다.
2. 두 번째 상점에서 "B" 2개를 구매하고 새로고침 합니다.
3. 세 번째 상점에서 "B" 2개를 구매하고 새로고침 합니다.
4. 네 번째 상점에서 "B" 2개를 구매합니다.
5."B" 6개를 황금 티켓 2개와 교환할 수 있습니다.

입출력 예 #4
다음과 같은 방법으로 2개의 황금 티켓을 모을 수 있으며, 이보다 더 많은 황금 티켓을 모으는 방법은 없습니다.
1. 첫 번째 상점에서 "A" 3개를 구매하고 새로고침 합니다.
2. 두 번째 상점에서 "B" 2개를 구매하고 새로고침 합니다.
3. 세 번째 상점에서 "B" 1개를 구매합니다.
4. "A" 3개, "B" 3개를 황금 티켓 2개와 교환할 수 있습니다.

* */
public class Test4 {
    // 티켓 가격 정보를 저장할 맵


    public static void main(String[] args) {
        // 테스트 케이스 예시
        String[] tickets1 = {"A 1", "B 2", "C 5", "D 3"};
        int roll1 = 10;
        String[][] shop1 = {{"B", "C", "B", "C"}, {"A", "A", "A", "B"}, {"D", "D", "C", "D"}};
        int money1 = 30;

        String[] tickets2 = {"A 1", "B 2", "C 5", "D 3"};
        int roll2 = 10;
        String[][] shop2 = {{"B", "C", "B", "C"}, {"A", "A", "A", "B"}, {"D", "D", "C", "D"}};
        int money2 = 100;

        String[] tickets3 = {"A 2", "B 1"};
        int roll3 = 1;
        String[][] shop3 = {{"A", "A", "A"}, {"A", "B", "B"}, {"A", "B", "B"}, {"A", "B", "B"}};
        int money3 = 9;

        String[] tickets4 = {"A 2", "B 1"};
        int roll4 = 5;
        String[][] shop4 = {{"A", "A", "A"}, {"A", "B", "B"}, {"A", "B", "B"}, {"A", "B", "B"}};
        int money4 = 19;

        // 결과 출력
        System.out.println("Result 1: " + new Test4().solution(tickets1, roll1, shop1, money1));
        System.out.println("Result 2: " + new Test4().solution(tickets2, roll2, shop2, money2));
        System.out.println("Result 3: " + new Test4().solution(tickets3, roll3, shop3, money3));
        System.out.println("Result 4: " + new Test4().solution(tickets4, roll4, shop4, money4));
    }

    public static int solution(String[] tickets, int roll, String[][] shop, int money) {
        Map<String, Integer> ticketPrices = new HashMap<>();
        for (String ticketInfo : tickets) {
            String[] parts = ticketInfo.split(" ");
            ticketPrices.put(parts[0], Integer.parseInt(parts[1]));
        }

        int maxGoldTickets = 0;

        // 초기 자금에서 새로고침 비용을 빼고 시작합니다.
        // 모든 상점을 순회합니다.
        for (int i = 0; i < shop.length && money >= roll; i++) {
            // 상점을 새로고침할 때마다 비용이 듭니다. 첫 상점은 새로고침 비용이 없습니다.
            if (i > 0) {
                money -= roll;
            }

            // 현재 상점에서 구매할 수 있는 최대 황금 티켓 수를 계산합니다.
            Map<String, Integer> ticketCounts = new HashMap<>();
            for (String ticket : shop[i]) {
                if (money >= ticketPrices.get(ticket)) {
                    ticketCounts.put(ticket, ticketCounts.getOrDefault(ticket, 0) + 1);
                    money -= ticketPrices.get(ticket); // 티켓 구매에 사용된 금액을 빼줍니다.
                }
            }

            // 황금 티켓으로 교환합니다.
            for (Map.Entry<String, Integer> entry : ticketCounts.entrySet()) {
                maxGoldTickets += entry.getValue() / 3; // 3개의 일반 티켓으로 1개의 황금 티켓을 얻습니다.
            }
        }

        return maxGoldTickets;
    }


}
