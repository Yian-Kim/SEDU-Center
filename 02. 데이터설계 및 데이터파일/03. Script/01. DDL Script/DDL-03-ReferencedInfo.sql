/*
문서명 : DDL-03-ReferencedInfo.sql (3/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 강의가능과목 (tblAvlSubject) -- line 20
02. 개설과정 (tblOpenCourse) -- line 39
03. 담당과정 (tblTeacherCourse) -- line 60
04. 개설과목관리 (tblOpenSubjectMgmt) -- line 79
05. 수강신청 (tblRegiCourse) -- line 100
*/

-----------------------------------------------------------------------------------------
-- 01. 강의가능과목 (tblAvlSubject)
-----------------------------------------------------------------------------------------

CREATE TABLE tblAvlSubject -- 강의가능과목
(
    aviSubject_seq NUMBER PRIMARY KEY, -- 번호(PK)
    teacher_seq NUMBER REFERENCES tblTeacher(teacher_seq) NOT NULL, -- 교사번호(FK)
    subject_seq NUMBER REFERENCES tblSubject(subject_seq) NOT NULL -- 과목번호(FK)
);

create sequence avlSubject_seq;

DROP TABLE tblAvlSubject;
DROP SEQUENCE avlSubject_seq;

SELECT * FROM tblAvlSubject;


-----------------------------------------------------------------------------------------
-- 02. 개설과정 (tblOpenCourse)
-----------------------------------------------------------------------------------------

CREATE TABLE tblOpenCourse -- 개설과정
(  
    openCourse_seq NUMBER PRIMARY KEY, -- 번호(PK)
    startDate DATE NOT NULL, -- 시작일
    endDate DATE NOT NULL, -- 종료일
    course_seq NUMBER REFERENCES tblCourse(course_seq) NOT NULL, -- 과정번호(FK)
    room_seq NUMBER REFERENCES tblRoom(room_seq) NOT NULL -- 강의실번호(FK)
);

CREATE SEQUENCE OpenCourse_seq;

DROP TABLE tblOpenCourse;
DROP SEQUENCE OpenCourse_seq;

SELECT * FROM tblOpenCourse;


-----------------------------------------------------------------------------------------
-- 03. 담당과정 (tblTeacherCourse)
-----------------------------------------------------------------------------------------

CREATE TABLE tblTeacherCourse -- 담당과정
(
    teacherCourse_seq NUMBER PRIMARY KEY, -- 번호(PK)
    openCourse_seq NUMBER REFERENCES tblOpenCourse(openCourse_seq) NOT NULL, -- 개설과정번호(FK)
    teacher_seq NUMBER REFERENCES tblTeacher(teacher_seq) NOT NULL -- 교사번호(FK)
);

CREATE SEQUENCE TeacherCourse_seq;

DROP TABLE tblTeacherCourse;
DROP SEQUENCE TeacherCourse_seq;

SELECT * FROM tblTeacherCourse;


-----------------------------------------------------------------------------------------
-- 04. 개설과목관리 (tblOpenSubjectMgmt)
-----------------------------------------------------------------------------------------

CREATE TABLE tblOpenSubjectMgmt -- 개설과목관리
(
    openSubjectMgmt_seq NUMBER PRIMARY KEY, -- 번호(PK)
    startDate DATE NOT NULL, -- 시작일
    endDate DATE NOT NULL, -- 종료일
    subject_seq NUMBER REFERENCES tblSubject(subject_seq) NOT NULL, -- 과목번호(FK)
    openCourse_seq NUMBER REFERENCES tblOpenCourse(openCourse_seq) NOT NULL -- 개설과정번호(FK)
);

CREATE SEQUENCE OpenSubjectMgmt_seq;

DROP TABLE tblOpenSubjectMgmt;
DROP SEQUENCE OpenSubjectMgmt_seq;

SELECT * FROM tblOpenSubjectMgmt;


-----------------------------------------------------------------------------------------
-- 05. 수강신청 (tblRegiCourse)
-----------------------------------------------------------------------------------------

CREATE TABLE tblRegiCourse -- 수강신청
(
    regiCourse_seq NUMBER PRIMARY KEY, -- 번호(PK)
    student_seq NUMBER REFERENCES tblStudent(student_seq) NOT NULL, -- 학생번호(FK)
    openCourse_seq NUMBER REFERENCES tblOpenCourse(openCourse_seq) NOT NULL -- 개설과정번호(FK)
);

CREATE SEQUENCE RegiCourse_seq;

DROP TABLE tblRegiCourse;
DROP SEQUENCE RegiCourse_seq;

SELECT * FROM tblRegiCourse;
