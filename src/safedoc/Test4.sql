/*문제 설명
VIDEOS 테이블은 영화 정보를 담고 있는 테이블입니다.
VIDEOS 테이블 구조는 다음과 같으며, TITLE, RATE, NUM_VIEW, RELEASE_DATE, MPAA_RATE 는 각각 제목, 평점, 관람수, 개봉일, 영화 등급을 의미합니다.

NAME			TYPE			NULLABLE
ID				INT				FALSE
TITLE			VARCHAR(N)		FALSE
RATE			NUMERIC(N,N)	FALSE
NUM_VIEW		INT				FALSE
RELEASE_DATE	DATE			FALSE
MPAA_RATE		VARCHAR(N)		FALSE

문제
당신은 클라이언트로부터 등급별 영화들을 조회하는 SQL 문을 작성해달라는 요청을 받았습니다.
이 SQL의 실행결과 중 column은 순서대로 G, PG, PG-13, R, NC-17등급의 영화 제목을 담아야 합니다.
n번째 row에는 해당 등급 영화 중 n번째로 평점이 높은 영화 제목을 담아야 합니다.
만약 어떤 등급에서 n번째로 평점이 높은 영화가 없으면 해당 값은 0으로 설정하며, 만약 같은 등급에 같은 평점인 영화가 두 개 이상이면 알파벳순으로 앞에 있는 영화의 우선순위가 더 높습니다.

예시
예를 들어 다음과 같은 테이블로:

ID		TITLE									RATE	NUM_VIEW	RELEASE_DATE	MPAA_RATE
23918	Jaws: The Revenge						2.9		31779		20110309		PG-13
17771	Blue Demon								2.9		842			20110309		PG-13
32756	Jolly Roger: Massacre at Cutter's Cove	2.9		856			20110309		R
18810	Return to Two Moon Junction				3.0		453			20120220		NC-17
32756	Bloody Murder							3.0		1404		20110309		R
33832	Home Alone 3							4.3		79034		20110308		PG
6350	Beethoven's 5th							4.0		2096		20110309		G

SQL을 실행하면 다음과 같이 출력되어야 합니다:
G					PG				PG-13				R											NC-17
Beethoven's 5th		Home Alone 3	Blue Demon			Bloody Murder								Return to Two Moon Junction
0					0				Jaws: The Revenge	Jolly Roger: Massacre at Cutter's Cove		0*/

WITH ranked_movies AS (
    SELECT
        MPAA_RATE,
        TITLE,
        RATE,
        ROW_NUMBER() OVER (
            PARTITION BY MPAA_RATE
            ORDER BY RATE DESC, TITLE ASC
        ) AS rnk
    FROM VIDEOS
),
     pivoted AS (
         SELECT
             MAX(CASE WHEN MPAA_RATE = 'G' THEN TITLE ELSE '0' END) AS G,
             MAX(CASE WHEN MPAA_RATE = 'PG' THEN TITLE ELSE '0' END) AS PG,
             MAX(CASE WHEN MPAA_RATE = 'PG-13' THEN TITLE ELSE '0' END) AS `PG-13`,
             MAX(CASE WHEN MPAA_RATE = 'R' THEN TITLE ELSE '0' END) AS R,
             MAX(CASE WHEN MPAA_RATE = 'NC-17' THEN TITLE ELSE '0' END) AS `NC-17`,
             rnk
         FROM ranked_movies
         GROUP BY rnk
     )
SELECT G, PG, `PG-13`, R, `NC-17`
FROM pivoted
ORDER BY rnk;
