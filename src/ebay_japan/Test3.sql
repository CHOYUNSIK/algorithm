/*
MySQL

문제 설명

CARD_USAGES 테이블은 어느 회사원의 카드 사용 내역을 담은 테이블입니다.
CARD_USAGES 테이블의 구조는 다음과 같으며, ID, CREATED_AT, CATEGORY, AMOUNT, MERCHANT_ID 는 각각 아이디, 사용일, 구분(0이면 결제 1이면 취소), 금액, 결제 가맹점 아이디를 나타냅니다.

| NAME         | TYPE     | NULLABLE |
| ------------ | -------- | -------- |
| ID           | INT      | FALSE    |
| CREATED_AT   | DATETIME | FALSE    |
| CATEGORY     | INT      | FALSE    |
| AMOUNT       | INT      | FALSE    |
| MERCHANT_ID  | INT      | FALSE    |


MERCHANTS 테이블은 XX 카드 가맹점 정보를 담은 테이블입니다.
MERCHANTS 테이블의 구조는 다음과 같으며, ID, NAME, BUSINESS_ID, TAX_TYPE, CATEGORY_ID 는 각각 아이디, 상호명, 사업자등록번호, 과세유형, 업종분류아이디를 나타냅니다. ID는 기본키입니다.

| NAME         | TYPE    |
| ------------ | ------- |
| ID           | INT     |
| NAME         | VARCHAR |
| BUSINESS_ID  | VARCHAR |
| TAX_TYPE     | VARCHAR |
| CATEGORY_ID  | INT     |


문제

카드 가맹점별로 언제 누적 매출이 110000보다 많아졌는지 구하려고 합니다.
가맹점의 아이디, 가맹점의 이름, 누적 매출이 110000보다 많아졌을 때 결제일, 누적 매출이 110000보다 많아졌을 때 누적 매출을 구하는 SQL 문을 작성해주세요.
전체 누적 매출이 110000 이하인 가맹점은 결과에 포함되지 않아야 합니다.

단, 구분이 '취소'인 카드 사용 내역은 고려하지 않습니다.
카드 사용 내역 중에서 가맹점과 결제일이 모두 같은 경우는 주어지지 않습니다.

결과는 가맹점의 아이디를 기준으로 오름차순 정렬해주세요.

예시

예를 들어 CARD_USAGES, MERCHANTS 테이블이 다음과 같다면

**CARD_USAGES**

| ID     | CREATED_AT          | CATEGORY | AMOUNT | MERCHANT_ID  |
| ------ | ------------------- | -------- | ------ | ------------ |
| 225018 | 2018-05-11 14:42:34 | 0        | 3700   | 9449         |
| 225019 | 2018-05-12 13:22:14 | 0        | 19700  | 9449         |
| 231374 | 2018-05-11 20:43:24 | 0        | 67750  | 9842         |
| 231375 | 2018-05-11 20:43:24 | 1        | -67750 | 9842         |
| 255259 | 2018-05-15 16:01:16 | 0        | 47870  | 9842         |
| 312442 | 2018-09-21 18:33:21 | 0        | 14403  | 9842         |

**MERCHANTS**

| ID    | NAME          | BUSINESS_ID  | TAX_TYPE  | CATEGORY_ID  |
| ----- | ------------- | ------------ | --------- | ------------ |
| 9449  | 지에스25 강남2차칼튼점 | 330-20-00457 | 일반과세자     | 2            |
| 9842  | 주식회사아다스트리아코리아 | 106-87-04232 | 일반과세자     | 6            |
| 14479 | 딸부자네쌀빵강남역점    | 894-85-00042 | 일반과세자     | 1            |

* 아이디가 9449인 가맹점의 누적 매출은 3700 + 19700 = 23400입니다. 전체 누적 매출이 110000 이하이므로 결과에 포함되지 않아야 합니다.
* 아이디가 9842인 가맹점의 누적 매출은 67750 + 47870 + 14403 = 130023입니다. 47870이 추가되었을 때 누적 매출이 115620로 110000을 넘습니다. 아이디가 231375인 사용 내역은 구분이 ‘취소’이기 때문에 고려하지 않습니다.
* 아이디가 14479인 가맹점은 결제 내역이 없습니다. 따라서 결과에 포함되지 않아야 합니다.

따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.

| ID   | NAME          | CREATED_AT         | PRICE  |
| ---- | ------------- | ------------------- | ------ |
| 9842 | 주식회사아다스트리아코리아 | 2018-05-15 16:01:16 | 115620 |


  */

WITH pay AS (
    SELECT
        cu.merchant_id,
        cu.created_at,
        SUM(cu.amount) OVER (
            PARTITION BY cu.merchant_id
            ORDER BY cu.created_at
            ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
        ) AS running_sum
    FROM CARD_USAGES cu
    WHERE cu.category = 0
),
     first_cross AS (
         SELECT
             merchant_id,
             created_at,
             running_sum,
             ROW_NUMBER() OVER (
            PARTITION BY merchant_id
            ORDER BY created_at
        ) AS rn
         FROM pay
         WHERE running_sum > 110000
     )
SELECT
    m.id        AS id,
    m.name      AS name,
    f.created_at,
    f.running_sum AS price
FROM first_cross f
         JOIN MERCHANTS m
              ON m.id = f.merchant_id
WHERE f.rn = 1
ORDER BY m.id;


