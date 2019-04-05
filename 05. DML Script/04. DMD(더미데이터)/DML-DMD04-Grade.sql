/*
문서명 : DML-DMD04-Grade.sql (4/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-04-Grade.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-04-Grade.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 성적정보 더미데이터 -- line 18
*/

------------------------------------------------------------------------------------------------------------------------
-- 01. 성적정보 더미데이터
------------------------------------------------------------------------------------------------------------------------

-- 성적정보 (개설과정 1번의 학생 1번에 관한 성적, 출결현황 데이터 있는 학생이랑 같음)
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/06','yyyy-mm-dd'), 1, 1);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/16','yyyy-mm-dd'), 1, 2);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/12','yyyy-mm-dd'), 1, 3);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/31','yyyy-mm-dd'), 1, 4);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 1, 5);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 88, to_date('2019/01/30','yyyy-mm-dd'), 1, 6);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/20','yyyy-mm-dd'), 1, 7);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/27','yyyy-mm-dd'), 1, 8);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/03/21','yyyy-mm-dd'), 1, 9);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 1, 10);
