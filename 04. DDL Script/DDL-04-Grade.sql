/*
문서명 : DDL-04-Grade.sql (4/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 성적정보 (tblGrade) -- line 20
*/

-----------------------------------------------------------------------------------------
-- 01. 성적정보 (tblGrade)
-----------------------------------------------------------------------------------------

CREATE TABLE tblGrade -- 성적정보
(
    grade_seq NUMBER PRIMARY KEY, -- 번호(PK)
    score NUMBER NULL, -- 점수
    testDate DATE NOT NULL, -- 시험날짜
    regiCourse_seq NUMBER REFERENCES tblRegiCourse(regiCourse_seq) NOT NULL, -- 수강신청번호(FK)
    openSubjectMgmt_seq NUMBER REFERENCES tblOpenSubjectMgmt(openSubjectMgmt_seq) NOT NULL -- 개설과목관리번호(FK)
);

CREATE SEQUENCE Grade_seq;
 
DROP TABLE tblGrade;
DROP SEQUENCE Grade_seq;

SELECT * FROM tblGrade;
