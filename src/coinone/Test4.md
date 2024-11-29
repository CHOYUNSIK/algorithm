
문제 설명
EMPLOYEES 테이블은 자동차 판매 회사에서 일하고 있는 직원의 정보가 담긴 테이블입니다. ENPLOYEES 테이블 구조는 다음과 같으며,
ID, MAME, SALARY, BRANCH_ID는 각각 직원의 아이디, 이름, 월급, 근무하는 대리점 아이디를 나타냅니다.

NAME    TYPE            NULLABLE

ID          INT             FALSE
NAME        VARCHAR(N)      FALSE
SALARY      NUMERIC(N,M)    FALSE
BRANCH_ID   INT             FALSE

문제
EMPLOYEES 테이블을 이용해 각 사원과 같은 지점에 근무하는 동료가 몇 명인지 조회하는 SQL 문을 작성해주세요.
단, 결과는 직원의 ID 순으로 정렬되어야 합니다.

예시
예를 들어 EMPLOYEES 테이블이 다음과 같다면

ID      NAME    SALARY  BRANCHJD
4603    Alayna  180     15
3021    Kassidy 960     16
864     Holly   330     15
2842    Куrа    280     16
2716    Audrina 870     16

    1. Alayna와 같은 지점에 근무하는 1명(Holly) 입니다.
    2. Kassidy와 같은 지점에 근무하는 직원은 2명(Kyra, Audrina) 입니다.
    3. Holly와 같은 지점에 근무하는 직원은 1명(Alayna) 입니다.

(이하 생략)

따라서 SQL을 실행하면 다음과 같이 출력되어야 합니다.
   
ID      NAME    NUMCOWORKER
864     Holly   1
2716    Audrina 2
2842    Куrа    2
3021    Kassidy 2
4603    Alayna  1

~~~sql

SELECT
    A.ID,
    A.NAME,
    COUNT(B.ID) - 1 AS NUMCOWORKER
FROM
    EMPLOYEES A
        JOIN
    EMPLOYEES B ON A.BRANCH_ID = B.BRANCH_ID
GROUP BY
    A.ID, A.NAME
ORDER BY
    A.ID;


~~~

~~~sql

SELECT E.ID, E.NAME, COUNT(E2.ID) AS NUMCOWORKER
FROM EMPLOYEES E
JOIN EMPLOYEES E2 ON E.BRANCH_ID = E2.BRANCH_ID AND E.ID != E2.ID
GROUP BY E.ID, E.NAME
ORDER BY E.ID;

~~~

~~~sql

SELECT 
    E.ID, 
    E.NAME, 
    (SELECT COUNT(*) 
     FROM EMPLOYEES E2 
     WHERE E.BRANCH_ID = E2.BRANCH_ID AND E.ID != E2.ID) AS NUMCOWORKER
FROM 
    EMPLOYEES E
ORDER BY 
    E.ID;


~~~
