/*
문서명 : DDL-05-Attendance_n_Result.sql (5/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 근태관리 (tblAttendanceMgmt) -- line 17
02. 수료여부 (tblResult) -- line 39
*/

-----------------------------------------------------------------------------------------
-- 01. 근태관리 (tblAttendanceMgmt)
-----------------------------------------------------------------------------------------

CREATE TABLE tblAttendanceMgmt -- 근태관리
(
    attendanceMgmt_seq NUMBER PRIMARY KEY, -- 번호(PK)
    attendDate DATE NOT NULL, -- 날짜
    workOn DATE, -- 출근시간 // 9시 기준
    workOff DATE, -- 퇴근시간 // 5시 50분 기준
    state VARCHAR2(10), -- 근태상황 // 정상, 결석, 지각, 조퇴, 병가, 기타
    regiCourse_seq NUMBER REFERENCES tblRegiCourse(regiCourse_seq) NOT NULL -- 수강신청번호(FK)
);

CREATE SEQUENCE AttendanceMgmt_seq;

DROP TABLE tblAttendanceMgmt;
DROP SEQUENCE AttendanceMgmt_seq;

SELECT * FROM tblAttendanceMgmt;


-----------------------------------------------------------------------------------------
-- 02. 수료여부 (tblResult)
-----------------------------------------------------------------------------------------

CREATE TABLE tblResult -- 수료여부
(
    result_seq NUMBER PRIMARY KEY, -- 번호(PK)
    state VARCHAR2(15), -- 수료여부 // 수료, 수강중, 중도탈락
    finalDate DATE, -- 수료 or 중도탈락 날짜
    regiCourse_seq NUMBER REFERENCES tblRegiCourse(regiCourse_seq) NOT NULL -- 수강신청번호(FK)
);

CREATE SEQUENCE Result_seq;

DROP TABLE tblResult;
DROP SEQUENCE Result_seq;

SELECT * FROM tblResult;
