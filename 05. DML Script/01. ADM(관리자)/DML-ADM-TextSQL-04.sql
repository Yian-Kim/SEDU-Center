-- DML-ADM-TextSQL-04.sql

-- 1. 관리자 - 4. 학생 관리 - a. 학생 정보 전체보기
-- a. 학생명, 주민번호, 전화번호, 등록일, 학과
SELECT student_seq, name, pw, tel, regiDate, major
    FROM tblStudent;

-- 1. 관리자 – 4. 학생 관리 - b. 학생 정보 등록 (학생명, 주민번호, 전화번호, 학과 입력)
INSERT INTO tblStudent 
    VALUES(student_seq.nextval, '입력한 학생명', '입력한 주민번호', '입력한 전화번호', null,'입력한 학과');

-- 학생명과 주민번호가 동시에 해당 학생 테이블에 만족하는게 있으면 등록안됨
SELECT name, pw FROM tblStudent;


-- 1. 관리자 – 4. 학생 관리 - c. 학생 정보 검색 및 수정 
-- a. 
SELECT name FROM tblStudent WHERE name = '입력학생명';














   
