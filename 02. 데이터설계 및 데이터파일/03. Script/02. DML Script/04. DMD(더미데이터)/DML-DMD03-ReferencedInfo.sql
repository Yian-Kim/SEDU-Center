/*
문서명 : DML-DMD03-ReferencedInfo.sql (3/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-03-ReferencedInfo.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-03-ReferencedInfo.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 강의가능과목 더미데이터 -- line 22
02. 개설과정 더미데이터 -- line 139
03. 담당과정 더미데이터 -- line 150
04. 개설과목관리 더미데이터 -- line 161
05. 수강신청 더미데이터 -- line 223
*/

------------------------------------------------------------------------------------------------------------------------
-- 01. 강의가능과목 더미데이터
------------------------------------------------------------------------------------------------------------------------

-- 시퀀스 1번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 1);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 2);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 3);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 4);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 5);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 6);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 7);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 8);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 9);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 1, 10);

-- 시퀀스 2번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 1);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 11);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 12);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 13);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 14);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 15);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 16);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 17);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 18);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 19);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 26);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 43);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 45);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 46);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 2, 53);

-- 시퀀스 3번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 1);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 11);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 12);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 13);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 14);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 15);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 16);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 17);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 18);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 19);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 20);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 21);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 22);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 23);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 24);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 3, 25);

-- 시퀀스 4번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 5);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 11);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 19);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 20);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 21);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 22);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 23);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 24);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 25);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 26);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 27);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 28);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 29);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 30);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 31);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 32);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 33);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 34);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 35);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 36);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 4, 37);

-- 시퀀스 5번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 5);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 11);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 19);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 21);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 23);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 24);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 26);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 27);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 28);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 29);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 30);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 31);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 32);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 33);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 34);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 35);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 36);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 37);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 38);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 39);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 40);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 41);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 42);

-- 시퀀스 6번 선생님 담당과정의 과목들 생성
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 11);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 19);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 21);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 23);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 24);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 26);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 38);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 39);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 40);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 41);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 5, 42);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 43);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 45);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 46);
insert into tblAvlSubject (aviSubject_seq, teacher_seq, subject_seq) values (avlSubject_seq.nextval, 6, 53);


------------------------------------------------------------------------------------------------------------------------
-- 02. 개설과정 더미데이터
------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblOpenCourse (openCourse_seq, startDate, endDate, course_seq, room_seq)
    VALUES(OpenCourse_seq.nextVal, '2018-10-01', '2019-04-24', 1, 1);
    
INSERT INTO tblOpenCourse (openCourse_seq, startDate, endDate, course_seq, room_seq)
    VALUES(OpenCourse_seq.nextVal, '2019-01-07', '2019-07-26', 2, 2);


------------------------------------------------------------------------------------------------------------------------
-- 03. 담당과정 더미데이터
------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblTeacherCourse (teacherCourse_seq, openCourse_seq, teacher_seq)
    VALUES (TeacherCourse_seq.nextVal, 1, 1);

INSERT INTO tblTeacherCourse (teacherCourse_seq, openCourse_seq, teacher_seq)
    VALUES (TeacherCourse_seq.nextVal, 2, 2);
    

------------------------------------------------------------------------------------------------------------------------
-- 04. 개설과목관리 더미데이터
------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2018/10/01','yyyy-mm-dd'), to_date('2018/11/06','yyyy-mm-dd'), 1, 1);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2018/11/07','yyyy-mm-dd'), to_date('2018/11/16','yyyy-mm-dd'), 2, 1);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2018/11/17','yyyy-mm-dd'), to_date('2018/12/12','yyyy-mm-dd'), 3, 1);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2018/12/13','yyyy-mm-dd'), to_date('2018/12/31','yyyy-mm-dd'), 4, 1);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/01/01','yyyy-mm-dd'), to_date('2019/01/08','yyyy-mm-dd'), 5, 1);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/01/09','yyyy-mm-dd'), to_date('2019/01/30','yyyy-mm-dd'), 6, 1);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/01/31','yyyy-mm-dd'), to_date('2019/02/20','yyyy-mm-dd'), 7, 1);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/02/21','yyyy-mm-dd'), to_date('2019/02/27','yyyy-mm-dd'), 8, 1);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/02/28','yyyy-mm-dd'), to_date('2019/03/21','yyyy-mm-dd'), 9, 1);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/03/22','yyyy-mm-dd'), to_date('2019/04/24','yyyy-mm-dd'), 10, 1);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/01/07','yyyy-mm-dd'), to_date('2019/01/07','yyyy-mm-dd'), 11, 2);

INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/01/08','yyyy-mm-dd'), to_date('2019/02/15','yyyy-mm-dd'), 1, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/02/16','yyyy-mm-dd'), to_date('2019/03/04','yyyy-mm-dd'), 12, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/03/05','yyyy-mm-dd'), to_date('2019/03/15','yyyy-mm-dd'), 13, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/03/16','yyyy-mm-dd'), to_date('2019/05/16','yyyy-mm-dd'), 14, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/05/17','yyyy-mm-dd'), to_date('2019/05/30','yyyy-mm-dd'), 15, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/05/31','yyyy-mm-dd'), to_date('2019/06/12','yyyy-mm-dd'), 16, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/06/13','yyyy-mm-dd'), to_date('2019/06/24','yyyy-mm-dd'), 17, 2);
    
INSERT INTO tblOpenSubjectMgmt (openSubjectMgmt_seq, startDate, endDate, subject_seq, openCourse_seq) 
    VALUES (OpenSubjectMgmt_seq.nextVal, to_date('2019/06/25','yyyy-mm-dd'), to_date('2019/07/26','yyyy-mm-dd'), 18, 2);


------------------------------------------------------------------------------------------------------------------------
-- 05. 수강신청 더미데이터
------------------------------------------------------------------------------------------------------------------------

-- 1과정
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 1, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 2, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 3, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 4, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 5, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 6, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 7, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 8, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 9, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 10, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 11, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 12, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 13, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 14, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 15, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 16, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 17, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 18, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 19, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 20, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 21, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 22, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 23, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 24, 1);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 25, 1);

-- 2과정
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 26, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 27, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 28, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 29, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 30, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 31, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 32, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 33, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 34, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 35, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 36, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 37, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 38, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 39, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 40, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 41, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 42, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 43, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 44, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 45, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 46, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 47, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 48, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 49, 2);
INSERT INTO tblRegiCourse (regiCourse_seq, student_seq, openCourse_seq) VALUES (RegiCourse_seq.nextVal, 50, 2);
