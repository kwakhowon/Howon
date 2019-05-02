--게시판(Bulletin Board System) 테이블 생성
CREATE TABLE BBS(
    ARTICLE_NUMBER NUMBER PRIMARY KEY,
    ID VARCHAR2(15) NOT NULL,
    TITLE VARCHAR2(15) NOT NULL,
    CONTENT CLOB NOT NULL,
    GROUP_ID NUMBER NOT NULL,
    DEPTH NUMBER NOT NULL,
    POS NUMBER NOT NULL,    --position, 게시글 순서를 조정
    HIT NUMBER NOT NULL,    --조회수
    WRITE_DATE DATE NOT NULL,
    FILE_NAME VARCHAR2(300)
);
 
--시퀀스 생성
CREATE SEQUENCE BBS_SEQ
 START WITH 1
INCREMENT BY 1;

/*
 OracleDBConnector클래스, BBSOracleDao클래스를 그대로 사용하도록 한다.
  단 OracleDBConnector클래스의 getConnection()메서드에 주석 처리해둔 
 core.log를 사용하여 쿼리문과 결과를 콘솔에 찍도록 한다. 
 core.log를 사용하기 위해서는 http://log4sql.sourceforge.net/에서 log4sql.jar를 
  다운받아 톰캣 폴더의 lib폴더에 넣어줘야 한다.




*/
-- **
-- 게시글 리스트 출력하는 방법의 과정
-- **
 
SELECT rownum, bbs.*
  FROM bbs
 WHERE rownum BETWEEN 10 AND 20;
--BETWEEN A AND B에서 A의 값이 1이 아니라면 rownum은 순서를 찾을 수 없다.
--아무런 결과가 출력되지 않을 것이다.
--쿼리를 실행하면 WHERE절부터 수행하기 때문에 SELECT 하기 전까지 rownum을 찾을 수 없기 때문이다.
 
 
SELECT bbs.*
  FROM (
        SELECT rownum AS row_num, bbs.*   --rownum은 익명으로 사용해야한다
          FROM bbs
        --결과는 출력되지만,
        --게시글의 순서를 최신순(group_id DESC), 본글과 답글순(pos ASC)으로 정렬이 필요하다.
       ) bbs
 WHERE row_num BETWEEN 10 AND 20;
 
 
SELECT bbs.*
  FROM (
        SELECT rownum AS row_num, bbs.*   --rownum은 익명으로 사용해야한다.
          FROM bbs
         ORDER BY group_id DESC, pos ASC  --게시글 순서 정렬
       ) bbs
 WHERE row_num BETWEEN 10 AND 20;
--원하는 데이터를 가져오지 못한다.
--ORDER BY가 rownum값을 만드는 데 영향을 주지 않는 듯 하다.
 
 
SELECT rownum, bbs.*
  FROM (
        SELECT bbs.*
          FROM bbs
         ORDER BY group_id DESC, pos ASC
       ) bbs
 WHERE rownum BETWEEN 10 AND 20;   --처음과 같이 rownum을 찾을 수 없다.
--만약 rownum이 무조건 1부터 시작한다면 더이상의 과정은 필요없다.
--'답글 보기' 기능에는 이 방식을 사용할 것이다.
 
 
--위와 같은 과정을 통해서 이러한 쿼리문이 만들어졌다.
SELECT bbs.*
  FROM (
        SELECT rownum AS row_num, bbs.*
          FROM (
                SELECT bbs.*
                  FROM bbs
                 ORDER BY group_id DESC, pos ASC
               ) bbs
       ) bbs
 WHERE row_num BETWEEN 10 AND 20;

CREATE TABLE users(
  id VARCHAR2(15) PRIMARY KEY,
  pw VARCHAR2(15) NOT NULL
);

 
INSERT INTO users VALUES('kglim', '1004');
 
COMMIT;


--댓글 테이블 생성
CREATE TABLE comments(
  comment_number NUMBER PRIMARY KEY,
  id VARCHAR2(15) NOT NULL,
  comment_content VARCHAR2(200) NOT NULL,
  comment_date DATE NOT NULL,
  article_number NUMBER NOT NULL,
  --글이 지워지면 해당 답글도 지워져야 한다.
  --article_number > delete option : cascade
CONSTRAINT comment_fk FOREIGN KEY(article_number)
REFERENCES bbs(article_number) ON DELETE CASCADE);
 
--댓글 시퀀스 생성
CREATE SEQUENCE comment_seq
 START WITH 1
INCREMENT BY 1;
