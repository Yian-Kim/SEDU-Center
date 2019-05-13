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

-- 과정 - 과목 - 학생순
-- 과정명 : 자바 기반 융합형 SW 개발자 양성과정
-- 과목명 : (1) 객체지향 프로그래밍
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/06','yyyy-mm-dd'), 1, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/06','yyyy-mm-dd'), 2, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/11/06','yyyy-mm-dd'), 3, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/06','yyyy-mm-dd'), 4, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/11/06','yyyy-mm-dd'), 5, 1);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/06','yyyy-mm-dd'), 6, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/06','yyyy-mm-dd'), 7, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/11/06','yyyy-mm-dd'), 8, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/06','yyyy-mm-dd'), 9, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/06','yyyy-mm-dd'), 10, 1);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/11/06','yyyy-mm-dd'), 11, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/11/06','yyyy-mm-dd'), 12, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 10, to_date('2018/11/06','yyyy-mm-dd'), 13, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/06','yyyy-mm-dd'), 14, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/06','yyyy-mm-dd'), 15, 1);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/06','yyyy-mm-dd'), 16, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/06','yyyy-mm-dd'), 17, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/06','yyyy-mm-dd'), 18, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/11/06','yyyy-mm-dd'), 19, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/11/06','yyyy-mm-dd'), 20, 1);   
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/06','yyyy-mm-dd'), 21, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/06','yyyy-mm-dd'), 22, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/06','yyyy-mm-dd'), 23, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/06','yyyy-mm-dd'), 24, 1);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/06','yyyy-mm-dd'), 25, 1);  
    
    
------------------------------------------------------------------------------------------------------------------------   

-- 과목명 : (2) 데이터 베이스 구현
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/11/16','yyyy-mm-dd'), 1, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/16','yyyy-mm-dd'), 2, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/16','yyyy-mm-dd'), 3, 2);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/11/16','yyyy-mm-dd'), 4, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/16','yyyy-mm-dd'), 5, 2);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 6, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 7, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 8, 2);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 9, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/11/16','yyyy-mm-dd'), 10, 2);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/11/16','yyyy-mm-dd'), 11, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/11/16','yyyy-mm-dd'), 12, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2018/11/16','yyyy-mm-dd'), 13, 2);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 60, to_date('2018/11/16','yyyy-mm-dd'), 14, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/16','yyyy-mm-dd'), 15, 2);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 16, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/11/16','yyyy-mm-dd'), 17, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2018/11/16','yyyy-mm-dd'), 18, 2);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2018/11/16','yyyy-mm-dd'),19, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/16','yyyy-mm-dd'),20, 2);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/11/16','yyyy-mm-dd'), 21, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/11/16','yyyy-mm-dd'), 22, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/16','yyyy-mm-dd'), 23, 2);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/11/16','yyyy-mm-dd'), 24, 2);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/11/16','yyyy-mm-dd'), 25, 2);
    
    
------------------------------------------------------------------------------------------------------------------------ 

-- 과목명 : (3) JAVA 애플리케이션 구현
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/12','yyyy-mm-dd'), 1, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/12','yyyy-mm-dd'), 2, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 60, to_date('2018/12/12','yyyy-mm-dd'), 3, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/12','yyyy-mm-dd'), 4, 3);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/12/12','yyyy-mm-dd'), 5, 3);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/12','yyyy-mm-dd'), 6, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/12','yyyy-mm-dd'), 7, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/12','yyyy-mm-dd'), 8, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/12','yyyy-mm-dd'), 9, 3);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/12','yyyy-mm-dd'), 10, 3);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/12','yyyy-mm-dd'), 11, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/12','yyyy-mm-dd'), 12, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/12/12','yyyy-mm-dd'), 13, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/12','yyyy-mm-dd'), 14, 3);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/12','yyyy-mm-dd'), 15, 3);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/12','yyyy-mm-dd'), 16, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/12','yyyy-mm-dd'), 17, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/12','yyyy-mm-dd'), 18, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/12','yyyy-mm-dd'), 19, 3);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/12','yyyy-mm-dd'), 20, 3);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/12','yyyy-mm-dd'), 21, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/12','yyyy-mm-dd'), 22, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/12','yyyy-mm-dd'), 23, 3);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/12','yyyy-mm-dd'), 24, 3);    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/12','yyyy-mm-dd'), 25, 3);
    
    
------------------------------------------------------------------------------------------------------------------------     
    
-- 과목명 : (4) JAVA애플리케이션 통합테스트 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 1, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/31','yyyy-mm-dd'), 2, 4); 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/31','yyyy-mm-dd'), 3, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2018/12/31','yyyy-mm-dd'), 4, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 5, 4);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/31','yyyy-mm-dd'), 6, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/12/31','yyyy-mm-dd'), 7, 4); 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 8, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/31','yyyy-mm-dd'), 9, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2018/12/31','yyyy-mm-dd'), 10, 4);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2018/12/31','yyyy-mm-dd'), 11, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/31','yyyy-mm-dd'), 12, 4); 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 13, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/31','yyyy-mm-dd'), 14, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/31','yyyy-mm-dd'), 15, 4);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/31','yyyy-mm-dd'), 16, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/31','yyyy-mm-dd'), 17, 4); 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/31','yyyy-mm-dd'), 18, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/31','yyyy-mm-dd'), 19, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2018/12/31','yyyy-mm-dd'), 20, 4);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 21, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2018/12/31','yyyy-mm-dd'), 22, 4); 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2018/12/31','yyyy-mm-dd'), 23, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2018/12/31','yyyy-mm-dd'), 24, 4);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2018/12/31','yyyy-mm-dd'), 25, 4);
    
------------------------------------------------------------------------------------------------------------------------ 
 
-- 과목명 : (5) 애플리케이션 배포 
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/08','yyyy-mm-dd'), 1, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/08','yyyy-mm-dd'), 2, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/01/08','yyyy-mm-dd'), 3, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/08','yyyy-mm-dd'), 4, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 5, 5);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/01/08','yyyy-mm-dd'), 6, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/01/08','yyyy-mm-dd'), 7, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 60, to_date('2019/01/08','yyyy-mm-dd'), 8, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/08','yyyy-mm-dd'), 9, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/08','yyyy-mm-dd'), 10, 5);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 11, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 12, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 13, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/01/08','yyyy-mm-dd'), 14, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/08','yyyy-mm-dd'), 15, 5);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/08','yyyy-mm-dd'), 16, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/08','yyyy-mm-dd'), 17, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/08','yyyy-mm-dd'), 18, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/08','yyyy-mm-dd'), 19, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/08','yyyy-mm-dd'), 20, 5);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/08','yyyy-mm-dd'), 21, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/01/08','yyyy-mm-dd'), 22, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/01/08','yyyy-mm-dd'), 23, 5);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/08','yyyy-mm-dd'), 24, 5);  
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/08','yyyy-mm-dd'), 25, 5);
    
    
------------------------------------------------------------------------------------------------------------------------   
    
-- 과목명 : (6) Front-end 웹 애플리케이션 구현
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/30','yyyy-mm-dd'), 1, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/30','yyyy-mm-dd'), 2, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/30','yyyy-mm-dd'), 3, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 4, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 5, 6);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/01/30','yyyy-mm-dd'), 6, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/30','yyyy-mm-dd'), 7, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/30','yyyy-mm-dd'), 8, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/01/30','yyyy-mm-dd'), 9, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/01/30','yyyy-mm-dd'), 10, 6);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/01/30','yyyy-mm-dd'), 11, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/01/30','yyyy-mm-dd'), 12, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/30','yyyy-mm-dd'), 13, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/30','yyyy-mm-dd'), 14, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/30','yyyy-mm-dd'), 15, 6);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 16, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/01/30','yyyy-mm-dd'), 17, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 18, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/01/30','yyyy-mm-dd'), 19, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 20, 6);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/01/30','yyyy-mm-dd'), 21, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/01/30','yyyy-mm-dd'), 22, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/01/30','yyyy-mm-dd'), 23, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/01/30','yyyy-mm-dd'), 24, 6);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/01/30','yyyy-mm-dd'), 25, 6);
    
    
------------------------------------------------------------------------------------------------------------------------ 

-- 과목명 : (7) Back-end 웹 애플리케이션 구현
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/20','yyyy-mm-dd'), 1, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/20','yyyy-mm-dd'), 2, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/20','yyyy-mm-dd'), 3, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/20','yyyy-mm-dd'), 4, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/20','yyyy-mm-dd'), 5, 7);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/20','yyyy-mm-dd'), 6, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/02/20','yyyy-mm-dd'), 7, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/20','yyyy-mm-dd'), 8, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/02/20','yyyy-mm-dd'), 9, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/20','yyyy-mm-dd'), 10, 7);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/20','yyyy-mm-dd'), 11, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/20','yyyy-mm-dd'), 12, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/20','yyyy-mm-dd'), 13, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/20','yyyy-mm-dd'), 14, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/20','yyyy-mm-dd'), 15, 7);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/20','yyyy-mm-dd'), 16, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/20','yyyy-mm-dd'), 17, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/20','yyyy-mm-dd'), 18, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/20','yyyy-mm-dd'), 19, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/20','yyyy-mm-dd'), 20, 7);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/20','yyyy-mm-dd'), 21, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/20','yyyy-mm-dd'), 22, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/20','yyyy-mm-dd'), 23, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/20','yyyy-mm-dd'), 24, 7);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/20','yyyy-mm-dd'), 25, 7);
    
------------------------------------------------------------------------------------------------------------------------ 
    
-- 과목명 : (8) Full-stack Framework 구현
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 1, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/27','yyyy-mm-dd'), 2, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/27','yyyy-mm-dd'), 3, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/02/27','yyyy-mm-dd'), 4, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/27','yyyy-mm-dd'), 5, 8);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 60, to_date('2019/02/27','yyyy-mm-dd'), 6, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/27','yyyy-mm-dd'), 7, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/27','yyyy-mm-dd'), 8, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/27','yyyy-mm-dd'), 9, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 10, 8);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 11, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/27','yyyy-mm-dd'), 12, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/27','yyyy-mm-dd'), 13, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 14, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/02/27','yyyy-mm-dd'), 15, 8);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/27','yyyy-mm-dd'), 16, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/27','yyyy-mm-dd'), 17, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/02/27','yyyy-mm-dd'), 18, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 19, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/02/27','yyyy-mm-dd'), 20, 8);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/02/27','yyyy-mm-dd'), 21, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 22, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/02/27','yyyy-mm-dd'), 23, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/02/27','yyyy-mm-dd'), 24, 8);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/02/27','yyyy-mm-dd'), 25, 8);
 

------------------------------------------------------------------------------------------------------------------------ 

-- 과목명 : (9) 반응형 웹 개발기법
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/03/21','yyyy-mm-dd'), 1, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/03/21','yyyy-mm-dd'), 2, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/03/21','yyyy-mm-dd'), 3, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/03/21','yyyy-mm-dd'), 4, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/03/21','yyyy-mm-dd'), 5, 9);

INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/03/21','yyyy-mm-dd'), 6, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/03/21','yyyy-mm-dd'), 7, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/03/21','yyyy-mm-dd'), 8, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/03/21','yyyy-mm-dd'), 9, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/03/21','yyyy-mm-dd'), 10, 9);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/03/21','yyyy-mm-dd'), 11, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/03/21','yyyy-mm-dd'), 12, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/03/21','yyyy-mm-dd'), 13, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 80, to_date('2019/03/21','yyyy-mm-dd'), 14, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/03/21','yyyy-mm-dd'), 15, 9);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 75, to_date('2019/03/21','yyyy-mm-dd'), 16, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 65, to_date('2019/03/21','yyyy-mm-dd'), 17, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/03/21','yyyy-mm-dd'), 18, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 85, to_date('2019/03/21','yyyy-mm-dd'), 19, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 95, to_date('2019/03/21','yyyy-mm-dd'), 20, 9);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/03/21','yyyy-mm-dd'), 21, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 70, to_date('2019/03/21','yyyy-mm-dd'), 22, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 90, to_date('2019/03/21','yyyy-mm-dd'), 23, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 60, to_date('2019/03/21','yyyy-mm-dd'), 24, 9);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, 100, to_date('2019/03/21','yyyy-mm-dd'), 25, 9);


------------------------------------------------------------------------------------------------------------------------ 

-- 과목명 : (10) 융합기반 웹표준 프로젝트
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 1, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 2, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 3, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 4, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 5, 10);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 6, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 7, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 8, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 9, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 10, 10);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 11, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 12, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 13, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 14, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 15, 10);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 16, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 17, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 18, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 19, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 20, 10);
    
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 21, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 22, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 23, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 24, 10);
INSERT INTO tblGrade (grade_seq, score, testDate, regiCourse_seq, openSubjectMgmt_seq)
    VALUES (Grade_seq.nextVal, null, to_date('2019/04/24','yyyy-mm-dd'), 25, 10);
