/*
문서명 : DML-DMD05-Attendance_n_Result.sql (5/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-05-Attendance_n_Result.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-05-Attendance_n_Result.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 근태관리 더미데이터 -- line 19
02. 수료여부 더미데이터 -- line 493
*/

------------------------------------------------------------------------------------------------------------------------------
-- 01. 근태관리 더미데이터
------------------------------------------------------------------------------------------------------------------------------

-- 근태관리(개설과정 1번의 1번 학생 3,4월, 과정에 모든 학생 4월  16,17,18일 출력), 출근 9시 퇴근 5시 50분으로 근태상황 나눔)
---- 근태상황 : 정상, 결석, 지각, 조퇴, 병가, 기타
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-01','yyyy-mm-dd'), null, null, null, 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-02','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-03','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-04','yyyy-mm-dd'), to_date('2019-03-04 08:55','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-01 18:25','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-05','yyyy-mm-dd'), to_date('2019-03-05 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-05 18:22','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-06','yyyy-mm-dd'), to_date('2019-03-06 08:57','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-06 18:31','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-07','yyyy-mm-dd'), to_date('2019-03-07 08:59','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-07 18:12','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-08','yyyy-mm-dd'), to_date('2019-03-08 08:13','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:01','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-09','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-10','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-11','yyyy-mm-dd'), to_date('2019-03-11 08:57','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:05','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-12','yyyy-mm-dd'), to_date('2019-03-12 08:55','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:13','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-13','yyyy-mm-dd'), to_date('2019-03-13 08:46','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:11','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-14','yyyy-mm-dd'), to_date('2019-03-14 08:59','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:15','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-15','yyyy-mm-dd'), to_date('2019-03-15 08:37','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-08 18:53','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-16','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-17','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-18','yyyy-mm-dd'), to_date('2019-03-18 08:33','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-18 18:05','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-19','yyyy-mm-dd'), to_date('2019-03-19 08:56','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-19 18:18','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-20','yyyy-mm-dd'), to_date('2019-03-20 08:46','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-20 18:35','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-21','yyyy-mm-dd'), to_date('2019-03-21 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-21 18:07','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-22','yyyy-mm-dd'), to_date('2019-03-22 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-22 19:10','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-23','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-24','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-25','yyyy-mm-dd'), to_date('2019-03-25 08:31','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-25 18:12','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-26','yyyy-mm-dd'), to_date('2019-03-26 08:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-26 18:15','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-27','yyyy-mm-dd'), to_date('2019-03-27 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-27 15:07','yyyy-mm-dd hh24:mi'), '조퇴', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-28','yyyy-mm-dd'), to_date('2019-03-28 08:47','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-28 18:09','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-29','yyyy-mm-dd'), to_date('2019-03-29 08:49','yyyy-mm-dd hh24:mi'), 
        to_date('2019-03-29 18:01','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-30','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-03-31','yyyy-mm-dd'), null, null, null, 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-01','yyyy-mm-dd'), to_date('2019-04-01 08:51','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-01 18:11','yyyy-mm-dd hh24:mi'), '정상', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-02','yyyy-mm-dd'), to_date('2019-04-02 08:53','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-02 18:17','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-03','yyyy-mm-dd'), to_date('2019-04-03 08:37','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-03 18:36','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-04','yyyy-mm-dd'), to_date('2019-04-04 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-04 18:51','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-05','yyyy-mm-dd'), to_date('2019-04-05 08:28','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-05 18:14','yyyy-mm-dd hh24:mi'), '정상', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-06','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-07','yyyy-mm-dd'), null, null, null, 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-08','yyyy-mm-dd'), to_date('2019-04-08 08:38','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-08 18:40','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-09','yyyy-mm-dd'), to_date('2019-04-09 08:52','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-09 18:15','yyyy-mm-dd hh24:mi'), '정상', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-10','yyyy-mm-dd'), to_date('2019-04-10 08:49','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-10 18:17','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-11','yyyy-mm-dd'), to_date('2019-04-11 08:53','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-11 18:36','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-12','yyyy-mm-dd'), to_date('2019-04-12 08:55','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-12 18:40','yyyy-mm-dd hh24:mi'), '정상', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-13','yyyy-mm-dd'), null, null, null, 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-14','yyyy-mm-dd'), null, null, null, 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-15','yyyy-mm-dd'), null, null, '병가', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), null, null, '결석', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:37','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:11','yyyy-mm-dd hh24:mi'), '정상', 1);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:37','yyyy-mm-dd hh24:mi'), '정상', 1);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:17','yyyy-mm-dd hh24:mi'), '정상', 2);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:00','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:20','yyyy-mm-dd hh24:mi'), '정상', 2);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:35','yyyy-mm-dd hh24:mi'), '정상', 2);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:40','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:23','yyyy-mm-dd hh24:mi'), '정상', 3);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:25','yyyy-mm-dd hh24:mi'), '정상', 3);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:35','yyyy-mm-dd hh24:mi'), '정상', 3);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:15','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:15','yyyy-mm-dd hh24:mi'), '정상', 4);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:16','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:56','yyyy-mm-dd hh24:mi'), '정상', 4);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:10','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:01','yyyy-mm-dd hh24:mi'), '정상', 4);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:10','yyyy-mm-dd hh24:mi'), '정상', 5);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:20','yyyy-mm-dd hh24:mi'), '정상', 5);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:36','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:33','yyyy-mm-dd hh24:mi'), '정상', 5);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:33','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:32','yyyy-mm-dd hh24:mi'), '정상', 6);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:35','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:32','yyyy-mm-dd hh24:mi'), '정상', 6);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:38','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:35','yyyy-mm-dd hh24:mi'), '정상', 6);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:01','yyyy-mm-dd hh24:mi'), '정상', 7);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:52','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:25','yyyy-mm-dd hh24:mi'), '정상', 7);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:55','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:05','yyyy-mm-dd hh24:mi'), '정상', 7);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:02','yyyy-mm-dd hh24:mi'), '정상', 8);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:00','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:05','yyyy-mm-dd hh24:mi'), '정상', 8);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:03','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:08','yyyy-mm-dd hh24:mi'), '정상', 8);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:32','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:17','yyyy-mm-dd hh24:mi'), '정상', 9);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:35','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:27','yyyy-mm-dd hh24:mi'), '정상', 9);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:37','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:30','yyyy-mm-dd hh24:mi'), '정상', 9);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:24','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:50','yyyy-mm-dd hh24:mi'), '정상', 10);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:52','yyyy-mm-dd hh24:mi'), '정상', 10);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:20','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:53','yyyy-mm-dd hh24:mi'), '정상', 10);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:25','yyyy-mm-dd hh24:mi'), '정상', 11);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:21','yyyy-mm-dd hh24:mi'), '정상', 11);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:35','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:05','yyyy-mm-dd hh24:mi'), '정상', 11);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:13','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:17','yyyy-mm-dd hh24:mi'), '정상', 12);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:10','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:10','yyyy-mm-dd hh24:mi'), '정상', 12);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:15','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:15','yyyy-mm-dd hh24:mi'), '정상', 12);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:23','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:27','yyyy-mm-dd hh24:mi'), '정상', 13);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:20','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:20','yyyy-mm-dd hh24:mi'), '정상', 13);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:25','yyyy-mm-dd hh24:mi'), '정상', 13);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:05','yyyy-mm-dd hh24:mi'), '정상', 14);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:52','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:02','yyyy-mm-dd hh24:mi'), '정상', 14);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:07','yyyy-mm-dd hh24:mi'), '정상', 14);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:07','yyyy-mm-dd hh24:mi'), '정상', 15);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:03','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:02','yyyy-mm-dd hh24:mi'), '정상', 15);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:05','yyyy-mm-dd hh24:mi'), '정상', 15);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:35','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:37','yyyy-mm-dd hh24:mi'), '정상', 16);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:30','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:30','yyyy-mm-dd hh24:mi'), '정상', 16);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:35','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:25','yyyy-mm-dd hh24:mi'), '정상', 16);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:25','yyyy-mm-dd hh24:mi'), '정상', 17);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:40','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:20','yyyy-mm-dd hh24:mi'), '정상', 17);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:42','yyyy-mm-dd hh24:mi'), '정상', 17);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:43','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:17','yyyy-mm-dd hh24:mi'), '정상', 18);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:00','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:20','yyyy-mm-dd hh24:mi'), '정상', 18);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:35','yyyy-mm-dd hh24:mi'), '정상', 18);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:50','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:55','yyyy-mm-dd hh24:mi'), '정상', 19);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:52','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:52','yyyy-mm-dd hh24:mi'), '정상', 19);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:51','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:53','yyyy-mm-dd hh24:mi'), '정상', 19);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:07','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:10','yyyy-mm-dd hh24:mi'), '정상', 20);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:08','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:10','yyyy-mm-dd hh24:mi'), '정상', 20);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:05','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:15','yyyy-mm-dd hh24:mi'), '정상', 20);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:44','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:17','yyyy-mm-dd hh24:mi'), '정상', 21);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:24','yyyy-mm-dd hh24:mi'), '정상', 21);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:49','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:20','yyyy-mm-dd hh24:mi'), '정상', 21);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:40','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:25','yyyy-mm-dd hh24:mi'), '정상', 22);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:38','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:24','yyyy-mm-dd hh24:mi'), '정상', 22);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:37','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:28','yyyy-mm-dd hh24:mi'), '정상', 22);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:21','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:27','yyyy-mm-dd hh24:mi'), '정상', 23);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:20','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:22','yyyy-mm-dd hh24:mi'), '정상', 23);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:25','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:25','yyyy-mm-dd hh24:mi'), '정상', 23);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 08:38','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:21','yyyy-mm-dd hh24:mi'), '정상', 24);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:39','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:27','yyyy-mm-dd hh24:mi'), '정상', 24);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:55','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:05','yyyy-mm-dd hh24:mi'), '정상', 24);

INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-16','yyyy-mm-dd'), to_date('2019-04-16 07:42','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-16 18:04','yyyy-mm-dd hh24:mi'), '정상', 25);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-17','yyyy-mm-dd'), to_date('2019-04-17 08:07','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-17 18:28','yyyy-mm-dd hh24:mi'), '정상', 25);
    
INSERT INTO tblAttendanceMgmt (attendanceMgmt_seq, attendDate, workOn, workOff, state, regiCourse_seq)
    VALUES (AttendanceMgmt_seq.nextVal, to_date('2019-04-18','yyyy-mm-dd'), to_date('2019-04-18 08:00','yyyy-mm-dd hh24:mi'), 
        to_date('2019-04-18 18:35','yyyy-mm-dd hh24:mi'), '정상', 25);


------------------------------------------------------------------------------------------------------------------------------
-- 02. 수료여부 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 1);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 2);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 3);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 4);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 5);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 6);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 7);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 8);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 9);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 10);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 11);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 12);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 13);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 14);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 15);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 16);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 17);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 18);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 19);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 20);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 21);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 22);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 23);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 24);
INSERT INTO tblResult (result_seq, state, finalDate, regiCourse_seq) VALUES (Result_seq.nextVal, '수료중', null, 25);
