/*
문서명 : DDL-07-Consult.sql (7/7)
작성자 : 디비 2조
작성일자 : 2019.04.02.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 상담요청 (tblConsultRequest) -- line 17
02. 상담일지 (tblConsultRecord) -- line 37
*/

-----------------------------------------------------------------------------------------
-- 01. 상담요청 (tblConsultRequest)
-----------------------------------------------------------------------------------------

CREATE TABLE tblConsultRequest -- 상담요청
(
    consult_seq NUMBER PRIMARY KEY, -- 번호(PK)
    requestDate DATE NOT NULL, --요청날짜
    requestContent VARCHAR2(900), -- 요청내용
    regiCourse_seq NUMBER REFERENCES tblRegiCourse(regiCourse_seq) NOT NULL, -- 수강신청번호(FK)
    consultfin VARCHAR2(20) DEFAULT 'n' -- 상담 완료 여부
);

CREATE SEQUENCE ConsultRequest_seq;

DROP TABLE tblConsultRequest;
DROP SEQUENCE ConsultRequest_seq;

SELECT * FROM tblConsultRequest;


-----------------------------------------------------------------------------------------
-- 02. 상담일지 (tblConsultRecord)
-----------------------------------------------------------------------------------------

CREATE TABLE tblConsultRecord -- 상담일지
(
    record_seq NUMBER PRIMARY KEY, -- 번호(PK)
    recordDate DATE NOT NULL, -- 상담일시
    recordContent VARCHAR(900), -- 상담내용
    consult_seq NUMBER REFERENCES tblConsultRequest(consult_seq) NOT NULL -- 상담요청번호(FK)
);

CREATE SEQUENCE ConsultRecord_seq;

DROP TABLE tblConsultRecord;
DROP SEQUENCE ConsultRecord_seq;

SELECT * FROM tblConsultRecord;
