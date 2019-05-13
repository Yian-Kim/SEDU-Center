/*
문서명 : DDL-06-TeacherEval.sql (6/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 유형 (tblType) -- line 19
02. 보기 (tblExample) -- line 37
03. 교사평가문제 (tblTeacherEval_Q) -- line 55
04. 교사평가답변 (tblTeacherEval_A) -- line 74
*/

-----------------------------------------------------------------------------------------
-- 01. 유형 (tblType)
-----------------------------------------------------------------------------------------

CREATE TABLE tblType -- 유형
(  
    type_seq NUMBER PRIMARY KEY, -- 번호(PK)
    type VARCHAR2(9) NOT NULL -- 유형 // 객관식 or 주관식
);

CREATE SEQUENCE Type_seq;

DROP TABLE tblType;
DROP SEQUENCE Type_seq;

SELECT * FROM tblType;


-----------------------------------------------------------------------------------------
-- 02. 보기 (tblExample)
-----------------------------------------------------------------------------------------

CREATE TABLE tblExample -- 보기
(
    example_seq NUMBER PRIMARY KEY, -- 번호(PK)
    content VARCHAR2(30) NOT NULL -- 보기내용 // 매우그렇다, 그렇다, 보통이다, 아니다, 매우아니다
);

create sequence example_seq;

DROP TABLE tblExample;
DROP SEQUENCE example_seq;

SELECT * FROM tblExample;


-----------------------------------------------------------------------------------------
-- 03. 교사평가문제 (tblTeacherEval_Q)
-----------------------------------------------------------------------------------------

CREATE TABLE tblTeacherEval_Q -- 교사평가문제
(
    evalQ_seq NUMBER PRIMARY KEY, -- 번호(PK)
    question VARCHAR2(150) NOT NULL, -- 문제 // 7문제 중 1~5 객관식 6,7 주관식
    type_seq NUMBER REFERENCES tblType(type_seq) NOT NULL -- 유형번호(FK)
);

CREATE SEQUENCE TeacherEval_Q;

DROP TABLE tblTeacherEval_Q;
DROP SEQUENCE TeacherEval_Q;

SELECT * FROM tblTeacherEval_Q;


-----------------------------------------------------------------------------------------
-- 04. 교사평가답변 (tblTeacherEval_A)
-----------------------------------------------------------------------------------------

CREATE TABLE tblTeacherEval_A -- 교사평가답변
(
    evalA_seq NUMBER PRIMARY KEY, -- 번호(PK)
    subjective_A VARCHAR2(900), -- 주관식답변
    objective_A NUMBER REFERENCES tblExample(example_seq), -- 객관식답변(FK)
    evalQ_seq NUMBER REFERENCES tblTeacherEval_Q(evalQ_seq) NOT NULL, -- 평가문제번호(FK)
    regiCourse_seq NUMBER REFERENCES tblRegiCourse(regiCourse_seq) NOT NULL -- 수강신청번호(FK) 
);

CREATE SEQUENCE TeacherEval_A_seq;

DROP TABLE tblTeacherEval_A;
DROP SEQUENCE TeacherEval_A_seq;

SELECT * FROM tblTeacherEval_A;
