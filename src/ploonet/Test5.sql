/*PAYMENTS 테이블은 XX런 게임의 캐시 충전 내역을 담은 테이블입니다. PAYMENTS 테이블의 구조는 다음과 같으며,
ID, USER_ID, AMOUNT, PAY_DATE, PAYMENT_TYPE은 각각 ID, 유저의 ID, 충전액, 충전일, 충전 방법을 나타냅니다.

NAME			TYPE
ID				INT
USER_ID			VARCHAR
AMOUNT			INT
PAY_DATE		DATETIME
PAYMENT_TYPE	INT

문제
2016년 11월 15일 이후로 한 번에 20,000원 이상의 금액을 충전한 기록이 있는 유저의 ID를 나타내는 SQL문을 작성해주세요. 각 유저의 ID는 한 번씩만 나타나야 합니다.
결과는 유저의 ID든 기준으로 사전 순 정렬해 주세요.


예시
예들 들어 PAYMENTS 테이블이 다음과 같다면,
PAYMENTS


ID		USER_ID		AMOUNT		PAY_DATE				PAYMENT_TYPE
1		userl		40000		2016-11-11 13:00:00		0
2		user2		50000		2016-11-20 14:00:00		1
3		user2		30000		2016-11-27 15:00:00		1
4		user3		2570		2016-11-29 13:00:00		1
5		user4		20000		2016-11-15 00:00:00		1
6		user5		15000		2016-12-03 14:00:00		1
7		user5		15000		2016-12-05 17:00:00		1
• user1은 한 번에 40,000원을 충전한 기록이 있습니다. 하지만 2016년 11월 15일 이전 기록이므로 결과에 포함하지 않습니다.
• user2는 한 번에 20,000원 이상을 충전한 기록이 2016년 11월 15일 이후에 있습니다.
• user3은 한 번에 20,000원 이상을 충전한 기록이 없습니다.
• user4는 한 번에 20,000원 이상을 충전한 기록이 2016년 11월 15일 이후에 있습니다.
• user5의 충전 금액 합은 30,000원이지만 한 번에 20,000원 이상을 충전한 기록이 없습니다.
따라서 SQL 문을 실행하면 다음과 같이 출력되어야 합니다.

USER_ID
user2
user4*/

SELECT DISTINCT USER_ID
FROM PAYMENTS
WHERE PAY_DATE > '2016-11-15'
  AND AMOUNT >= 20000
ORDER BY USER_ID;
