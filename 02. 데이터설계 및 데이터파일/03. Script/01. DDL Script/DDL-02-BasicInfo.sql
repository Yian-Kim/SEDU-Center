/*
문서명 : DDL-02-BasicInfo.sql (2/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 과목 (tblSubject) -- line 18
02. 강의실 (tblRoom) -- line 37
03. 과정 (tblCourse) -- line 55
*/

-----------------------------------------------------------------------------------------
-- 01. 과목 (tblSubject)
-----------------------------------------------------------------------------------------

CREATE TABLE tblSubject -- 과목
(
    subject_seq NUMBER PRIMARY KEY NOT NULL,-- 번호(PK)
    name VARCHAR2(100) NOT NULL, -- 과목명
    period NUMBER NOT NULL -- 기간(몇일)
);

create sequence Subject_seq;

DROP TABLE tblSubject;
DROP SEQUENCE Subject_seq;

SELECT * FROM tblSubject;


-----------------------------------------------------------------------------------------
-- 02. 강의실 (tblRoom)
-----------------------------------------------------------------------------------------

CREATE TABLE tblRoom -- 강의실
(
    room_seq NUMBER PRIMARY KEY NOT NULL, -- 번호(PK)
    roomName VARCHAR2(12) NOT NULL -- 강의실명
);

create sequence room_seq;

DROP TABLE tblRoom;
DROP SEQUENCE room_seq;

SELECT * FROM tblRoom;


-----------------------------------------------------------------------------------------
-- 03. 과정 (tblCourse)
-----------------------------------------------------------------------------------------

CREATE TABLE tblCourse -- 과정
(
    course_seq NUMBER PRIMARY KEY NOT NULL, -- 번호(PK)
    name VARCHAR2(100) NOT NULL, -- 과정명
    period NUMBER NOT NULL -- 기간(몇일)
);

CREATE SEQUENCE Course_seq;

DROP TABLE tblCourse;
DROP SEQUENCE Course_seq;

SELECT * FROM tblCourse;
