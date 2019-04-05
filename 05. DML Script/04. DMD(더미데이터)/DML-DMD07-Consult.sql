/*
문서명 : DML-DMD07-Consult.sql (7/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-07-Consult.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-07-Consult.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 상담요청 더미데이터 -- line 19
02. 상담일지 더미데이터 -- line 33
*/

------------------------------------------------------------------------------------------------------------------------------
-- 01. 상담요청 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblConsultRequest (consult_seq, requestDate, requestContent, regiCourse_seq)
    VALUES (ConsultRequest_seq.nextVal, to_date('2018/11/20','yyyy-mm-dd'), '개발자의 삶... 전망이 어떤가요', 1);

INSERT INTO tblConsultRequest (consult_seq, requestDate, requestContent, regiCourse_seq)
    VALUES (ConsultRequest_seq.nextVal, to_date('2019/01/25','yyyy-mm-dd'), '수업을 따라가기 힘들어요', 1);

INSERT INTO tblConsultRequest (consult_seq, requestDate, requestContent, regiCourse_seq)
    VALUES (ConsultRequest_seq.nextVal, to_date('2019/3/26','yyyy-mm-dd'), '정보처리기사이외에 자격증 따로 준비해야할까요?', 1);


------------------------------------------------------------------------------------------------------------------------------
-- 02. 상담일지 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblConsultRecord (record_seq, recordDate, recordContent, consult_seq) 
    VALUES (ConsultRecord_seq.nextVal, to_date('2018/11/20','yyyy-mm-dd'), '프로그래머 전망에 대한 상담 진행 완료.', 1);

INSERT INTO tblConsultRecord (record_seq, recordDate, recordContent, consult_seq) 
    VALUES (ConsultRecord_seq.nextVal,  to_date('2019/01/25','yyyy-mm-dd'), '학습 방법에 대한 상담 진행 완료.', 2);
    
INSERT INTO tblConsultRecord (record_seq, recordDate, recordContent, consult_seq) 
    VALUES (ConsultRecord_seq.nextVal,  to_date('2019/3/26','yyyy-mm-dd'), '관련 자격중에 대한 상담 진행 완료.', 3);
