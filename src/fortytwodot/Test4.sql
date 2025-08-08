/*### 문제 설명

`EMPLOYEES` 테이블은 자동차 판매 회사에서 일하고 있는 직원의 정보를 담고 있는 테이블입니다.
`EMPLOYEES` 테이블 구조는 다음과 같으며, `ID`, `NAME`, `SALARY`, `BRANCH_ID`는 각각 직원의 아이디, 이름, 월급, 근무하는 대리점 아이디를 나타냅니다.

|NAME|TYPE|NULLABLE|
|---|---|---|
|ID|INT|FALSE|
|NAME|VARCHAR(N)|FALSE|
|SALARY|NUMERIC(N,M)|FALSE|
|BRANCH_ID|INT|FALSE|

`SELLINGS` 테이블은 자동차 판매 회사의 2016년 하반기 판매 기록을 담고 있는 테이블입니다.
`SELLINGS` 테이블 구조는 다음과 같으며, `CAR_ID`, `EMPLOYEE_ID`, `CREATED_AT`, `PRICE`는 각각 판매한 자동차 ID, 판매한 사원 ID, 판매일, 판매 가격을 나타냅니다.

|NAME|TYPE|NULLABLE|
|---|---|---|
|CAR_ID|INT|FALSE|
|EMPLOYEE_ID|INT|FALSE|
|CREATED_AT|DATETIME|FALSE|
|PRICE|NUMERIC(N,M)|FALSE|
다음은 이미지에 포함된 텍스트를 그대로 옮긴 내용입니다:

---

### 문제

판매 성적을 기준으로 사원을 평가하기 위해 자동차를 많이 판매한 순으로 판매 수, 사원의 이름을 조회하는 SQL문을 작성해 주세요.
만약 판매 수가 같은 사원이 여럿이고, 이 판매 수가 최대 판매 수인 경우는 사원들의 이름을 한 줄씩 보여줍니다.
만약 판매 수가 같은 사원이 여럿이고(N명), 이 판매 수가 최대 판매 수가 아닌 경우에는 `"이이디가 최소인 사원의 이름 and N-1 other"`을 보여줍니다.

---

### 예시

예를 들어 `EMPLOYEES` 테이블과 `SELLINGS` 테이블이 각각 다음과 같으면

**EMPLOYEES 테이블:**

|ID|NAME|SALARY|BRANCH_ID|
|---|---|---|---|
|308|Reagan|890|66|
|316|Brielle|970|42|
|318|Isabel|890|33|
|322|Reese|930|57|
|329|Gracie|570|37|

**SELLINGS 테이블:**

|CAR_ID|EMPLOYEE_ID|CREATED_AT|PRICE|
|---|---|---|---|
|852|308|20160716161144|2000|
|616|308|20160818015911|29100|
|980|308|20161220233506|18500|
|463|316|20161109205942|28500|
|1254|316|20161225122641|20300|
|1875|316|20161228200614|9000|
|933|318|20161209182436|19500|
|1261|318|20161227232623|17500|
|1286|322|20160928012557|3800|
|1738|322|20161021174211|25300|
|1584|329|20160728021306|12200|

SQL을 실행하면 다음과 같이 출력되어야 합니다.

|COUNT|DESCRIPTION|
|---|---|
|3|Brielle|
|3|Reagan|
|2|Isabel and 1 other|
|1|Gracie|*/

WITH SALES_COUNT AS (
    SELECT
        E.ID,
        E.NAME,
        COUNT(*) AS CNT
    FROM
        SELLINGS S
            JOIN
        EMPLOYEES E ON S.EMPLOYEE_ID = E.ID
    GROUP BY
        E.ID, E.NAME
),
     RANKED_SALES AS (
         SELECT
             CNT,
             COUNT(*) OVER (PARTITION BY CNT) AS CNT_TIE,
                 MAX(CNT) OVER () AS MAX_CNT,
                 ID,
             NAME,
             ROW_NUMBER() OVER (PARTITION BY CNT ORDER BY ID) AS RN
         FROM
             SALES_COUNT
     )
SELECT
    CNT AS COUNT,
    CASE
        WHEN CNT = MAX_CNT THEN NAME
        WHEN RN = 1 THEN NAME || ' and ' || (CNT_TIE - 1) || ' other'
        ELSE NULL
END AS DESCRIPTION
FROM
    RANKED_SALES
WHERE
    CNT = MAX_CNT OR RN = 1
ORDER BY
    CNT DESC;

