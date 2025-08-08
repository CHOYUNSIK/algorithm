/*SQL: 온라인 호스팅 고객 패널을 위한 대시보드 보고서

역동적인 웹 호스팅 환경에서 고객에게 자산에 대한 명확한 개요를 제공하는 것은 사용자 경험을 향상시키 는 데 매우 중요합니다. 개발팀은 모든 고객과 고객이 보유한 활성 웹사이트 수에 대한 대시보드 보고서를 생 성하는 온라인 호스팅 고객 패널 기능을 개발해야 합니다.
결과에는 다음 열이 포함되어야 합니다: email, tota_active_sites .
• email- 고객의 이메일 주소
• tota_active_sites - 각 고객의 총 활성 웹사이트 수
결과는 이메일 기준으로 오름차순으로 정렬됩니다.
메모:
• 활성화된 웹사이트만 포함해야 합니다.

schema

<customer>
Name	Type  			Constraints		Description
id		INT				PRIMARY KEY		The identifier of the customer
email	VARCHAR(255)					The email address of the customer

<sites>
Name			Type			Constraints									Description
customer_id		INT				FOREIGN KEY(customer _id => customers.id)	The reference to the customer
url				VARCHAR(255)												The URL of the website
is_active		BOOLEAN														The status of the website



Sample Data Tables
<customer>
id		email
1		dcristofol0@slashdot.org
2		mbillanie1@japanpost.jp
3		hmainz2@utexas.edu

<sites>
customer	url 								is_active
1			https://trellian.com				1
1           https://www.google.de				1
1           https://merriam-webster.com			1
1           https://wordpress.com				1
1           https://nsw.gov.au					1
1           https://www.barnesandnoble.com		1
1           https://www.yahoo.com				1
2           https://cloudflare.com				0
2           https://www.is.gd					1
2           https://www.unesco.org				1
3           https://www.sina.com.cn				0
3           https://xinhuanet.com				1
3           https://cyberchimps.com				1
3           https://ask.com						1
3           https://businessinsider.com			1
3           https://www.dailymail.co.uk			1
3           https://www.guardian.co.uk			1
3           https://www.microsoft.com			1
3           https://www.gizmodo.com				1
3           https://www.163.com					1

sample output

email						total_active_sites
dcristofol0@slashdot.org	7
mbillanie1@japanpost.jp		9
hmainz2@utexas.edu			2
*/

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
