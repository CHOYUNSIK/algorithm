문제 설명
YOUTUBES 테이블은 스트리밍 서비스에 등록된 동영상의 정보를 담은 테이블입니다. YOUTUBES 테이블 구조는 다음과 같으며
ID , TITLE, CHANEL_TITLE, TAGS, VIENS, LIKES, DISLIKES는 각각 영상의 아이디, 제목, 채널 이름, 태그, 조회수, 좋아요 수, 싫어요 수를 나타냅니다.

NAME            TYPE        NULLABLE

ID              VARCHAR(N)  FALSE
TITLE           VARCHAR(N)  FALSE
CHANNEL_TITLE   VARCHAR(N)  FALSE
TAGS            JSON        FALSE
VIEWS           INTEGER     FALSE
LIKES           INTEGER     FALSE
DISLIKES        INTEGER     FALSE

문제
조회수가 가장 높은 영상 10개의 아이디와 제목, 조회수를 조회수가 높은 순으로 보여주는 SQL 문을 작성하세요. 모든 영상의 조회수가 다른 경우만 입력 으로 주어집니다.

예시
SQL 문을 실행하면 결과가 다음과 같은 형식으로 나와야합니다.
ID  TITLE  VIEWS
(row 수 10개)

~~~sql

SELECT ID, TITLE, VIEWS
FROM YOUTUBES
ORDER BY VIEWS DESC
LIMIT 10;

~~~

