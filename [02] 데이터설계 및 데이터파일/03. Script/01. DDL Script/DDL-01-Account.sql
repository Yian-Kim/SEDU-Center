/*
문서명 : DDL-01-Account.sql (1/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 관리자 계정 (tblAdmin) -- line 18
02. 교사 계정 (tblTeacher) -- line 37
03. 학생 계정 (tblStudent) -- line 57
*/

-----------------------------------------------------------------------------------------
-- 01. 관리자 계정 (tblAdmin)
-----------------------------------------------------------------------------------------

CREATE TABLE tblAdmin -- 관리자 계정
(
    admin_seq NUMBER PRIMARY KEY NOT NULL, -- 번호(PK)
    id VARCHAR2(30) NOT NULL, -- 아이디
    pw VARCHAR2(14) NOT NULL -- 비밀번호
);

CREATE SEQUENCE Admin_seq;

DROP TABLE tblAdmin;
DROP SEQUENCE Admin_seq;

SELECT * FROM tblAdmin;


-----------------------------------------------------------------------------------------
-- 02. 교사 계정 (tblTeacher)
-----------------------------------------------------------------------------------------

CREATE TABLE tblTeacher --교사 계정
(
    teacher_seq NUMBER PRIMARY KEY NOT NULL, -- 번호(PK)
    name VARCHAR2(30) NOT NULL, -- 교사명
    pw VARCHAR2(14) NOT NULL, -- 비밀번호
    tel VARCHAR2(13) NOT NULL -- 연락처
);

create sequence teacher_seq;

DROP TABLE tblTeacher;
DROP SEQUENCE teacher_seq;

SELECT * FROM tblTeacher;


-----------------------------------------------------------------------------------------
-- 03. 학생 계정 (tblStudent)
-----------------------------------------------------------------------------------------

CREATE TABLE tblStudent -- 학생 계정
(
    student_seq NUMBER PRIMARY KEY NOT NULL, -- 번호(PK)
    name VARCHAR2(30) NOT NULL, -- 학생명
    pw VARCHAR2(14) NOT NULL, -- 주민번호
    tel VARCHAR2(13) NOT NULL, -- 연락처
    regiDate DATE NOT NULL, -- 등록일
    major VARCHAR2(30) NOT NULL -- 학과  
);
 
CREATE SEQUENCE student_seq;

DROP TABLE tblStudent;
DROP SEQUENCE student_seq;

SELECT * FROM tblStudent;
